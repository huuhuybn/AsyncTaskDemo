package vn.edu.poly.asynctaskdemo;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Counting2 extends AsyncTask<String, Integer, String> {

    private int index = 0;

    private ProgressBar progressBar;
    private TextView textView;
    private Context context;

    public Counting2(ProgressBar progressBar, TextView textView, Context context) {
        this.progressBar = progressBar;
        this.textView = textView;
        this.context = context;
    }

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

        if (s.equals("Finished")) Toast.makeText(context,
                "Finished Counting!!!!", Toast.LENGTH_LONG).show();

    }

}
