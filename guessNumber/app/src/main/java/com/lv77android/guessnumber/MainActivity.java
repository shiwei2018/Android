package com.lv77android.guessnumber;

import android.content.Context;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private long highRange = 0;
    private long lowRange = 0;
    private long random = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        randomizing();
    }

    private void randomizing(){
        while(this.highRange <= 1) {
            this.highRange = generateRandomIntBetween(1L, 100L);
        }
        this.lowRange = generateRandomIntBetween(0L, this.highRange);
        this.random = generateRandomIntBetween(this.lowRange,this.highRange);

        Log.i("DEFINITION","Low： " + this.lowRange +"; High: " + this.highRange + "; Random: " +this.random);
        TextView display = findViewById(R.id.headline);
        display.setText("I'm thinking of an integer number from " + this.lowRange + " to " + this.highRange);
    }

    private Long generateRandomIntBetween(long low, long high){

        if(low >= high){
            long tmp = low;
            high = low;
            low = tmp;
        }
        double lowl = low*0.01;
        double highl = high*0.01;
        double realRans = Math.random();
        while(realRans < lowl || realRans >highl){
            Log.i("PROGRESSING","generated: " + realRans);
            realRans = Math.random();
        }

        return Long.valueOf(Math.round(realRans*100));
    }

    public void showResult(View view) {

        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

        EditText et = findViewById(R.id.guess_line);
        ImageView trycatch = findViewById(R.id.hint_image1);
        ImageView resultwrong = findViewById(R.id.hint_image2);
        ImageView resultright = findViewById(R.id.hint_image3);
        Integer input = 0;
        try {
            input = Integer.valueOf(et.getText().toString());
        } catch (Exception e) {
            Log.e("ERROR", "The input is " + et.getText().toString());
            trycatch.setVisibility(View.VISIBLE);
            resultwrong.setVisibility(View.INVISIBLE);
            resultright.setVisibility(View.INVISIBLE);
            Toast.makeText(MainActivity.this, "Woops! You need to guess a whole number!", Toast.LENGTH_SHORT).show();
            et.setText("");

            return;
        }


        Log.e("PROGRESS", "The input is " + input);

        if (input > random) {
            trycatch.setVisibility(View.INVISIBLE);
            resultwrong.setVisibility(View.VISIBLE);
            resultright.setVisibility(View.INVISIBLE);
            Toast.makeText(MainActivity.this, input + " is too large! Keep trying! ", Toast.LENGTH_SHORT).show();
            et.setText("");
        } else if (input < random) {
            trycatch.setVisibility(View.INVISIBLE);
            resultwrong.setVisibility(View.VISIBLE);
            resultright.setVisibility(View.INVISIBLE);
            Toast.makeText(MainActivity.this, input + " is too small! Do it again!", Toast.LENGTH_SHORT).show();
            et.setText("");
        } else {
            trycatch.setVisibility(View.INVISIBLE);
            resultwrong.setVisibility(View.INVISIBLE);
            resultright.setVisibility(View.VISIBLE);
            Toast.makeText(MainActivity.this, "Congratulations! You got the right number! Try again!", Toast.LENGTH_LONG).show();
            et.setText("");
            randomizing();
        }
    }
}
