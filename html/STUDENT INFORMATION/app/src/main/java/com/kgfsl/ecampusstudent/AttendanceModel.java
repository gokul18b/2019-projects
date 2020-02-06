package com.kgfsl.ecampusstudent;

/**
 * Created by Madhan on 25-12-2017.
 */

class AttendanceModel {
Integer id;
    String name;
    boolean pos;
    public AttendanceModel(Integer id, String name) {
        this.id=id;
        this.name=name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setPos(boolean pos) {
        this.pos = pos;
    }

    public boolean getPos() {
        return pos;
    }
}

