package com.example.breintraning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    TextView sumtextview,textView2,timerTextview;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int locationofcorrectanswer;
    Button button, button2, button3 , button4,button5;
    Integer score = 0;
    int numberofquestions = 0;
    TextView pointtextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        textView2 = findViewById(R.id.textView2);
        timerTextview = findViewById(R.id.timerTextview);

        button5.setVisibility(View.INVISIBLE);
        textView2.setVisibility(View.INVISIBLE);
        pointtextview = findViewById(R.id.pointtextview);



        generatequwstion();

//        new CountDownTimer(3000, 1000) {
//            @Override
//            public void onTick(long miliunitfinished) {
//
//                timerTextview.setText(String.valueOf(miliunitfinished/1000+"")+ "s");
//
//            }
//
//            @Override
//            public void onFinish() {
//
//                textView2.setText("Final Score :"+ Integer.toString(score) + "/" + Integer.toString(numberofquestions));
//                button5.setVisibility(View.VISIBLE);
//
//            }
//        }.start();

        playagain(findViewById(R.id.button5));
       



    }

    public  void choosans(@NonNull View view){

//        Log.i("tag", (String) view.getTag());

        if (view.getTag().toString().equals(Integer.toString(locationofcorrectanswer))){

            textView2.setVisibility(View.VISIBLE);
            Log.i("correct", "correct");
            score++;
            textView2.setText("CORRECT");


        }else {

            textView2.setVisibility(View.VISIBLE);
            Log.i("correct", "incorrect");
            textView2.setText("INCORRECT");

        }
        numberofquestions ++;
        pointtextview.setText(Integer.toString(score) + "/" + Integer.toString(numberofquestions));
        generatequwstion();


    }


    public  void  generatequwstion(){

        button.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        button4.setEnabled(true);

        int a , b ;

        Random ran = new Random();

        a = ran.nextInt(50);
        b = ran.nextInt(50);

        sumtextview = findViewById(R.id.sumtextview);
        sumtextview.setText(Integer.toString(a) + "+" + Integer.toString(b));


        locationofcorrectanswer = ran.nextInt(4);
        answers.clear();

        int incorrect;

        for (int i = 0; i < 4; i++) {
            if (i == locationofcorrectanswer) {

                answers.add(a + b);

            }else{
                incorrect = ran.nextInt(41);



                while (incorrect == a +b) {

                    incorrect = ran.nextInt(41);

                }
                answers.add(incorrect);


            }

        }

        button.setText(Integer.toString(answers.get(0)));
        button2.setText(Integer.toString(answers.get(1)));
        button3.setText(Integer.toString(answers.get(2)));
        button4.setText(Integer.toString(answers.get(3)));


    }

    public  void  playagain(View view){
        generatequwstion();

        score = 0;
        numberofquestions =0 ;

        timerTextview.setText("hello");
        pointtextview.setText("0/0");
        textView2.setVisibility(View.INVISIBLE);
        button5.setVisibility(View.INVISIBLE);

        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long miliunitfinished) {

                timerTextview.setText(String.valueOf(miliunitfinished/1000+"")+ "s");

            }

            @Override
            public void onFinish() {

                textView2.setText("Final Score :"+ Integer.toString(score) + "/" + Integer.toString(numberofquestions));
                button5.setVisibility(View.VISIBLE);
                button.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);

            }
        }.start();


    }

}