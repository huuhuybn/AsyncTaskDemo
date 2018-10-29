package vn.edu.poly.asynctaskdemo;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Counting3 extends AsyncTask<String, Integer, String> {

    private int index = 0;

    private OnFinishedCounting onFinishedCounting;

    public void setOnFinishedCounting(OnFinishedCounting onFinishedCounting) {
        this.onFinishedCounting = onFinishedCounting;
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

        onFinishedCounting.onUpdateProgress(values[0]);


    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        onFinishedCounting.onFinished(s);

    }

}
