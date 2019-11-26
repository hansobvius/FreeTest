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
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class TransitionActivity extends AppCompatActivity {

    private GridView mGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);

        mGridView = (GridView) findViewById(R.id.grid);
        mGridView.setAdapter(new GridAdapter());

        //Transition Activity
        //Necessario crir um transition resource
        //também atualizar o style (porém nao esta funcionando)
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(TransitionActivity.this, DetailTransitionActivity.class),
                        ActivityOptions.makeSceneTransitionAnimation(TransitionActivity.this, view, "transition").toBundle());
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

    private class GridAdapter extends BaseAdapter {

        @Override
        public int getCount(){
            return 20;
        }

        @Override
        public Object getItem(int position){
            return null;
        }

        @Override
        public long getItemId(int position){
            return position;
        }

        @Override
        public View getView(int position, View converView, ViewGroup parent){
            if(converView == null){
                converView = getLayoutInflater().inflate(R.layout.grid_item, parent, false);
            }
            ((TextView) converView).setText("A");
            return converView;
        }

    }
}
