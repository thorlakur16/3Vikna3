package c.b.a.lab04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private static final String URI2 = "https://od-api.oxforddictionaries.com/api/v1/entries/";

    private TextView display;
    private TextView transDisplay;

    String language = "en";
    String word = "";
    String translation = "";
    String word_id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.display);
        transDisplay = findViewById(R.id.translate);
    }

    public void getDef(View view) {
        EditText input = findViewById(R.id.input);
        word = input.getText().toString();
        if (word.length() != 0) {
            word_id = word.toLowerCase(); //word id is case sensitive and lowercase is required
            Ion.with(this)
                .load(URI2 + language + "/" + word_id)
                .addHeader("Accept", "application/json")
                .addHeader("app_id", "3b866cec")
                .addHeader("app_key", "89be2b63ae384073cd549dbd614a6ea1")
                .setTimeout(2000)
                .asString()
                .setCallback(new FutureCallback<String>() {
                    @Override
                    public void onCompleted(Exception e, String result) {
                        try {
                            String jsonData = result.toString();
                            JSONObject obj = new JSONObject(jsonData);

                            JSONArray resultsArr = obj.getJSONArray("results");

                            JSONArray lexicalEntriesArr = resultsArr.getJSONObject(0).getJSONArray("lexicalEntries");
                            JSONArray entriesArr = lexicalEntriesArr.getJSONObject(0).getJSONArray("entries");
                            JSONArray sensesArr = entriesArr.getJSONObject(0).getJSONArray("senses");
                            JSONArray definitionsArr = sensesArr.getJSONObject(0).getJSONArray("definitions");
                            String definition = definitionsArr.getString(0);
                            display.setText(definition);
                            if(translation != ""){
                                translate();
                            }
                        } catch (JSONException e1) {
                            e1.printStackTrace();
                        }
                    }
                });
            }
        }

    public void setLangGer() {
        translation = "/translations=de";
    }

    public void setLangSp() {
        translation = "/translations=es";
    }

    public void translate() {
            Ion.with(this)
                .load(URI2 + language + "/" + word_id + translation)
                .addHeader("Accept", "application/json")
                .addHeader("app_id", "3b866cec")
                .addHeader("app_key", "89be2b63ae384073cd549dbd614a6ea1")
                .setTimeout(2000)
                .asString()
                .setCallback(new FutureCallback<String>() {
                    @Override
                    public void onCompleted(Exception e, String result) {
                        String jsonData = result.toString();
                        JSONObject obj = null;
                        try {
                            obj = new JSONObject(jsonData);
                            JSONArray resultsArr = obj.getJSONArray("results");
                            String test = resultsArr.getJSONObject(0).toString();

                            JSONArray lexicalEntriesArr = resultsArr.getJSONObject(0).getJSONArray("lexicalEntries");
                            JSONArray entriesArr = lexicalEntriesArr.getJSONObject(0).getJSONArray("entries");
                            JSONArray sensesArr = entriesArr.getJSONObject(0).getJSONArray("senses");
                            JSONArray translationArr = sensesArr.getJSONObject(0).getJSONArray("translations");

                            String trans = translationArr.getJSONObject(0).getString("text");
                            transDisplay.setText(trans);

                        } catch (JSONException e1) {
                            e1.printStackTrace();
                        }
                    }
                });
            }


    public void radioClick(View view) {
        if (((RadioButton)view).isChecked()) {
            switch (view.getId()) {
                case R.id.german:
                    setLangGer();
                    break;
                case R.id.spanish:
                    setLangSp();
                    break;
            }
        }
    }
}
