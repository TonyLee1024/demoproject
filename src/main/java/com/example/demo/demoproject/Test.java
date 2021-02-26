package com.example.demo.demoproject;

import cn.hutool.core.lang.Console;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test {
    /**
     * 获取文件夹下所有文件的名称 + 模糊查询（当不需要模糊查询时，queryStr传空或null即可）
     * 1.当路径不存在时，map返回retType值为1
     * 2.当路径为文件路径时，map返回retType值为2，文件名fileName值为文件名
     * 3.当路径下有文件夹时，map返回retType值为3，文件名列表fileNameList，文件夹名列表folderNameList
     * @param folderPath 路径
     * @param queryStr 模糊查询字符串
     * @return
     */
    public static HashMap<String, Object> getFilesName(String folderPath , String queryStr) {
        HashMap<String, Object> map = new HashMap<>();
        List<String> fileNameList = new ArrayList<>();//文件名列表
        List<String> folderNameList = new ArrayList<>();//文件夹名列表
        File f = new File(folderPath);
        if (!f.exists()) { //路径不存在
            map.put("retType", "1");
        }else{
            boolean flag = f.isDirectory();
            if(flag==false){ //路径为文件
                map.put("retType", "2");
                map.put("fileName", f.getName());
            }else{ //路径为文件夹
                map.put("retType", "3");
                File fa[] = f.listFiles();
                queryStr = queryStr==null ? "" : queryStr;//若queryStr传入为null,则替换为空（indexOf匹配值不能为null）
                for (int i = 0; i < fa.length; i++) {
                    File fs = fa[i];
                    if(fs.getName().indexOf(queryStr)!=-1){
                        if (fs.isDirectory()) {
                            folderNameList.add(fs.getName());
                        } else {
                            fileNameList.add(fs.getName());
                        }
                    }
                }
                map.put("fileNameList", fileNameList);
                map.put("folderNameList", folderNameList);
            }
        }
        return map;
    }

    /**
     * 测试
     */
    public static void main(String[] args) {
//        HashMap<String,Object> filesName = getFilesName("D:\\Users", "BD1");
//        List<String> fileNameList = (List<String>) filesName.get("fileNameList");//文件名列表
//        for (int i = 0; i < fileNameList.size(); i++) {
//            System.out.println(fileNameList.get(i));
//        }
//        System.out.println(filesName);

        List<String> fileNameLists = getFilesNames("D:\\Users", "申");
        for (int i = 0; i < fileNameLists.size(); i++) {
            System.out.println(fileNameLists.get(i));
        }
    }
    public static List<String> getFilesNames(String folderPath , String queryStr) {

        List<String> fileNameList = new ArrayList<>();//文件名列表
        File f = new File(folderPath);
        if (!f.exists()) { //路径不存在
            return  fileNameList;
        }else{

                File fa[] = f.listFiles();
                queryStr = queryStr==null ? "" : queryStr;//若queryStr传入为null,则替换为空（indexOf匹配值不能为null）
                for (int i = 0; i < fa.length; i++) {
                    File fs = fa[i];
                    if(fs.getName().indexOf(queryStr)!=-1){
                        if (fs.isDirectory()) {

                        } else {
                            fileNameList.add(fs.getName());
                        }
                    }
                }

        }

        return fileNameList;
    }
}