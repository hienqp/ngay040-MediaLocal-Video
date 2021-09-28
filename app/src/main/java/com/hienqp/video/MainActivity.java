package com.hienqp.video;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    Button buttonPlayVideo;
    VideoView videoViewDisplayMp4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        captureViewObjectFromLayout();

        buttonPlayVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.thay_long_remix_nal_tvk_legiaquan);
                videoViewDisplayMp4.setVideoURI(uri);
                videoViewDisplayMp4.start();

                MediaController mediaController = new MediaController(MainActivity.this);

                mediaController.setMediaPlayer(videoViewDisplayMp4);
                videoViewDisplayMp4.setMediaController(mediaController);
            }
        });
    }

    private void captureViewObjectFromLayout() {
        buttonPlayVideo = (Button) findViewById(R.id.button_play_video);
        videoViewDisplayMp4 = (VideoView) findViewById(R.id.videoView_display_mp4);
    }
}