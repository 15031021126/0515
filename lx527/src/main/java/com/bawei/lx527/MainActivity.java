package com.bawei.lx527;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.lx527.dlmvp.Ionecontract;
import com.bawei.lx527.dlmvp.OnePresenterImpl;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements Ionecontract.IOneView {

    private Button dl;
    private TextView zc;
    private ImageView eye;
    private EditText editPhone;
    private EditText editpwd;
    private OnePresenterImpl presenter;
    private Boolean b = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dl = findViewById(R.id.dl);
        zc = findViewById(R.id.zc);
        eye = findViewById(R.id.eye);
        editPhone = findViewById(R.id.edphone);
        editpwd = findViewById(R.id.edpwd);
        presenter = new OnePresenterImpl();
        presenter.attach(this);

        Intent intent = getIntent();
        String zh = intent.getStringExtra("zh");
        String mm = intent.getStringExtra("mm");
        editPhone.setText(zh);
        editpwd.setText(mm);
        zc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ZCActivity.class);
                startActivity(intent);
            }
        });
        dl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = editPhone.getText().toString().trim();
                String b = editpwd.getText().toString().trim();
                presenter.requestDL(MainActivity.this, "http://172.17.8.100/small/user/v1/login", a, b);
            }
        });

        eye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b = !b;
                if (b) {
                    editpwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    editpwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }

            }
        });
    }

    @Override
    public void showData(String result) {
        //Log.e("123", "showData: " + result);

        try {
            JSONObject object = new JSONObject(result);
            String message = object.getString("message");
            Toast.makeText(this, "" + message, Toast.LENGTH_SHORT).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
