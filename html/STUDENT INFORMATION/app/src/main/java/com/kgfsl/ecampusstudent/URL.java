package com.kgfsl.ecampusstudent;

/**
 * Created by Madhan on 25-12-2017.
 */

public class URL {

    //public final static String URL="http://192.168.43.153/gokul/api/api/college";
    public final static String URL="http://192.168.43.127/gokul/college";
    //public final static String URL="http://172.30.3.45/gokul/college";


    public final static String register =URL+"/register.php";
    public final static String login=URL+"/login.php";
    public final static String profile=URL+"/profile.php?id=";
    public final static  String alldonorslist=URL+"/alldonorslist.php?id=";

    public final static  String sending_request=URL+"/sendingrequest.php";
    public final static String  classlist=URL+"/classlist.php";
    public final static String  studentlist=URL+"/studentllist.php";
    public final static String  attendanceregister=URL+"/attendanceregister.php";
    public final static String  attendancedetails=URL+"/attendancedetails.php";
    public final static String putHomework=URL+"/puthomework.php";
    public final static String homeworklist=URL+"/viewhomework.php";
    public final static String  postfeedback=URL+"/postfeedback.php";
    public final static String  viewfeedback=URL+"/viewfeedback.php";
}
