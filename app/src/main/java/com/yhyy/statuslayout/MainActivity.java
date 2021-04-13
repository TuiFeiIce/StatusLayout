package com.yhyy.statuslayout;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.yhyy.statuslayout.widget.EmptyLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.emptyLayout)
    EmptyLayout emptyLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        emptyLayout.setOnLayoutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emptyLayout.setContentType(EmptyLayout.LOADING);
            }
        });
    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                emptyLayout.setContentType(EmptyLayout.LOADING);
                emptyLayout.setContentMessage("加载中");
                break;
            case R.id.button2:
                emptyLayout.setContentType(EmptyLayout.CONTENT);
                emptyLayout.setContentMessage("加载失败");
                emptyLayout.setContentImage(R.mipmap.ic_launcher_round);
                emptyLayout.setContentClick(true);
                break;
            case R.id.button3:
                emptyLayout.dismiss();
                break;
        }
    }
}