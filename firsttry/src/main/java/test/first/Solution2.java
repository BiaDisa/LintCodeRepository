package test.first;

import java.util.HashMap;
import java.util.Stack;

import static java.util.Arrays.binarySearch;

public class Solution2 {

    Solution engineFirst = new Solution();

    //---------------
    /**
     * 62. 搜索旋转排序数组
     * 中文English
     * 假设有一个排序的按未知的旋转轴旋转的数组
     * (比如，0 1 2 4 5 6 7 可能成为4 5 6 7 0 1 2)。给定一个目标值进行搜索，
     * 如果在数组中找到目标值返回数组中的索引位置，否则返回-1。你可以假设数组中不存在重复的元素。
     * 输入: [4, 5, 1, 2, 3] and target=1,
     * 输出: 2.
     * 例2:
     *
     * 输入: [4, 5, 1, 2, 3] and target=0,
     * 输出: -1.
     */
    public int searchForSolution(int[] A, int target) {
            if (A == null || A.length == 0) {
                return -1;
            }

            int start = 0;
            int end = A.length - 1;
            int mid;

            while (start + 1 < end) {
                mid = start + (end - start) / 2;
                if (A[mid] == target) {
                    return mid;
                }
                if (A[start] < A[mid]) {
                    // situation 1, red line
                    if (A[start] <= target && target <= A[mid]) {
                        end = mid;
                    } else {
                        start = mid;
                    }
                } else {
                    // situation 2, green line
                    if (A[mid] <= target && target <= A[end]) {
                        start = mid;
                    } else {
                        end = mid;
                    }
                }
            } // while

            if (A[start] == target) {
                return start;
            }
            if (A[end] == target) {
                return end;
            }
            return -1;
        }

    public int search(int[] A, int target) {
        if(A.length == 0)
            return -1;
        if(A.length == 1 && A[0] == target)
            return 0;
        int rotateStart = findFirstIndex(A,0,A.length-1);
        if(target<A[rotateStart] ||
                (rotateStart>1 && target > A[rotateStart-1])||
                (target>A[A.length-1]&&target<A[0])){
            return -1;
        }
        else if(target == A[rotateStart])
            return rotateStart;
        else if(target >= A[0]){
            return engineFirst.binarySearch(A,target,0,rotateStart);
        }
        else if(target<=A[A.length-1]){
            return engineFirst.binarySearch(A,target,rotateStart,A.length-1);
        }

        return -1;
    }

    //------------------------
    /**
     * 63. 搜索旋转排序数组 II
     * 中文English
     * 跟进“搜索旋转排序数组”，假如有重复元素又将如何？
     *
     * 是否会影响运行时间复杂度？
     *
     * 如何影响？
     *
     * 为何会影响？
     *
     * 写出一个函数判断给定的目标值是否出现在数组中。

     */
    public boolean search2(int[] A, int target) {
        if(A == null || A.length == 0)
            return false;
        int first = findFirstIndexDupilicated(A,0,A.length-1);
        if(target == A[first] || target == A[0] || target == A[A.length-1] || (first-1 >0 && target == A[first-1]))
            return true;
        if(target>A[first]&&target<A[A.length-1]){
            return (engineFirst.binarySearch(A,target,first,A.length-1) != -1);
        }else if(target>A[A.length-1] && target<A[first-1] && first>1){
            return (engineFirst.binarySearch(A,target,0,first-1) != -1);
        }else{
            return false;
        }
    }

    public int findFirstIndex(int[] A,int start ,int end){
        if(start > end){
            return 0;
        }
        if(start == end){
            return end;
        }
        if(start == end -1){
            return A[start]>A[end]?end:start;
        }
        int startVal = A[start];
        int endVal = A[end];
        int mid = (start+end)/2;
        int midVal = A[mid];
        if(midVal<=startVal && midVal<=endVal){
            while(mid > 0 && A[mid]>A[mid-1]){
                mid--;
            }
            return mid;
        }
        if(midVal<endVal && midVal>startVal){
            return findFirstIndex(A,start,mid-1);
        }
        if(midVal>=startVal) {
            return findFirstIndex(A, mid + 1, end);
        }
        else{//midVal<endVal && midVal>starVal
            return -1;
        }
    }

