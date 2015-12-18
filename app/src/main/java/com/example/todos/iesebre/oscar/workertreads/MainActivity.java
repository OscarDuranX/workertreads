package com.example.todos.iesebre.oscar.workertreads;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private ImageView mImageView;

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mImageView = (ImageView) findViewById(R.id.imageMostra);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                new Thread(new Runnable() {
                    public void run() {
                        Bitmap b = loadImageFromNetwork("http://example.com/image.png");
                        mImageView.setImageBitmap(b);
                    }
                }).start();
            }

//            public void onClick(View v) {
//
//                new Thread(new Runnable() {
//                    public void run() {
//                        Bitmap b = loadImageFromNetwork("http://example.com/image.png");
//                        mImageView.setImageBitmap(b);
//                    }
//                }).start();
//
//
//            }

            private Bitmap loadImageFromNetwork(String url) {
                try {
                    Bitmap bitmap = BitmapFactory.decodeStream((InputStream) new URL(url).getContent());
                    return bitmap;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }


       });


    }
}
