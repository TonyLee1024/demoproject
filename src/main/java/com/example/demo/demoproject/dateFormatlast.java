package com.example.demo.demoproject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class dateFormatlast {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


//        Date date = new Date();//获取当前时间
//        Calendar calendar = Calendar.getInstance(); //创建Calendar 的实例
////        calendar.add(Calendar.YEAR, -1);//当前时间减去一年，即一年前的时间
//          calendar.add(Calendar.MONTH, -1);//当前时间减去一个月，即一个月前的时间
////        calendar.add(Calendar.DAY_OF_MONTH,-1); //当前时间减去一天，即一天前的时间
//        calendar.getTimeInMillis();//返回当前时间的毫秒数
//        date = calendar.getTime();
//        String oldTimeStr = sdf.format(date);

        String time = "2021-01-01";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(time);
        Date lastMonthDate = new Date();//获取当前时间

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, -1);//当前时间减去一个月，即一个月前的时间
        lastMonthDate = cal.getTime();

        String oldTimeStr = sdf.format(lastMonthDate);
        System.out.println("last month date:"+oldTimeStr);





//        1.利用Date的equals比较大小
//
////1.利用Date的equals比较大小
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String timeStr1 = "2020-02-12 12:45:45";
//        String timeStr2 = "2020-02-12 12:45:40";
//        Date date1 = sdf.parse(timeStr1);
//        Date date2 = sdf.parse(timeStr2);
//        if(date1.equals(date2)) {
//            //相等
//        }
//        2.题外：利用Calendar的equals比较
//
//        Calendar time1 = Calendar.getInstance();
//        Calendar time2 = Calendar.getInstance();
//        time1.setTime(date1);
//        time2.setTime(date2);
//        if(time1.equals(time2)) {
//            //相等

        }
}
