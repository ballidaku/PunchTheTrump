package ballidaku.sharan.punchme;

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

import com.sharan.punchme.R;

import java.util.Random;

import ballidaku.sharan.punchme.MyUtilities.MyConstants;
import ballidaku.sharan.punchme.MyUtilities.MyLibrary;
import ballidaku.sharan.punchme.MyUtilities.MySharedPreferences;
import ballidaku.sharan.punchme.MyUtilities.MyUtil;

/*import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;*/

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    ImageView imgv_main;
    ImageView imgv_background;

    ImageView imgv_mainRight;
    ImageView imgv_mainLeft;
    ImageView imgv_trump_punch;


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

//    InterstitialAd mInterstitialAd;
//    private AdView mAdView;


    String oldString = "PUNCH_LESS_20";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        context = this;

        setUpIDS();

        // MySharedPreferences.getInstance().saveCoins(context, 301);


        actionBackground(R.drawable.trump_right);

       // punchFromTrump();



       /* setUpBannerAdd();


        if (MySharedPreferences.getInstance().openInterstitialApp(context))
        {
            setUpInterstitialAdd();
        }*/


        //MyInAppPurchase.initializeInappPurchaseHelper(context);
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
        imgv_main.setVisibility(View.GONE);


        imgv_mainLeft = (ImageView) findViewById(R.id.imgv_mainLeft);
        imgv_mainRight = (ImageView) findViewById(R.id.imgv_mainRight);
        imgv_trump_punch= (ImageView) findViewById(R.id.imgv_main);


        imageView = imgv_mainRight;

        imgv_background = (ImageView) findViewById(R.id.imgv_background);

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

                // RIGHT SIDE SCREEN
                if (e.getX() > (viewWidth * 0.7))
                {
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
                    punch(MyConstants.LEFT);
                    /*if(e.getY()> viewHeight*0.7){
                        Log.e(TAG, "Left middle on screen  ");
                    }else if(e.getY()> (viewHeight*0.45)){
                        Log.e(TAG, "Left down on screen ");
                    }*/
                }
                else if (PHWB.equals(MyConstants.PUNCH))
                {
                    if (e.getY() > viewHeight * 0.7)
                    {
                        if (e.getX() > (viewWidth / 2))
                        {
                            punch(MyConstants.RIGHT_DOWN);
                        }
                        else
                        {
                            punch(MyConstants.LEFT_DOWN);
                        }
                    }
                    else if (e.getY() > (viewHeight * 0.45))
                    {
                        //Log.e(TAG, "Middle down on screen ");
                    }
                }
                return false;
            }
        });


    }

/*    private void setUpBannerAdd()
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
    }*/

/*    private void showInterstitial()
    {
        if (mInterstitialAd.isLoaded())
        {
            mInterstitialAd.show();
        }
    }*/


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

                intervalTime = 1000;
                PHWB = MyConstants.PUNCH;
                refreshBackground();

                break;

            case R.id.imgv_round_baseball:

                intervalTime = 600;
                PHWB = MyConstants.BASEBALL;
                refreshBackground();

                break;

            case R.id.imgv_round_hillary:

                //  PHWB = MyConstants.HILLARY;

                break;

        }
    }


    public void punch(String leftRightBottom)
    {
        LRB = leftRightBottom;

        if (PHWB.equals(MyConstants.PUNCH))
        {
            punchCount++;
        }
        else if (PHWB.equals(MyConstants.BASEBALL))
        {
            punchCount += 2;
        }
        else if (PHWB.equals(MyConstants.WALL))
        {
            punchCount += 3;
        }
        else if (PHWB.equals(MyConstants.HILLARY))
        {
            punchCount += 4;
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
        refresh();

        // after puch we have to show image and gif of trump movement
        CountDownTimer countDownTimer = new CountDownTimer(intervalTime, intervalTime);
        countDownTimer.start();


        // Sound Section
        playPunchSound(leftRightBottom);

        // Update the punch count
        txtv_punch_count.setText("" + punchCount);
    }


    public void playPunchSound(String leftRightBottom)
    {
        int sound;
        if (leftRightBottom.equals(MyConstants.RIGHT))
        {
            sound = R.raw.right_hook;
        }
        else if (leftRightBottom.equals(MyConstants.LEFT))
        {
            sound = R.raw.left_hook;
        }
       /* else if (leftRightBottom.equals(MyConstants.TRUMP_PUNCH))
        {
            sound = R.raw.trump_punch;
        }*/
        else
        {
            sound = R.raw.upper_cut;
        }

        mp = MediaPlayer.create(this, sound);
        mp.start();
    }


    class CountDownTimer extends android.os.CountDownTimer
    {

        public CountDownTimer(long millisInFuture, long countDownInterval)
        {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l) {}

        @Override
        public void onFinish()
        {
            imgv_mainLeft.setVisibility(View.GONE);
            imgv_mainRight.setVisibility(View.GONE);
            imgv_main.setVisibility(View.GONE);
            imgv_trump_punch.setVisibility(View.GONE);

            if (!oldString.equals(MyLibrary.newString))
            {
                oldString = MyLibrary.newString;

                refreshBackground();
            }


        }
    }

    private void refresh()
    {
        newConcept(LRB,MyLibrary.getInstance().getGifOnHit2(PHWB, punchCount, LRB));
    }

    private void refreshBackground()
    {
        actionBackground(MyLibrary.getInstance().getGifAfterHit2(PHWB, punchCount, LRB, frameLayout_main));
    }

    // Show image in glide
    public void punchFromTrump()
    {
        imgv_main.setVisibility(View.VISIBLE);
        myUtil.showImageInGlide(context, imgv_trump_punch, R.drawable.punch_from_trump_right);

        mp = MediaPlayer.create(this, R.raw.trump_punch);
        mp.start();
    }


    public void actionBackground(int image)
    {
        myUtil.showImageInGlide(context, imgv_background, image);

    }

    String oldLR=MyConstants.RIGHT;

    ImageView imageView ;

    public void newConcept(String newLR,int image)
    {

        if(!oldLR.equals(newLR))
        {
            if(newLR.equals(MyConstants.LEFT))
            {
                imgv_mainRight.setVisibility(View.INVISIBLE);
                imgv_main.setVisibility(View.INVISIBLE);


                imageView=imgv_mainLeft;

            }
            else if(newLR.equals(MyConstants.RIGHT))
            {
                imgv_mainLeft.setVisibility(View.INVISIBLE);
                imgv_main.setVisibility(View.INVISIBLE);

                imageView=imgv_mainRight;
            }
            else
            {
                imgv_mainRight.setVisibility(View.INVISIBLE);
                imgv_mainLeft.setVisibility(View.INVISIBLE);

                imageView=imgv_main;
            }
        }

        imageView.setVisibility(View.VISIBLE);
        myUtil.showImageInGlide(context, imageView, image);



        if(randomSlave == randomNum)
        {
            randomSlave=0;
            random();

            intervalTime = 500;
            punchFromTrump();
        }
        randomSlave++;

    }


    int maximum =4;
    int minimum =1;
    int randomNum=0;
    int randomSlave=0;
    public void random()
    {
        Random rn = new Random();
        int range = maximum - minimum + 1;
        randomNum =  rn.nextInt(range) + minimum;

        Log.e("Random",""+randomNum);

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
