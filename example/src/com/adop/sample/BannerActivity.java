package com.adop.sample;

import com.adop.sdk.AdEntry;
import com.adop.sdk.BaseAdView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class BannerActivity extends Activity {
    private BaseAdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdView = new BaseAdView(this); // BaseAdView 생성
        AdEntry aEntry = new AdEntry("342"); // 발급받은 ZoneID 입력
        mAdView.setAdInfo(aEntry, this); // AdEntry, Activity
        mAdView.load(); // Load 광고실행
        
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.mainLayout);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        
        layout.addView(mAdView, params); // 생성한 Layout에 AdView 추가 
        
    }

    @Override
    protected void onPause() {
        mAdView.onPause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mAdView.onResume();
    }

    @Override
    protected void onDestroy() {
        mAdView.onDestroy();
        super.onDestroy();
    }
}
