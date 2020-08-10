package com.example.bmail;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.Locale;

public class Register extends AppCompatActivity implements TextToSpeech.OnInitListener {


    TextView name,username,age,password,phone;
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
    Handler handler;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name=findViewById(R.id.name);
        username=findViewById(R.id.username);
        age=findViewById(R.id.age);
        password=findViewById(R.id.password);
        phone=findViewById(R.id.phone);
        confirm = findViewById(R.id.confirm);
        relative =findViewById(R.id.rel);
        tts = new TextToSpeech(this,this);
        mAuth = FirebaseAuth.getInstance();
       handler = new Handler();

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
                    Delay();

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
                    tts.speak("Say username", TextToSpeech.QUEUE_FLUSH, null);
                    Delay();
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
                    tts.speak("Say 4 digit password", TextToSpeech.QUEUE_FLUSH, null);
                    Delay();
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
                    tts.speak("Say age", TextToSpeech.QUEUE_FLUSH, null);
                    Delay();
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
                    tts.speak("Say phone number", TextToSpeech.QUEUE_FLUSH, null);
                    Delay();
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

                  say("The name you have entered is "+s1 +"The username you have entered is "+s2 +"The gender you have entered is "+s3 +"The age you have entered is "+s4 +"The phone number you have entered is "+s5+"Tap to confirm and long tap to re enter details.");

                  relative.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View view) {
                          mAuth.createUserWithEmailAndPassword(s2,s3).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                              @Override
                              public void onComplete(@NonNull Task<AuthResult> task) {

                                  if (task.isSuccessful())
                                  {

                                   say("your account has been created");
                                   startActivity(new Intent(getApplicationContext(),Login.class));

                                  }

                              }
                          });




                      }
                  });
                  relative.setOnLongClickListener(new View.OnLongClickListener() {
                      @Override
                      public boolean onLongClick(View view) {


                          return true;

                      }
                  }


                  );
                    c=0;
                    break  outer;
                }
            }


        }
        });


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
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "say username");
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
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "say 4 digit password");
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
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "say age");
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
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "say phone number");
        try {
            startActivityForResult(intent, R5);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(), "Try Again",
                    Toast.LENGTH_SHORT).show();
        }
    }
    public void say(String text2say) {

        tts.speak(text2say, TextToSpeech.QUEUE_ADD, null);
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
                    say("name you are entered is "+s1);
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
                    say("username you are entered is "+s2);
                    say("tap to proceed.long tap to re enter");
                }
            }
            break;

            case R3: {

                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    password.setText(result.get(0));
                    s3=password.getText().toString();
                    say("password you are entered is "+s3);
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
                    say("age you are entered is "+s4);
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
                    say("phone number you are entered is "+s5);
                    say("tap to proceed. long tap to re enter");
                }
                break;

            }
        }
    }

   public void Delay()
    {
  handler.postDelayed(new Runnable() {
      @Override
      public void run() {

      }
  },5000);
    }

    }
