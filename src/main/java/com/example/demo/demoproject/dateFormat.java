package com.example.demo.demoproject;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.LocalDateTimeUtil;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

        System.out.println(isTwoYear);

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

}
