/**
 * Created by sundareswaran on 28/9/15.
 */
function ajaxObj(meth, url) {
    var x = new XMLHttpRequest();
    x.open(meth, url, true);
    x.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    return x;
}
function ajaxReturn(x) {
    if (x.readyState == 4 && x.status == 200) {
        return true;
    }
}

function _(v) {
    return document.getElementById(v);
}