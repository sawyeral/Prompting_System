package com.example.android.nonlinearsystemflowsetup;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.media.MediaPlayer;
import android.widget.MediaController;
import android.widget.VideoView;

import static com.example.android.nonlinearsystemflowsetup.R.*;

public class NavToItem extends AppCompatActivity {

    int counterNavToItemPhoto = 1;
    int counterNavToItemVideo = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_nav_to_item_photo);

        // Switch from 'Navigate to Item - Photo Prompt" to "Call for Help"
        Button buttonNavToItemToCallForHelp = (Button) findViewById(id.button_navtoitemphoto_callforhelp);
        buttonNavToItemToCallForHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentNavToItemToCallForHelp = new Intent(getApplicationContext(), CallForHelp.class);
                startActivity(intentNavToItemToCallForHelp);
            }
        });

        // Switch from 'Navigate to Item - Photo Prompt' to 'Scan Item'
        Button buttonNavToItemToScanItem = (Button) findViewById(id.button_navtoitemphoto_arrival_scanitem);
        buttonNavToItemToScanItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentNavToItemToScanItem = new Intent(getApplicationContext(), ScanItem.class);
                startActivity(intentNavToItemToScanItem);
            }
        });


        // Play second photo prompt for 'Navigate to Item - Photo Prompt'
        final Button buttonNavToItemSecondAttempt = (Button) findViewById(id.button_navtoitemphoto_noarrival_navtoitemvideo);
        buttonNavToItemSecondAttempt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Intent intentNavToItemPhotoToNavToItemVideo = new Intent(getApplicationContext(), NavToItemVideo.class);
                //startActivity(intentNavToItemPhotoToNavToItemVideo);
                if (counterNavToItemPhoto < 2) {
                    navToItemPhotoPlay();
                    counterNavToItemPhoto = counterNavToItemPhoto + 1;
                } else {
                    //Intent intentNavToItemPhotoToNavToItemVideo = new Intent(getApplicationContext(), ScanItem.class);
                    //startActivity(intentNavToItemPhotoToNavToItemVideo);
                    setContentView(layout.activity_nav_to_item_video);
                    navToItemVideoPrompt(view);
                }
            }

        });

        MediaPlayer mpNavItemAttempt1 = MediaPlayer.create(this, R.raw.navigate_to_item_attempt1_sample);
        mpNavItemAttempt1.start();
    }

    public void navToItemPhotoPlay() {
        MediaPlayer mpNavItemAttempt2 = MediaPlayer.create(this, R.raw.navigate_to_item_attempt2_sample);
        mpNavItemAttempt2.start();
        counterNavToItemPhoto = counterNavToItemPhoto + 1;
    }

    // Switch to 'Navigate to Item - Video Prompt'
    public void navToItemVideoPrompt(View view) {
        if (counterNavToItemVideo < 2) {
            VideoView vvNavToItemVideo = (VideoView) findViewById(id.navtoitemvideo_video);
            vvNavToItemVideo.setVideoPath("android.resource://" + getPackageName() + "/" + raw.sample_video_prompt);
            vvNavToItemVideo.setMediaController(new MediaController(this));
            vvNavToItemVideo.start();
            counterNavToItemVideo = counterNavToItemVideo + 1;
        } else {
            Intent intentNavToItemVideoToCallForHelp = new Intent(getApplicationContext(), CallForHelp.class);
            startActivity(intentNavToItemVideoToCallForHelp);
        }

    }

    public void navToItemVideoToCallForHelp(View view) {
        Intent intentNavToItemVideoToCallForHelp = new Intent(getApplicationContext(), CallForHelp.class);
        startActivity(intentNavToItemVideoToCallForHelp);
    }

    public void navToItemVideoToScanItem(View view) {
        Intent intentNavToItemVideoToScanItem = new Intent(getApplicationContext(), ScanItem.class);
        startActivity(intentNavToItemVideoToScanItem);
    }

}

        /*public void navToItemPhotoPlay(View view) {
        if (counterNavToItemPhoto < 2) {
            MediaPlayer mpNavItemAttempt2 = MediaPlayer.create(this, R.raw.navigate_to_item_attempt2_sample);
            mpNavItemAttempt2.start();
            counterNavToItemPhoto = counterNavToItemPhoto + 1;
        } else {
            counterNavToItemVideo = counterNavToItemVideo + 1;
            navToItemPhotoToNavToItemVideo();
        }

    }

    public void navToItemPhotoToNavToItemVideo() {
        if (counterNavToItemVideo < 2) {
            setContentView(layout.activity_nav_to_item_video);
            VideoView vvNavToItemVideo = (VideoView) findViewById(id.navtoitemvideo_video);
            vvNavToItemVideo.setVideoPath("android.resource://" + getPackageName() + "/" + raw.sample_video_prompt);
            ;
            vvNavToItemVideo.setMediaController(new MediaController(this));
            vvNavToItemVideo.start();

            counterNavToItemVideo = counterNavToItemVideo + 1;
        }
    }*/

// }
//}