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
import android.widget.Toast;

import com.bawei.lx527.dlmvp.Ionecontract;
import com.bawei.lx527.dlmvp.OnePresenterImpl;

import org.json.JSONException;
import org.json.JSONObject;

public class ZCActivity extends AppCompatActivity implements Ionecontract.IOneView {

    private Button zc;
    private EditText editPhone;
    private EditText editpwd;
    private Boolean bb = false;
    private OnePresenterImpl presenter;
    private ImageView eye;
    private ImageView fh;

    private String b;
    private String a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zc);
        zc = findViewById(R.id.zc);
        editPhone = findViewById(R.id.edphone);
        eye = findViewById(R.id.eye);

        editpwd = findViewById(R.id.edpwd);
        fh = findViewById(R.id.backfh);
        presenter = new OnePresenterImpl();

        presenter.attach(ZCActivity.this);
        zc.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                a = editPhone.getText().toString().trim();
                b = editpwd.getText().toString().trim();
                presenter.requestZC(ZCActivity.this, "http://172.17.8.100/small/user/v1/register", a, b);
            }
        });
        fh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ZCActivity.this, MainActivity.class);
                intent.putExtra("zh", a);
                intent.putExtra("mm", b);
                startActivity(intent);
            }
        });

        eye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bb = !bb;
                if (bb) {
                    editpwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    editpwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }

            }
        });
    }

    @Override
    public void showData(String result) {
        try {
            JSONObject object = new JSONObject(result);
            String message = object.getString("message");
            Toast.makeText(this, "" + message, Toast.LENGTH_SHORT).show();
            if (message.equals("注册成功")) {
                Intent intent = new Intent(ZCActivity.this, MainActivity.class);
                intent.putExtra("zh", a);
                intent.putExtra("mm", b);
                startActivity(intent);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
