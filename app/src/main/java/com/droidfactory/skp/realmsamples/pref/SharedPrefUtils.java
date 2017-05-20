package com.droidfactory.skp.realmsamples.pref;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import static android.text.TextUtils.isEmpty;

/**
 * Created by Shashi Pal on 5/20/2017.
 */

public class SharedPrefUtils {

    public static final String CHECK_BOX_PREF = "check_box_pref";

    private static SharedPreferences prefs;

    public static Object getPreferenceValue (Context context, String prefKey, Object defaultValue) {

        if ( prefs == null ) {

            prefs = PreferenceManager.getDefaultSharedPreferences ( context );

        }

        Object data = null;

        if ( !isEmpty ( prefKey ) && defaultValue != null ) {
            if ( defaultValue instanceof String ) {
                data = prefs.getString ( prefKey, ( String ) defaultValue );
            } else if ( defaultValue instanceof Integer ) {
                data = prefs.getInt ( prefKey, ( Integer ) defaultValue );
            } else if ( defaultValue instanceof Boolean ) {
                data = prefs.getBoolean ( prefKey, ( Boolean ) defaultValue );
            } else if ( defaultValue instanceof Long ) {
                data = prefs.getLong ( prefKey, ( Long ) defaultValue );
            } else if ( defaultValue instanceof Float ) {
                data = prefs.getFloat ( prefKey, ( Float ) defaultValue );
            }
        }

        return data;

    }


    /**
     * UPDATE the preference value of any type
     *
     * @param key   the key
     * @param value the value
     */
    @SuppressWarnings("SameParameterValue")
    @SuppressLint("CommitPrefEdits")
    public static void updatePreferenceValue (Context context, String key, Object value) {

        if ( !isEmpty ( key ) && value != null ) {
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences
                    ( context );
            SharedPreferences.Editor editor = preferences.edit ();
            if ( value instanceof String ) {
                editor.putString ( key, ( String ) value );
            } else if ( value instanceof Integer ) {
                editor.putInt ( key, ( Integer ) value );
            } else if ( value instanceof Boolean ) {
                editor.putBoolean ( key, ( Boolean ) value );
            } else if ( value instanceof Long ) {
                editor.putLong ( key, ( Long ) value );
            } else if ( value instanceof Float ) {
                editor.putFloat ( key, ( Float ) value );
            }
            editor.commit ();
        }
    }

}
