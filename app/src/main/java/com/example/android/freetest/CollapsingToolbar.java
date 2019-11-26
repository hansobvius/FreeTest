package com.example.android.freetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class CollapsingToolbar extends AppCompatActivity {

    private Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_toolbar);

        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolBar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.transition_manager) {
            startActivity(new Intent(this, MainActivity.class));
            return true;
        }
        if (id == R.id.transition_activity) {
            Intent intent = new Intent(this, TransitionActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.image_transition) {
            Toast.makeText(this, "Not working...", Toast.LENGTH_LONG).show();
            /*
            Intent intent = new Intent(this, TickCrossActivity.class);
            startActivity(intent);
            */
            return true;
        }
        if (id == R.id.collapsing_toolbar_activity) {
            startActivity(new Intent(this, CollapsingToolbar.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
