package com.example.bmail;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class Login extends AppCompatActivity implements TextToSpeech.OnInitListener {

    TextView username, password;
    TextToSpeech tts;
    RelativeLayout rel;
    int a = 0, c = 0;
    private final int R1 = 100;
    private final int R2 = 101;
    String s1, s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tts = new TextToSpeech(this, this);
        username = findViewById(R.id.email);
        password = findViewById(R.id.password);
        rel = findViewById(R.id.rel);


        rel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                outer:
                for (c = a; c < 10; c++) {


                    if (c == 0) {
                        tts.speak("Say username", TextToSpeech.QUEUE_FLUSH, null);


                    }


                    if (c==1)
                    {
                        tts.speak("Say password", TextToSpeech.QUEUE_FLUSH, null);


                    }
                }
            }
        });


    }

    @Override
    public void onInit(int i) {

        say("WELCOME TO THE LOGIN PAGE . TAP TO PROCEED ");

    }

    private void say(String msg1) {
        tts.speak(msg1, TextToSpeech.QUEUE_FLUSH, null);
    }


    private void promptSpeechInput1() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "say name");
        try {
            startActivityForResult(intent, R1);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(), "Try Again",
                    Toast.LENGTH_SHORT).show();
        }
    }


    private void promptSpeechInput2() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "say 4 digit password");
        try {
            startActivityForResult(intent, R1);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(), "Try Again",
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case R1: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    username.setText(result.get(0));
                    s1 = username.getText().toString();
                    say("username you are entered is " + s1);
                    say("tap to proceed. long tap to re enter");
                }
            }
            break;
            case R2: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    password.setText(result.get(0));
                    s2 = password.getText().toString();
                    say("password you are entered is " + s2);
                    say("tap to proceed.long tap to re enter");
                }
            }
            break;

        }
    }
}