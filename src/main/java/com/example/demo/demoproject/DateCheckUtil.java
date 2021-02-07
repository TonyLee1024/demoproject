package com.example.demo.demoproject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 二师兄
 * @version V1.0
 * @Title: 时间校验工具类
 * @Description:
 * @date 2020/12/30 11:42
 */
public class DateCheckUtil {

    /**
     * 校验日期区间时间跨度是否在一年之内
     *      参数日期格式应为 yyyy-MM-dd，例如：2020-12-31
     * @param beginDate 开始日期
     * @param dueDate 结束日期
     */
    public static boolean checkIsOneYear(String beginDate, String dueDate){
        //365天的毫秒数
        long ms = 31536000000L;
        try {
            //规定需要转换的日期格式
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            //文本转日期
            Date due = sdf.parse(dueDate);
            Date begin = sdf.parse(beginDate);
            long time = due.getTime() - begin.getTime();
            System.out.println(time + "=" + due.getTime() + "-" + begin.getTime());
            //天数大于366天或者小于一天一定属于不合理输入，返回false
            if(time > 31622400000L || time < 0L){
//                System.out.println("查询时间期间不合法。");
                return false;
            }

            //对字符串截取，取出年份和月份
            Integer beginYear = Integer.valueOf(beginDate.substring(0, 4));
            Integer beginMonth = Integer.valueOf(beginDate.substring(5, 7));
            Integer dueYear = Integer.valueOf(dueDate.substring(0, 4));
            Integer dueMonth = Integer.valueOf(dueDate.substring(5, 7));

            //判断是否为闰年，并跨过2月，如果是则增加一天的毫秒数
            if(isLeapYear(beginYear) && beginMonth <= 2){
                ms += 86400000;
            }else if(isLeapYear(dueYear) && dueMonth >= 2){
                ms += 86400000;
            }

            return time <= ms;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 给定一个年份，判断是否为闰年
     * @param year
     * @return
     */
    public static boolean isLeapYear(Integer year){
        if(year % 100 == 0){
            if(year % 400 == 0){
                return true;
            }
        }else if(year % 4 == 0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Map<Object,Object> mapInfo = new HashMap<>();
        mapInfo.put("createTime","1606914734000");

        Object goodsPayTime = mapInfo.get("createTime").toString();
        String beginDate = goodsPayTime.toString();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String payTime = sdf.format(new Date(Long.parseLong(beginDate))); // 时间戳转换日期

        Date nowTime = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        Date oldTime = df.parse(payTime);
        String now = sdf.format(new Date()); // 时间戳转换日期

        String begin = "2020-01-15";
        String dueDate = "2021-01-15";
        System.out.println("payTime:"+payTime);
        System.out.println("now:"+now);
        boolean b = checkIsOneYear(payTime, now);
        System.out.println(b);
    }

}
