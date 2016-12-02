package com.tbi.punchdonaldtrump;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.tbi.punchdonaldtrump.MyUtilities.MyConstants;
import com.tbi.punchdonaldtrump.MyUtilities.MyInAppPurchase;
import com.tbi.punchdonaldtrump.MyUtilities.MySharedPreferences;
import com.tbi.punchdonaldtrump.MyUtilities.MyUtil;
import com.tbi.punchdonaldtrump.util.IabHelper;
import com.tbi.punchdonaldtrump.util.IabResult;
import com.tbi.punchdonaldtrump.util.Purchase;

public class MoreCoins extends AppCompatActivity implements View.OnClickListener
{


    TextView txtv_coin_count;

    Context context;

    MyUtil myUtil = new MyUtil();

    int coinsCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_coins);

        context = this;

        setUpIDS();

        coinsCount = MySharedPreferences.getInstance().getCoins(context);

        txtv_coin_count.setText("" + coinsCount);

    }

    private void setUpIDS()
    {

        myUtil.applyFont(context, findViewById(R.id.linearLayout_main));

        txtv_coin_count = (TextView) findViewById(R.id.txtv_coin_count);

        findViewById(R.id.txtv_back).setOnClickListener(this);

        findViewById(R.id.linearlayout_10coins).setOnClickListener(this);
        findViewById(R.id.linearlayout_25coins).setOnClickListener(this);
        findViewById(R.id.linearlayout_50coins).setOnClickListener(this);
        findViewById(R.id.linearlayout_100coins).setOnClickListener(this);
        findViewById(R.id.linearlayout_300coins).setOnClickListener(this);

    }


    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.txtv_back:

                finish();

                break;

            case R.id.linearlayout_10coins:

                MyInAppPurchase.buySingleCharacter(MoreCoins.this, MyConstants.COINS_10, onIabPurchaseFinishedListener);

                break;

            case R.id.linearlayout_25coins:

                MyInAppPurchase.buySingleCharacter(MoreCoins.this, MyConstants.COINS_25, onIabPurchaseFinishedListener);

                break;

            case R.id.linearlayout_50coins:

                MyInAppPurchase.buySingleCharacter(MoreCoins.this, MyConstants.COINS_50, onIabPurchaseFinishedListener);

                break;

            case R.id.linearlayout_100coins:

                MyInAppPurchase.buySingleCharacter(MoreCoins.this, MyConstants.COINS_100, onIabPurchaseFinishedListener);

                break;

            case R.id.linearlayout_300coins:

                MyInAppPurchase.buySingleCharacter(MoreCoins.this, MyConstants.COINS_300, onIabPurchaseFinishedListener);

                break;

        }
    }


    IabHelper.OnIabPurchaseFinishedListener onIabPurchaseFinishedListener = new IabHelper.OnIabPurchaseFinishedListener()
    {
        @Override
        public void onIabPurchaseFinished(IabResult result, Purchase info)
        {
            Log.e("Response InApppurchase", "Result : " + result + " Info : " + info);
        }
    };


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        // super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 10001)
        {

            if (MyInAppPurchase.mHelper == null) return;
            Log.d("Log_tag", "onActivityResult");
            // Pass on the activity result to the helper for handling
            if (!MyInAppPurchase.mHelper.handleActivityResult(requestCode, resultCode, data))
            {
                // not handled, so handle it ourselves (here's where you'd
                // perform any handling of activity results not related to in-app
                // billing...
                super.onActivityResult(requestCode, resultCode, data);
            }
            else
            {
                Log.d("Log_tag", "onActivityResult handled by IABUtil.");
            }

        }
    }


}
