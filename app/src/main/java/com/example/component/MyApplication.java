package com.example.component;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.librouter.Router;
import com.example.module.login.LoginActivity;
import com.example.module.main.MainActivity;

/**
 * @author AlexisYin
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        /*Router.getInstance().register("/main/MainActivity", MainActivity.class);
        Router.getInstance().register("/login/LoginActivity", LoginActivity.class);*/

        if (BuildConfig.DEBUG) {
            // 打印日志
            ARouter.openLog();
            // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
            ARouter.openDebug();
        }
        ARouter.init(this);
    }
}
