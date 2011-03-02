package com.team.project;

import android.app.Activity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.view.View;;
public class beatMix extends Activity {
	
	/** Global variable for image button */
  
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
       
       
    	//ImageButton splashscreen = (ImageButton) findViewById(R.id.splashscreen);
    	
    }
  
    
    /**When the splash screen is clicked advance to next screen */
    public void clickNew(View v)
    {
    	this.finish();
 
    	
    }

    
    
}