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
				mShowButton.setText("Show Interstitial");
                mShowButton.setEnabled(true);
			}
			
			@Override
			public void onFailedAd() {
				// 광고 Load 실패
				mShowButton.setText("Ad Failed to Load");
                mShowButton.setEnabled(false);
			}
			
			@Override
			public void onCloseAd() {
				// 광고 Close
			}
		});
        
        
        mShowButton = (Button) findViewById(R.id.showButton);
        mShowButton.setEnabled(false);
        
    }
    
    public void loadInterstitial(View unusedView) {
    	mShowButton.setText("Loading Interstitial...");
        mShowButton.setEnabled(false);
    	mInterstitial.load();
    }

    public void showInterstitial(View unusedView) {
    	if (mInterstitial.isLoaded()) {
            mInterstitial.show();
        }

        mShowButton.setText("Interstitial Not Ready");
        mShowButton.setEnabled(false);
    }
    
    public void DirectInterstitial(View unusedView) {
    	mInterstitial.start();
    }
}
