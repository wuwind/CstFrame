package com.leelen.community.account.view.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.leelen.community.account.constance.CommunityConst;
import com.leelen.community.account.contract.RegisterOrResetPwdContract;
import com.leelen.community.account.model.SharePreferenceModel;
import com.leelen.community.account.presenter.RegisterOrResetPwdPresenter;
import com.leelen.community.register.MainActivity;
import com.leelen.community.register.R;
import com.leelen.core.base.BaseActivity;

/**
 * @description:
 * @copyright: Copyright (c) 2019 厦门立林科技有限公司
 * @author: cwx
 * @date: 2019/4/25
 * @version: 1.00
 * @history:
 */
public class RegisterOrResetPwdActivity extends BaseActivity<RegisterOrResetPwdPresenter> implements RegisterOrResetPwdContract.View, View.OnClickListener {
    private int mVerifyCodeType;

    private boolean mCanSeePwd;
    private boolean mCanGetCode = true;
    private ImageView ivClose;
    private TextView tvTitle;
    private EditText etUserName;
    private EditText etVerifyCode;
    private TextView tvGetVerifyCode;
    private EditText etPwd;
    private ImageView ivPwdSee;
    private TextView tvTips;
    private Button btnSure;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_register_or_reset_pwd);
        init();
    }

    @Override
    protected RegisterOrResetPwdPresenter createPresenter() {
        return new RegisterOrResetPwdPresenter();
    }


    private void init() {
        initViews();
        clickSeePwdBtn();// 让密码默认可见
        etUserName.addTextChangedListener(mWatcher);
        etVerifyCode.addTextChangedListener(mWatcher);
        etPwd.addTextChangedListener(mWatcher);
        Intent intent = getIntent();
        mVerifyCodeType = intent.getIntExtra(CommunityConst.BUNDLE_VERIFY_CODE_TYPE,
                CommunityConst.VerifyCodeType.TYPE_ACCOUNT_REGISTER);
        if (mVerifyCodeType == CommunityConst.VerifyCodeType.TYPE_MODIFY_PASSWORD) {
            String userName = intent.getStringExtra(CommunityConst.BUNDLE_USER_NAME);
            etUserName.setText(userName);
            etUserName.setSelection(etUserName.getText().toString().trim().length());
            tvTitle.setText(R.string.forget_password);
        } else {
            tvTitle.setText(R.string.account_register);
        }
    }


    protected int getActivityLayoutId() {
        return R.layout.activity_account_register_or_reset_pwd;

    }

    /**
     * 点击切换密码状态：可见与不可见
     */
    public void clickSeePwdBtn() {
        mCanSeePwd = !mCanSeePwd;
        if (mCanSeePwd) {
            ivPwdSee.setImageResource(R.drawable.selector_bg_see);
            etPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            etPwd.setSelection(etPwd.getText().toString().trim().length());
        } else {
            ivPwdSee.setImageResource(R.drawable.selector_bg_not_see);
            etPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
            etPwd.setSelection(etPwd.getText().toString().trim().length());
        }
    }

    private TextWatcher mWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int arg1, int arg2, int arg3) {
        }

        @Override
        public void beforeTextChanged(CharSequence s, int arg1, int arg2, int arg3) {
        }

        @SuppressLint("ResourceAsColor")
        @Override
        public void afterTextChanged(Editable s) {
            String username = etUserName.getText().toString().trim();
            if (!TextUtils.isEmpty(username) && username.length() == CommunityConst.PHONE_NUM_LENGTH && mCanGetCode) {
                tvGetVerifyCode.setEnabled(true);
            } else {
                tvGetVerifyCode.setEnabled(false);
            }
            String verifyCode = etVerifyCode.getText().toString().trim();
            String pwd = etPwd.getText().toString().trim();
            if (!TextUtils.isEmpty(username) && username.length() == CommunityConst.PHONE_NUM_LENGTH
                    && !TextUtils.isEmpty(verifyCode) && verifyCode.length() == 6
                    && !TextUtils.isEmpty(pwd) && pwd.length() >= CommunityConst.MIN_PASSWORD_LENGTH) {
                btnSure.setEnabled(true);
                int diverHeight = (int) (getResources().getDimension(R.dimen.button_elevation) + 0.5f);
//                btnSure.setElevation(diverHeight);
            } else {
                btnSure.setEnabled(false);
//                btnSure.setElevation(0);
            }
        }
    };

    public String getUserName() {
        return etUserName.getText().toString().trim();
    }

    public String getPassword() {
        return etPwd.getText().toString().trim();
    }

    public String getVerifyCode() {
        return etVerifyCode.getText().toString().trim();
    }

    public int getVerifyCodeType() {
        return mVerifyCodeType;
    }

    public void setGetVerifyCodeText(int num) {
        if (num >= 0) {
            tvGetVerifyCode.setText(String.format(getResources().getString(R.string.format_countdown_second), "" + num));
        } else {
            tvGetVerifyCode.setText(R.string.get_verify_code);
        }
    }

    public void setGetCodeEnable(boolean enable) {
        mCanGetCode = enable;
        etUserName.setEnabled(enable);
        tvGetVerifyCode.setEnabled(enable);
    }

    public void toMainActivity() {
        // 跳转到主页
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    private void initViews() {
        ivClose = (ImageView) findViewById(R.id.iv_close);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        etUserName = (EditText) findViewById(R.id.et_user_name);
        etVerifyCode = (EditText) findViewById(R.id.et_verify_code);
        tvGetVerifyCode = (TextView) findViewById(R.id.tv_get_verify_code);
        etPwd = (EditText) findViewById(R.id.et_pwd);
        ivPwdSee = (ImageView) findViewById(R.id.iv_pwd_see);
        tvTips = (TextView) findViewById(R.id.tv_tips);
        btnSure = (Button) findViewById(R.id.btn_sure);
        ivClose.setOnClickListener(this);
        tvTitle.setOnClickListener(this);
        etUserName.setOnClickListener(this);
        etVerifyCode.setOnClickListener(this);
        tvGetVerifyCode.setOnClickListener(this);
        etPwd.setOnClickListener(this);
        ivPwdSee.setOnClickListener(this);
        tvTips.setOnClickListener(this);
        btnSure.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.iv_close) {
            finish();
        } else if (id == R.id.iv_pwd_see) {
            clickSeePwdBtn();
        } else if (id == R.id.tv_get_verify_code) {
            mPresenter.getVerifyCode();
        } else if (id == R.id.btn_sure) {
            if (SharePreferenceModel.getIsEncryptAccountEnable()) {
                mPresenter.getUuid();
            } else {
                mPresenter.clickSure();
            }
        }
    }
}
