package com.tbi.punchdonaldtrump.MyUtilities;

import android.widget.FrameLayout;

import com.tbi.punchdonaldtrump.R;

/**
 * Created by brst-pc93 on 11/29/16.
 */

public class MyLibrary
{
    private static MyLibrary instance = null;


    // PUNCHES
    private int[] trump_punch_right = {
            R.drawable.trump_punch_right,
            R.drawable.trump_punch_right_scrach_one,
            R.drawable.trump_punch_right_scrach_two,
            R.drawable.trump_punch_right_scrach_three,
            R.drawable.trump_punch_right_scrach_four,
            R.drawable.trump_punch_right_scrach_five,
            R.drawable.trump_punch_right_scrach_six,
            R.drawable.trump_punch_right_scrach_seven
    };

    private int[] trump_punch_left = {
            R.drawable.trump_punch_left,
            R.drawable.trump_punch_left_scrach_one,
            R.drawable.trump_punch_left_scrach_two,
            R.drawable.trump_punch_left_scrach_three,
            R.drawable.trump_punch_left_scrach_four,
            R.drawable.trump_punch_left_scrach_five,
            R.drawable.trump_punch_left_scrach_six,
            R.drawable.trump_punch_left_scrach_seven
    };

    private int[] trump_punch_bottom_left = {
            R.drawable.trump_punch_bottom_left,
            R.drawable.trump_punch_bottom_left_scrach_one,
            R.drawable.trump_punch_bottom_left_scrach_two,
            R.drawable.trump_punch_bottom_left_scrach_three,
            R.drawable.trump_punch_bottom_left_scrach_four,
            R.drawable.trump_punch_bottom_left_scrach_five,
            R.drawable.trump_punch_bottom_left_scrach_six,
            R.drawable.trump_punch_bottom_left_scrach_seven
    };


    private int[] trump_punch_bottom_right = {
            R.drawable.trump_punch_bottom_right,
            R.drawable.trump_punch_bottom_right_scrach_one,
            R.drawable.trump_punch_bottom_right_scrach_two,
            R.drawable.trump_punch_bottom_right_scrach_three,
            R.drawable.trump_punch_bottom_right_scrach_four,
            R.drawable.trump_punch_bottom_right_scrach_five,
            R.drawable.trump_punch_bottom_right_scrach_six,
            R.drawable.trump_punch_bottom_right_scrach_seven
    };


    private int[] trump_move_right = {
            R.drawable.trump_right,
            R.drawable.trump_move_right_scrach_one,
            R.drawable.trump_move_right_scrach_two,
            R.drawable.trump_move_right_scrach_three,
            R.drawable.trump_move_right_scrach_four,
            R.drawable.trump_move_right_scrach_five,
            R.drawable.trump_move_right_scrach_six,
            R.drawable.trump_move_right_scrach_seven
    };

    private int[] trump_move_left = {
            R.drawable.trump_left,
            R.drawable.trump_move_left_scrach_one,
            R.drawable.trump_move_left_scrach_two,
            R.drawable.trump_move_left_scrach_three,
            R.drawable.trump_move_left_scrach_four,
            R.drawable.trump_move_left_scrach_five,
            R.drawable.trump_move_left_scrach_six,
            R.drawable.trump_move_left_scrach_seven
    };


    // BASEBALL
    private int[] trump_baseball_left = {
            R.drawable.trump_baseball_left,
            R.drawable.trump_baseball_left_scrach_one,
            R.drawable.trump_baseball_left_scrach_two,
            R.drawable.trump_baseball_left_scrach_three,
            R.drawable.trump_baseball_left_scrach_four,
            R.drawable.trump_baseball_left_scrach_five,
            R.drawable.trump_baseball_left_scrach_six,
            R.drawable.trump_baseball_left_scrach_seven
    };


    private int[] trump_baseball_right = {
            R.drawable.trump_baseball_right,
            R.drawable.trump_baseball_right_scrach_one,
            R.drawable.trump_baseball_right_scrach_two,
            R.drawable.trump_baseball_right_scrach_three,
            R.drawable.trump_baseball_right_scrach_four,
            R.drawable.trump_baseball_right_scrach_five,
            R.drawable.trump_baseball_right_scrach_six,
            R.drawable.trump_baseball_right_scrach_seven
    };


