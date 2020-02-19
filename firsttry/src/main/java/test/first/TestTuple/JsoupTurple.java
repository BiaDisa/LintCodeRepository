package test.first.TestTuple;
import org.jsoup.*;
import org.jsoup.nodes.Document;


import java.io.IOException;
import java.net.URI;
import java.util.List;


public class JsoupTurple {

    //invalid-too many redirect
    public static void firstSpiderWithJsoup() throws IOException {
        Document document = Jsoup.connect("https://www.baidu.com").get();
        System.out.println(document.body());
    }





    public static void main(String[] args){
      try {
            firstSpiderWithJsoup();
        } catch (IOException e) {
           e.printStackTrace();
      }
    }

}
