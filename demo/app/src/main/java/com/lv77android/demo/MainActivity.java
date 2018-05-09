package com.lv77android.demo;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loginCheck(View view) {
        EditText userName = findViewById(R.id.username);
        EditText pw = findViewById(R.id.pword);

        if(userName.getText() == null || userName.getText().toString().equals("")){
            Toast.makeText(MainActivity.this, "Username is not entered!",Toast.LENGTH_LONG);
            return;
        }

        if(pw.getText() == null || pw.getText().toString().equals("")){
            Toast.makeText(MainActivity.this, "Password is not entered!",Toast.LENGTH_LONG);
            return;
        }

        TextView tv = findViewById(R.id.title);
        tv.setTextSize(30);
        if(pw.getText().toString().equalsIgnoreCase("itsfriday!")){
            tv.setText(R.string.welcome_msg_after_login_bonus);
        }else {
            tv.setText(R.string.welcome_msg_after_login_normal);
        }

        ImageView iv = findViewById(R.id.welcomeImage);
        iv.setVisibility(View.VISIBLE);

        view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

        Log.i("PROGRESS","Login completed!");
        return;

    }
}
