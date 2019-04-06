/*
*永远喜欢
* Makito
 */


package me.yuruekis.chinesestyle;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PhotosActivity extends AppCompatActivity {

    public static final String VILLAGE_NAME = "village_name";

    private DrawerLayout mDrawerLayout;

    private List<Photos> photosList = new ArrayList<>(Arrays.asList(new Photos("大门", "https://ws1.sinaimg.cn/mw690/0071ouepgy1g1k00uuei0j31hc0u0quu.jpg"), new Photos("庭院", "https://ws1.sinaimg.cn/mw690/0071ouepgy1g1k00uuei0j31hc0u0quu.jpg"), new Photos("广场", "https://ws1.sinaimg.cn/mw690/0071ouepgy1g1k00uuei0j31hc0u0quu.jpg"), new Photos("房屋", "https://ws1.sinaimg.cn/mw690/0071ouepgy1g1k00uuei0j31hc0u0quu.jpg"), new Photos("住宅", "https://ws1.sinaimg.cn/mw690/0071ouepgy1g1k00uuei0j31hc0u0quu.jpg"), new Photos("院子", "https://ws1.sinaimg.cn/mw690/0071ouepgy1g1k00uuei0j31hc0u0quu.jpg")));

    private PhotosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);
        TextView introVillage = (TextView) findViewById(R.id.intro_village);
        TextView actionBarTitle = (TextView) findViewById(R.id.toolbar_title_acitivity_photos);
        CircleImageView introAvatar = (CircleImageView) findViewById(R.id.avatar_village);

        Intent intent = getIntent();
        String villageName = intent.getStringExtra(VILLAGE_NAME);

        photosList = PhotosSwitcher.getPhotosList(villageName);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_2);
        setSupportActionBar(toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_2);
        final NavigationView navView = (NavigationView) findViewById(R.id.nav_view_2);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            //actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
            actionBar.setTitle("");
            actionBarTitle.setText(villageName);
        }

        switch (villageName) {
            case "汕大剪纸":
                introVillage.setText("剪纸是一种纸张艺术，是以剪刀把纸剪成不同的图案。");  //设置简介
                introAvatar.setImageResource(R.drawable.avatar_new);  //设置简介处头像
                break;
            case "剪纸过程":
                introVillage.setText("苟利国家生死以，岂因祸福避趋之");
                introAvatar.setImageResource(R.drawable.avatar_new);
                break;
            default:
                break;
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
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view_2);

        final View header = findViewById(R.id.header);
        header.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                recyclerView.setPadding(0, header.getMeasuredHeight(), 0, 0);
                recyclerView.scrollToPosition(0);
                header.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            private int scrollY = 0; // side-effect: this will be out of accuracy after changing items
            private boolean isCollapsed = false;

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                scrollY += dy;
                // 使用哪种效果就取消注释即可，三选一

                // 第一种效果，上滑 header 跟随滑动直至隐藏，下滑 header 跟随直至完全显示
                /*
                if (dy > 0) {
                    header.setTranslationY(Math.max(header.getTranslationY() - dy, -header.getMeasuredHeight()));
                } else if (dy < 0) {
                    header.setTranslationY(Math.min(0, header.getTranslationY() - dy));
                }
                */

                // 下面是第二种效果，手指向上滑动 header 高度后 header 隐藏，手指向下滑动时快到顶部时显示 header
                /*
                if (scrollY > header.getMeasuredHeight() && !isCollapsed) {
                    isCollapsed = true;
                    header.clearAnimation();
                    header.animate().translationY(-header.getMeasuredHeight()).setDuration(300).start();
                } else if (scrollY < header.getMeasuredHeight() && isCollapsed) {
                    isCollapsed = false;
                    header.clearAnimation();
                    header.animate().translationY(0).setDuration(300).start();
                }
                */

                // 第一种效果的变体，自带动画不跟随滑动

                if (scrollY > header.getMeasuredHeight() && dy > 0 && !isCollapsed) {
                    isCollapsed = true;
                    header.clearAnimation();
                    header.animate().translationY(-header.getMeasuredHeight()).setDuration(300).start();
                } else if (dy < 0 && isCollapsed) {
                    isCollapsed = false;
                    header.clearAnimation();
                    header.animate().translationY(0).setDuration(300).start();
                }

            }
        });
        adapter = new PhotosAdapter(photosList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
