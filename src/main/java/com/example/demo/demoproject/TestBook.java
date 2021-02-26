//package com.example.demo.demoproject;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.baidu.finance.licai.trust.service.client.AbstractGatewayClient;
//import com.baidu.finance.licai.trust.service.common.model.BookPeriodItem;
//import com.google.common.reflect.TypeToken;
//import com.google.gson.Gson;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//import org.apache.commons.lang3.StringEscapeUtils;
//import org.opensaml.xml.signature.G;
//
//import java.io.*;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.net.URLConnection;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//public class TestBook extends AbstractGatewayClient {
//
//
//    private static List<Date> getDates(int year) {
//        List<Date> dates = new ArrayList<Date>();
//        SimpleDateFormat date_format = new SimpleDateFormat("yyyyMMdd");
//        for (int month = 1; month <= 12; month++) {
//            Calendar cal = Calendar.getInstance();
//            cal.set(Calendar.YEAR, year);
//            cal.set(Calendar.MONTH, month - 1);
//            cal.set(Calendar.DATE, 1);
//            while (cal.get(Calendar.YEAR) == year && cal.get(Calendar.MONTH) < month) {
//                int day = cal.get(Calendar.DAY_OF_WEEK);
//
//                if (!(day == Calendar.SUNDAY || day == Calendar.SATURDAY)) {
//                    Date resDate = cal.getTime();
//                    String dateStr = date_format.format(resDate);
////                    System.out.println(dateStr);
//                    dates.add((Date) cal.getTime().clone());
//                }
//                cal.add(Calendar.DATE, 1);
//            }
//        }
//
//        return dates;
//
//    }
//    public static List<Date> SendGET(String url, List<Date> workDates){
//
//        String result="";//访问返回结果
//        SimpleDateFormat date_format = new SimpleDateFormat("MM-dd");
//        BufferedReader read=null;//读取访问结果
//        StringBuffer buffer = new StringBuffer();
//        String res="";
//        JsonObject object = null;
//        List<Date> resultDate = new ArrayList<>();
//        Calendar cal = Calendar.getInstance();
//        try {
//
//            //创建url
//
//            URL realurl=new URL(url+"?");
//
//            //打开连接
//
//            URLConnection connection=realurl.openConnection();
//
//            // 设置通用的请求属性
//
//            connection.setRequestProperty("accept", "*/*");
//
//            connection.setRequestProperty("connection", "Keep-Alive");
//
//            connection.setRequestProperty("user-agent",
//
//                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
//
//            //建立连接
//
//            connection.connect();
//            InputStream is = connection.getInputStream();
//            InputStreamReader isr = new InputStreamReader(is,"utf-8");
//            BufferedReader br = new BufferedReader(isr);
//            String str = null;
//            while((str = br.readLine())!=null){
//                buffer.append(str);
//            }
//            br.close();
//            isr.close();
//            is.close();
//            res = buffer.toString();
//            JsonParser parse =new JsonParser();
//            object = (JsonObject) parse.parse(res);
//            System.out.println(object.get("holiday"));
//            String holidayDate = object.get("holiday").toString();
//            //{"code":0,"holiday":{"01-01":{"holiday":true,"name":"元旦","wage":3,"date":"2021-01-01","rest":3},"01-02":{"holiday":true,"name":"元旦","wage":2,"date":"2021-01-02","rest":1},"01-03":{"holiday":true,"name":"元旦","wage":2,"date":"2021-01-03","rest":1},"02-07":{"holiday":false,"name":"春节前调休","after":false,"wage":1,"target":"春节","date":"2021-02-07","rest":35},"02-11":{"holiday":true,"name":"除夕","wage":2,"date":"2021-02-11","rest":39},"02-12":{"holiday":true,"name":"初一","wage":3,"date":"2021-02-12","rest":1},"02-13":{"holiday":true,"name":"初二","wage":3,"date":"2021-02-13","rest":1},"02-14":{"holiday":true,"name":"初三","wage":3,"date":"2021-02-14","rest":1},"02-15":{"holiday":true,"name":"初四","wage":2,"date":"2021-02-15"},"02-16":{"holiday":true,"name":"初五","wage":2,"date":"2021-02-16"},"02-17":{"holiday":true,"name":"初六","wage":2,"date":"2021-02-17"},"02-20":{"holiday":false,"name":"春节后调休","after":true,"wage":1,"target":"春节","date":"2021-02-20"},"04-03":{"holiday":true,"name":"清明节","wage":3,"date":"2021-04-03","rest":1},"04-04":{"holiday":true,"name":"清明节","wage":2,"date":"2021-04-04","rest":1},"04-05":{"holiday":true,"name":"清明节","wage":2,"date":"2021-04-05","rest":1},"04-25":{"holiday":false,"name":"劳动节前调休","after":false,"wage":1,"target":"劳动节","date":"2021-04-25"},"05-01":{"holiday":true,"name":"劳动节","wage":3,"date":"2021-05-01"},"05-02":{"holiday":true,"name":"劳动节","wage":2,"date":"2021-05-02"},"05-03":{"holiday":true,"name":"劳动节","wage":2,"date":"2021-05-03"},"05-04":{"holiday":true,"name":"劳动节","wage":2,"date":"2021-05-04"},"05-05":{"holiday":true,"name":"劳动节","wage":2,"date":"2021-05-05"},"05-08":{"holiday":false,"name":"劳动节后调休","after":true,"wage":1,"target":"劳动节","date":"2021-05-08"},"06-12":{"holiday":true,"name":"端午节","wage":3,"date":"2021-06-12"},"06-13":{"holiday":true,"name":"端午节","wage":2,"date":"2021-06-13"},"06-14":{"holiday":true,"name":"端午节","wage":2,"date":"2021-06-14"},"09-18":{"holiday":false,"after":false,"name":"中秋节前调休","wage":1,"target":"中秋节","date":"2021-09-18"},"09-19":{"holiday":true,"name":"中秋节","wage":3,"date":"2021-09-19"},"09-20":{"holiday":true,"name":"中秋节","wage":2,"date":"2021-09-20"},"09-21":{"holiday":true,"name":"中秋节","wage":2,"date":"2021-09-21"},"09-26":{"holiday":false,"after":false,"name":"国庆节前调休","wage":1,"target":"国庆节","date":"2021-09-26"},"10-01":{"holiday":true,"name":"国庆节","wage":3,"date":"2021-10-01"},"10-02":{"holiday":true,"name":"国庆节","wage":3,"date":"2021-10-02"},"10-03":{"holiday":true,"name":"国庆节","wage":3,"date":"2021-10-03"},"10-04":{"holiday":true,"name":"国庆节","wage":2,"date":"2021-10-04"},"10-05":{"holiday":true,"name":"国庆节","wage":2,"date":"2021-10-05"},"10-06":{"holiday":true,"name":"国庆节","wage":2,"date":"2021-10-06"},"10-07":{"holiday":true,"name":"国庆节","wage":2,"date":"2021-10-07"},"10-09":{"holiday":false,"name":"国庆节后调休","after":true,"wage":1,"target":"国庆节","date":"2021-10-09"}}}
//
//            Gson gson = new Gson();
//            Map<Object,Object> mapObj =  gson.fromJson(holidayDate,new TypeToken<Map<Object,Object>>(){}.getType());
//            for(int i = 0;i<workDates.size();i++) {
//                String dateStr = date_format.format(workDates.get(i));
//                System.out.println(dateStr);
//                boolean resultFlag = isEqualsKey(dateStr,mapObj);
//
//                    if(resultFlag){
////                        System.out.println("添加："+":"+dateStr);
//                        resultDate.add(workDates.get(i));
//                    }
//
//                }
//
//            return resultDate;
//
//        } catch (IOException e) {
//
//            e.printStackTrace();
//
//        }finally{
//
//            if(read!=null){//关闭流
//
//                try {
//
//                    read.close();
//
//                } catch (IOException e) {
//
//                    e.printStackTrace();
//
//                }
//
//            }
//
//        }
//        return resultDate;
//
//    }
//
//    private static boolean isEqualsKey(String dateStr, Map<Object, Object> mapObj) {
//        boolean flag = true;
//        for(Map.Entry<Object, Object> entry : mapObj.entrySet()){
//            //01-04  01-01
//
//            Object mapKey = entry.getKey();
//            if(mapKey.equals(dateStr)){
//                System.out.println("相等："+dateStr+":"+mapKey);
//                flag = false;
//                break;
//            }
//
//        }
//        return flag;
//
//    }
//
//    public static void main(String[] args) {
//        String spId = "402";
//
//        List<Date> workDates = getDates(2021);
//        SimpleDateFormat date_format = new SimpleDateFormat("YYYY-MM-dd");
//        //获取所有工作日
//        List<Date> workResultDateList = SendGET("http://timor.tech/api/holiday/year/2021/",workDates);
//
//
//        List<BookPeriodItem> resultBookPeriodItemList = createJsonDate(workResultDateList);
//
//        String resultBookPeriodItemListJson = createResultJson(resultBookPeriodItemList);
////        for(int i = 0;i< workResultDateList.size();i++) {
////            String dateStr = date_format.format(workResultDateList.get(i));
////            System.out.println(dateStr);
//////            System.out.println(workResultDateList.get(i).toString());
////        }
//
//        for(int i = 0;i< 8;i++) {
//            BookPeriodItem bookPeriodItem = resultBookPeriodItemList.get(i);
//            System.out.println(bookPeriodItem.getPeriodId());
//
//        }
//        Map<String,Object> resultBookPeriodItemMap = new HashMap<>();
//        resultBookPeriodItemMap.put(spId,resultBookPeriodItemListJson);
//        System.out.println(resultBookPeriodItemMap.get("402"));
//
//        String jsonString = JSON.toJSONString(resultBookPeriodItemMap);
//        //Gson gson = new Gson();
//        //String gsonStr = gson.toJson(resultBookPeriodItemMap);
//        System.out.print("打印转换的数据："+" "+jsonString);
//       String result = StringEscapeUtils.unescapeJava(jsonString);
//        System.out.print("打印转换的数据："+" "+result);
//        createFileInComputer(result);
//    }
//
//    private static void createFileInComputer(String jsonString) {
//        String replacesStr =StringEscapeUtils.unescapeJava(jsonString);
//        SimpleDateFormat date_format = new SimpleDateFormat("yyyyMMdd");
//        Calendar cal = Calendar.getInstance();
//        Date resDate = cal.getTime();
//        String dateStr = date_format.format(resDate);
//        String fullFilename = "D:/BookPeriodItemData"+dateStr+".json";
//
//        try {
//            File newTextFile = new File(fullFilename);
//            FileWriter fw;
//            fw = new FileWriter(newTextFile);
//            fw.write(replacesStr);
//            fw.close();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//
//    private static String createResultJson(List<BookPeriodItem> resultBookPeriodItemList) {
//        JSONArray jsonArray = new JSONArray();
//        for(BookPeriodItem bookPeriodItem : resultBookPeriodItemList){
//            JSONObject jo = new JSONObject();
//            jo.put("periodId", bookPeriodItem.getPeriodId());
//            jo.put("periodDesc", bookPeriodItem.getPeriodDesc());
//            jo.put("remainNum", bookPeriodItem.getRemainNum());
//            jo.put("periodStartTime", bookPeriodItem.getPeriodStartTime());
//            jo.put("periodEndTime", bookPeriodItem.getPeriodEndTime());
//            jsonArray.add(jo);
//        }
//        return jsonArray.toString();
//    }
//
//    private static List<BookPeriodItem> createJsonDate(List<Date> workResultDateList) {
//        List<BookPeriodItem> resultBookPeriodList = new ArrayList<>();
//        SimpleDateFormat date_formatId = new SimpleDateFormat("yyyyMMdd");
//
//        SimpleDateFormat date_formatDesc = new SimpleDateFormat("yyyy-MM-dd");
//
//        for(int i = 0;i<workResultDateList.size();i++) {
//
//            for(int k = 1; k<=8; k++) {
//
//                BookPeriodItem bookPeriodItem = new BookPeriodItem();
//
//                String datePeriodIdStr = date_formatId.format(workResultDateList.get(i)) + "0" + k;
//
//                bookPeriodItem.setPeriodId(Integer.parseInt(datePeriodIdStr));
//                String datePeriodDescStr="";
//                String datePeriodStartTimeStr="";
//                String datePeriodEndTimeStr="";
//                switch (k){
//                    case 1:
//                        datePeriodDescStr = date_formatDesc.format(workResultDateList.get(i)) + " 10:00-11:00";
//                        datePeriodStartTimeStr = date_formatDesc.format(workResultDateList.get(i)) + " 10:00:00";
//                        datePeriodEndTimeStr = date_formatDesc.format(workResultDateList.get(i)) + " 11:00:00";
//                        bookPeriodItem.setPeriodDesc(datePeriodDescStr);
//                        bookPeriodItem.setRemainNum(2);
//                        bookPeriodItem.setPeriodStartTime(datePeriodStartTimeStr);
//                        bookPeriodItem.setPeriodEndTime(datePeriodEndTimeStr);
//                        break;
//                    case 2:
//                        datePeriodDescStr = date_formatDesc.format(workResultDateList.get(i)) + " 11:00-12:00";
//                        datePeriodStartTimeStr = date_formatDesc.format(workResultDateList.get(i)) + " 11:00:00";
//                        datePeriodEndTimeStr = date_formatDesc.format(workResultDateList.get(i)) + " 12:00:00";
//                        bookPeriodItem.setPeriodDesc(datePeriodDescStr);
//                        bookPeriodItem.setRemainNum(2);
//                        bookPeriodItem.setPeriodStartTime(datePeriodStartTimeStr);
//                        bookPeriodItem.setPeriodEndTime(datePeriodEndTimeStr);
//                        break;
//                    case 3:
//                        datePeriodDescStr = date_formatDesc.format(workResultDateList.get(i)) + " 12:00-13:00";
//                        datePeriodStartTimeStr = date_formatDesc.format(workResultDateList.get(i)) + " 12:00:00";
//                        datePeriodEndTimeStr = date_formatDesc.format(workResultDateList.get(i)) + " 13:00:00";
//                        bookPeriodItem.setPeriodDesc(datePeriodDescStr);
//                        bookPeriodItem.setRemainNum(2);
//                        bookPeriodItem.setPeriodStartTime(datePeriodStartTimeStr);
//                        bookPeriodItem.setPeriodEndTime(datePeriodEndTimeStr);
//                        break;
//                    case 4:
//                        datePeriodDescStr = date_formatDesc.format(workResultDateList.get(i)) + " 13:00-14:00";
//                        datePeriodStartTimeStr = date_formatDesc.format(workResultDateList.get(i)) + " 13:00:00";
//                        datePeriodEndTimeStr = date_formatDesc.format(workResultDateList.get(i)) + " 14:00:00";
//                        bookPeriodItem.setPeriodDesc(datePeriodDescStr);
//                        bookPeriodItem.setRemainNum(2);
//                        bookPeriodItem.setPeriodStartTime(datePeriodStartTimeStr);
//                        bookPeriodItem.setPeriodEndTime(datePeriodEndTimeStr);
//                        break;
//                    case 5:
//                        datePeriodDescStr = date_formatDesc.format(workResultDateList.get(i)) + " 14:00-15:00";
//                        datePeriodStartTimeStr = date_formatDesc.format(workResultDateList.get(i)) + " 14:00:00";
//                        datePeriodEndTimeStr = date_formatDesc.format(workResultDateList.get(i)) + " 15:00:00";
//                        bookPeriodItem.setPeriodDesc(datePeriodDescStr);
//                        bookPeriodItem.setRemainNum(2);
//                        bookPeriodItem.setPeriodStartTime(datePeriodStartTimeStr);
//                        bookPeriodItem.setPeriodEndTime(datePeriodEndTimeStr);
//                        break;
//                    case 6:
//                        datePeriodDescStr = date_formatDesc.format(workResultDateList.get(i)) + " 15:00-16:00";
//                        datePeriodStartTimeStr = date_formatDesc.format(workResultDateList.get(i)) + " 15:00:00";
//                        datePeriodEndTimeStr = date_formatDesc.format(workResultDateList.get(i)) + " 16:00:00";
//                        bookPeriodItem.setPeriodDesc(datePeriodDescStr);
//                        bookPeriodItem.setRemainNum(2);
//                        bookPeriodItem.setPeriodStartTime(datePeriodStartTimeStr);
//                        bookPeriodItem.setPeriodEndTime(datePeriodEndTimeStr);
//                        break;
//                    case 7:
//                        datePeriodDescStr = date_formatDesc.format(workResultDateList.get(i)) + " 16:00-17:00";
//                        datePeriodStartTimeStr = date_formatDesc.format(workResultDateList.get(i)) + " 16:00:00";
//                        datePeriodEndTimeStr = date_formatDesc.format(workResultDateList.get(i)) + " 17:00:00";
//                        bookPeriodItem.setPeriodDesc(datePeriodDescStr);
//                        bookPeriodItem.setRemainNum(2);
//                        bookPeriodItem.setPeriodStartTime(datePeriodStartTimeStr);
//                        bookPeriodItem.setPeriodEndTime(datePeriodEndTimeStr);
//                        break;
//                    case 8:
//                        datePeriodDescStr = date_formatDesc.format(workResultDateList.get(i)) + " 17:00-18:00";
//                        datePeriodStartTimeStr = date_formatDesc.format(workResultDateList.get(i)) + " 17:00:00";
//                        datePeriodEndTimeStr = date_formatDesc.format(workResultDateList.get(i)) + " 18:00:00";
//                        bookPeriodItem.setPeriodDesc(datePeriodDescStr);
//                        bookPeriodItem.setRemainNum(2);
//                        bookPeriodItem.setPeriodStartTime(datePeriodStartTimeStr);
//                        bookPeriodItem.setPeriodEndTime(datePeriodEndTimeStr);
//                        break;
//                    default:
//                        datePeriodDescStr = date_formatDesc.format(workResultDateList.get(i)) + " 17:00-18:00";
//                        datePeriodStartTimeStr = date_formatDesc.format(workResultDateList.get(i)) + " 17:00:00";
//                        datePeriodEndTimeStr = date_formatDesc.format(workResultDateList.get(i)) + " 18:00:00";
//                        bookPeriodItem.setPeriodDesc(datePeriodDescStr);
//                        bookPeriodItem.setRemainNum(2);
//                        bookPeriodItem.setPeriodStartTime(datePeriodStartTimeStr);
//                        bookPeriodItem.setPeriodEndTime(datePeriodEndTimeStr);
//                }
//                resultBookPeriodList.add(bookPeriodItem);
//            }
//
//
//
//        }
//
//
//        return resultBookPeriodList;
//
//
//    }
//
//
//}
