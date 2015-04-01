package com.adop.sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.adop.sdk.AdEntry;
import com.adop.sdk.BaseInterstitial;
import com.adop.sdk.OptimaAdListener;

public class InterstitialActivity extends Activity {
    private BaseInterstitial mInterstitial;
    private Button mShowButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interstitial);

        mInterstitial = new BaseInterstitial(this); // Interstitial View 생
        AdEntry info = new AdEntry("357"); // 발급받은 ZoneID 입력
        mInterstitial.setAdInfo(info, InterstitialActivity.this); // AdEntry 및 Activity
        
        // OptimaAd Listener 설정
        mInterstitial.setOptimaAdListener(new OptimaAdListener() {
			
			@Override
			public void onSuccesAd() {
				// 광고 Load 성공
			}
			
			@Override
			public void onFailedAd() {
				// 광고 Load 실패
			}
			
			@Override
			public void onCloseAd() {
				// 광고 Close
			}
		});
        
        mShowButton = (Button) findViewById(R.id.showButton);
        mShowButton.setEnabled(true);
    }

    public void showInterstitial(View unusedView) {
    	mInterstitial.load(); // 광고셋팅이 완료 된 후 Load 실행.
    }
}
