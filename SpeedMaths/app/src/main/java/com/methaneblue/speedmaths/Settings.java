package com.methaneblue.speedmaths;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import java.util.List;

public class Settings extends PreferenceActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new MyPreferenceFragment()).commit();
    }

    public static class MyPreferenceFragment extends PreferenceFragment
    {
        PrefManager prefManager;
        @Override
        public void onCreate(final Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);

//            prefManager = new PrefManager(Settings.this);
//            SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
//            prefManager.setAddSTRENGTH((Integer.parseInt(SP.getString("addType", "Level 1").toString())));
        }
    }

}