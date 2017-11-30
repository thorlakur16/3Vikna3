package c.b.a.lab03;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    PhoneMap map = new PhoneMap();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        populateLayout();
    }

    private void populateLayout() {

        lv= findViewById(R.id.phonebook);

        List<String> personList = new ArrayList<String>();

        for (Map.Entry<String, Person> info : map.getAllPhones()) {
            personList.add(info.getKey());
        }

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                personList );

        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                String name = adapter.getItemAtPosition(position).toString();

                Person p = map.getPerson(name);
                setContentView(R.layout.view);

                TextView viewName = findViewById(R.id.viewName);
                TextView viewAddress = findViewById(R.id.viewAddress);
                TextView viewPhone = findViewById(R.id.viewPhone);

                viewName.setText(p.name);
                viewAddress.setText(p.address);
                viewPhone.setText(p.phone);
            }
        });
    }

    public void addFuncView(View view) {
        setContentView(R.layout.add);
    }

    public void addDone(View view) {

        EditText phoneT = findViewById(R.id.addPhone);
        EditText nameT = findViewById(R.id.addName);
        EditText addressT = findViewById(R.id.addAddress);
        String phone = phoneT.getText().toString();
        String name = nameT.getText().toString();
        String address = addressT.getText().toString();

        map.addPerson(new Person(phone, name, address));

        setContentView(R.layout.activity_main);
        populateLayout();
    }

    public void viewBack(View view) {

        setContentView(R.layout.activity_main);
        populateLayout();
    }

    public void viewPers(View view) {
    }
}



