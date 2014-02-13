package com.gamecalc.jomeister15;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import java.lang.Math;
import java.math.BigDecimal;
import java.math.RoundingMode;
import android.view.inputmethod.InputMethodManager;
import android.content.Context;
import android.widget.Toast;
import java.lang.String;
import android.media.MediaPlayer;
import android.content.Intent;



//TODO: have this screen do something
public class SideActivity1 extends Activity {

/** Called when the activity is first created. */
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_side);

    Button next = (Button) findViewById(R.id.goback);
    next.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
            Intent intent = new Intent();
            setResult(RESULT_OK, intent);
            finish();
        }

    });
}}