    int[] trump_baseball_move = {
            R.drawable.trump_move_baseball_left,
            R.drawable.trump_move_baseball_left_scrach_one,
            R.drawable.trump_move_baseball_left_scrach_two,
            R.drawable.trump_move_baseball_left_scrach_three,
            R.drawable.trump_move_baseball_left_scrach_four,
            R.drawable.trump_move_baseball_left_scrach_five,
            R.drawable.trump_move_baseball_left_scrach_six,
            R.drawable.trump_move_baseball_left_scrach_seven
    };


    //IMAGES

    int[] punch_image = {
            R.drawable.trump_image,
            R.drawable.trump_image_scrach_one,
            R.drawable.trump_image_scrach_two,
            R.drawable.trump_image_scrach_three,
            R.drawable.trump_image_scrach_four,
            R.drawable.trump_image_scrach_five,
            R.drawable.trump_image_scrach_six,
            R.drawable.trump_image_scrach_seven
    };


    int[] baseball_image = {
            R.drawable.trump_image_baseball,
            R.drawable.trump_image_baseball_scrach_one,
            R.drawable.trump_image_baseball_scrach_two,
            R.drawable.trump_image_baseball_scrach_three,
            R.drawable.trump_image_baseball_scrach_four,
            R.drawable.trump_image_baseball_scrach_five,
            R.drawable.trump_image_baseball_scrach_six,
            R.drawable.trump_image_baseball_scrach_seven
    };


    public static MyLibrary getInstance()
    {
        if (instance == null)
        {
            instance = new MyLibrary();
        }
        return instance;
    }


