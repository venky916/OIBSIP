package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Stop_Watch extends AppCompatActivity {
private int seconds=0;
private boolean running=false;
    Button start;
    Button hold;
    Button stop;
    TextView timer;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stop_watch);
        
        initialize();
    }

    private void initialize() {
        start = findViewById(R.id.start);
        hold = findViewById(R.id.hold);
        stop = findViewById(R.id.stop);
        timer = findViewById(R.id.timer);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onPressStart();
            }
        }); hold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onPressHold();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onPressStop();
            }
        });
    }

    public void onPressStart(){
        if(!running) {
            startTimer();
        }

    }

    public void onPressHold(){
        if(running) {
            running = false;
            handler.removeCallbacks(null);
        }
    }

    public void onPressStop( ) {
        onPressHold();
        seconds= 0;
        onPressHold();

    }

    private void startTimer(){
        running = true;
        handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hrs = seconds / 3600;
                int mins =(seconds%3600)/60;
                int sec=seconds%60;
                String time=String.format("%02d:%02d:%02d",hrs,mins,sec);
                timer.setText(time);
                if(running){
                        seconds++;
                    }
                handler.postDelayed(this,0);
            }

            });
        }

}