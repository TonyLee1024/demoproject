package com.example.demo.demoproject;

import java.util.HashMap;
import java.util.Map;

public class longClassTest {
    public static void main(String[] args) {
        String number = "0";
        long longNumber = Long.parseLong(number);

//        if(longNumber == 0){
//            System.out.println("为0");
//        }else{
//            System.out.println("不为0");
//        }
        Map<Object,Object> mapInfo = new HashMap<>();
        mapInfo.put("bankName",null);
        if(null == mapInfo.get("bankName")){
            System.out.println("为null");
            mapInfo.put("bankName","建设银行");
        }


        System.out.println(mapInfo.get("bankName"));

//        if(null == orderData.get("bankName")){
//            logger.info(" redisOrderData bankName is null");
//            orderData.put("bankName",bankerName);
//        }
//        String value = JSON.toJSONString(orderData);
    }


}
