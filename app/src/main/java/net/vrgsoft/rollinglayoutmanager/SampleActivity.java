package net.vrgsoft.rollinglayoutmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import net.vrgsoft.layoutmanager.RollingLayoutManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class SampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        String[] array = getResources().getStringArray(R.array.header);
        List<String> list = Arrays.asList(array);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RollingLayoutManager rollingLayoutManager = new RollingLayoutManager(this);
        SimpleAdapter simpleAdapter = new SimpleAdapter(list,this);
        recyclerView.setLayoutManager(rollingLayoutManager);
        recyclerView.setAdapter(simpleAdapter);
        Intent intent = new Intent();
    }
}
