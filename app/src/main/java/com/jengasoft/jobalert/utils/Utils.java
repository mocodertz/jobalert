package com.jengasoft.jobalert.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by MoCoder#1956# on 10/4/2017.
 */

public class Utils {
    private static final String PREFERENCES_FILE = "jobalert_settings";

    public static void saveSharedSetting(Context context, String settingName, String settingValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCES_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor sharedPreferenceEditor = sharedPreferences.edit();
        sharedPreferenceEditor.putString(settingName, settingValue);
        sharedPreferenceEditor.apply();
    }

    public static String readSharedSetting(Context context, String settingName, String defaultValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCES_FILE, Context.MODE_PRIVATE);
        return sharedPreferences.getString(settingName, defaultValue);
    }
}
