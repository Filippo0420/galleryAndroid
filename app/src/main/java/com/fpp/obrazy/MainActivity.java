package com.fpp.obrazy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    private ImageSwitcher simpleImageSwitcher;
    private Button btnNext, btnBack;


    // Array of Image IDs to Show In ImageSwitcher
    int imageIds[] = {R.drawable.zaba, R.drawable.zaba1, R.drawable.zaba2, R.drawable.zaba3};
    int count = imageIds.length;
    // to keep current Index of ImageID array
    int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btnNext = (Button) findViewById(R.id.next);
        btnBack = findViewById(R.id.back);
        simpleImageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);
        simpleImageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        });
        simpleImageSwitcher.setImageResource(imageIds[currentIndex]);

        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

        simpleImageSwitcher.setInAnimation(in);
        simpleImageSwitcher.setOutAnimation(out);


        btnNext.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                currentIndex++;
                if (currentIndex == count)
                    currentIndex = 0;
                simpleImageSwitcher.setImageResource(imageIds[currentIndex]);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                currentIndex--;
                if (currentIndex < 0)
                    currentIndex = count-1;
                simpleImageSwitcher.setImageResource(imageIds[currentIndex]);
            }
        });

    }
}