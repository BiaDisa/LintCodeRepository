package test.first;

import java.util.Arrays;

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
     *
     */
    //------------
    /**
     * testMain
     */
    public static void main(String[] args){
        int[] A = {12,20,11};
        Solution2 engine = new Solution2();
        System.out.println(engine.findPeak(A));
    }
}
