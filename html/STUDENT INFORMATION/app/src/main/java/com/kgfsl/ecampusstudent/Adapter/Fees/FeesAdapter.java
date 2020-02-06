package com.kgfsl.ecampusstudent.Adapter.Fees;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.kgfsl.ecampusstudent.Pojo.Fees.FeesChild;
import com.kgfsl.ecampusstudent.Pojo.Fees.FeesHeader;
import com.kgfsl.ecampusstudent.R;

import java.util.ArrayList;

/**
 * Created by gokul on 20-10-2017.
 */

public class FeesAdapter extends BaseExpandableListAdapter {
    private Context context;
    private ArrayList<FeesHeader> deptList;

    public FeesAdapter(Context context, ArrayList<FeesHeader> deptList) {
        this.context = context;
        this.deptList = deptList;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        ArrayList<FeesChild> productList = deptList.get(groupPosition).getProductList();
        return productList.get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                             View view, ViewGroup parent) {

        FeesChild feesChild = (FeesChild) getChild(groupPosition, childPosition);
        if (view == null) {
            LayoutInflater infalInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = infalInflater.inflate(R.layout.ex_child_row, null);
        }

        TextView childItem = (TextView) view.findViewById(R.id.feesname);
        childItem.setText(feesChild.getName().trim());

        TextView sequence = (TextView) view.findViewById(R.id.feesval);
        sequence.setText(feesChild.getAmount());

        return view;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        ArrayList<FeesChild> productList = deptList.get(groupPosition).getProductList();
        return productList.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return deptList.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return deptList.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isLastChild, View view,
                             ViewGroup parent) {
        FeesHeader feesHeader = (FeesHeader) getGroup(groupPosition);
        if (view == null) {
            LayoutInflater inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inf.inflate(R.layout.ex_group_head, null);
        }
        TextView heading = (TextView) view.findViewById(R.id.heading);
        heading.setText(feesHeader.getName().trim());
        return view;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}