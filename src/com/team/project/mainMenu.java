package com.team.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.os.Bundle;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.widget.Button; 
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.View.OnTouchListener;


public class mainMenu extends Activity implements OnClickListener{
public byte[] boom;
int intSize = android.media.AudioTrack.getMinBufferSize(44100, AudioFormat.CHANNEL_CONFIGURATION_MONO,
        AudioFormat.ENCODING_PCM_16BIT);

AudioTrack at = new AudioTrack(AudioManager.STREAM_MUSIC, 44100, AudioFormat.CHANNEL_CONFIGURATION_MONO,
                    AudioFormat.ENCODING_PCM_16BIT, intSize, AudioTrack.MODE_STREAM);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Button b1 = (Button) findViewById(R.id.playsound);
        
        try {
			boom = CreateBuffer("android.resource://" + getPackageName() + "/res/raw/boom");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		playAudioTrack();
        //b1.setOnTouchListener(this);
        b1.setOnClickListener(this);
  
    
    }

    
	public void onClick(View v) {
//android.resource://
     //   try {
        	//PlayAudioTrack("android.resource://" + getPackageName() + "/res/raw/boom");
        	PlayAudioTrack(boom);
		//} catch (IOException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		
	}

    private void playAudioTrack()
    {
    	at.play();
    }
    private void stopAudioTrack()
    {
    	at.stop();
    }
	
	private byte[] CreateBuffer(String filePath) throws IOException
	{
		if (filePath == null)
			return null;
		
		byte[] byteData = null;
	    InputStream file = getResources().openRawResource(R.raw.boom);
	    byteData = new byte[file.available()];
		   
	    try {
	       //in = new FileInputStream( file );
	      file.read( byteData );
	        file.close(); 

	    } catch (FileNotFoundException e) {
	        // TODO Auto-generated catch block
	    ////    e.printStackTrace();
	    }
	    
	    return byteData;
	    
		
	}
   
	private void PlayAudioTrack(byte[] byteData ) 
	{
/*
	    if (filePath==null)
	        return;

	    byte[] byteData = null;

	     InputStream file = getResources().openRawResource(R.raw.boom);
	    //file = new File(filePath); // sdcard path
	    byteData = new byte[file.available()];
	   
	    try {
	       //in = new FileInputStream( file );
	      file.read( byteData );
	        file.close(); 

	    } catch (FileNotFoundException e) {
	        // TODO Auto-generated catch block
	    ////    e.printStackTrace();
	    }
*/
	   
	 //   at.play();

	    at.write(byteData, 0, byteData.length);
	  //  at.stop();              

	}
	
	


	//public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
	//	return false;
	//}


	//public void onClick(View v) {
		// TODO Auto-generated method stub
		
	//}

	@Override
	public void onDestroy()
	{
		at.stop();
		super.onDestroy();
	}
	
	
        
}
