package com.tbi.punchdonaldtrump;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;

import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.tbi.punchdonaldtrump.MyUtilities.MyConstants;
import com.tbi.punchdonaldtrump.MyUtilities.MyInAppPurchase;
import com.tbi.punchdonaldtrump.MyUtilities.MyLibrary;
import com.tbi.punchdonaldtrump.MyUtilities.MySharedPreferences;
import com.tbi.punchdonaldtrump.MyUtilities.MyUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    ImageView imgv_main;
    ImageView imgv_background;


    TextView txtv_punch_count;
    TextView txtv_coin_count;

    FrameLayout frameLayout_main;

    MyUtil myUtil = new MyUtil();

    Context context;

    MediaPlayer mp;

    int coinsCount = 0;

    int punchCount = 0;

    String LRB;



    String PHWB = MyConstants.PUNCH;


    int intervalTime = 1000;

    InterstitialAd mInterstitialAd;
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        context = this;

        setUpIDS();

        MySharedPreferences.getInstance().saveCoins(context, 301);



        action(R.drawable.trump_right);

       /* setUpBannerAdd();


        if (MySharedPreferences.getInstance().openInterstitialApp(context))
        {
            setUpInterstitialAdd();
        }*/


        MyInAppPurchase.initializeInappPurchaseHelper(context);
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        coinsCount = MySharedPreferences.getInstance().getCoins(context);

        txtv_coin_count.setText("" + coinsCount);
    }

    String TAG = "ABC";

    private void setUpIDS()
    {

        findViewById(R.id.imgv_round_hillary).setOnClickListener(this);
        findViewById(R.id.imgv_round_wall).setOnClickListener(this);

        findViewById(R.id.imgv_round_baseball).setOnClickListener(this);
        findViewById(R.id.imgv_round_punch).setOnClickListener(this);

        txtv_punch_count = (TextView) findViewById(R.id.txtv_punch_count);
        txtv_coin_count = (TextView) findViewById(R.id.txtv_coin_count);
        txtv_coin_count.setOnClickListener(this);

        imgv_main = (ImageView) findViewById(R.id.imgv_main);
        imgv_background= (ImageView) findViewById(R.id.imgv_background);

        frameLayout_main = (FrameLayout) findViewById(R.id.frameLayout_main);

        myUtil.applyFont(context, findViewById(R.id.frameLayout_main));


        frameLayout_main.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View view, MotionEvent e)
            {

                Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
                int viewWidth = display.getWidth();
                int viewHeight = display.getHeight();


//                Log.e(TAG+"XXXX", ""+e.getX()+"---------"+viewWidth*0.7+"---------"+viewWidth*0.3);

                // RIGHT SIDE SCREEN
                if (e.getX() > (viewWidth * 0.7))
                {
//                    Log.e(TAG, "RIGHT SIDE");

                    punch(MyConstants.RIGHT);

                    /*if(e.getY()> viewHeight*0.7){
                        Log.e(TAG, "right down on screen");
                    }else if(e.getY()> (viewHeight*0.45)){
                        Log.e(TAG, "right middle on screen   ");
                    }*/
                }
                // LEFT SIDE SCREEN
                else if (e.getX() < (viewWidth * 0.3))
                {
//                    Log.e(TAG, "LEFT SIDE");

                    punch(MyConstants.LEFT);
                    /*if(e.getY()> viewHeight*0.7){
                        Log.e(TAG, "Left middle on screen  ");
                    }else if(e.getY()> (viewHeight*0.45)){
                        Log.e(TAG, "Left down on screen ");
                    }*/
                }
                else if(PHWB.equals(MyConstants.PUNCH))
                {
//                    Log.e(TAG+"YYYY", ""+e.getY()+"---------"+viewWidth*0.7+"------"+viewHeight*0.45);
                    if (e.getY() > viewHeight * 0.7)
                    {

                        if (e.getX() > (viewWidth / 2))
                        {
                            //Log.e(TAG, "Right Hand");
                            punch(MyConstants.RIGHT_DOWN);
                        }
                        else
                        {
//                           Log.e(TAG , "Left Hand");
                            punch(MyConstants.LEFT_DOWN);
                        }

                    }
                    else if (e.getY() > (viewHeight * 0.45))
                    {
                        Log.e(TAG, "Middle down on screen ");
                    }
                }


                return false;
            }
        });


    }

    private void setUpBannerAdd()
    {

        mAdView = (AdView) findViewById(R.id.ad_view);

        AdRequest adRequest = new AdRequest.Builder()
                // .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                // Check the LogCat to get your test device ID
                // .addTestDevice("C04B1BFFB0774708339BC273F8A43708")
                .build();

        mAdView.setAdListener(new AdListener()
        {
            @Override
            public void onAdLoaded()
            {
            }

            @Override
            public void onAdClosed()
            {
               // Toast.makeText(getApplicationContext(), "Ad is closed!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode)
            {
              //  Toast.makeText(getApplicationContext(), "Ad failed to load! error code: " + errorCode, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdLeftApplication()
            {
              //  Toast.makeText(getApplicationContext(), "Ad left application!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdOpened()
            {
                super.onAdOpened();
            }
        });

        mAdView.loadAd(adRequest);
    }

    private void setUpInterstitialAdd()
    {

        mInterstitialAd = new InterstitialAd(this);

        // set the ad unit ID
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));

        AdRequest adRequest = new AdRequest.Builder()
                //.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                // Check the LogCat to get your test device ID
                // .addTestDevice("C04B1BFFB0774708339BC273F8A43708")
                .build();

        mInterstitialAd.loadAd(adRequest);

        mInterstitialAd.setAdListener(new AdListener()
        {
            public void onAdLoaded()
            {
                showInterstitial();
            }

            @Override
            public void onAdClosed()
            {
               // Toast.makeText(getApplicationContext(), "Ad is closed!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode)
            {
               // Toast.makeText(getApplicationContext(), "Ad failed to load! error code: " + errorCode, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdLeftApplication()
            {
                //Toast.makeText(getApplicationContext(), "Ad left application!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdOpened()
            {
               // Toast.makeText(getApplicationContext(), "Ad is opened!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showInterstitial()
    {
        if (mInterstitialAd.isLoaded())
        {
            mInterstitialAd.show();
        }
    }


    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {


            case R.id.imgv_round_wall:

                startActivity(new Intent(context, OtherWeapons.class));

                break;


            case R.id.txtv_coin_count:

                startActivity(new Intent(context, MoreCoins.class));

                break;


            case R.id.imgv_round_punch:

                intervalTime = 800;
                PHWB = MyConstants.PUNCH;
//                frameLayout_main.setBackgroundResource(R.drawable.trump_image);
//                action(R.drawable.trump_right);

                refresh2();
                break;

            case R.id.imgv_round_baseball:

                intervalTime = 600;
                PHWB = MyConstants.BASEBALL;
//                frameLayout_main.setBackgroundResource(R.drawable.trump_image_baseball);
//                action(R.drawable.trump_move_baseball_left);

                refresh2();

                break;

            case R.id.imgv_round_hillary:

              //  PHWB = MyConstants.HILLARY;

                break;

        }
    }

    private void refresh1()
    {
        action(MyLibrary.getInstance().getGifOnHit2(PHWB, punchCount, LRB));
    }

    private void refresh2()
    {

        action2(MyLibrary.getInstance().getGifAfterHit2(PHWB, punchCount, LRB, frameLayout_main));
    }


    public void punch(String leftRightBottom)
    {


        LRB = leftRightBottom;


        if(PHWB.equals(MyConstants.PUNCH))
        {
            punchCount++;
        }
        else if(PHWB.equals(MyConstants.BASEBALL))
        {
            punchCount+=2;
        }
        else if(PHWB.equals(MyConstants.WALL))
        {
            punchCount+=3;
        }
        else if(PHWB.equals(MyConstants.HILLARY))
        {
            punchCount+=4;
        }


        // Check punch is divisible by number, if divisible increase coin count
        boolean isDivisibleBy5 = punchCount % 500 == 0;
        if (isDivisibleBy5)
        {
            coinsCount += 1;

            MySharedPreferences.getInstance().saveCoins(context, coinsCount);

            txtv_coin_count.setText("" + coinsCount);
        }

        // Punch the character
        //action(MyLibrary.getInstance().getGifOnHit(PHWB, punchCount, leftRightBottom));

        //action(MyLibrary.getInstance().getGifOnHit2(PHWB, punchCount, leftRightBottom));

        refresh1();



        // after puch we have to show image and gif of trump movement

        CountDownTimer countDownTimer = new CountDownTimer(intervalTime, intervalTime);
        countDownTimer.start();


        // Sound Section
        int sound;
        if (leftRightBottom.equals(MyConstants.RIGHT))
        {
            sound = R.raw.right_hook;
        }
        else if (leftRightBottom.equals(MyConstants.LEFT))
        {
            sound = R.raw.left_hook;
        }
        else
        {
            sound = R.raw.upper_cut;
        }

        mp = MediaPlayer.create(this, sound);

        mp.start();


        // Update the punch count
        txtv_punch_count.setText("" + punchCount);


    }




    class CountDownTimer extends android.os.CountDownTimer
    {

        public CountDownTimer(long millisInFuture, long countDownInterval)
        {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l)
        {

        }

        @Override
        public void onFinish()
        {
            //action(MyLibrary.getInstance().getGifAfterHit(PHWB, punchCount, LRB, frameLayout_main));

           // action(MyLibrary.getInstance().afterHit(PHWB, punchCount, LRB, frameLayout_main));

            refresh2();


        }
    }


    // Show image in glide
    public void action(int image)
    {
        imgv_main.setVisibility(View.VISIBLE);
        myUtil.showImageInGlide(context, imgv_main, image);
        //imgv_background.setVisibility(View.GONE);

    }



    public void action2(int image)
    {
      //  imgv_background.setVisibility(View.VISIBLE);
        imgv_main.setVisibility(View.GONE);
        myUtil.showImageInGlide(context, imgv_background, image);

    }





/*    //Called when leaving the activity
    @Override
    public void onPause()
    {
        if (mAdView != null)
        {
            mAdView.pause();
        }
        super.onPause();
    }

    //Called when returning to the activity
    @Override
    public void onResume()
    {
        super.onResume();
        if (mAdView != null)
        {
            mAdView.resume();
        }
    }

    // Called before the activity is destroyed
    @Override
    public void onDestroy()
    {
        if (mAdView != null)
        {
            mAdView.destroy();
        }
        super.onDestroy();
    }*/






}
