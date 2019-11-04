package test.first;
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
    public int search(int[] A, int target) {
        if(A.length == 0)
            return -1;
        int rotateStart = findFirstIndex(A,0,A.length-1);
        if(target<A[rotateStart] ||
                (rotateStart>1 && target > A[rotateStart-1])||
                (target>A[A.length-1]&&target<A[0])){
            return -1;
        }
        else if(target > A[0]){
            return engineFirst.binarySearch(A,target,0,rotateStart-1);
        }
        else if(target<A[A.length-1]){
            return engineFirst.binarySearch(A,target,rotateStart+1,A.length-1);
        }
        return -1;
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
        if(midVal<startVal && midVal<endVal){
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
     */
    public int findPeak(int[] A) {
       int left = A[0];
       int right = A[A.length-1];
        while(left< right){
            int mid = (left+ right)/2;
            if(mid == 1 || mid == A.length-2){
                return 0;
            }
            if(A[mid]>A[mid+1]&&A[mid]>A[mid-1]){
                return mid;
            }
            if(A[mid]<A[mid+1]&&A[mid]>A[mid-1]){
                left = mid+1;
            }
            else{//mid<mid-1>mid+1
                right = mid+1;
            }
        }
        return 0;
    }

    //---------------
    /**
     * testMain
     */
    public static void main(String[] args){
        int[] A = {1,2,1,3,4,5,7,6};
        Solution2 engine = new Solution2();
        System.out.println(A[engine.findFirstIndex(A,0,A.length-1)]);
    }
}
