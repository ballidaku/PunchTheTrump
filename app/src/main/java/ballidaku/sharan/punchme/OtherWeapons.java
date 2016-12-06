package ballidaku.sharan.punchme;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import ballidaku.sharan.punchme.MyUtilities.MyConstants;
import ballidaku.sharan.punchme.MyUtilities.MySharedPreferences;
import ballidaku.sharan.punchme.MyUtilities.MyUtil;

import com.sharan.punchme.R;

public class OtherWeapons extends AppCompatActivity implements View.OnClickListener
{

    public TextView txtv_coin_count;
    TextView txtv_baseball_buy;
    TextView txtv_wall_buy;
    TextView txtv_hillary_buy;

    Context context;

    MyUtil myUtil = new MyUtil();

    int coinsCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_weapons);
        context = this;

        setUpIDS();
    }


    @Override
    protected void onResume()
    {
        super.onResume();

        coinsCount = MySharedPreferences.getInstance().getCoins(context);

        txtv_coin_count.setText("" + coinsCount);
    }

    private void setUpIDS()
    {

        myUtil.applyFont(context, findViewById(R.id.linearLayout_main));

        (txtv_coin_count = (TextView) findViewById(R.id.txtv_coin_count)).setOnClickListener(this);


        txtv_baseball_buy = (TextView) findViewById(R.id.txtv_baseball_buy);
        txtv_wall_buy = (TextView) findViewById(R.id.txtv_wall_buy);
        txtv_hillary_buy = (TextView) findViewById(R.id.txtv_hillary_buy);

        txtv_baseball_buy.setOnClickListener(this);
        txtv_wall_buy.setOnClickListener(this);
        txtv_hillary_buy.setOnClickListener(this);


        findViewById(R.id.txtv_back).setOnClickListener(this);


        if (MySharedPreferences.getInstance().getWeaponStatus(context, MyConstants.BASEBALL))
        {
            txtv_baseball_buy.setVisibility(View.INVISIBLE);
        }

        if (MySharedPreferences.getInstance().getWeaponStatus(context, MyConstants.WALL))
        {
            txtv_wall_buy.setVisibility(View.INVISIBLE);
        }

        if (MySharedPreferences.getInstance().getWeaponStatus(context, MyConstants.HILLARY))
        {
            txtv_hillary_buy.setVisibility(View.INVISIBLE);
        }


    }


    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.txtv_back:

                finish();

                break;


            case R.id.txtv_coin_count:

                startActivity(new Intent(context, MoreCoins.class));

                break;


            case R.id.txtv_baseball_buy:

                check(MyConstants.BASEBALL);
                //MyInAppPurchase.buySingleCharacter(OtherWeapons.this, MyConstants.KEY_BASEBALL, onIabPurchaseFinishedListener);

                break;

            case R.id.txtv_wall_buy:

                check(MyConstants.WALL);
                //MyInAppPurchase.buySingleCharacter(OtherWeapons.this, MyConstants.KEY_WALL, onIabPurchaseFinishedListener);

                break;

            case R.id.txtv_hillary_buy:

                check(MyConstants.HILLARY);
                //MyInAppPurchase.buySingleCharacter(OtherWeapons.this, MyConstants.KEY_HILLARY, onIabPurchaseFinishedListener);

                break;
        }
    }

    private void check(String BWH)
    {

        int coins = MySharedPreferences.getInstance().getCoins(context);

        if (BWH.equals(MyConstants.BASEBALL))
        {
            if (coins >= 50)
            {
                MySharedPreferences.getInstance().buyWeapon(context, MyConstants.BASEBALL);
                int remainingCoins = coins - 50;
                MySharedPreferences.getInstance().saveCoins(context, remainingCoins);
                txtv_coin_count.setText("" + MySharedPreferences.getInstance().getCoins(context));

                txtv_baseball_buy.setVisibility(View.INVISIBLE);
            }
            else
            {
                Toast.makeText(context, "You don't have enough money to buy item", Toast.LENGTH_SHORT).show();
            }
        }
        else if (BWH.equals(MyConstants.WALL))
        {
            if (coins >= 150)
            {
                MySharedPreferences.getInstance().buyWeapon(context, MyConstants.WALL);
                int remainingCoins = coins - 150;
                MySharedPreferences.getInstance().saveCoins(context, remainingCoins);
                txtv_coin_count.setText("" + MySharedPreferences.getInstance().getCoins(context));

                txtv_wall_buy.setVisibility(View.INVISIBLE);
            }
            else
            {
                Toast.makeText(context, "You don't have enough money to buy item", Toast.LENGTH_SHORT).show();
            }
        }
        else if (BWH.equals(MyConstants.HILLARY))
        {
            if (coins >= 300)
            {
                MySharedPreferences.getInstance().buyWeapon(context, MyConstants.HILLARY);
                int remainingCoins = coins - 300;
                MySharedPreferences.getInstance().saveCoins(context, remainingCoins);
                txtv_coin_count.setText("" + MySharedPreferences.getInstance().getCoins(context));

                txtv_hillary_buy.setVisibility(View.INVISIBLE);
            }
            else
            {
                Toast.makeText(context, "You don't have enough money to buy item", Toast.LENGTH_SHORT).show();
            }
        }
    }










 /*   IabHelper.OnIabPurchaseFinishedListener onIabPurchaseFinishedListener = new IabHelper.OnIabPurchaseFinishedListener()
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
    }*/
}