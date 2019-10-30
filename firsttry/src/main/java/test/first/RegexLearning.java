package test.first;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegexLearning {

    public static void main(String[]  args){
        Date date = new Date(System.currentTimeMillis());
        String dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        System.out.println(dateStr);
    }
}


