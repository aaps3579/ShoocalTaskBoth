package com.example.aman.shoocaltaskboth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ExpandableListView;

import com.example.aman.shoocaltaskboth.InterfacesAndAdapters.MyExpandableAdapter;
import com.example.aman.shoocaltaskboth.model.ExpandableListData;

public class TaskTwo extends AppCompatActivity {


    MyExpandableAdapter myExpandableAdapter;
    ExpandableListView expandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_two);
        expandableListView = (ExpandableListView) findViewById(R.id.expandable_lv);
        myExpandableAdapter = new MyExpandableAdapter(this, ExpandableListData.getTitleData(), ExpandableListData.getFullData());
        Log.d("Task", ExpandableListData.getFullData().size() + " , " + ExpandableListData.getTitleData().size());
        expandableListView.setAdapter(myExpandableAdapter);
    }


}
