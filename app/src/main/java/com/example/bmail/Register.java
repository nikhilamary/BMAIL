package com.example.bmail;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class Register extends AppCompatActivity implements TextToSpeech.OnInitListener {


    TextView name,username,age,gender,phone;
    Button confirm;
    RelativeLayout relative;
    TextToSpeech tts;
    int a = 0, c = 0;
    private final int R1 = 100;
    private final int R2 = 101;
    private final int R3 = 102;
    private final int R4 = 103;
    private final int R5 = 104;
    String s1,s2,s3,s4,s5,s6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name=findViewById(R.id.name);


        username=findViewById(R.id.username);
        age=findViewById(R.id.age);
        gender=findViewById(R.id.gender);
        phone=findViewById(R.id.phone);
        confirm = findViewById(R.id.confirm);
        relative =findViewById(R.id.rel);
        tts = new TextToSpeech(this,this);

        say("You are at the Registration page .Tap to Proceed");



        relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                outer:
                    for (c = a; c < 10; c++) {
                if (c == 0) {
                    //username.setCursorVisible(true);
                    tts.speak("Say name", TextToSpeech.QUEUE_FLUSH, null);
                    promptSpeechInput1();
                    //say(s1);

                    relative.setOnLongClickListener(new View.OnLongClickListener() {

                        @Override
                        public boolean onLongClick(View v) {
                            promptSpeechInput1();
                            return true;
                        }
                    });
                    a++;
                    break outer;
                }
                if (c == 1) {
                    tts.speak("Say gender", TextToSpeech.QUEUE_FLUSH, null);
                    promptSpeechInput2();
                    //say(s2);
                    relative.setOnLongClickListener(new View.OnLongClickListener() {

                        @Override
                        public boolean onLongClick(View v) {
                            promptSpeechInput2();
                            return true;
                        }
                    });


                    a++;
                    break outer;
                }
                if (c == 2) {
                    tts.speak("Say user id", TextToSpeech.QUEUE_FLUSH, null);
                    promptSpeechInput3();
                    //say(s3);
                    relative.setOnLongClickListener(new View.OnLongClickListener() {

                        @Override
                        public boolean onLongClick(View v) {
                            promptSpeechInput3();
                            return true;
                        }
                    });
                    a++;
                    break outer;
                }
                if (c == 3) {
                    tts.speak("Say phone number", TextToSpeech.QUEUE_FLUSH, null);
                    promptSpeechInput4();
                    relative.setOnLongClickListener(new View.OnLongClickListener() {

                        @Override
                        public boolean onLongClick(View v) {
                            promptSpeechInput4();
                            return true;
                        }
                    });
                    //say(s4);
                    a++;
                    break outer;
                }
                if (c == 4) {
                    tts.speak("Say age", TextToSpeech.QUEUE_FLUSH, null);
                    promptSpeechInput5();
                    //say(s5);
                    relative.setOnLongClickListener(new View.OnLongClickListener() {

                        @Override
                        public boolean onLongClick(View v) {
                            promptSpeechInput5();
                            return true;
                        }
                    });
                    a++;
                    break outer;
                }
                if (c == 5) {
                    s6="your account has been created";
                    say(s6);
                   // startActivity(new Intent(getApplicationContext(),login.class));
                }
            }


        }
        });


    }


    private void say(String msg1) {
        tts.speak(msg1, TextToSpeech.QUEUE_FLUSH, null);
    }
    @Override
    public void onInit(int i) {
        say("You are at the Registration page .Tap to Proceed");


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
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "say gender");
        try {
            startActivityForResult(intent, R2);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(), "Try Again",
                    Toast.LENGTH_SHORT).show();
        }
    }


    private void promptSpeechInput3() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "say user id");
        try {
            startActivityForResult(intent, R3);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(), "Try Again",
                    Toast.LENGTH_SHORT).show();
        }
    }


    private void promptSpeechInput4() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "phone number");
        try {
            startActivityForResult(intent, R4);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(), "Try Again",
                    Toast.LENGTH_SHORT).show();
        }
    }


    private void promptSpeechInput5() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "say age");
        try {
            startActivityForResult(intent, R5);
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
                    name.setText(result.get(0));
                    s1=name.getText().toString();
                    say(s1);
                    say("tap to proceed. long tap to re enter");
                }
            }
            break;
            case R2: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    username.setText(result.get(0));
                    s2=username.getText().toString();
                    say(s2);
                    say("tap to proceed.long tap to re enter");
                }
            }
            break;

            case R3: {

                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    gender.setText(result.get(0));
                    s3=gender.getText().toString();
                    say(s3);
                    say("tap to proceed.long tap to re enter");
                }
            }
            break;


            case R4: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    age.setText(result.get(0));
                    s4=age.getText().toString();
                    say(s4);
                    say("tap to proceed.long tap to re enter");
                }
                break;
            }
            case R5: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    phone.setText(result.get(0));
                    s5=phone.getText().toString();
                    say(s5);
                    say("tap to proceed. long tap to re enter");
                }
                break;

            }
        }
    }
    }
