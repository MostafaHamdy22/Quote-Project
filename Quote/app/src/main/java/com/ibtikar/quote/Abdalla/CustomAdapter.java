package com.ibtikar.quote.Abdalla;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Abdallh Abasery on 9/1/2015.
 */
class CustomAdapter extends ArrayAdapter<Quote> {



    ArrayList<Quote>Quotes;

    public CustomAdapter(Context context, int Resourse,ArrayList<Quote>Quotes) {
        super(context,Resourse);
        this.Quotes=Quotes;

    }


    @Override
    public int getCount() {
        return Quotes.size();
    }

    @Override
    public Quote getItem(int position) {
        return Quotes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        List_Row listrow ;

        listrow= new List_Row(getContext());



        listrow.setData(Quotes.get(position));

        return listrow;



    }
}
 