package com.tbi.punchdonaldtrump.MyUtilities;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by brst-pc93 on 11/24/16.
 */

public class MySharedPreferences
{
    private static MySharedPreferences instance = null;

    public final String PreferenceName = "MyPreference";

    public static MySharedPreferences getInstance()
    {
        if(instance == null)
        {
            instance=new MySharedPreferences();
        }
        return instance;
    }


    public SharedPreferences getPreference(Context context)
    {
        return context.getSharedPreferences(PreferenceName, Activity.MODE_PRIVATE);
    }

    public void saveCoins(Context context,int coinsCount)
    {
        SharedPreferences.Editor editor = getPreference(context).edit();
        editor.putInt(MyConstants.COINS_COUNT, coinsCount);
        editor.apply();
    }


    public int getCoins(Context context)
    {
       return getPreference(context).getInt(MyConstants.COINS_COUNT,0);
    }

    public boolean openInterstitialApp(Context context)
    {
       int count= getPreference(context).getInt(MyConstants.INTERSTITIAL_ADD_COUNT,0);

        count++;

        SharedPreferences.Editor editor = getPreference(context).edit();
        editor.putInt(MyConstants.INTERSTITIAL_ADD_COUNT, count==3 ? 0 : count);
        editor.apply();


        if(count == 3)
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    public void buyWeapon(Context context,String weaponName)
    {
        SharedPreferences.Editor editor = getPreference(context).edit();
        editor.putBoolean(weaponName, true);
        editor.apply();
    }

    public boolean getWeaponStatus(Context context,String weaponName)
    {
        return getPreference(context).getBoolean(weaponName,false);
    }



}
