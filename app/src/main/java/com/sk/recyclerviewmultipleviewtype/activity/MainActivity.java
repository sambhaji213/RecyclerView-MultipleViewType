package com.sk.recyclerviewmultipleviewtype.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.sk.recyclerviewmultipleviewtype.R;
import com.sk.recyclerviewmultipleviewtype.adapter.MultiViewTypeAdapter;
import com.sk.recyclerviewmultipleviewtype.model.Model;
import com.sk.recyclerviewmultipleviewtype.util.AppConstant;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by Sambhaji Karad on 13-Feb-18
 * Mobile 9423476192
 * Email sambhaji2134@gmail.com/
*/

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        List<Model> modelList = new ArrayList<>();
        Model model = new Model();
        model.setViewType(AppConstant.TYPE_HEADER);
        model.setCollegeName("Hello. This is the Header View Type");
        model.setImageUrl(0);
        modelList.add(model);

        Model model2 = new Model();
        model2.setViewType(AppConstant.TYPE_CHILD);
        model2.setCollegeName("Hello. This is first Child View Type");
        model2.setImageUrl(R.drawable.wtc);
        modelList.add(model2);

        Model model3 = new Model();
        model3.setViewType(AppConstant.TYPE_CHILD);
        model3.setCollegeName("Hello. This is second Child View Type");
        model3.setImageUrl(R.drawable.snow);
        modelList.add(model3);

        MultiViewTypeAdapter adapter = new MultiViewTypeAdapter(modelList,MainActivity.this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, OrientationHelper.VERTICAL, false);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //https://www.journaldev.com/12372/android-recyclerview-example
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
