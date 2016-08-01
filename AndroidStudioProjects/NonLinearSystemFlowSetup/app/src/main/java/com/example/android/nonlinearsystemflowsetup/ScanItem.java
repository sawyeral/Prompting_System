package com.example.android.nonlinearsystemflowsetup;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class ScanItem extends AppCompatActivity {

    int counterAttemptsPhoto = 1;
    int counterAttemptsVideo = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_item);

        // Switch from 'Scan Item - Photo Prompt' to 'Navigate to Shipping'
        Button buttonScanItemToNavToShip = (Button) findViewById(R.id.button_scanitemphoto_correctnumber_navtoship);
        buttonScanItemToNavToShip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentScanItemToNavToShip = new Intent(getApplicationContext(),NavToShip.class);
                startActivity(intentScanItemToNavToShip);
            }
        });

        // Switch from 'Scan Item - Photo Prompt' to 'Call for Help'
        Button buttonScanItemToCallForHelp = (Button) findViewById(R.id.button_scanitemphoto_callforhelp);
        buttonScanItemToCallForHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentScanItemToCallForHelp = new Intent(getApplicationContext(),CallForHelp.class);
                startActivity(intentScanItemToCallForHelp);
            }
        });

        // Play Attempt 1 'Scan Item' Audio Prompt
        MediaPlayer mpScanItemAttempt1 = MediaPlayer.create(this, R.raw.scan_item_attempt1_sample);
        mpScanItemAttempt1.start();
    }

    public void itemScanNoAction(View view){
        if (counterAttemptsPhoto < 2){
            MediaPlayer mpScanItemNoAction = MediaPlayer.create(this, R.raw.scan_item_noresponse_sample);
            mpScanItemNoAction.start();
            counterAttemptsPhoto = counterAttemptsPhoto + 1;
        } else{
            setContentView(R.layout.activity_scan_item_video);
            VideoView vvScanItemVideo = (VideoView) findViewById(R.id.scanitem_video);
            vvScanItemVideo.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.sample_video_prompt);
            vvScanItemVideo.setMediaController(new MediaController(this));
            vvScanItemVideo.start();
        }
    }

    public void itemScanTooMany(View view){
        if (counterAttemptsPhoto < 2){
            MediaPlayer mpScanItemTooMany = MediaPlayer.create(this, R.raw.scan_item_toomany_sample);
            mpScanItemTooMany.start();
            counterAttemptsPhoto = counterAttemptsPhoto + 1;
        } else{
            setContentView(R.layout.activity_scan_item_video);
            VideoView vvScanItemVideo = (VideoView) findViewById(R.id.scanitem_video);
            vvScanItemVideo.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.sample_video_prompt);
            vvScanItemVideo.setMediaController(new MediaController(this));
            vvScanItemVideo.start();
        }
    }

    public void itemScanWrongItem(View view){
        if (counterAttemptsPhoto < 2){
            MediaPlayer mpScanItemWrongItem = MediaPlayer.create(this, R.raw.scan_item_wrongitem_sample);
            mpScanItemWrongItem.start();
            counterAttemptsPhoto = counterAttemptsPhoto + 1;
        } else{
            setContentView(R.layout.activity_scan_item_video);
            VideoView vvScanItemVideo = (VideoView) findViewById(R.id.scanitem_video);
            vvScanItemVideo.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.sample_video_prompt);
            vvScanItemVideo.setMediaController(new MediaController(this));
            vvScanItemVideo.start();
        }
    }

    public void itemScanVideoNoAction(View view){
        if (counterAttemptsVideo < 2){
            VideoView vvScanItemVideo = (VideoView) findViewById(R.id.scanitem_video);
            vvScanItemVideo.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.sample_video_prompt);
            vvScanItemVideo.setMediaController(new MediaController(this));
            vvScanItemVideo.start();
            counterAttemptsVideo = counterAttemptsVideo + 1;
        } else{
            Intent intentScanItemToCallForHelp = new Intent(getApplicationContext(),CallForHelp.class);
            startActivity(intentScanItemToCallForHelp);
        }
    }

    public void itemScanVideoTooMany(View view){
        if (counterAttemptsVideo < 2){
            VideoView vvScanItemVideo = (VideoView) findViewById(R.id.scanitem_video);
            vvScanItemVideo.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.sample_video_prompt);
            vvScanItemVideo.setMediaController(new MediaController(this));
            vvScanItemVideo.start();
            counterAttemptsVideo = counterAttemptsVideo + 1;
        } else{
            Intent intentScanItemToCallForHelp = new Intent(getApplicationContext(),CallForHelp.class);
            startActivity(intentScanItemToCallForHelp);
        }
    }

    public void itemScanVideoWrongItem(View view){
        if (counterAttemptsVideo < 2){
            VideoView vvScanItemVideo = (VideoView) findViewById(R.id.scanitem_video);
            vvScanItemVideo.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.sample_video_prompt);
            vvScanItemVideo.setMediaController(new MediaController(this));
            vvScanItemVideo.start();
            counterAttemptsVideo = counterAttemptsVideo + 1;
        } else{
            Intent intentScanItemToCallForHelp = new Intent(getApplicationContext(),CallForHelp.class);
            startActivity(intentScanItemToCallForHelp);
        }
    }

    public void itemScanVideoCorrectNumber(View view){
        Intent intentScanItemToNavToShip = new Intent(getApplicationContext(),NavToShip.class);
        startActivity(intentScanItemToNavToShip);
    }

    public void itemScanVideoToCallForHelp(View view){
        Intent intentScanItemToCallForHelp = new Intent(getApplicationContext(),CallForHelp.class);
        startActivity(intentScanItemToCallForHelp);
    }

}

