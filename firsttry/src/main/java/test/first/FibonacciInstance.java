package test.first;

public class FibonacciInstance implements  Runnable{
    int index;
    final int fId = taskCount++;
    int[] list;
    static int taskCount = 0;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }


    public FibonacciInstance() {
        index = (int)(Math.random()*100+2);
        list = new int[index];
        list[0] = 1;
        list[1] = 1;
        for(int i=2;i<index;i++)
            list[i] = list[i-1]+list[i-2];
    }

    @Override
    public void run() {
        for (int i : list) {
            System.out.println("#"+fId+" index: "+index+":"+i+" ");
            Thread.yield();
        }
        return;
    }

}
