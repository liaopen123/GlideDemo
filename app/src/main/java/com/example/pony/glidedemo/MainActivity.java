package com.example.pony.glidedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView iv = (ImageView) findViewById(R.id.iv);
        Glide.with(this).load("http://xiaoziqianbao.oss-cn-hangzhou.aliyuncs.com/tixianyouhua2.jpg").into(iv);
        Glide.with(this).load("https://camo.githubusercontent.com/0b993d6b4ae35fa2a7de09a48e7b0d7a4ec79dfa/687474703a2f2f6a636f64656372616565722e636f6d2f75706c6f6164732f32303135303332372f313432373434353336363530333038342e676966").asGif().into(iv);
    }
}
