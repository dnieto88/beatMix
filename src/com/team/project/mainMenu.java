package com.team.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button; 
import android.view.View.OnClickListener;
import android.view.View;

public class mainMenu extends Activity implements OnClickListener{
private audioMixer mSoundManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Button b1 = (Button) findViewById(R.id.playsound);
        
        mSoundManager = new audioMixer();
        mSoundManager.initSounds(getBaseContext());
        mSoundManager.addSound(1, R.raw.boom);
        
		//playAudioTrack();
        //b1.setOnTouchListener(this);
        b1.setOnClickListener(this);
    
    }

	public void onClick(View v) {

		mSoundManager.playSound(1);
        	 
	}
}