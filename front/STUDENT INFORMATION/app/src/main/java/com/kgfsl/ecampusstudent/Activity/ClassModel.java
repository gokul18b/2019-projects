package com.kgfsl.ecampusstudent.Activity;

/**
 * Created by Madhan on 25-12-2017.
 */


public class ClassModel {
    String id,cls;
    public ClassModel(String id, String cls) {
        this.id=id;
        this.cls=cls;
    }

    public String getId() {
        return id;
    }

    public String getCls() {
        return cls;
    }
}
