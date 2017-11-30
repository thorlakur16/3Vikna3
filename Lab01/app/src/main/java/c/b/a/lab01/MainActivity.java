package c.b.a.lab01;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public int checkEmpty(String n, String k){
        if(n.length() == 0 || k.length() == 0){
            CharSequence text = "Number fields 1 and 2 cannot be empty";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(getApplicationContext(),text, duration);
            toast.show();
            return 0;
        }
        else
            return 1;
    }

    public void addNumbers(View view) {
        EditText Number_1 = findViewById(R.id.number_1);
        String n = Number_1.getText().toString();
        EditText Number_2 = findViewById(R.id.number_2);
        String k = Number_2.getText().toString();
        int check = checkEmpty(n,k);
        if(check == 1){
            double double_n = Double.valueOf(n);
            double double_k = Double.valueOf(k);
            double ans = double_n+double_k;
            EditText Ans = findViewById(R.id.answer);
            String text_answer;
            if(ans %1 == 0){
                text_answer = Integer.toString((int)ans);
            }
            else{
                text_answer = Double.toString(ans);
            }
            Ans.setText(text_answer);
        }
    }

    public void subtractNumbers(View view) {
        EditText Number_1 = findViewById(R.id.number_1);
        String n = Number_1.getText().toString();
        EditText Number_2 = findViewById(R.id.number_2);
        String k = Number_2.getText().toString();
        int check = checkEmpty(n,k);
        if(check == 1) {
            double int_n = Double.valueOf(n);
            double double_k = Double.valueOf(k);
            double ans = int_n - double_k;
            EditText Ans = findViewById(R.id.answer);
            String text_answer;
            if (ans % 1 == 0) {
                text_answer = Integer.toString((int) ans);
            } else {
                text_answer = Double.toString(ans);
            }
            Ans.setText(text_answer);
        }
    }

    public void multiplyNumbers(View view) {
        EditText Number_1 = findViewById(R.id.number_1);
        String n = Number_1.getText().toString();
        EditText Number_2 = findViewById(R.id.number_2);
        String k = Number_2.getText().toString();
        int check = checkEmpty(n,k);
        if(check == 1) {
            double double_n = Double.valueOf(n);
            double double_k = Double.valueOf(k);
            double ans = double_n * double_k;
            EditText Ans = findViewById(R.id.answer);
            String text_answer;
            if (ans % 1 == 0) {
                text_answer = Integer.toString((int) ans);
            } else {
                text_answer = Double.toString(ans);
            }
            Ans.setText(text_answer);
        }
    }

    public void divideNumbers(View view) {
        EditText Number_1 = findViewById(R.id.number_1);
        String n = Number_1.getText().toString();
        EditText Number_2 = findViewById(R.id.number_2);
        String k = Number_2.getText().toString();
        int check = checkEmpty(n,k);
        if(check == 1) {
            double double_n = Double.valueOf(n);
            double double_k = Double.valueOf(k);
            double ans = double_n / double_k;
            EditText Ans = findViewById(R.id.answer);
            String text_answer;
            if (ans % 1 == 0) {
                text_answer = Integer.toString((int) ans);
            } else {
                text_answer = Double.toString(ans);
            }
            Ans.setText(text_answer);
        }
    }

    public void clear(View view) {
        EditText Number_1 = findViewById(R.id.number_1);
        EditText Number_2 = findViewById(R.id.number_2);
        EditText Ans = findViewById(R.id.answer);
        Number_1.setText("");
        Number_2.setText("");
        Ans.setText("");
    }
}