    // Punch the character
    // PBHW = Punch Baseball Hillary Wall
    public int getGifOnHit(String PBHW, int punchCount, String leftRightBottom)
    {
        int image = 0;

        if (punchCount < 5 && PBHW.equals(MyConstants.PUNCH))
//        if (punchCount < 5)
        {
            if (leftRightBottom.equals(MyConstants.RIGHT))
            {
                image = trump_punch_right[0];
            }
            else if (leftRightBottom.equals(MyConstants.LEFT))
            {
                image = trump_punch_left[0];
            }
            else if (leftRightBottom.equals(MyConstants.LEFT_DOWN))
            {
                image = trump_punch_bottom_left[0];
            }
            else if (leftRightBottom.equals(MyConstants.RIGHT_DOWN))
            {
                image = trump_punch_bottom_right[0];
            }
        }
        else if (punchCount < 10 && PBHW.equals(MyConstants.PUNCH))
//        else  if (punchCount < 10)
        {

            if (leftRightBottom.equals(MyConstants.RIGHT))
            {
                image = trump_punch_right[1];
            }
            else if (leftRightBottom.equals(MyConstants.LEFT))
            {
                image = trump_punch_left[1];
            }
            else if (leftRightBottom.equals(MyConstants.LEFT_DOWN))
            {
                image = trump_punch_bottom_left[1];
            }
            else if (leftRightBottom.equals(MyConstants.RIGHT_DOWN))
            {
                image = trump_punch_bottom_right[1];
            }
        }
        else if (punchCount < 15 && PBHW.equals(MyConstants.PUNCH))
//        else  if (punchCount < 15)
        {

            if (leftRightBottom.equals(MyConstants.RIGHT))
            {
                image = trump_punch_right[2];
            }
            else if (leftRightBottom.equals(MyConstants.LEFT))
            {
                image = trump_punch_left[2];
            }
            else if (leftRightBottom.equals(MyConstants.LEFT_DOWN))
            {
                image = trump_punch_bottom_left[2];
            }
            else if (leftRightBottom.equals(MyConstants.RIGHT_DOWN))
            {
                image = trump_punch_bottom_right[2];
            }
        }
        else if (punchCount < 20 && PBHW.equals(MyConstants.PUNCH))
//        else  if (punchCount < 20)
        {
            if (leftRightBottom.equals(MyConstants.RIGHT))
            {
                image = trump_punch_right[3];
            }
            else if (leftRightBottom.equals(MyConstants.LEFT))
            {
                image = trump_punch_left[3];
            }
            else if (leftRightBottom.equals(MyConstants.LEFT_DOWN))
            {
                image = trump_punch_bottom_left[3];
            }
            else if (leftRightBottom.equals(MyConstants.RIGHT_DOWN))
            {
                image = trump_punch_bottom_right[3];
            }
        }
        else if (punchCount < 25 && PBHW.equals(MyConstants.PUNCH))
//        else  if (punchCount < 25)
        {
            if (leftRightBottom.equals(MyConstants.RIGHT))
            {
                image = trump_punch_right[4];
            }
            else if (leftRightBottom.equals(MyConstants.LEFT))
            {
                image = trump_punch_left[4];
            }
            else if (leftRightBottom.equals(MyConstants.LEFT_DOWN))
            {
                image = trump_punch_bottom_left[4];
            }
            else if (leftRightBottom.equals(MyConstants.RIGHT_DOWN))
            {
                image = trump_punch_bottom_right[4];
            }
        }
        else if (punchCount < 30 && PBHW.equals(MyConstants.PUNCH))
//        else  if (punchCount < 30)
        {
            if (leftRightBottom.equals(MyConstants.RIGHT))
            {
                image = trump_punch_right[5];
            }
            else if (leftRightBottom.equals(MyConstants.LEFT))
            {
                image = trump_punch_left[5];
            }
            else if (leftRightBottom.equals(MyConstants.LEFT_DOWN))
            {
                image = trump_punch_bottom_left[5];
            }
            else if (leftRightBottom.equals(MyConstants.RIGHT_DOWN))
            {
                image = trump_punch_bottom_right[5];
            }
        }
        else if (punchCount < 35 && PBHW.equals(MyConstants.PUNCH))
//        else  if (punchCount < 35)
        {
            if (leftRightBottom.equals(MyConstants.RIGHT))
            {
                image = trump_punch_right[6];
            }
            else if (leftRightBottom.equals(MyConstants.LEFT))
            {
                image = trump_punch_left[6];
            }
            else if (leftRightBottom.equals(MyConstants.LEFT_DOWN))
            {
                image = trump_punch_bottom_left[6];
            }
            else if (leftRightBottom.equals(MyConstants.RIGHT_DOWN))
            {
                image = trump_punch_bottom_right[6];
            }
        }
        else if (punchCount >= 35 && PBHW.equals(MyConstants.PUNCH))
        {
            if (leftRightBottom.equals(MyConstants.RIGHT))
            {
                image = trump_punch_right[7];
            }
            else if (leftRightBottom.equals(MyConstants.LEFT))
            {
                image = trump_punch_left[7];
            }
            else if (leftRightBottom.equals(MyConstants.LEFT_DOWN))
            {
                image = trump_punch_bottom_left[7];
            }
            else if (leftRightBottom.equals(MyConstants.RIGHT_DOWN))
            {
                image = trump_punch_bottom_right[7];
            }
        }
        //************************************************************************************************
        //************************************   Baseball ************************************************
        //************************************************************************************************

        else if (punchCount < 5 && PBHW.equals(MyConstants.BASEBALL))
        {
            if (leftRightBottom.equals(MyConstants.RIGHT))
            {
                image = trump_baseball_right[0];
            }
            else if (leftRightBottom.equals(MyConstants.LEFT))
            {
                image = trump_baseball_left[0];
            }
        }
        else if (punchCount < 10 && PBHW.equals(MyConstants.BASEBALL))
        {

            if (leftRightBottom.equals(MyConstants.RIGHT))
            {
                image = trump_baseball_right[1];
            }
            else if (leftRightBottom.equals(MyConstants.LEFT))
            {
                image = trump_baseball_left[1];
            }

        }
        else if (punchCount < 15 && PBHW.equals(MyConstants.BASEBALL))
        {

            if (leftRightBottom.equals(MyConstants.RIGHT))
            {
                image = trump_baseball_right[2];
            }
            else if (leftRightBottom.equals(MyConstants.LEFT))
            {
                image = trump_baseball_left[2];
            }
        }
        else if (punchCount < 20 && PBHW.equals(MyConstants.BASEBALL))
        {
            if (leftRightBottom.equals(MyConstants.RIGHT))
            {
                image = trump_baseball_right[3];
            }
            else if (leftRightBottom.equals(MyConstants.LEFT))
            {
                image = trump_baseball_left[3];
            }
        }
        else if (punchCount < 25 && PBHW.equals(MyConstants.BASEBALL))
        {
            if (leftRightBottom.equals(MyConstants.RIGHT))
            {
                image = trump_baseball_right[4];
            }
            else if (leftRightBottom.equals(MyConstants.LEFT))
            {
                image = trump_baseball_left[4];
            }
        }
        else if (punchCount < 30 && PBHW.equals(MyConstants.BASEBALL))
        {
            if (leftRightBottom.equals(MyConstants.RIGHT))
            {
                image = trump_baseball_right[5];
            }
            else if (leftRightBottom.equals(MyConstants.LEFT))
            {
                image = trump_baseball_left[5];
            }
        }
        else if (punchCount < 35 && PBHW.equals(MyConstants.BASEBALL))
        {
            if (leftRightBottom.equals(MyConstants.RIGHT))
            {
                image = trump_baseball_right[6];
            }
            else if (leftRightBottom.equals(MyConstants.LEFT))
            {
                image = trump_baseball_left[6];
            }
        }
        else if (punchCount >= 35 && PBHW.equals(MyConstants.BASEBALL))
        {
            if (leftRightBottom.equals(MyConstants.RIGHT))
            {
                image = trump_baseball_right[7];
            }
            else if (leftRightBottom.equals(MyConstants.LEFT))
            {
                image = trump_baseball_left[7];
            }

        }

        return image;

    }


