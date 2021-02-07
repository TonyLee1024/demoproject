package com.example.demo.stream;

import cn.hutool.core.lang.Console;
import com.example.demo.entity.User;

import java.util.*;
import java.util.stream.Collectors;

public class exampleStream {



    public static void main(String[] args) {
        List<User> userList = new ArrayList<>(
                Arrays.asList(
                        new User("strive", "努力"),
                        new User("fighter", "奋斗"),
                        new User("lucky",  "幸运"),
                        new User("lucky",  "幸运222")
                )
        );
//   ---     forEach方法用于迭代遍历每个数据
//        userList.forEach(str -> System.out.println(str + ""));
//        User(name=strive, description=努力)
//        User(name=fighter, description=奋斗)
//        User(name=lucky, description=幸运)
//        User(name=lucky, description=幸运222)

        //获取stringList中非空字符串的集合
        List<String> strList = new ArrayList<>(Arrays.asList("01","02","03","","03"));

        List<String> collect = strList.stream().filter(
                str -> !str.isEmpty()
        ).collect(Collectors.toList());

        Console.log("获取stringList中非空字符串的集合"+collect);
//        count() 方法，用来统计数量
        long emtyStrNum = strList.stream().filter(str -> str.isEmpty()).count();

        Console.log("空字符数量 ：" + emtyStrNum);

//        [01, 02, 03]
//        空字符数量 ：1

        //获取stringList中非空字符串的集合 去重后 转化为list集合
        List<String> collectDis = strList.stream().filter(str -> !str.isEmpty()).distinct().collect(Collectors.toList());

        Console.log("获取stringList中非空字符串的集合 去重后 转化为list集合:"+collectDis);


//        Collectors 类中实现了很多的规约操作（可用于返回列表或字符串）
//        最常用的是将流转换为 集合或聚合元素对象
        Set<String> stringSet = strList.stream().filter(str -> !str.isEmpty()).collect(Collectors.toSet());

        Console.log("set集合，不去重也输出相同的结果（set中不会有重复的元素）:"+stringSet);

        Map<String,User> mapObj = userList.stream().collect(Collectors.toMap(User::getName, i -> i,(v1,v2) -> v1));
        //第三个参数 (v1, v2) -> v1，当出现key值相同时（也就是如果v1与v2的key值相同），选择前面的 也就是v1 作为那个key所对应的值，**就是出现相同key时，谁覆盖谁的问题 *
        Console.log("使用Collectors.toMap(keyMapper, valueMapper)两个参数来将List转化为Map:"+mapObj);

        List<Integer> numList = Arrays.asList(2, 3, 10, 6, 8, 5, 2, 9);

        //最大
        Optional<Integer> maxNum = numList.stream().collect(Collectors.maxBy(Integer::compareTo));
        //最小
        Optional<Integer> minNum = numList.stream().collect(Collectors.minBy(Integer::compareTo));
        //平均值
        Double averagingInt = numList.stream().collect(Collectors.averagingInt(i -> i));
        //求和
        Integer summingInt = numList.stream().collect(Collectors.summingInt(i -> i));
        //summarizingInt 统计数目、求和、最小值、平均值、最大值
        IntSummaryStatistics summarizingInt = numList.stream().collect(Collectors.summarizingInt(i -> i));

        Console.log("最大值:"+maxNum);
        Console.log("最小值:"+minNum);
        Console.log("平均值:"+averagingInt);
        Console.log("求和:"+summingInt);
        Console.log("summarizingInt 统计数目、求和、最小值、平均值、最大值:"+summarizingInt);


    }
}

