package test.first;


import org.omg.CORBA.FREE_MEM;
import test.first.TestTuple.JsoupTurple;

import java.io.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

import static java.time.ZoneOffset.UTC;

public class Main {


    public static void main(String[] args) throws IOException, InterruptedException, ParseException {

        System.out.println(new Date().getTime());
        String s = "https://mp.weixin.qq.com/bizmall/authinvoice?action=list&s_pappid=d3xxxxxxxxxxxxxGLSS0wrL14No8c1".split("&")[1];
        System.out.println(s.split("=")[1]);
/**
 * AsycTest
 */
    /*List<Long> avgList = new ArrayList<>();
    for(int i=0;i<=100;i++) {
        avgList.add(AsycTest.AsycTestFirst());
    }
        System.out.println("平均耗时:"+avgList.stream().mapToLong(Long::valueOf).average()+"ms");*/


        /**
         * IteratorTest
         */
/*        IteratorTest.iteratorTestTuple();
        BigDecimal a = new BigDecimal("100.0005123")
;
        a.setScale(1,BigDecimal.ROUND_HALF_UP).setScale(1,BigDecimal.ROUND_HALF_UP);
        System.out.println(a.toString());
        a.setScale(1,BigDecimal.ROUND_HALF_UP);
        System.out.println(a.toString());*/

        /**
         * String.replaceFires Test
         * result:%s不会影响正常匹配
         */
        /*StringReplaceTest.replaceTest();*/


        /**
         * Collections.copy()test
         * result:copy方法仅将原元素复制到新list中，新list中的对象仍然指向对应元素地址
         */
        /*List<ListNode> a = new ArrayList<>();
        a.add(new ListNode(10));
        a.add(new ListNode(100));
        List<ListNode> b = new ArrayList<>();
        b.add(new ListNode(1));
        b.add(new ListNode(5));
        Collections.copy(b,a);
        System.out.println(b.get(0));
        System.out.println(a.get(0)); --b.0 equals  to  a.0*/

        /*        *//**
         * Collections.rotate() test1
         * reason: -1%1=? etc
         *//*
         *//*        System.out.println(-1%1);//0
        System.out.println(-1%2);//-1
        System.out.println(-5%1);//0
        System.out.println(-10%3);//-1*//*
        String a = "活动奖励【%s】";
        *//*a = a.replaceFirst("%s","1");*//*
        System.out.println(a);*/

        /**
         * rotate Test
         */
        /*List<Integer> rotateArr  = Arrays.asList(1,2,3,4,5,6,7);
        Collections.rotate(rotateArr,4);
        System.out.println(rotateArr);*/

        /*  *//**
         * gotoTest
         * result:label would not init value 
         *//*
        gotoTest:
         for(int cad = 0;cad<10;cad++){
             if(cad == 3)
                 continue  gotoTest;
             System.out.println(cad);
         }*/


        /**
         *ISO_OFFSET_DATE_TIME yyyy-MM-ddThh:mm:ss+HH:MM 转换
         */




        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:SS");

        String dateStr = sdf.format(d);
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d2 ;
        d2 = sdf.parse("2020-03-30 23:59:59",new ParsePosition(0));
        Date d3 = sdf.parse("2020-05-30 19:00:00",new ParsePosition(0));
        System.out.println(dateStr);
        System.out.println(d2);
        System.out.println(sdf.format(d2));
        System.out.println(d2.compareTo(d));
        System.out.println(d2.compareTo(d3));



    }
    public static void popUpTest(){
        int i = 0;
        List<List<Integer>> totalList = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        popUpTestRecursion(i,totalList,list);
        System.out.println("102845y190tyh13908");
    }

    public static void popUpTestRecursion(Integer i,List<List<Integer>> totalList,ArrayList<Integer> list){
        ArrayList<Integer> arrayList = new ArrayList<>();
        Collections.copy(list,arrayList);
        while(i<=10){
            arrayList.add(i);
            i++;
            popUpTestRecursion(i,totalList,list);
        }
        totalList.add(arrayList);
    }




    }






















