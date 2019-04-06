package me.yuruekis.chinesestyle;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class PhotoDetailActivity extends AppCompatActivity {

    public static final String PHOTOS_NAME = "photos_name";

    public static final String PHOTOS_IMAGE_URL = "photos_image_url";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_detail);
        Intent intent = getIntent();
        String photosName = intent.getStringExtra(PHOTOS_NAME);
        String photosImageURL = intent.getStringExtra(PHOTOS_IMAGE_URL);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_3);
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        ImageView photosImageView = (ImageView) findViewById(R.id.photo_image_view);
        TextView photosContentText = (TextView) findViewById(R.id.photo_content_text);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbar.setTitle(photosName);

        Glide.with(this).load(photosImageURL).into(photosImageView);
        // String photosContent = // 待实现 加载照片文字简介
        // photosContentText.setText(photosContent);
        photosContentText.setText(PhotoDetailSwitcher.getPhotoDetail(photosName)); //根据不同 photo 加载不同的文字
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
