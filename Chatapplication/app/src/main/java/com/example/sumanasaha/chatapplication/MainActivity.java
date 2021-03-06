package com.example.sumanasaha.chatapplication;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static android.app.PendingIntent.getActivity;
import static android.support.v7.widget.LinearLayoutManager.VERTICAL;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private RecyclerView recyclerView;
    private VivzAdapter adapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<String> data=new ArrayList<>();
    Context mCntx;
    int height=0;





    @Override
    protected void onStart() {
        super.onStart();

    }
    @Override
    protected void onResume()
    {
        super.onResume();
        recyclerView.scrollToPosition(data.size()-1);
        adapter.notifyItemInserted(data.size() - 1);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        /**FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //fv= (TextView) findViewById(R.id.firsttext);
       //fv.setId(curTextViewId);
        setUpRecyclerView();
        firsttext();



    }
    private void setUpRecyclerView()
    {
        recyclerView= (RecyclerView) findViewById(R.id.drawerlist);
        recyclerView.setHasFixedSize(true);
       // mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        height=containerHeight();
        adapter=new VivzAdapter(this,data,height);
        recyclerView.setAdapter(adapter);

    }
    private void firsttext()
    {
        data.add("Welcome!! How can we help you today");
        recyclerView.scrollToPosition(data.size()-1);
        adapter.notifyItemInserted(data.size() - 1);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public int containerHeight() {
        WindowManager windowManager= (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        int h = windowManager.getDefaultDisplay().getHeight();
        return h;

    }
    public void sendMessage(View view)
    {



        EditText txt= (EditText) findViewById(R.id.msgText);
        String msg=txt.getText().toString();
        String[] msgs={msg};
        txt.setText("");

    //  Log.v("MainActivity", "Screen height" + height);
        data.add(msg);
            recyclerView.scrollToPosition(data.size() - 1);
            adapter.notifyItemInserted(data.size()-1);







/**


        //Fetching the id of Main Layout
        RelativeLayout rl= (RelativeLayout) findViewById(R.id.mainlayout);

        //Setting the parameters for TextView
       LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT
                , LayoutParams.WRAP_CONTENT);

        TextView tv = new TextView(this);
        tv.setLayoutParams(params);
        tv.setText(fv.getText().toString());
        tv.setVisibility(View.VISIBLE);


        //Setting Parameters for Relative layout
       RelativeLayout.LayoutParams param = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

                    //TextView fv= (TextView) findViewById(R.id.firsttext);
                    //int curTextViewId = prevTextViewId + 1;
                    //int cur=curTextViewId+1;
                    //fv.setId(curTextViewId);
       // tv.setId(cur);
        tv.setTextColor(Color.RED);
        // param.addRule(RelativeLayout.ABOVE, curTextViewId);
        rl.addView(tv, param);
        fv.setText(msg);



        /**tv.setId(curTextViewId);
        TextView tv1 = new TextView(this);
        tv1.setLayoutParams(params);
        tv1.setText(msg);
        tv1.setVisibility(View.VISIBLE);
        RelativeLayout.LayoutParams param1 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        param.addRule(RelativeLayout.BELOW, curTextViewId);
        rl.addView(tv1, param);*/




        //tv.setId(curTextViewId);
       // curTextViewId=cur;
        //cur=curTextViewId+1;*/

    }
    public void removeContent(View view)
    {
        EditText msgrcvd= (EditText) findViewById(R.id.msgText);
        String msg=msgrcvd.getText().toString();
        msgrcvd.setText(" ");
    }
}
