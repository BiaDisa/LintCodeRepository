package test.first;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RegexLearning {


    public static void main(String[]  args){
        String sor = "Is is the cost of of gasoline going up up";
        String pattern = "\b([a-z]+) \\\1\\\b\\/ig";
        Arrays.stream(sor.split(pattern)).forEach(a-> System.out.println(a));
        Date date = new Date(System.currentTimeMillis());
        String dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        System.out.println(dateStr);
    }
}


