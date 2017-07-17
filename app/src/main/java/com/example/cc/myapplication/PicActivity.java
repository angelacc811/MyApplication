package com.example.cc.myapplication;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.File;

import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.GrayscaleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import pl.droidsonroids.gif.GifImageView;

/**
 * @author chun.chen@wonhe.net
 * @ClassName: PicActivity
 * @Description:图片处理
 * @date 2017/7/17
 */
public class PicActivity extends Activity {
    GifImageView testgif;
    ImageView testiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_pic);
            GifImageView testgif = (GifImageView) findViewById(R.id.testgif);
            ImageView testiv = (ImageView) findViewById(R.id.testiv);
            ImageView testiv_huidu = (ImageView) findViewById(R.id.testiv_huidu);
            ImageView testiv_yuan = (ImageView) findViewById(R.id.testiv_yuan);
            ImageView testiv_yuanjiao = (ImageView) findViewById(R.id.testiv_yuanjiao);
            ImageView testiv_bendigif = (ImageView) findViewById(R.id.testiv_bendigif);



            //1:加载gif动画
            testgif.setImageResource(R.mipmap.giftest);
            // 3、使用Glide加载网络图片
            Glide.with(this)
                    .load("http://inthecheesefactory.com/uploads/source/glidepicasso/cover.jpg")
                    .into(testiv);
            // 3、使用Glide加载网络图片并且灰度
            Glide.with(this)
                    .load("http://inthecheesefactory.com/uploads/source/nestedfragment/fragments.png")
                    .bitmapTransform(new GrayscaleTransformation(this))
                    .placeholder( R.mipmap.dw_jzz ).error( R.mipmap.dw_jzz ).into(testiv_huidu);
            // 4、使用Glide加载网络图片并且圆形裁剪
            Glide.with(this)
                    .load("http://inthecheesefactory.com/uploads/source/nestedfragment/fragments.png")
                    .bitmapTransform(new CropCircleTransformation(this))
                    .into(testiv_yuan);
            // 5、使用Glide加载网络图片并且圆角处理
        Glide.with(this)
                .load("http://inthecheesefactory.com/uploads/source/nestedfragment/fragments.png")
                .bitmapTransform(new RoundedCornersTransformation(this,30,0, RoundedCornersTransformation.CornerType.ALL))
                .into(testiv_yuanjiao);


        }
    }
}
