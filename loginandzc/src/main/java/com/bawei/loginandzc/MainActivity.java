package com.bawei.loginandzc;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.loginandzc.mvp.Ionecontract;
import com.bawei.loginandzc.mvp.OnePersenterImpl;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements Ionecontract.iOneView {

    private Button dl;
    private Button zc;
    private EditText phone;
    private EditText pwd;
    private OnePersenterImpl persenter;
    private String a;
    private String b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        persenter = new OnePersenterImpl();
        persenter.attach(this);
        dl = findViewById(R.id.dl);
        zc = findViewById(R.id.zc);
        phone = findViewById(R.id.phone);
        pwd = findViewById(R.id.pwd);
        Intent intent = new Intent(MainActivity.this, TwoActivity.class);
        startActivity(intent);

        dl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                a = phone.getText().toString();
                b = pwd.getText().toString();
                if (a.equals("") && b.equals("")) {
                    Toast.makeText(MainActivity.this, "不得为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                persenter.requestLogin(MainActivity.this, "http://172.17.8.100/small/user/v1/login", a, b);

            }
        });
        zc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                a = phone.getText().toString();
                b = pwd.getText().toString();
                if (a.equals("") && b.equals("")) {
                    Toast.makeText(MainActivity.this, "不得为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                persenter.reauestZc(MainActivity.this, "http://172.17.8.100/small/user/v1/register", a, b);
            }
        });
    }

    @Override
    public void getData(String data) {

        try {
            JSONObject object = new JSONObject(data);
            String message = object.getString("message");
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            if (message.equals("登录成功")) {
                Intent intent = new Intent(MainActivity.this, TwoActivity.class);
                startActivity(intent);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
