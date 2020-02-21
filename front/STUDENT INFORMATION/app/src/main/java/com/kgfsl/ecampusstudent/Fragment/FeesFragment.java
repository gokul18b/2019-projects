package com.kgfsl.ecampusstudent.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kgfsl.ecampusstudent.Adapter.Fees.FeesAdapter;
import com.kgfsl.ecampusstudent.Pojo.Fees.Child;
import com.kgfsl.ecampusstudent.Pojo.Fees.FeesChild;
import com.kgfsl.ecampusstudent.Pojo.Fees.FeesHeader;
import com.kgfsl.ecampusstudent.Pojo.Fees.FeesPojo;
import com.kgfsl.ecampusstudent.Pojo.Fees.Result;
import com.kgfsl.ecampusstudent.R;

import java.util.ArrayList;
import java.util.LinkedHashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class FeesFragment  extends Fragment {
    private LinkedHashMap<String, FeesHeader> mySection = new LinkedHashMap<>();
    private ArrayList<FeesHeader> SectionList = new ArrayList<>();
    private FeesAdapter listAdapter;
    private ExpandableListView expandableListView;
    Toolbar toolbar;
    //CustomTextview title;
    View v;

    public FeesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_fees, container, false);


        return v;
    }
    private void expandAll() {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++) {
            expandableListView.expandGroup(i);
        }
    }

    private void collapseAll() {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++) {
            expandableListView.collapseGroup(i);
        }
    }

    public void getFees() {
        String json = "{\"status\":true,\"result\":[{\"fees\":\"COLLEGE\",\"child\":[{\"name\":\"PLACEMENT\",\"val\":\"₹5,000\"},{\"name\":\"BOOKS & RECORDS\",\"val\":\"₹10,000\"},{\"name\":\"TUTION\",\"val\":\"₹45,000\"},{\"name\":\"LATE FEES\",\"val\":\"₹4,200\"}]},{\"fees\":\"EXAM\",\"child\":[{\"name\":\"EXAM PAPERS\",\"val\":\"₹1,000\"},{\"name\":\"ARRIER PAPER\",\"val\":\"₹3,000\"},{\"name\":\"EXAM FEES\",\"val\":\"₹4,500\"},{\"name\":\"Late Fees\",\"val\":\"₹4,200\"}]},{\"fees\":\"HOSTEL\",\"child\":[{\"name\":\"DHOBI FEE\",\"val\":\"₹3,000\"},{\"name\":\"MESS FEE - YEARLY\",\"val\":\"₹24,000\"},{\"name\":\"SINGLE COT\",\"val\":\"₹10,000\"}]}]}";

        ObjectMapper mapper = new ObjectMapper();
        try{
            FeesPojo response = mapper.readValue(json, FeesPojo.class);
            if(response.getStatus()){
                for(int i=0;i<response.getResult().size();i++){
                    String feename =  response.getResult().get(i).getFees();
                    Result result =response.getResult().get(i);
                    for(int j=0;j<result.getChild().size();j++){
                        Child child = result.getChild().get(j);
                        String name =   child.getName();
                        String val = child.getVal();
                        addProduct(feename, name, val);
                    }
                }
            }
        }catch (Exception e){

        }

//        try {
//            JSONObject jsonObject = new JSONObject(json);
//            if (jsonObject.getBoolean("status")) {
//                JSONArray jsonArray = jsonObject.getJSONArray("result");
//                for (int i = 0; i < jsonArray.length(); i++) {
//                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
//
//                    String sem = jsonObject1.getString("sem");
//                    JSONArray jsonArray1 = jsonObject1.getJSONArray("child");
//                    for (int j = 0; j < jsonArray1.length(); j++) {
//                        JSONObject jsonObject2 = jsonArray1.getJSONObject(j);
//                        boolean ishighlight = jsonObject2.getBoolean("isHighlight");
//                        String name = jsonObject2.getString("name");
//                        String val = jsonObject2.getString("val");
//                        addProduct(sem, name, val, ishighlight);
//                    }
//                }
//            }
//
//
//        } catch (JSONException e) {
//            Toast.makeText(v.getContext(), String.valueOf(e), Toast.LENGTH_SHORT).show();
//            e.printStackTrace();
//        }

        expandList();

    }

    private void expandList() {
        expandableListView = (ExpandableListView)v.findViewById(R.id.expandablelistview);
        listAdapter = new FeesAdapter(v.getContext(), SectionList);
        expandableListView.setAdapter(listAdapter);
        //expandAll();
        //collapseAll();
        //expandableListView.setOnChildClickListener(myListItemClicked);
        expandableListView.setOnGroupClickListener(myListGroupClicked);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                int count = listAdapter.getGroupCount();
                for (int i = 0; i < count; i++) {
                    if (groupPosition != i) {
                        expandableListView.collapseGroup(i);
                    }
                }

            }
        });
    }


    private ExpandableListView.OnChildClickListener myListItemClicked = new ExpandableListView.OnChildClickListener() {

        public boolean onChildClick(ExpandableListView parent, View v,
                                    int groupPosition, int childPosition, long id) {

            //get the group header
            FeesHeader billHeader = SectionList.get(groupPosition);
            //get the child info
            FeesChild billChild = billHeader.getProductList().get(childPosition);
            //display it or do something with it
//            Toast.makeText(getBaseContext(), "Clicked on Detail " + billHeader.getName()
//                    + "/" + billChild.getName(), Toast.LENGTH_LONG).show();
            return false;
        }

    };

    //our group listener
    private ExpandableListView.OnGroupClickListener myListGroupClicked = new ExpandableListView.OnGroupClickListener() {

        public boolean onGroupClick(ExpandableListView parent, View v,
                                    int groupPosition, long id) {

            //get the group header
            FeesHeader billHeader = SectionList.get(groupPosition);


//            int count = listAdapter.getGroupCount();
//            for (int i = 0; i < count; i++) {
//                if (groupPosition == i) {
//                    expandableListView.expandGroup(i);
//                }
//            }


            //display it or do something with it
//            Toast.makeText(getBaseContext(), "Child on Header " + billHeader.getName(),
//                    Toast.LENGTH_LONG).show();

            return false;
        }
    };

    //here we maintain our products in various departments
    private int addProduct(String sem, String name, String val) {

        int groupPosition = 0;
        //check the hash map if the group already exists
        FeesHeader billHeader = mySection.get(sem);
        //add the group if doesn't exists
        if (billHeader == null) {
            billHeader = new FeesHeader();
            billHeader.setName(sem);
            mySection.put(sem, billHeader);
            SectionList.add(billHeader);
        }

        //get the children for the group
        ArrayList<FeesChild> productList = billHeader.getProductList();
        //size of the children list
        int listSize = productList.size();
        //add to the counter
        listSize++;

        //create a new child and add that to the group
        FeesChild billChild = new FeesChild();
        billChild.setAmount(val);
        billChild.setName(name);

        productList.add(billChild);
        billHeader.setProductList(productList);

        //find the group position inside the list
        groupPosition = SectionList.indexOf(billHeader);
        return groupPosition;
    }




}
