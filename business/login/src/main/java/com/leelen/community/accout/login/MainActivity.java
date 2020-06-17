package com.leelen.community.accout.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.leelen.community.account.constance.CommunityConst;
import com.leelen.community.account.view.activity.RegisterOrResetPwdActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnRegister;
    Button btnForget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, RegisterOrResetPwdActivity.class);
        int id = view.getId();
        if (id == R.id.btn_register) {
        } else if (id == R.id.btn_forget) {
            intent.putExtra(CommunityConst.BUNDLE_VERIFY_CODE_TYPE,
                    CommunityConst.VerifyCodeType.TYPE_MODIFY_PASSWORD);
        }
        startActivity(intent);
    }

    private void initViews() {
        btnRegister = (Button) findViewById(R.id.btn_register);
        btnForget = (Button) findViewById(R.id.btn_forget);
        btnRegister.setOnClickListener(this);
        btnForget.setOnClickListener(this);
    }
}
