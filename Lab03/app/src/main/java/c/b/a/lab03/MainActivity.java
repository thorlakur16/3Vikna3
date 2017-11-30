package c.b.a.lab03;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        String[] members = new String[]{};
        members = populatePhonebook(members);
        ListView ls = findViewById(R.id.phonebook);
        PersonAdapter adapter = new PersonAdapter(this, members);
        ls.setAdapter(adapter);

        setContentView(R.layout.activity_main);
    }


    private String[] populatePhonebook(String[] members) {
        for(int i = 0; i < 10; i++){
            members[i] = "Gudmundur Rassgat "+i;
        }

        return members;
    }

    public void addFuncView(View view) {
        setContentView(R.layout.add);
    }
}



