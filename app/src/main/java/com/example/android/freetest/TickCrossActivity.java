package com.example.android.freetest;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class TickCrossActivity extends AppCompatActivity {

    private ImageView mImageView;
    private AnimatedVectorDrawable tickToCross;
    private AnimatedVectorDrawable crossToTick;
    private boolean tick = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tick_cross);

        mImageView = (ImageView) findViewById(R.id.tick_cross);

        tickToCross = (AnimatedVectorDrawable) getDrawable(R.drawable.avd_tick_to_cross);
        crossToTick = (AnimatedVectorDrawable) getDrawable(R.drawable.avd_cross_to_tick);
    }

    public void animate(View view){
        AnimatedVectorDrawable drawable = tick ? tickToCross : crossToTick;
        mImageView.setImageDrawable(drawable);
        drawable.start();
        tick = !tick;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.transition_manager){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        }
        if(id == R.id.transition_activity){
            Intent intent = new Intent(this, TransitionActivity.class);
            startActivity(intent);
            return true;
        }
        if(id == R.id.image_transition){
            Toast.makeText(this, "You already are on Image Transition", Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
