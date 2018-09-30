package com.jengasoft.jobalert.ui.activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.jengasoft.jobalert.R;
import com.jengasoft.jobalert.ui.fragment.FeedFragment;
import com.jengasoft.jobalert.ui.fragment.HelpFragment;
import com.jengasoft.jobalert.ui.fragment.ProfileFragment;
import com.jengasoft.jobalert.ui.fragment.SettingFragment;
import com.jengasoft.jobalert.ui.helper.BottomNavigationViewBehavior;
import com.jengasoft.jobalert.ui.helper.BottomNavigationViewHelper;
import com.jengasoft.jobalert.utils.Utils;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView mBottomNavigationView;
    private Toolbar toolbar;
    public static final String PREF_USER_FIRST_TIME = "user_first_time";
    boolean isUserFirstTime;

    public static final String TEST_DEVICE_ID = "DEVICE_ID_EMULATOR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        isUserFirstTime = Boolean.valueOf(Utils.readSharedSetting(MainActivity.this, PREF_USER_FIRST_TIME, "true"));

        Intent introIntent = new Intent(MainActivity.this, OnBoardingActivity.class);
        introIntent.putExtra(PREF_USER_FIRST_TIME, isUserFirstTime);

        //if (isUserFirstTime)
            //startActivity(introIntent);

        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Job Feed");
        setSupportActionBar(toolbar);
        setupBottomNavigation();

        if (savedInstanceState == null) {
            loadFeedFragment();
        }
    }

    private void setupBottomNavigation() {

        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.disableShiftMode(mBottomNavigationView);
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) mBottomNavigationView.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationViewBehavior());

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.action_job_feed:
                        loadFeedFragment();
                        return true;
                    case R.id.action_job_pin:
                        loadPinFragment();
                        return true;
                    case R.id.action_job_help:
                        loadHelpFragment();
                        return true;
                    /**case R.id.action_setting:
                        loadSettingFragment();
                        return true;*/
                }
                return false;
            }
        });
    }

    private void loadFeedFragment() {

        FeedFragment feedFragment = FeedFragment.newInstance();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_frame, feedFragment);
        fragmentTransaction.commit();
        toolbar.setTitle("Job Feed");
    }

    private void loadPinFragment() {

        ProfileFragment profileFragment = ProfileFragment.newInstance();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_frame, profileFragment);
        fragmentTransaction.commit();
        toolbar.setTitle("Profile");
    }

    private void loadHelpFragment() {

        HelpFragment helpFragment = HelpFragment.newInstance();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_frame, helpFragment);
        fragmentTransaction.commit();
        toolbar.setTitle("Help");
    }

    private void loadSettingFragment() {

        SettingFragment settingFragment = SettingFragment.newInstance();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_frame, settingFragment);
        fragmentTransaction.commit();
        toolbar.setTitle("Setting");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }
}
