package c.b.a.lab02;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    float movespeed_X = 0.015f;
    float movespeed_Y = 0.02f;

    boolean gameOn = true;

    private GraphicView graphicView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        graphicView = findViewById(R.id.graphicView);
        new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                while (gameOn) {
                    Circle.getInstance().addX(movespeed_X);
                    Circle.getInstance().addY(movespeed_Y);
                    if (Circle.getInstance().getX() + Circle.getInstance().getRadius() > graphicView.getWidth() || Circle.getInstance().getX() - Circle.getInstance().getRadius() < 0) {
                        movespeed_X *= -1;
                    }
                    if (Circle.getInstance().getY()  + Circle.getInstance().getRadius() > graphicView.getHeight() || Circle.getInstance().getY() -  Circle.getInstance().getRadius() < 0) {
                        movespeed_Y *= -1;
                    }
                    publishProgress();
                }
                return null;
            }
            @Override
            protected void onProgressUpdate(Void... params){
                graphicView.update();
            }
        }.execute();
    }
}























