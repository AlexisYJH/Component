package com.example.module.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.libbase.model.User;
import com.example.librouter.Router;

@Route(path = "/login/LoginActivity")
public class LoginActivity extends AppCompatActivity {

    @Autowired(name = "id")
    int id;
    @Autowired
    String name;
    @Autowired(name = "data")
    User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ARouter.getInstance().inject(this);
        Log.d("TAG", "onCreate: " + id + ", name: " + name + ", data: " + user);
    }

    public void login(View view) {
        //Router.getInstance().startActivity(this, "/main/MainActivity");
        ARouter.getInstance().build("/main/MainActivity").navigation();
    }
}