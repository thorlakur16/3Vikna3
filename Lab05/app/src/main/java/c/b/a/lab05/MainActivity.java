package c.b.a.lab05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText un;
    private MyDataBase db;
    public int type;
    int n1, n2;
    User u;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        db = MyDataBase.getInstance(this);
        un = findViewById(R.id.login);
    }


    private void toast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void buttonAction(View view){
        TextView textType;
        UserDao dao = db.userDao();
        switch (view.getId()){
            case R.id.buttonLogin:
                String sun = un.getText().toString();
                u = dao.getUserByName(sun);

                if(u == null){
                    toast("User does not exist");
                }
                else{
                    if(u.nr1 != 0){
                        setContentView(R.layout.activity_main);

                        TextView nr1 = findViewById(R.id.nr1);
                        TextView nr2 = findViewById(R.id.nr2);
                        TextView typeBox = findViewById(R.id.questionType);

                        nr1.setText(""+u.nr1);
                        nr2.setText(""+u.nr2);
                        typeBox.setText(u.type);

                        if(u.type == "+"){
                            type = 1;
                        }
                        else if(u.type == "-"){
                            type = 2;
                        }
                        else{
                            type = 3;
                        }
                    }
                }
                break;

            case R.id.buttonSignup:
                EditText usernameT = findViewById(R.id.login);
                String un = usernameT.getText().toString();
                dao.addUser(new User(un));
                u = dao.getUserByName(un);
                setContentView(R.layout.selection);
                break;

                case R.id.addition:
                setContentView(R.layout.activity_main);
                    textType = findViewById(R.id.questionType);
                    textType.setText("Addition");
                type = 1;
                populateQuestions();
                break;

            case R.id.subtraction:
                setContentView(R.layout.activity_main);
                textType = findViewById(R.id.questionType);
                textType.setText("Subtraction");
                type = 2;
                populateQuestions();
                break;

            case R.id.multiplication:
                setContentView(R.layout.activity_main);
                textType = findViewById(R.id.questionType);
                textType.setText("Multiplication");
                type = 3;
                populateQuestions();
                break;

            case R.id.buttonAnswer:
                checkAnswer();
                break;

            case R.id.change:
                setContentView(R.layout.selection);
                break;

            case R.id.back:
                setContentView(R.layout.activity_main);
                populateQuestions();
                break;

            case R.id.viewStats:
                db.userDao().updateUser(u);
                setContentView(R.layout.stats);

                TextView addWins = findViewById(R.id.statsAddWins);
                TextView addPlayed= findViewById(R.id.statsAddPlayed);
                TextView addPercent = findViewById(R.id.addWinPercent);

                TextView subWins = findViewById(R.id.statsSubWins);
                TextView subPlayed = findViewById(R.id.statsSubPlayed);
                TextView subPercent = findViewById(R.id.subWinPercent);

                TextView multiplyWins = findViewById(R.id.statsMultiplyWins);
                TextView multiplyPlayed = findViewById(R.id.statsMultiplyPlayed);
                TextView multiplyPercent = findViewById(R.id.multiplyWinPercent);

                if(u.add_played != 0){
                    addWins.setText(""+u.add_right);
                    addPlayed.setText(""+u.add_played);
                    double ans = ((double)u.add_right/u.add_played)*100;
                    String result = String.format("%.2f", ans);
                    addPercent.setText(result);
                }
                else {
                    addWins.setText("N/A");
                    addPlayed.setText("N/A");
                    addPercent.setText("N/A");
                }
                if(u.sub_played != 0){
                    subWins.setText(""+u.sub_right);
                    subPlayed.setText(""+u.sub_played);
                    double ans = ((double)u.sub_right/u.sub_played)*100;
                    String result = String.format("%.2f", ans);
                    subPercent.setText(result);
                }
                else {
                    subWins.setText("N/A");
                    subPlayed.setText("N/A");
                    subPercent.setText("N/A");
                }
                if(u.mul_played != 0){
                    multiplyWins.setText(""+u.mul_right);
                    multiplyPlayed.setText(""+u.mul_played);
                    double ans = ((double)u.mul_right/u.mul_played)*100;
                    String result = String.format("%.2f", ans);
                    multiplyPercent.setText(result);
                }
                else {
                    multiplyWins.setText("N/A");
                    multiplyPlayed.setText("N/A");
                    multiplyPercent.setText("N/A");
                }
                break;
        }
    }

    public void onStop(){
        super.onStop();
        u.nr1 = n1;
        u.nr2 = n2;
        Log.d("n1 og n2: ", u.nr1 + " " + u.nr2);
        if(type == 1){
            u.type = "+";
        }
        else if(type == 2){
            u.type = "-";
        }
        else{
            u.type = "*";
        }
        db.userDao().updateUser(u);

    }

    private void checkAnswer() {
        EditText ans = findViewById(R.id.answer);
        int solution;
        int answer = Integer.valueOf(ans.getText().toString());

        Log.d("answer: ", ""+answer);

        if(type == 1){
            solution = n1 + n2;
            if(answer == solution){
                toast("Right answer!");
                u.add_right += 1;
                u.add_played += 1;
                ans.setText("");
            }
            else{
                toast("Wrong answer!");
                u.add_played += 1;
                ans.setText("");
            }

        }
        else if(type == 2){
            solution = n1 - n2;
            if(answer == solution){
                toast("Right answer!");
                u.sub_right += 1;
                u.sub_played += 1;
                ans.setText("");
            }
            else{
                toast("Wrong answer!");
                u.sub_played += 1;
                ans.setText("");
            }
        }
        else{
            solution = n1 * n2;
            if(answer == solution){
                toast("Right answer!");
                u.mul_right += 1;
                u.mul_played += 1;
                ans.setText("");
            }
            else{
                toast("Wrong answer!");
                u.mul_played += 1;
                ans.setText("");
            }
        }
        populateQuestions();
    }

    private void populateQuestions() {

        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        n1 = rand.nextInt(100);
        n2 = rand.nextInt(100);


        TextView nr1 = findViewById(R.id.nr1);
        TextView nr2 = findViewById(R.id.nr2);
        TextView sign = findViewById(R.id.sign);

        if(n1 < n2){
            nr1.setText(""+n2);
            nr2.setText(""+n1);
            int temp = n1;
            n1 = n2;
            n2 = temp;
        }
        else{
            nr1.setText(""+n1);
            nr2.setText(""+n2);
        }

        if(type == 1){
            sign.setText("+");
        }
        if(type == 2){
            sign.setText("-");
        }
        if(type == 3){
            sign.setText("*");
        }
    }
}
