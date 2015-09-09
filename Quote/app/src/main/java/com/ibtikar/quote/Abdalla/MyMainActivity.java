package com.ibtikar.quote.Abdalla;

import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.ibtikar.quote.R;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;

import java.util.ArrayList;

public class MyMainActivity extends ActionBarActivity implements SwipyRefreshLayout.OnRefreshListener {


    private SwipyRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_main);
        mSwipeRefreshLayout = (SwipyRefreshLayout) findViewById(R.id.swipyrefreshlayout);

        mSwipeRefreshLayout.setDirection(SwipyRefreshLayoutDirection.BOTH);
        mSwipeRefreshLayout.setOnRefreshListener(MyMainActivity.this);


        ArrayList<Quote> Quotes = new ArrayList<Quote>();
        for(int i=0; i<=4;i++)
        {
            Quote person1 = new Quote();
//            int id =getResources().getIdentifier("@drawable/img"+i,null,getPackageName());

            person1.setImage(R.drawable.abc_btn_switch_to_on_mtrl_00012);

            Quotes.add(person1);
        }




        ListAdapter abdallaadapter = new CustomAdapter(this,R.layout.custom_row,Quotes);
        ListView listview = (ListView)findViewById(R.id.listView);
        listview.setAdapter(abdallaadapter);


    }


    @Override
    public void onRefresh(SwipyRefreshLayoutDirection direction) {
        Log.d("MainActivity", "Refresh triggered at "
                + (direction == SwipyRefreshLayoutDirection.TOP ? "top" : "bottom"));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Hide the refresh after 2sec
                MyMainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

//                        List<String> newCatNames = new ArrayList<>();
//                        for (int i = 0; i < mCatNames.size(); i++) {
//                            int randomCatNameIndex = new Random().nextInt(mCatNames.size() - 1);
//                            newCatNames.add(mCatNames.get(randomCatNameIndex));
//                        }
//                        mAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, newCatNames);
//                        mListView.setAdapter(mAdapter);
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                });
            }
        }, 2000);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}