package com.example.user.tourguideapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageDetailActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button button;
    private TextView textview;
    private static final String DRAWABLE_RESOURE = "resource";
    private static final String TEXT_RESOURCE = "textResource";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);

        imageView = (ImageView) findViewById(R.id.img);
        textview = findViewById(R.id.text);

        int drawbleResource = getIntent().getIntExtra(DRAWABLE_RESOURE, 0);
        imageView.setImageResource(drawbleResource);

    }
    @Override
    public void onBackPressed() {
        finish();

    }
}
