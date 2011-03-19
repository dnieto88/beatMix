package com.team.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.widget.Button; 
import android.view.View.OnClickListener;
import android.view.View;


public class mainMenu extends Activity implements OnClickListener{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Button b1 = (Button) findViewById(R.id.playsound);
        
        b1.setOnClickListener(this);
  
    
    }

    
	public void onClick(View v) {

        try {
			PlayAudioTrack("android.resource://com.team.project/raw/kick");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


   
	private void PlayAudioTrack(String filePath) throws IOException
	{

	    if (filePath==null)
	        return;

	    byte[] byteData = null;

	    File file = null; 
	    file = new File(filePath); // sdcard path
	    byteData = new byte[(int) file.length()];
	    FileInputStream in = null;
	    try {
	        in = new FileInputStream( file );
	        in.read( byteData );
	        in.close(); 

	    } catch (FileNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }

	    int intSize = android.media.AudioTrack.getMinBufferSize(8000, AudioFormat.CHANNEL_CONFIGURATION_MONO,
	            AudioFormat.ENCODING_PCM_8BIT);

	    AudioTrack at = new AudioTrack(AudioManager.STREAM_MUSIC, 8000, AudioFormat.CHANNEL_CONFIGURATION_MONO,
	                        AudioFormat.ENCODING_PCM_8BIT, intSize, AudioTrack.MODE_STREAM);

	    at.play();

	    at.write(byteData, 0, byteData.length);
	    at.stop();              

	}

        
}
