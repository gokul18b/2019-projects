package com.kgfsl.ecampusstudent;

/**
 * Created by Madhan on 27-12-2017.
 */

public class HomeworkModel {
    String name,des,date;


    public HomeworkModel(String name, String des,String date) {
        this.name=name;
        this.des=des;
        this.date=date;
    }

    public String getName() {
        return name;
    }

    public String getDes() {
        return des;
    }

    public String getDate() {
        return date;
    }
}
