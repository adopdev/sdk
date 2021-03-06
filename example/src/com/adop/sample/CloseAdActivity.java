package com.adop.sample;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.adop.sdk.AdEntry;
import com.adop.sdk.BaseRectAdView;

public class CloseAdActivity extends Activity {
	private Button mShowButton;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_closead);
        
        mShowButton = (Button) findViewById(R.id.showButton);
        mShowButton.setEnabled(true);
        
    }

    public void showCloseAd(View unusedView) {
    	BaseRectAdView closead = new BaseRectAdView(this); // BaseRectAdView 생성
    	AdEntry info = new AdEntry("399"); // 발급받은 ZoneID 입력
    	closead.setAdInfo(info, this); // AdEntry 및 Activity
    	
    	closead.setAge(27); // 숫자로 기입.
    	closead.setGender(AdEntry.MALE); // 남자(MALE), 여자(FEMALE)로 구분. 모를땐 미사용.
    	closead.setKeyword("sports,game"); // 키워드 ,(콤마)로 여러개 입력 가능.
    	
    	closead.load();
    	
    	alertClose(closead);
    }

    
	private void alertClose(View view) {
		new AlertDialog.Builder(this, AlertDialog.THEME_HOLO_LIGHT)
			.setTitle("Close")
			.setView(view)
			.setPositiveButton("Yes",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,	int whichButton) {
							finish();
						}
					})
			.setNegativeButton("Cancel",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,	int whichButton) {

						}
		}).create().show();
	}
}
