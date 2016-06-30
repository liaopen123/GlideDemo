package com.example.pony.glidedemo;

import android.content.Context;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.module.GlideModule;

/**
 * Created by Pony on 2016/4/18.
 */
public class GlideConfiguration implements GlideModule {
    private static final String TAG = "GlideConfiguration";
    int cacheSize100MegaBytes = 1048576*2;
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        builder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
        //设置图片缓存策略  外部存储卡  2M空间  //外部存储空间:默认Android/data/包名/里面
        builder.setDiskCache(new ExternalCacheDiskCacheFactory(context, cacheSize100MegaBytes));
        //设置为内部存储空间 和大小
        builder.setDiskCache(new InternalCacheDiskCacheFactory(context, cacheSize100MegaBytes));
    }

    @Override
    public void registerComponents(Context context, Glide glide) {

    }
}
