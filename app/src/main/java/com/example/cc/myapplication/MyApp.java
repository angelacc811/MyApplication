package com.example.cc.myapplication;
import android.app.Application;

import com.lzy.okgo.OkGo;

/**
 * @ClassName: MyApp
 * @Description: application
 * @author chun.chen@wonhe.net
 * @date 2017/7/12
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        OkGo.getInstance().init(this);
    }
}
