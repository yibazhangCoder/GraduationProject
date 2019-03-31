function timeStampToTime(d) {
    var date = new Date(d);
    var Y = date.getFullYear()+'-';
    var M = (date.getMonth()+1<10?'0'+ (date.getMonth()+1):date.getMonth()+1)+'-';
    var D = date.getDate()+' ';
    var h = date.getHours()+':';
    var m = date.getMinutes()+':';
    var s = date.getSeconds();
    return Y+M+D+h+m+s;
}