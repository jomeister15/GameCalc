package com.gamecalc.jomeister15;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;

import java.io.IOException;
import java.lang.Math;
import java.math.BigDecimal;
import java.math.RoundingMode;
import android.view.inputmethod.InputMethodManager;
import android.content.Context;
import android.widget.Toast;
import java.lang.String;
import android.media.MediaPlayer;
import android.content.Intent;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;





public class MainActivity extends Activity{
	
	  //declaration of vardependence
	  EditText TAG;
	  EditText TBG;
	  EditText TARS;
	  EditText TBRS;
	  EditText TARA;
	  EditText TBRA;
	  EditText TBN;
	  EditText TAN;
	  
	 
	  EditText result;
	  Button domath;
	  
	  //use for da math
	  double twpa=0;
	  double twpb=0;
	  double expa=0;
	  double expb=0;
	  double rsa=0;
	  double rsb=0;
	  double gpa=0;
	  double gpb=0;
	  double raa=0;
	  double rab=0;
	  double fper=0;
	  double fper1=0;
	  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        screen2init();
        initSeq();
      
       
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    private void initSeq()
    
    {
    	TAG=(EditText)findViewById(R.id.TAG);
    	TBG=(EditText)findViewById(R.id.TBG);
    	TARS=(EditText)findViewById(R.id.TARS);
    	TBRS=(EditText)findViewById(R.id.TBRS);
    	TARA=(EditText)findViewById(R.id.TARA);
    	TBRA=(EditText)findViewById(R.id.TBRA);
    	TAN=(EditText)findViewById(R.id.TAN);
    	TBN=(EditText)findViewById(R.id.TBN);
    	result=(EditText)findViewById(R.id.result);
    	domath=(Button)findViewById(R.id.domath);
    	
    	final MediaPlayer mp2=MediaPlayer.create(getBaseContext(), R.raw.miss);
    	final MediaPlayer mp1=MediaPlayer.create(getApplicationContext(), R.raw.baseballhit);
    	
    	domath.setSoundEffectsEnabled(false);
    	domath.setOnClickListener(new Button.OnClickListener()
    	
    	//onclick code
    	{public void onClick 
    	(View v) {
    	
    	
    	//hide keyboard on button press	
    	InputMethodManager inputManager = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE); 

inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                       InputMethodManager.HIDE_NOT_ALWAYS);
    		 
	    //string theory
	String TAG1 = TAG.getText().toString();
	String TBG1 = TBG.getText().toString();
	String TARS1 = TARS.getText().toString();
	String TBRS1 = TBRS.getText().toString();
	String TARA1 = TARA.getText().toString();
	String TBRA1 = TBRA.getText().toString();
	String TAN1 = TBN.getText().toString();
	String TBN1 = TAN.getText().toString();
	String url = "http://www.androidbegin.com/tutorial/android-basic-jsoup-tutorial/";
		
	
	//dat if then doe
	//TODO: Add check for other inputs
	if (TBN.equals("") || TAN.equals(""))
	{
		//dat toast doe
		Toast.makeText(getApplicationContext(), "Some inputs are empty", 
				Toast.LENGTH_SHORT).show();
		
		//swing and miss
		
		mp2.start();
	}
			
	else {
		
		//sounds
		
		mp1.start();
		
		//stirring the pot
		makejsoup();
	
	    //doingdatmath--function version
		dodatmath();
		
		
	}}});	
    		
    		
    		
    	}
    
    //rounding method
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    //adding a second screen
    private void screen2init() {
    	Button screen2 = (Button) findViewById(R.id.screen2);
        screen2.setOnClickListener(new View.OnClickListener() 
        
        {public void onClick(View v) { 
        	
        	Intent myIntent = new Intent(v.getContext(), SideActivity1.class);
            startActivityForResult(myIntent, 0);
        }
        
        });
    }

    //doing the math--director's cut
    
    private void dodatmath() {
    	
    	
    	
    	
    	
    	
    	//all the vars
    	rsa=Double.parseDouble(TARS.getText().toString());
    	rsb=Double.parseDouble(TBRS.getText().toString());
    	raa=Double.parseDouble(TARA.getText().toString());
    	rab=Double.parseDouble(TBRA.getText().toString());
    	gpa=Double.parseDouble(TAG.getText().toString());
    	gpb=Double.parseDouble(TBG.getText().toString());
    	
    	//finding the exponents using pythagenpat
    	expa=Math.pow(((rsa+raa)/(gpa)),(.287));
    	expb=Math.pow(((rsb+rab)/(gpb)),(.287));
    	
    	//finding true win percentage (0.040 is homefield advantage)
    	twpa=((1)/(1+(Math.pow((raa/rsa),(expa)))))+0.040;
    	twpb=(1)/(1+(Math.pow((rab/rsb),(expb))));
    	
    	//determing who will win
    	fper=(twpa-(twpa*twpb))/((twpa+twpb)-(2*twpa*twpb));
    	fper1=round((fper*100),2);
    	result.setText(Double.toString(fper1));
    	
    			
    	
    	
    	
    
    }
    
    //jsoup access method
    
     
    public void makejsoup() {
    	
    	
    	String url = "http://www.androidbegin.com/tutorial/android-basic-jsoup-tutorial/";
    	String desc;	
    	
    	//TODO: elaborate on Jsoup code, acccess runs scored, etc...,
    	try {
			Document document = Jsoup.connect(url).get();
			
			//selecting certain parts of html
			Elements description = document
					.select("meta[name=description]");
			//accessing description
			desc = description.attr("content");
			//setting description in TARS string
			TARS.setText(desc);
			
		} catch (IOException e) {
			//TODO: change error--maybe make toast
			e.printStackTrace();
		}
    	
    	
    	
    	
    }
    
    
    
}

