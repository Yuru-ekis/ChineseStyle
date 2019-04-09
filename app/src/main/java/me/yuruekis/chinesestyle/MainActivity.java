package me.yuruekis.chinesestyle;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    //private SwipeRefreshLayout swipeRefresh;

    //private Village[] villages = {new Village("乔林村", "https://i.loli.net/2019/03/29/5c9e1a0004541.jpg"), new Village("桃山村", "https://i.loli.net/2019/03/29/5c9e1a0004541.jpg"), new Village("贾里村", "https://i.loli.net/2019/03/29/5c9e1a0004541.jpg")};

    private List<Village> villageList = new ArrayList<>(Arrays.asList(new Village("汕大剪纸", "https://ww1.sinaimg.cn/large/0071ouepgy1g1vkb32xomj30hs0da3zk.jpg"), new Village("剪纸过程", "https://ws1.sinaimg.cn/large/0071ouepgy1g1vnxryky2j30eo0c0t8z.jpg")));

    private VillageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        final NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            //actionBar.setDisplayHomeAsUpEnabled(true);
            //actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
            actionBar.setTitle(" ");
        }
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.tobecontinue:
                        Snackbar.make(navView, "未完成的功能", Snackbar.LENGTH_SHORT)
                                .setActionTextColor(Color.parseColor("#f48fb1"))
                                .setAction("好的", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                    }
                                }).show();
                }
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new VillageAdapter(villageList);
        recyclerView.setAdapter(adapter);
    }

    /*public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }*/

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
        }
        return true;
    }*/
}
