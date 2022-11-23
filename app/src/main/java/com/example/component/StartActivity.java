package com.example.component;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.libbase.model.User;
import com.example.librouter.Router;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        //Router.getInstance().startActivity(this, "/login/LoginActivity");
        ARouter.getInstance().build("/login/LoginActivity")
                .withInt("id", 1)
                .withString("name", "LIL WEN")
                .withSerializable("data", new User("Lil Wen"))
                .navigation();
    }
}