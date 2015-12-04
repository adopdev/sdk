package com.adop.sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.RelativeLayout;

import com.adop.sdk.AdEntry;
import com.adop.sdk.BaseAdView;

public class BannerActivity extends Activity {
    private BaseAdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdView = new BaseAdView(this); // BaseAdView 생성
        AdEntry aEntry = new AdEntry("342"); // 발급받은 ZoneID 입력
        mAdView.setAdInfo(aEntry, this); // AdEntry, Activity
        
//        mAdView.setHouseAd(true); // 하우스배너 사용 설정
//        mAdView.setHouseAdURL("http://"); // 하우스배너 사용시 원하는 ImageURL 설정. 미설정시 ADOP HouseAd Image 노출
//        mAdView.setRefresh(false); // 광고 리프레쉬 기능 on/off 설정
//        mAdView.setFillRate(false); // 광고 FillRate 기능 on/off 설정
        
        mAdView.setAge(27); // 숫자로 기입.
        mAdView.setGender(AdEntry.MALE); // 남자(MALE), 여자(FEMALE)로 구분. 모를땐 미사용.
        mAdView.setKeyword("sports,game"); // 키워드 ,(콤마)로 여러개 입력 가능.
        
        mAdView.setInterval(60); // 초 단위 기재.
        mAdView.load(); // Load 광고실행
        mAdView.setGravity(Gravity.CENTER);
        
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
