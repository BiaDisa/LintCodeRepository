package test.first.TestTuple;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class IteratorTest {
    /**
     * iterator学习
     * 测试结果：若使用foreach循环，当发生删除操作时会报错
     * 必须使用如下格式，方可正常运行
     */
    public static void iteratorTestTuple(){
        ArrayList<Integer> source = new ArrayList<>();
        source.addAll(Arrays.asList(1,54,13,4,187,66,777,88,9));
        ArrayList<Integer> compareSource = new ArrayList<>();
        compareSource.addAll(Arrays.asList(1,4,9,54));
        for (int i =0; i<compareSource.size() ; i++) {
            Integer comp =  compareSource.get(i);
            Iterator iterator = source.iterator();
            while(iterator.hasNext()){
                Integer temp = (Integer)iterator.next();
                if(comp.equals(temp)){
                    iterator.remove();
                    break;
                }
            }
        }
        System.out.println(source);
    }
}
