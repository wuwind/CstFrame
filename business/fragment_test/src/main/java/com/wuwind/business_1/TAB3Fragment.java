package com.wuwind.business_1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.wuwind.common.RouterPathConst;
import com.wuwind.zrouter_annotation.ZRoute;


@ZRoute(RouterPathConst.PATH_FRAGMENT_TAB3)
public class TAB3Fragment extends Fragment {
    public TAB3Fragment() {
    }

    public static TAB3Fragment newInstance(Bundle bundle) {
        TAB3Fragment homeFragment = new TAB3Fragment();
        homeFragment.setArguments(bundle);
        return homeFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_tab3, null);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
