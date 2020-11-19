package com.example.android.sunshine;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.EditTextPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceManager;
import android.support.v7.preference.PreferenceScreen;

public class SettingsFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener {
    @Override
    public void onCreatePreferences(Bundle bundle, String key) {
        addPreferencesFromResource(R.xml.pref_settings);
        SharedPreferences shared_Prefer_setting= getPreferenceScreen().getSharedPreferences();
        PreferenceScreen pref_scn=getPreferenceScreen();
        int pref_size=pref_scn.getPreferenceCount();

        for(int i=0;i<pref_size;i++)
        {
            Preference preference=pref_scn.getPreference(i);
            if(!(preference instanceof CheckBoxPreference))
            {
                String value=shared_Prefer_setting.getString(preference.getKey(),"");
                setSummuryPref(preference,value);
            }
        }
    }

    private void setSummuryPref(Preference preference, String value) {
        if(preference instanceof ListPreference)
        {
            ListPreference unit_listpreference= (ListPreference) preference;
            int pref_index=unit_listpreference.findIndexOfValue(value);
            if(pref_index>=0)
            {
                unit_listpreference.setSummary(unit_listpreference.getEntries()[pref_index]);
            }
        }
        else {
            EditTextPreference location_edt_pref= (EditTextPreference) preference;
            location_edt_pref.setSummary(value);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
Preference preference=findPreference(key);
if(preference!=null)
{if(!(preference instanceof CheckBoxPreference))
{
setSummuryPref(preference,sharedPreferences.getString(key,""));
    }}}
}
