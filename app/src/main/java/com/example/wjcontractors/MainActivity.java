package com.example.wjcontractors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.FadingCircle;

public class MainActivity<PostDelayed> extends AppCompatActivity {

    ImageView logo;
    TextView cname, slogan;
    Animation topanim, bottomanim;

    private static int SPLASH_SCREEN = 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo=findViewById(R.id.logo);
        cname=findViewById(R.id.cname);
        slogan=findViewById(R.id.slogan);

        //Animations
        topanim = AnimationUtils.loadAnimation(this, R.anim.top_anim);
        bottomanim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);

        //set animations
        logo.setAnimation(topanim);
        cname.setAnimation(bottomanim);
        slogan.setAnimation(bottomanim);

        //custom Progress Bar
        ProgressBar progressBar = (ProgressBar)findViewById(R.id.progress);
        Sprite doubleBounce = new FadingCircle();
        progressBar.setIndeterminateDrawable(doubleBounce);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent =new  Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);
    }
    @Override
    public void onBackPressed() {

    }


}