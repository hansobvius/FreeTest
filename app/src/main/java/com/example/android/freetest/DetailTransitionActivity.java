package com.example.android.freetest;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DetailTransitionActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_transition);

        mTextView = (TextView) findViewById(R.id.click_text);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailTransitionActivity.this, TransitionActivity.class),
                        ActivityOptions.makeSceneTransitionAnimation(DetailTransitionActivity.this).toBundle());
            }
        });
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
            Toast.makeText(this, "You already are on Transition Activity", Toast.LENGTH_LONG).show();
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
