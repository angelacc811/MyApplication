package com.example.cc.myapplication;

import android.app.Activity;
import android.os.Bundle;

import pl.droidsonroids.gif.GifImageView;

/**
 * 主页 烦烦烦方法
 * 烦烦烦
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GifImageView testgif = (GifImageView) findViewById(R.id.testgif);
        testgif.setImageResource(R.mipmap.giftest);
        //我是一个快乐小宝宝
  //我是一个快乐小宝宝dddddddddddddddd
    }
}
