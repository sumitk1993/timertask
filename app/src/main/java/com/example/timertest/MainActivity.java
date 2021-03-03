package com.example.timertest;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.util.Calendar;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView timer;
    TextView seconds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer = findViewById(R.id.timerView);
        seconds=findViewById(R.id.seconds);

        showTime();
    }

    private void showTime() {
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY)+1);
        calendar.set(Calendar.MINUTE, 30);
        long mills=calendar.getTimeInMillis()-Calendar.getInstance().getTimeInMillis();
       new CountDownTimer(mills, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                int hours = (int) (millisUntilFinished / (1000 * 60 * 60));
                int mins = (int) (millisUntilFinished / (1000 * 60)) % 60;
                int seconds = (int) ((millisUntilFinished / (1000)) % 60);
                String diff = ((hours < 10 ? "0" + hours : hours) + ":") + (mins < 10 ? "0" + mins : mins) + ":" + (seconds < 10 ? "0" + seconds : seconds);


                Log.e("Seconds in Clock", Calendar.getInstance().get(Calendar.SECOND) + "");
              Log.e("Seconds in Timer", seconds + "");

                // mills=mills-1000;// updated value every1 second
                // ((TextView)getActivity().getWindow().findViewById(R.id.textyouandYou)).setText(diff);
               settext(diff, Calendar.getInstance().get(Calendar.SECOND) +"" );
            }

            @Override
            public void onFinish() {
                showTime();
            }

        }.start();
    }

    private void settext(String diff, String secandsFromClock) {
        timer.setText(diff);
        seconds.setText(secandsFromClock);

    }
}