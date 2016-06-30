package com.example.pony.glidedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView iv = (ImageView) findViewById(R.id.iv);
        //正常使用方法
        Glide.with(this).load("http://xiaoziqianbao.oss-cn-hangzhou.aliyuncs.com/tixianyouhua2.jpg").into(iv);
        //添加动态图片的方法
        Glide.with(this).load("https://camo.githubusercontent.com/0b993d6b4ae35fa2a7de09a48e7b0d7a4ec79dfa/687474703a2f2f6a636f64656372616565722e636f6d2f75706c6f6164732f32303135303332372f313432373434353336363530333038342e676966").asGif().into(iv);
        //设置占位图的方法 错误图示  和圆角的方法
        Glide.with(this).load("http://xiaoziqianbao.oss-cn-hangzhou.aliyuncs.com/tixianyouhua2.jpg").placeholder(getResources().getDrawable(R.mipmap.loading_fail_banner)).error(getResources().getDrawable(R.mipmap.loading_fail_banner)).transform(new GlideRoundTransform(this, 4)).into(iv);
        //设置Glide的监听
        Glide.with(this).load("http://xiaoziqianbao.oss-cn-hangzhou.aliyuncs.com/tixianyouhua2.jpg").listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                Log.e(TAG,"onResourceReady:"+"图片加载成功");
                //图片加载成功的回调  可以做一些操作  比如显示按钮
                return false;
            }
        }).into(iv);
    }
}
