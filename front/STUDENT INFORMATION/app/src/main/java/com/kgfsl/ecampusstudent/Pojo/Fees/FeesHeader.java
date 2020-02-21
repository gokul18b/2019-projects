package com.kgfsl.ecampusstudent.Pojo.Fees;

import java.util.ArrayList;

/**
 * Created by manivasagam on 20-10-2017.
 */

public class FeesHeader {

    private String name;
    private ArrayList<FeesChild> productList = new ArrayList<FeesChild>();

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<FeesChild> getProductList() {
        return productList;
    }
    public void setProductList(ArrayList<FeesChild> productList) {
        this.productList = productList;
    }

}
