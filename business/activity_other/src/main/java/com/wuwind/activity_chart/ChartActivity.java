package com.wuwind.activity_chart;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.wuwind.common.RouterPathConst;
import com.wuwind.zrouter_annotation.ZRoute;

@ZRoute(RouterPathConst.PATH_ACTIVITY_OTHER)
public class ChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
    }
}
