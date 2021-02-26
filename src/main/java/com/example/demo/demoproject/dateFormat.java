package com.example.demo.demoproject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class dateFormat {
    public static void main(String[] args) throws ParseException {
        Map<Object,Object> mapInfo = new HashMap<>();
        mapInfo.put("createTime","1606914734000");

        Object goodsPayTime = mapInfo.get("createTime").toString();
        String beginDate = goodsPayTime.toString();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String oldTimeStr = sdf.format(new Date(Long.parseLong(beginDate))); // 时间戳转换日期

        Boolean isTwoYear = yearCompare("2019-12-02");
        Integer monthNum = monthCompare("2019-12-01");

        String nextMonth = getNextMonthdayDate("2019-01-01",1);


        SimpleDateFormat sdftest = new SimpleDateFormat("yyyy-MM-dd");
        Date stfDate = sdftest.parse("2021-12-20");

        String dateTest1 = getYearOrMonthByDate(stfDate,1);
        String dateTest2 = getYearOrMonthByDate(stfDate,2);
//        System.out.println(dateTest1);

//        System.out.println(getFirstDayOfMonth1(new Date()).getTime());
        System.out.println(dateTest1+"-"+dateTest2);
        System.out.println(nextMonth);
    }
    /**
     * 获取指定月底天数
     * @return
     */
    public static Date getFirstDayOfMonth1(Date nowDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


        Calendar cal = Calendar.getInstance();
        cal.setTime(nowDate);

        //设置年份
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR));
        //设置月份
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH));

        int lastDay = cal.getActualMaximum(Calendar.DATE);

        //设置日历中月份的最小天数
        cal.set(Calendar.DAY_OF_MONTH,lastDay);

        Date resultDate = cal.getTime();
        System.out.println(sdf.format(resultDate));
        return resultDate;
    }
    /**
     * 传入参数判断是否大于2年
     */
    public static Boolean yearCompare(String oldTime){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date nowDate = new Date();
        String nowDateStr = sdf.format(nowDate);


        LocalDate from = LocalDate.parse(oldTime);
        LocalDate to = LocalDate.parse(nowDateStr);

        long years = ChronoUnit.YEARS.between(from, to);  // 0 weeks
        System.out.println(years);
        if(years>=2){
            return true;
        }else{
            return false;
        }

    }
    /**
     * 传入参数返回距离现在几个月
     */
    public static Integer monthCompare(String oldTime){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date nowDate = new Date();
        String nowDateStr = sdf.format(nowDate);


        LocalDate from = LocalDate.parse(oldTime);
        LocalDate to = LocalDate.parse(nowDateStr);

        Integer months = Math.toIntExact(ChronoUnit.MONTHS.between(from, to));

        return months;
    }
    /**
     * 根据指定日期格式返回下月日期
     *
     * @return date
     */
    public static String getNextMonthdayDate(String date, Integer monthNum) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date stfDate = sdf.parse(date);

        Date lastMonthDate = new Date();//获取当前时间
        Calendar cal = Calendar.getInstance();
        cal.setTime(stfDate);
        cal.add(Calendar.MONTH, monthNum);//当前时间减去一个月，即一个月前的时间
        lastMonthDate = cal.getTime();
        String newDateStr = sdf.format(lastMonthDate);
        return newDateStr;
    }
    /**
     * 根据指定日期格式返回年或月
     *
     * @return date
     */
    public static String getYearOrMonthByDate(Date date, Integer type)  {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date stfDate = date;

        Calendar cal = Calendar.getInstance();
        cal.setTime(stfDate);

        Integer month = cal.get(Calendar.MONTH)+1;
        Integer result = null;
        String resultStr = "";
        if(type.equals(1)){

                result = cal.get(Calendar.YEAR);
                resultStr = result.toString();

        }else if(type.equals(2)){

                result = cal.get(Calendar.MONTH)+1;
                if(result<10){
                    resultStr = "0"+result.toString();
                }else {
                    resultStr = result.toString();
                }

        }
        return resultStr;
    }
}
