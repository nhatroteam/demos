package com.example.ooosu.actionbartab;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String [] danhSach;
    private DrawerLayout drawerLayout;
    private ListView listView;
    private boolean start = false;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private String drawerTitle;
    private String title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        if(toolbar!=null)
//        setSupportActionBar(toolbar);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        listView = (ListView) findViewById(R.id.left_drawer);


        danhSach = getResources().getStringArray(R.array.thanhpho);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.drawer_list_item,danhSach);
        listView.setAdapter(adapter);
        title = drawerTitle = (String) getTitle();
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.drawer_open,R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Chon thanh pho");
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getSupportActionBar().setTitle(title);
            }
        };
       //actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        //co cai nay moi hien icon dc
       // getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME | ActionBar.DISPLAY_SHOW_TITLE);
        //bo ten tieu de
        //getSupportActionBar().setDisplayShowTitleEnabled(true);
        //hien icon

        //icon co the kick
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setDisplayUseLogoEnabled(false);
        //getSupportActionBar().setHomeButtonEnabled(true);
        //getSupportActionBar().setIcon(R.drawable.ic_drawer);
        //getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setHomeAsUpIndicator(getDrawable(R.drawable.ic_drawer));

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
//    @Override
//    protected void onPostCreate(Bundle savedInstanceState) {
//        super.onPostCreate(savedInstanceState);
//        actionBarDrawerToggle.syncState();
//    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean drawerOpen = drawerLayout.isDrawerOpen(listView);
        menu.findItem(R.id.action_search).setVisible(!drawerOpen);
        menu.findItem(R.id.action_share_1).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    public void message(String query){
        Toast.makeText(this,"seach:"+query,Toast.LENGTH_SHORT).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        //share
       //  Set up ShareActionProvider's default share intent
        MenuItem shareItem = menu.findItem(R.id.action_share_1);
        ShareActionProvider myShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);
        Intent myIntent = new Intent();
        myIntent.setAction(Intent.ACTION_SEND);
        myIntent.putExtra(Intent.EXTRA_TEXT,
                "Đây là đoạn text tôi muốn chia sẻ");
        myIntent.setType("text/plain");
        myShareActionProvider.setShareIntent(myIntent);


        //searchview
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.i("log i","dakicksearch");
                message(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.i("log onquery","on querty text change");
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
//            case R.id.action_share_1:
////                Log.i("Log d","share");
////                ShareActionProvider myShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(item);
////                Intent myIntent = new Intent();
////                myIntent.setAction(Intent.ACTION_SEND);
////                myIntent.putExtra(Intent.EXTRA_TEXT, "Đây là đoạn text tôi muốn chia sẻ");
////                myIntent.setType("text/plain");
////
////                myShareActionProvider.setShareIntent(myIntent);
//
//                Intent share = new Intent(Intent.ACTION_SEND);
//                share.setType("text/plain");
//                share.putExtra(Intent.EXTRA_TEXT, "I'm being sent!!");
//                startActivity(Intent.createChooser(share, "Share Text"));
//                return true;
//            case R.id.action_search:
//                Log.i("Log ","search");
//                SearchView searchView = (SearchView) item.getActionView();
//                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
//                    @Override
//                    public boolean onQueryTextSubmit(String query) {
//                        Log.i("log i","dakicksearch");
//                        message(query);
//                        return false;
//                    }
//
//                    @Override
//                    public boolean onQueryTextChange(String newText) {
//                        Log.i("log onquery","on querty text change");
//                        return false;
//                    }
//                });
//                return true;

            case R.id.action_settings:
                Intent intent = new Intent(this,AboutActivity.class);
                startActivity(intent);
                return true;
            case R.id.exit:
                //add the function to perform here
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

//    @Override
//    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
//        super.onPrepareOptionsMenu(menu);
//        if(start) {
//            menu.findItem(R.id.item2).setVisible(false);
//            menu.findItem(R.id.item3).setVisible(true);
//        }
//        else {
//            menu.findItem(R.id.item2).setVisible(true);
//            menu.findItem(R.id.item3).setVisible(false);
//        }
//        return true;
//    }

}
