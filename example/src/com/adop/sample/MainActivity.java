package com.adop.sample;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    private static class Sample {
        private String mTitle;
        private Class<? extends Activity> mActivityClass;
        
        private Sample(String title, Class<? extends Activity> activityClass) {
            mTitle = title;
            mActivityClass = activityClass;
        }

        @Override
        public String toString() {
            return mTitle;
        }

        public Class<? extends Activity> getActivityClass() {
            return mActivityClass;
        }
        
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Sample[] samples = {
            new Sample("BannerAdActivity", BannerActivity.class),
            new Sample("InstitialAdActivity", InterstitialActivity.class),
            new Sample("CloseAdActivity", CloseAdActivity.class),
        };
        setListAdapter(new ArrayAdapter<Sample>(this, android.R.layout.simple_list_item_1, samples));
        
    }

    @Override
    protected void onListItemClick(ListView listView, View view, int position, long id) {
        Sample sample = (Sample) listView.getItemAtPosition(position);
        Intent intent = new Intent(this.getApplicationContext(), sample.getActivityClass());
        startActivity(intent);
    }
}
