package com.tbi.punchdonaldtrump.MyUtilities;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.tbi.punchdonaldtrump.util.IabHelper;
import com.tbi.punchdonaldtrump.util.IabResult;

/**
 * Created by brst-pc93 on 12/1/16.
 */

public class MyInAppPurchase
{

    static public  IabHelper mHelper;


    public static void initializeInappPurchaseHelper(Context context)
    {
        String base64EncodedPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjsHIi9r/QCG+U9VsCA9bRc/LgZK+QAaH05xzthfaEIy+30vEK6tw1ifbtc6GoYH4rZHMgXQzBgkdzAZkACjs57/+1ovRQ88fGEb1HN78jiCpmbmQriNTPztXN5j93nq3kc64hoCUx+vvKhn9WgsRSW4rU7qyICTuUA9GbiCjQ472sWo0El90guG8un5nhO9Hs0Ldl9ifkOe9aahj/V/OWqpKA7QiJf0XnJPM7ZgHuAphaqWKjYOZgO0To0rPWwlxJWh9kJeqc3KUdu06bIRPIFETEk6DlieJ7zYY9uhxyPl/8IKS72avNCV7uwDykSOwQVlyERcYMZi814jkLe3GCwIDAQAB";

        // compute your public key and store it in base64EncodedPublicKey
        mHelper = new IabHelper(context, base64EncodedPublicKey);
        mHelper.startSetup(new IabHelper.OnIabSetupFinishedListener()
        {
            @Override
            public void onIabSetupFinished(IabResult result)
            {
                if (!result.isSuccess())
                {
                    // Oh no, there was a problem.
                    {


                    }
                    Log.e("Log_tag", "Problem setting up In-app Billing: " + result);
                }
                else
                {

                    Log.e("Log_tag", " In-app Billing setup done: " + result);
                }
            }


        });
    }

    public static void destroyingInappPurchase(Context mcontext)
    {
        if (mHelper != null)
        {
            try
            {
                mHelper.dispose();
            } catch (IabHelper.IabAsyncInProgressException e)
            {
                e.printStackTrace();
            }
        }
        mHelper = null;


    }

    public static void buySingleCharacter(Activity context, String product_id, IabHelper.OnIabPurchaseFinishedListener onIabPurchaseFinishedListener)
    {


        try
        {
            mHelper.launchPurchaseFlow(context, product_id, 10001, onIabPurchaseFinishedListener, "");
        } catch (IabHelper.IabAsyncInProgressException e)
        {
            e.printStackTrace();
        }
    }


}
