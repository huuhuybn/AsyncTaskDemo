package vn.edu.poly.asynctaskdemo;

import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setProgress(0);
        progressBar.setMax(1000000);


        textView = findViewById(R.id.textView);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Counting counting = new Counting();
//                counting.execute("Hello");

//                Counting2 counting2 =
//                        new Counting2(progressBar, textView, MainActivity.this);
//                counting2.execute("Hello");


                Counting3 counting3 = new Counting3();

                OnFinishedCounting onFinishedCounting = new OnFinishedCounting() {
                    @Override
                    public void onFinished(String s) {
                        
                        textView.setText("ABC");

                        if (s.equals("Finished")) Toast.makeText(MainActivity.this,
                                "Finished Counting!!!!", Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onUpdateProgress(int progress) {
                        progressBar.setProgress(progress);
                    }
                };

                counting3.setOnFinishedCounting(onFinishedCounting);
                counting3.execute("Hello");

            }
        });

    }

    class Counting extends AsyncTask<String, Integer, String> {

        private int index = 0;

        @Override
        protected String doInBackground(String... strings) {

            for (int i = 0; i <= 1000000; i++) {

                // cap nhat tien trinh
                onProgressUpdate(i);

                index = i;
            }

            if (index == 1000000) {
                return "Finished";
            } else
                return "NO";
        }


        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            textView.setText("ABC");

            if (s.equals("Finished")) Toast.makeText(MainActivity.this,
                    "Finished Counting!!!!", Toast.LENGTH_LONG).show();

        }
    }

}