    public int getGifAfterHit(String PBHW, int punchCount, String LRB, FrameLayout frameLayout_main)
    {

        int gif = 0;
        if (punchCount < 5 && PBHW.equals(MyConstants.PUNCH))
        {
            frameLayout_main.setBackgroundResource(R.drawable.trump_image);

            if (LRB.equals(MyConstants.LEFT))
            {
                gif = trump_move_right[0];
            }
            else
            {
                gif = trump_move_left[0];
            }
        }
        else if (punchCount < 10 && PBHW.equals(MyConstants.PUNCH))
        {
            frameLayout_main.setBackgroundResource(R.drawable.trump_image_scrach_one);

            if (LRB.equals(MyConstants.LEFT))
            {
                gif = trump_move_right[1];
            }
            else
            {
                gif = trump_move_left[1];
            }
        }
        else if (punchCount < 15 && PBHW.equals(MyConstants.PUNCH))
        {
            frameLayout_main.setBackgroundResource(R.drawable.trump_image_scrach_two);

            if (LRB.equals(MyConstants.LEFT))
            {
                gif = trump_move_right[2];
            }
            else
            {
                gif = trump_move_left[2];
            }
        }
        else if (punchCount < 20 && PBHW.equals(MyConstants.PUNCH))
        {
           // frameLayout_main.setBackgroundResource(R.drawable.trump_image_scrach_three);

            if (LRB.equals(MyConstants.LEFT))
            {
                gif = trump_move_right[3];
            }
            else
            {
                gif = trump_move_left[3];
            }
        }
        else if (punchCount < 25 && PBHW.equals(MyConstants.PUNCH))
        {
           // frameLayout_main.setBackgroundResource(R.drawable.trump_image_scrach_four);

            if (LRB.equals(MyConstants.LEFT))
            {
                gif = trump_move_right[4];
            }
            else
            {
                gif = trump_move_left[4];
            }
        }
        else if (punchCount < 30 && PBHW.equals(MyConstants.PUNCH))
        {
            frameLayout_main.setBackgroundResource(R.drawable.trump_image_scrach_five);

            if (LRB.equals(MyConstants.LEFT))
            {
                gif = trump_move_right[5];
            }
            else
            {
                gif = trump_move_left[5];
            }
        }
        else if (punchCount < 35 && PBHW.equals(MyConstants.PUNCH))
        {
           frameLayout_main.setBackgroundResource(R.drawable.trump_image_scrach_six);

            if (LRB.equals(MyConstants.LEFT))
            {
                gif = trump_move_right[6];
            }
            else
            {
                gif = trump_move_left[6];
            }
        }
        else if (punchCount >= 35 && PBHW.equals(MyConstants.PUNCH))
        {
           frameLayout_main.setBackgroundResource(R.drawable.trump_image_scrach_seven);

            if (LRB.equals(MyConstants.LEFT))
            {
                gif = trump_move_right[7];
            }
            else
            {
                gif = trump_move_left[7];
            }
        }

        //*************************************************************************************************
        //*************************************   Baseball ************************************************
        //*************************************************************************************************
        else if (punchCount < 20 && PBHW.equals(MyConstants.BASEBALL))
        {
            frameLayout_main.setBackgroundResource(R.drawable.trump_image_baseball);
            gif = R.drawable.trump_move_baseball_left;
        }
        return gif;
    }