    public int findFirstIndexDupilicated(int[] A,int start ,int end){
        int i = 1,lastVal = A[0];
        while(i<end && A[i] >=lastVal) {
            lastVal = A[i];
            i++;
        }
            return i;
    }
    //------------------
    /**
     * 75.你给出一个整数数组(size为n)，其具有以下特点：
     *
     * 相邻位置的数字是不同的
     * A[0] < A[1] 并且 A[n - 2] > A[n - 1]
     * 假定P是峰值的位置则满足A[P] > A[P-1]且A[P] > A[P+1]，返回数组中任意一个峰值的位置。
     * 数组保证至少存在一个峰
     * 如果数组存在多个峰，返回其中任意一个就行
     * 数组至少包含 3 个数
     * (数学证明题：满足所给条件时，区间必有峰值。以该结论为前提，可以很简单地使用二分法进行处理。)
     */
    public int findPeak(int[] A) {
        if (A.length == 3)
            return 1;
        int left = 0, right = A.length - 1;
        int mid;
        while (left + 1 < right) {
            mid = (left + right) / 2;
            if (A[mid] > A[mid + 1] && A[mid] > A[mid - 1])
                return mid;
            if (A[mid] < A[mid - 1])
                right = mid;
            else {
                left = mid;
            }
        }
        return A[left] > A[right] ? left : right;
    }
    //-----------------
    /**
     * 159. 寻找旋转排序数组中的最小值
     * 假设一个排好序的数组在其某一未知点发生了旋转（比如0 1 2 4 5 6 7 可能变成4 5 6 7 0 1 2）。你需要找到其中最小的元素。
     * tocheck:findFirstIndex()
     */

    //---------------
    /**
     *608. 两数和 II-输入已排序的数组
     * 中文English
     * 给定一个已经 按升序排列 的数组，找到两个数使他们加起来的和等于特定数。
     * 函数应该返回这两个数的下标，index1必须小于index2。注意返回的值不是 0-based。
     */
    public int[] twoSum(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        int sum = 0;
        int[] result = new int[2];
        while(left  < right){
            sum = nums[left]+nums[right];
            if(sum == target){
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            }else if(sum < target){
                left++;
                continue;
            }else {//sum>tar
                right--;
                continue;
            }
        }
        return result;
    }
    //---------------
    /**
     * 945. 任务计划
     * 给定一个字符串，表示CPU需要执行的任务。 这个字符串由大写字母A到Z构成，
     * 不同的字母代表不同的任务。完成任务不需要按照给定的顺序。
     * 每项任务都可以在一个单位时间内被完成。 在每个单位时间，CPU可以选择完成一个任务或是不工作。
     * 但是，题目会给定一个非负的冷却时间“n”，表示在执行两个“相同的任务”之间，必须至少有n个单位时间，此时CPU不能执行该任务，只能执行其他任务或者不工作。
     *
     * 您需要返回CPU完成所有给定任务所需的最少单位时间数。
     * 输入: tasks = ['A','A','A','B','B','B'], n = 2
     * 输出: 8
     * 解释:
     * A -> B -> idle -> A -> B -> idle -> A -> B.
     */
    public int leastInterval(char[] tasks, int n) {
        int[] rawScale = new int[26];
        int index = 0;
        for(int i=0;i<tasks.length;i++) {
            if(rawScale[tasks[i] - 'A'] == 0)
                index++;
            rawScale[tasks[i] - 'A']++;
        }
        int time = 0;
        int[] scale = new int[index];
        int scaleIndex = 0;
        int risist = 0;
        for(int i=0;i<26;i++) {
            if (rawScale[i] != 0)
                scale[scaleIndex++] = rawScale[i];
        }
        for(int i=0;i<index;){
            if(scale[i] == 0) {
                i++;
                continue;
            }
            risist = 0;
            scale[i]--;
            time++;
                for(int j=i+1;j<index && risist<n;j++){
                    if(scale[j] == 0)
                        continue;
                    scale[j]--;
                    risist++;
                }
                time+=n;
        }
        return (time+risist-n);
    }
    //-----------
    /**
     * 12. 带最小值操作的栈
     * 中文English
     * 实现一个栈, 支持以下操作:
     *
     * push(val) 将 val 压入栈
     * pop() 将栈顶元素弹出, 并返回这个弹出的元素
     * min() 返回栈中元素的最小值
     * 要求 O(1) 开销.
     * 注意事项
     * 保证栈中没有数字时不会调用 min()
     */

