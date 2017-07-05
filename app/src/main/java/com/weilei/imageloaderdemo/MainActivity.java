package com.weilei.imageloaderdemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.weilei.imageloaderlibrary.ImageLoader;

public class MainActivity extends Activity {

    private static final String IMAGE_URL = "https://avatars1.githubusercontent.com/u/18305635?v=3&u=5597e9384f45432ef0de413b816947cdaffa3a4e&s=400";
    private ImageView mImageView;
    private ImageLoader mImageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageLoader = ImageLoader.build(this);
        mImageView = (ImageView)findViewById(R.id.image_view);
        mImageLoader.bindBitmap(IMAGE_URL, mImageView);
    }
}
