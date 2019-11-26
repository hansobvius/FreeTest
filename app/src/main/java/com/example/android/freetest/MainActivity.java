package com.example.android.freetest;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private Toolbar mTollBar;
    private boolean isText = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.text__view);
        mTextView.setBackgroundColor(getResources().getColor(R.color.magenta));
        mTextView.setText(R.string.hello);
        mTextView.setTextSize(32.0f);

        mTollBar = (Toolbar) findViewById(R.id.main_tollbar);
        mTollBar.inflateMenu(R.menu.menu);
        setSupportActionBar(mTollBar);

        //FAB aplication
        FloatingActionButton fab = new FloatingActionButton(this);
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sayBye();
            }
        });
    }

    //TransitionManager
    public void sayBye(){


        Slide slide = new Slide();
        slide.setSlideEdge(Gravity.TOP);

        ViewGroup root = (ViewGroup) findViewById(android.R.id.content);
        TransitionManager.beginDelayedTransition(root, slide);

        if(isText) {
            mTextView.setVisibility(View.INVISIBLE);
            Toast.makeText(this, "Bye Bye", Toast.LENGTH_LONG).show();
            isText = false;
        }else{
            mTextView.setVisibility(View.VISIBLE);
            Toast.makeText(this, "hello again", Toast.LENGTH_LONG).show();
            isText = true;
        }

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
            Toast.makeText(this, "You already are on Transition Manager", Toast.LENGTH_LONG).show();
            return true;
        }
        if(id == R.id.transition_activity){
            Intent intent = new Intent(this, TransitionActivity.class);
            startActivity(intent);
            return true;
        }
        if(id == R.id.image_transition){
            Toast.makeText(this, "Not working...", Toast.LENGTH_LONG).show();
            /*
            Intent intent = new Intent(this, TickCrossActivity.class);
            startActivity(intent);
            */
            return true;
        }
        if(id == R.id.collapsing_toolbar_activity){
            startActivity(new Intent(this, CollapsingToolbar.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
