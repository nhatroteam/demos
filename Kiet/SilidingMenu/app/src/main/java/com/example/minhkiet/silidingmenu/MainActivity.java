package com.example.minhkiet.silidingmenu;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.minhkiet.silidingmenu.adapter.SlidingMenuAdapter;
import com.example.minhkiet.silidingmenu.model.ItemSlidingMenu;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private LinearLayout slidingLayout;
    private ListView lvSlidingMenu;

    private ArrayList<ItemSlidingMenu> itemSlidingMenus;
    private SlidingMenuAdapter slidingMenuAdapter;
    private ActionBarDrawerToggle actionBarDrawerToggle = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        // thay doi mau action bar
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2E4036")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // chuan bi items menu
        itemSlidingMenus = new ArrayList<>();
        itemSlidingMenus.add(new ItemSlidingMenu(android.R.drawable.ic_input_get, "Iniesta"));
        itemSlidingMenus.add(new ItemSlidingMenu(android.R.drawable.ic_menu_upload_you_tube,
                "Neymar"));
        itemSlidingMenus.add(new ItemSlidingMenu(android.R.drawable.ic_menu_recent_history,
                "Suarez"));
        itemSlidingMenus.add(new ItemSlidingMenu(android.R.drawable.ic_input_get, "Iniesta"));
        itemSlidingMenus.add(new ItemSlidingMenu(android.R.drawable.ic_menu_upload_you_tube,
                "Neymar"));
        itemSlidingMenus.add(new ItemSlidingMenu(android.R.drawable.ic_menu_recent_history,
                "Suarez"));

        // set adapter
        slidingMenuAdapter = new SlidingMenuAdapter(this, itemSlidingMenus);
        lvSlidingMenu.setAdapter(slidingMenuAdapter);

        // lang nghe su kien cho cac item
        lvSlidingMenu.setOnItemClickListener(new DrawerItemClickListener());

        // lang nghe su kien hoan thanh viec dong mo menu
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                R.string.drawer_open, R.string.drawer_close) {

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }
        };
        actionBarDrawerToggle.syncState();
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        lvSlidingMenu = (ListView) findViewById(R.id.lvSlidingMenu);
        lvSlidingMenu.setDivider(null); // xoa border trong listview
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        slidingLayout = (LinearLayout) findViewById(R.id.slidingMenu);
    }

    private class DrawerItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            setTitle(itemSlidingMenus.get(position).getTitle());
            drawerLayout.closeDrawer(slidingLayout);

            //do something
            Toast.makeText(getApplicationContext(), itemSlidingMenus.get(position).getTitle() +
                    " is selected", Toast.LENGTH_SHORT).show();
        }
    }
}
