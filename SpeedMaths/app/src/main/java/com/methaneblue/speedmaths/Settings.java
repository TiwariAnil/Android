package com.methaneblue.speedmaths;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class Settings extends PreferenceActivity  {

    private SharedPreferences SP;
    private static PrefManager  prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new MyPreferenceFragment()).commit();

        SharedPreferences.OnSharedPreferenceChangeListener mListener;
        SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        prefManager = new PrefManager(getBaseContext());

    }

    public static class MyPreferenceFragment extends PreferenceFragment implements
            SharedPreferences.OnSharedPreferenceChangeListener{
        @Override
        public void onCreate(final Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);
        }

        @Override
        public void onResume() {
            super.onResume();
            getPreferenceScreen().getSharedPreferences()
                    .registerOnSharedPreferenceChangeListener(this);
        }

        @Override
        public void onPause() {
            super.onPause();
            getPreferenceScreen().getSharedPreferences()
                    .unregisterOnSharedPreferenceChangeListener(this);
        }

//        public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {
//            if (key.equals("username")) {
//                Preference pref = findPreference(key);
//                pref.setDefaultValue(prefs.getString(key, "bob"));
//            } else if (key.equals("addLEVEL")) {
//                Preference pref = findPreference(key);
//                pref.setDefaultValue(prefs.getString(key, "1"));
//            } else if (key.equals("mulLEVEL")) {
//                Preference pref = findPreference(key);
//                pref.setDefaultValue(prefs.getString(key, "1"));
//            } else if (key.equals("mixedLEVEL")) {
//                Preference pref = findPreference(key);
//                pref.setDefaultValue(prefs.getString(key, "1"));
//            } else if (key.equals("loopLEVEL")) {
//                Preference pref = findPreference(key);
//                pref.setDefaultValue(prefs.getString(key, "1"));
//            } else if (key.equals("duelLEVEL")) {
//                Preference pref = findPreference(key);
//                pref.setDefaultValue(prefs.getString(key, "1"));
//            }
//        }


        public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {
            if (key.equals("username")) {
                Preference pref = findPreference(key);
                pref.setDefaultValue(prefs.getString(key, "bob"));
            } else if (key.equals("addLEVEL")) {
                Preference pref = findPreference(key);
                pref.setDefaultValue(prefManager.getAddLEVEL());

            } else if (key.equals("mulLEVEL")) {
                Preference pref = findPreference(key);
                pref.setDefaultValue(prefManager.getMulLEVEL());
            } else if (key.equals("mixedLEVEL")) {
                Preference pref = findPreference(key);
                pref.setDefaultValue(prefManager.getMixedLEVEL());
            } else if (key.equals("loopLEVEL")) {
                Preference pref = findPreference(key);
                pref.setDefaultValue(prefManager.getLoopLEVEL());
            } else if (key.equals("duelLEVEL")) {
                Preference pref = findPreference(key);
                pref.setDefaultValue(prefManager.getDuelLEVEL());
            }
        }
    }
}