    private int getPosition(String PBHW, int punch)
    {

        int position = 0;
        if (PBHW.equals(MyConstants.PUNCH))
        {
            if (punch < 20)
            {
                position = 0;
            }
            else if (punch < 50)
            {
                position = 1;
            }
            else if (punch < 100)
            {
                position = 2;
            }
            else if (punch < 150)
            {
                position = 3;
            }
            else if (punch < 200)
            {
                position = 4;
            }
            else if (punch < 300)
            {
                position = 5;
            }
            else if (punch < 500)
            {
                position = 6;
            }
            else
            {
                position = 7;
            }
        }
        else if (PBHW.equals(MyConstants.BASEBALL))
        {
            if (punch < 12)
            {
                position = 0;
            }
            else if (punch < 30)
            {
                position = 1;
            }
            else if (punch < 60)
            {
                position = 2;
            }
            else if (punch < 90)
            {
                position = 3;
            }
            else if (punch < 120)
            {
                position = 4;
            }
            else if (punch < 180)
            {
                position = 5;
            }
            else if (punch < 300)
            {
                position = 6;
            }
            else
            {
                position = 7;
            }
        }
        else if (PBHW.equals(MyConstants.WALL))
        {
            if (punch < 10)
            {
                position = 0;
            }
            else if (punch < 25)
            {
                position = 1;
            }
            else if (punch < 50)
            {
                position = 2;
            }
            else if (punch < 75)
            {
                position = 3;
            }
            else if (punch < 100)
            {
                position = 4;
            }
            else if (punch < 150)
            {
                position = 5;
            }
            else if (punch < 250)
            {
                position = 6;
            }
            else
            {
                position = 7;
            }
        }
        else if (PBHW.equals(MyConstants.HILLARY))
        {
            if (punch < 8)
            {
                position = 0;
            }
            else if (punch < 20)
            {
                position = 1;
            }
            else if (punch < 40)
            {
                position = 2;
            }
            else if (punch < 60)
            {
                position = 3;
            }
            else if (punch < 80)
            {
                position = 4;
            }
            else if (punch < 120)
            {
                position = 5;
            }
            else if (punch < 200)
            {
                position = 6;
            }
            else
            {
                position = 7;
            }
        }


        return position;



/*
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(5,0);
        map.put(10,1);
        map.put(15,2);
        map.put(20,3);
        map.put(25,4);
        map.put(30,5);
        map.put(35,6);
        //map.put(40,7);


        ArrayList<Integer> sortedHashMap=new ArrayList<Integer>();

        for(int m : map.keySet())
        {
            sortedHashMap.add(m);
        }

        Collections.sort(sortedHashMap);


//        Log.e("sortedHashMap",""+sortedHashMap);
//        Log.e("punch",""+punch);

        int position=7;


        for (int i = 0; i <sortedHashMap.size() ; i++)
        {
//            Log.e("Key",""+sortedHashMap.get(i));

            if(punch < sortedHashMap.get(i))
            {

                position=map.get(sortedHashMap.get(i));
//                Log.e("Position",""+position);
                break;
            }
        }



        return position;*/
    }


    public int getGifOnHit2(String PBHW, int punch, String leftRightBottom)
    {

        int position = getPosition(PBHW, punch);

        int GIF = 0;

        if (PBHW.equals(MyConstants.PUNCH) && leftRightBottom.equals(MyConstants.LEFT))
        {
            GIF = trump_punch_left[position];
        }
        else if (PBHW.equals(MyConstants.PUNCH) && leftRightBottom.equals(MyConstants.RIGHT))
        {
            GIF = trump_punch_right[position];
        }
        else if (PBHW.equals(MyConstants.PUNCH) && leftRightBottom.equals(MyConstants.LEFT_DOWN))
        {
            GIF = trump_punch_bottom_left[position];
        }
        else if (PBHW.equals(MyConstants.PUNCH) && leftRightBottom.equals(MyConstants.RIGHT_DOWN))
        {
            GIF = trump_punch_bottom_right[position];
        }
        else if (PBHW.equals(MyConstants.BASEBALL) && leftRightBottom.equals(MyConstants.LEFT))
        {
            GIF = trump_baseball_left[position];
        }
        else if (PBHW.equals(MyConstants.BASEBALL) && leftRightBottom.equals(MyConstants.RIGHT))
        {
            GIF = trump_baseball_right[position];
        }

        return GIF;

    }


    public int getGifAfterHit2(String PBHW, int punch, String leftRightBottom, FrameLayout frameLayout_main)
    {
        int position = getPosition(PBHW, punch);

        int GIF = 0;

        if (PBHW.equals(MyConstants.PUNCH))
        {
            frameLayout_main.setBackgroundResource(punch_image[position]);

            if (leftRightBottom.equals(MyConstants.LEFT))
            {
                GIF = trump_move_right[position];
            }
            else
            {
                GIF = trump_move_left[position];
            }

        }
        else if (PBHW.equals(MyConstants.BASEBALL))
        {
            frameLayout_main.setBackgroundResource(baseball_image[position]);
            GIF = trump_baseball_move[position];

        }


        return GIF;

    }


}
