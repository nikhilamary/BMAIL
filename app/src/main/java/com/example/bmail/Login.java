package com.example.bmail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class Login extends AppCompatActivity implements TextToSpeech.OnInitListener{

    TextView email;

    TextToSpeech tts;
    private GestureDetectorCompat gdetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tts = new TextToSpeech(this,this);
        gdetector = new GestureDetectorCompat(this,new GestureDetector());

        email = findViewById(R.id.email);
    }

    @Override
    public void onInit(int i) {

        say("Tap to start recording");

    }

    private void say(String msg1) {
        tts.speak(msg1, TextToSpeech.QUEUE_FLUSH, null);
    }

    private class GestureDetector extends android.view.GestureDetector.SimpleOnGestureListener
    {

        @Override
        public boolean onSingleTapUp(MotionEvent e) {

            promtSpeechInput();
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

    public void promtSpeechInput() {

        Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        i.putExtra(RecognizerIntent.EXTRA_PROMPT, "SAY SOMETHING");
        i.putExtra(RecognizerIntent.EXTRA_PARTIAL_RESULTS, true);



        try {

            startActivityForResult(i, 100);
            Toast.makeText(Login.this, "Say something kiddo", Toast.LENGTH_LONG).show();



        } catch (Exception e) {
            Toast.makeText(Login.this, "Sorry, your device not support speech inputs", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }


    }

    public void onActivityResult(int request_code, int result_code, Intent i) {


        super.onActivityResult(request_code, result_code, i);

        switch (request_code) {

            case 100:
                if (result_code == RESULT_OK && i != null) {
                    ArrayList<String> result = i.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                    email.setText(result.get(0));

                }
                break;

        }
    }
}
