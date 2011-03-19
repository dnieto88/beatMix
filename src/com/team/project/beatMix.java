package com.team.project;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class beatMix extends Activity {
	
	/** Global variable for image button */
  
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
       
        /** Moved to xml file */
    	//ImageButton splashscreen = (ImageButton) findViewById(R.id.splashscreen);
    	
    }
  
    
    /**When the splash screen is clicked advance to next screen */
    public void clickNew(View v)
    {

    /** this is what creates a new window */
    	Intent intent = new Intent(beatMix.this, mainMenu.class);
    	startActivity(intent);
    	
    	/** since this is only a splash screen
    	 * i figure move this off the stack
    	 * since we really do not want anyone backing
    	 * up into it.
    	 */
    	this.finish();
    }

    
    
}