    public static class MinStack {
        Stack<Integer> originStack;
        int min = 0;

        public MinStack() {
            originStack = new Stack();
            min =-Integer.MAX_VALUE;
        }

        /*
         * @param number: An integer
         * @return: nothing
         */
        public void push(int number) {
            if(originStack.isEmpty()){
                min = number;
            }
            else if(number < min){
                min = number;
            }
            originStack.push(number);
            return;
        }

        /*
         * @return: An integer
         */
        public int pop() {
            int popElement =  originStack.pop();
            if(min == popElement && !originStack.isEmpty()){
                sortMin();
            }
            return popElement;
        }

        private void sortMin(){
            int length = originStack.size();
            int[] tmpArr = new int[length];
            for(int i = length-1;i>=0;i--){
                int popElement = originStack.pop();
                tmpArr[i] = popElement;
                if(i == length-1){
                    min = popElement;
                }else{
                    if(min > popElement)
                        min = popElement;
                }
            }
            for(int j=0;j<tmpArr.length;j++){
                originStack.push(tmpArr[j]);
            }
        }

        /*
         * @return: An integer
         */
        public int min() {
            return min;
        }
    }
    //-------------
    /**
     * 请设计一种方法将一个栈进行升序排列 （最大的数在最上面）。
     *
     * 你可以使用另外一个栈来辅助操作，但不可将这些数复制到另外一个数据结构中 （如，数组）。
     */
    public void stackSorting(Stack<Integer> stk) {
        Stack<Integer> tempStack = new Stack();
        Stack<Integer> swapStack = new Stack();
        int scale = 0;
        while(!stk.isEmpty()){
            tempStack.push(stk.pop());
            scale++;
        }
        while(stk.size()<scale){
            int min = tempStack.pop();
            while(!tempStack.isEmpty()){
                int cmp = tempStack.pop();
                if(min>cmp){
                    swapStack.push(min);
                    min = cmp;
                }else{
                    swapStack.push(cmp);
                }
            }
            stk.push(min);
            Stack p ;
            p = tempStack;
            tempStack = swapStack;
            swapStack = p;
        }
    }
    //------------
    /**
     * 384. 最长无重复字符的子串
     * 给定一个字符串，请找出其中无重复字符的最长子字符串。
     * o(n)
     */
    public int lengthOfLongestSubstring(String s) {
        if(null == s || s.length() == 0 || s == "")
            return 0;
        char[] strArr = s.toCharArray();
        HashMap<Character,Integer> workingMap = new HashMap<>();
        int max = 1;
        for(int i=0;i<s.length();i++){
            if(workingMap.get(strArr[i])!=null){
                max = max < workingMap.size()?workingMap.size():max;
                workingMap.clear();
            }
            else{
                workingMap.put(strArr[i],1);
            }
        }
        return max;
    }

    //--------------
    /**
     * 40. 用栈实现队列
     * 正如标题所述，你需要使用两个栈来实现队列的一些操作。
     *
     * 队列应支持push(element)，pop() 和 top()，其中pop是弹出队列中的第一个(最前面的)元素。
     *
     * pop和top方法都应该返回第一个元素的值。
     */
    public class MyQueue {
        Stack<Integer> popStack, pushStack;
        public MyQueue() {
            // do intialization if necessary
            popStack = new Stack<>();
            pushStack = new Stack<>();
        }

        /*
         * @param element: An integer
         * @return: nothing
         */
        public void push(int element) {
            while(!popStack.isEmpty())
                pushStack.push(popStack.pop());
            pushStack.push(element);
        }

        /*
         * @return: An integer
         */
        public int pop() {
           while(!pushStack.isEmpty())
               popStack.push(pushStack.pop());
           int returnVal = popStack.pop();
           return returnVal;
        }

        /*
         * @return: An integer
         */
        public int top() {
            while(!pushStack.isEmpty())
                popStack.push(pushStack.pop());
            int returnVal = popStack.peek();
            return returnVal;
        }
    }

    //------------
    /**
     * testMain
     */
    public static void main(String[] args){
        MinStack stk = new MinStack();
        stk.push(3);
        stk.push(2);
        stk.push(1);
        stk.min();
        stk.pop();
        stk.min();
        stk.pop();
        stk.min();

    }
}
