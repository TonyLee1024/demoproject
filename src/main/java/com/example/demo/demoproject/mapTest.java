package com.example.demo.demoproject;

import java.util.HashMap;
import java.util.Map;

public class mapTest {
    public static void main(String[] args) {
        Integer dateYear = 2020;
        Long userId = 4444444L;
        Long itemId = 860000L;
        Integer datemonth = 12;
        Long totalIncome = 8888888L;
        Map<String,Long> incomeMap = new HashMap<>();
        String mapKey = userId +"-"+ itemId + "-" + datemonth;
        incomeMap.put(mapKey,totalIncome);


        for(String key: incomeMap.keySet()){
            String [] arrayKey = key.split("-");
            Long itemIdValue = Long.parseLong(arrayKey[1]);
            String month = arrayKey[2];
            Long totalValue = incomeMap.get(key);
            System.out.println(userId + "-" +itemIdValue+ "-" +dateYear+ "-" +month+ "-" +totalValue);
        }
    }
}
