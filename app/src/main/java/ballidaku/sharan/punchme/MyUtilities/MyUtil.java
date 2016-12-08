package ballidaku.sharan.punchme.MyUtilities;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created by brst-pc93 on 11/18/16.
 */

public class MyUtil
{


    public void showImageInGlide(Context context, ImageView imageView, int image)
    {
        try
        {
            Glide.with(context).load(image)
                 //.crossFade()
                 .asGif()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                 .into(imageView);
        } catch (Exception e)
        {

            e.printStackTrace();
            Glide.with(context)
                 .load(image)
                 .asGif()
               .diskCacheStrategy(DiskCacheStrategy.ALL)
                 .into(imageView);
        }
    }


    public void setFont(Context context, TextView textView)
    {
        Typeface face = Typeface.createFromAsset(context.getAssets(), "LithosProBlack.ttf");

        textView.setTypeface(face);

    }

    public void applyFont(final Context context, final View root)
    {
        try
        {
            if (root instanceof ViewGroup)
            {
                ViewGroup viewGroup = (ViewGroup) root;
                for (int i = 0; i < viewGroup.getChildCount(); i++)
                    applyFont(context, viewGroup.getChildAt(i));
            }
            else if (root instanceof TextView)
                setFont(context, (TextView) root);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
