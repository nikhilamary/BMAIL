package com.example.bmail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class Index extends AppCompatActivity implements TextToSpeech.OnInitListener {


    TextToSpeech tts;
    private GestureDetectorCompat gdetector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        tts = new TextToSpeech(this,this);
        gdetector = new GestureDetectorCompat(this, new GestureDetector());
    }

    @Override
    public void onInit(int i) {
        say("welcome to bmail. Tap for login .double tap for registration");
    }

    private void say(String msg1) {
        tts.speak(msg1, TextToSpeech.QUEUE_FLUSH, null);
    }



    private class GestureDetector extends android.view.GestureDetector.SimpleOnGestureListener
    {

        @Override
        public boolean onSingleTapUp(MotionEvent e) {

            Intent i = new Intent(getApplicationContext(),Login.class);
            startActivity(i);
            return super.onSingleTapUp(e);
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            Intent i = new Intent(getApplicationContext(),Register.class);
            startActivity(i);
            return super.onDoubleTap(e);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gdetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
