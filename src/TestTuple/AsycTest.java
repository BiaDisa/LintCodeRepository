package TestTuple;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AsycTest {

    /**
     * 基于JDK1.5的Future，进行阻塞与轮询的单纯性能判断
     * 总结如下：
     * 轮询 - 参数- 1000R+50 wait-100ms+即时  *100times avg:6501ms
     * 阻塞 -参数 -1000R+50  *100times avg:6098ms
     * 轮询 - 参数- 1000R+50 wait-不间断轮询（元组队列）+50ms（多线程元组任务内部）  *100times avg: 1071ms         CPU：25%-30%
     * 轮询 - 参数- 1000R+50 wait-50ms+50ms  *100times avg: 1110ms         CPU：25%-30%
     *
     */
    public static void AsycTuple() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        List<Long> totalResList = null;
        for (int i = 0; i <= 5; i++) {
            int ceilSize = 10;
            totalResList = new ArrayList<>();
            List<Future<Long>> futureList = new ArrayList<>();
            long startTime = System.currentTimeMillis();//开始时间
            for (int j = 0; j < ceilSize; j++) {
                //分批次进行，使用for循环效率稍高一些
                List<Long> itemMemberIdsList = new ArrayList<>();
                //初始化查询参数
                //提交任务到线程池
                futureList.add(cachedThreadPool.submit(() -> {
                    long lazyTime = (long) (1000 * Math.random() + 50);
                    try {
                        Thread.sleep(lazyTime);
                        return lazyTime;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return lazyTime;
                }));
            }
            if (1 == 1) {
                try {
                    cachedThreadPool.shutdown();
                    while (futureList.size() != 0) {//间断轮询
                        Thread.sleep(50);
                        Iterator<Future<Long>> iterator = futureList.iterator();
                        while (iterator.hasNext()) {
                            Future<Long> processFuture = iterator.next();
                            if (processFuture.isDone()) {
                                totalResList.add(processFuture.get());
                                iterator.remove();
                            }
                        }
                    }
                    System.out.println("Thread complete,avg thread running time:"+totalResList.stream().mapToLong(Long::valueOf).average()+"ms");
                } catch (Exception e) {

                    e.printStackTrace();
                }
            }
            if (1 == 1) {//阻塞
               int circleSize = futureList.size();
               for(int k=0;k<circleSize;k++){
                   try {
                       totalResList.add(futureList.get(k).get());
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   } catch (ExecutionException e) {
                       e.printStackTrace();
                   }
               }
                System.out.println("Thread complete,avg thread running time:"+totalResList.stream().mapToLong(Long::valueOf).average()+"ms");
            }
        }
        }


    public static Long AsycTestFirst() throws InterruptedException {
        Long startTime = System.currentTimeMillis();
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for(int j = 0;j<=10;j++){
            cachedThreadPool.submit(AsycTest::AsycTuple);
        }
        cachedThreadPool.shutdown();
        while(!cachedThreadPool.isTerminated()){
        }
        long lite = (System.currentTimeMillis()-startTime);
        System.out.println("Asyc共耗时："+lite+"ms");
        return lite;
    }
}
