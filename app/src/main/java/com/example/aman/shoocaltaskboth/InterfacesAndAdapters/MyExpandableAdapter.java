package com.example.aman.shoocaltaskboth.InterfacesAndAdapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.aman.shoocaltaskboth.R;
import com.example.aman.shoocaltaskboth.model.SingleRow;

import java.util.HashMap;
import java.util.List;

public class MyExpandableAdapter extends BaseExpandableListAdapter {
    Context context;
    List<String> expandableTitleData;
    HashMap<String, List<SingleRow>> expandableDataDetail;

    public MyExpandableAdapter(Context context, List<String> expandableTitleData, HashMap<String, List<SingleRow>> expandableDataDetail) {
        this.context = context;
        this.expandableTitleData = expandableTitleData;
        this.expandableDataDetail = expandableDataDetail;

    }

    @Override
    public int getGroupCount() {
        Log.d("Task", "Group Count = " + expandableTitleData.size());
        return expandableTitleData.size();
    }

    @Override
    public int getChildrenCount(int i) {

        Log.d("Task", "Children Count = " + expandableDataDetail.get(expandableTitleData.get(i)).size());
        return expandableDataDetail.get(expandableTitleData.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        Log.d("Task", "Group Returned " + i);

        return expandableTitleData.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        Log.d("Task", "Child Returned " + i + " , " + i1);
        return expandableDataDetail.get(expandableTitleData.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String title = (String) getGroup(i);
        if (view == null) {

            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.expandable_title_view, null);
        }
        TextView title_tv = (TextView) view.findViewById(R.id.tv_name);
        final CheckBox cb_title = (CheckBox) view.findViewById(R.id.cb_title);
        title_tv.setText(title);

        final List<SingleRow> singleGroupList = expandableDataDetail.get(title);
        boolean flag = false;

        for (SingleRow s : singleGroupList) {
            if (s.isStatus() == false) {
                flag = true;
            }
        }
        if (flag) {
            cb_title.setChecked(false);
        } else {
            cb_title.setChecked(true);
        }

        cb_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cb_title.isChecked()) {
                    //tick all child
                    for (int i = 0; i < singleGroupList.size(); i++) {
                        singleGroupList.get(i).setStatus(true);
                    }
                } else {
                    //untick all child
                    for (int i = 0; i < singleGroupList.size(); i++) {
                        singleGroupList.get(i).setStatus(false);
                    }
                }
                notifyDataSetChanged();
            }
        });
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        Log.d("Task", "In Child View");
        final SingleRow singleRowChild = (SingleRow) getChild(i, i1);
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.expandable_child_view, null);
        }
        TextView title_tv = (TextView) view.findViewById(R.id.tv_child);
        final CheckBox cb_title = (CheckBox) view.findViewById(R.id.cb_child);
        title_tv.setText(singleRowChild.getName());
        if (singleRowChild.isStatus()) {
            cb_title.setChecked(true);
        } else {
            cb_title.setChecked(false);
        }
        cb_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cb_title.isChecked()) {
                    //tick single child
                    singleRowChild.setStatus(true);
                } else {
                    //untick single child
                    singleRowChild.setStatus(false);
                }
                notifyDataSetChanged();
            }
        });
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
