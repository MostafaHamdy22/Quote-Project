package com.ibtikar.quote.Abdalla;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ibtikar.quote.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Abdallh Abasery on 9/8/2015.
 */
public class List_Row extends LinearLayout {



    ImageView quoteImage;
    CircleImageView avatarImage ;
    Button like ;
    Button comment;
    Button share ;
    TextView username ;





    public List_Row(Context context) {
        super(context);
        LayoutInflater abdallaInflater = LayoutInflater.from(getContext());
        abdallaInflater.inflate(R.layout.custom_row,this);

        quoteImage= (ImageView) findViewById(R.id.image_view);





    }

    public void setData(Quote quote){

        quoteImage.setImageResource(quote.getImage());


    }

}
 