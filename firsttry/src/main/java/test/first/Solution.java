package test.first;

import java.util.*;

public class Solution {
    /**
     * @param n: The number of digits
     * @return: All narcissistic numbers with n digits
     */
    public static List<Integer> getNarcissisticNumbers(int n) {
        int[] pos = new int[n];
        List<Integer> list = new ArrayList<>();
        int op;
        for (int i = n>1?times(10,n-1):0; i < times(10, n); i++) {
            int tempI = i;
            op = 0;
            int[] btes = integerDecodeByPos(i);
            for (int j = 0; j <= n-1; j++) {
                op += times(btes[j],n);
            }
            if (op == i)
                list.add(i);
        }
        return list;
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n < 2) return n;
        int[] record = new int[128];
        int left = 0;
        int res = 0;
        for (int right = 0; right < n; right++){
            char cur = s.charAt(right);
            // left更新
            if (record[cur] > left){
                left = record[cur];
            }
            // left = Math.max(left, record[cur]);

            // 记录位置
            record[cur] = right + 1;

            // res更新
            res = Math.max(res, right - left + 1);

//             if (record[cur] > left){
//                 left = right;
//             }
//                 record[cur] = right+1;

//             int val = right - left + 1;
//                 if (val > res) {
//                     res = val;
//                 }

        }

        return res;
    }

    public int digitCounts(int k, int n) {

        if(k==0&&n>0){
            return (n/10)+1;
        }
        int tenCount = getPos(n);
        int tar[] =  integerDecodeByPos(n);//按位将n拆分
        int getT = 0;
        int despos = n;//用来计算的n
        int odd=0;//下一位添加数
        for(int i=0;i<tenCount;i++){
            if(tar[i]>k)  {
                getT += tenPow(tenCount-i);

            }
            if(tar[i]==k) {
                getT += despos-tar[i]*tenPow(tenCount-i)+1;
            }

            /*if(i>=1){
                getT += tar[i-1]*tenPow(tenCount-i);
            }*/
            despos-=tar[i]*tenPow(tenCount-i);
            getT += odd*tenPow(tenCount-i);
            odd=tar[i]*tenPow(tenCount-i-1);
        }
        return getT;
    }


    /*public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int result =  getTotal(l1,1)+getTotal(l2,1);
        return decompose(result);
    }

    public int getTotal(ListNode l1,int times){
        if(l1.next==null)
            return l1.val*times;
        return l1.val*times+getTotal(l1.next,times*10);
    }
    public ListNode decompose(int k){
        if(k/10 == 0)
            return new ListNode(k);
        ListNode list = new ListNode(k-(k/10)*10);
        list.next = decompose(k/10);
        return list;
    }

    public ListNode convertArrayToListNode(int x){
        if(x/10 == 0)
            return new ListNode(x);
        ListNode temp =
    }*/

    public int nthUglyNumber(int n) {
        int[] primes = new int[n];
        if(n==1)
            return 1;
        int count=1;
        int tar =1;
        int primeIndex = 1;
        primes[0] = 1;
        boolean flag=false;
        while(count<n){
            tar++;
            if(tar %2==0|| tar %3==0|| tar %5==0) {
                for(int i=0;i<primeIndex;i++){
                    if(tar%primes[i]!=0||primes[i]==1){
                        flag=true;
                        continue;
                    }else{
                        flag=false;
                        break;
                    }

                }
                if(flag)
                    count++;
            }else{
                primes[primeIndex]=tar;
                primeIndex++;
            }
        }
        return tar;
    }

    public void rotateString(char[] str, int offset) {
        char X ;
        int head=0;
        int length=0;
        int index=0;
        for(char m:str){
            if(m!=' ')
                length++;
        }
        if(length==0)
            return;
        if(offset>length){
            int N = offset-(offset/length)*length;
            offset = N;
        }
        index = length-offset;
        for(int find=length-offset;find<=length-1;find++){
            X = str[find];
            for(int j=find;j>find-index;j--){
                str[j] = str[j-1];
            }
            str[head]=X;
            head++;
        }
    }

    public static int times(int m, int j) {
        int eachTime = m;
        if(j == 0)
            return 1;
        for (int n = 1; n < j; n++) {
            m = m * eachTime;
        }
        return m;
    }

    public static int[] integerDecodeByPos(int n){
        int pos = 1;
        int tempN = n,contain;
        while((n=n/10)!=0)
            pos++;
        int integerPos[] = new int[pos];
        for(int i=1;tempN!=0;i++){
             integerPos[pos-i]=tempN-(tempN/10)*10;
             tempN =tempN/10;
        }
        return integerPos;
    }


    public int tenPow(int n){
        int value=1;
        int circle = 1;
        while(circle<n){
            value*=10;
            circle++;
        }
        return value;
    }

    public int getPos(int n){
        int pos=1;
        while((n=n/10)!=0)
            pos++;
        return pos;
    }




    public static boolean isUnique(String str) {
        char[] c =str.toCharArray();
        HashMap<String,Integer> map = new HashMap();
        for(int i=0;i<c.length;i++){
            if(map.get(String.valueOf(c))!=null){
                return false;
            }
            map.put(String.valueOf(c),i);
        }
        return true;
    }

    public static String reverseWords(String s) {
        String[] rawList = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = rawList.length-1;i>=0;i--){
            if(!rawList[i].equals("")){
            sb.append(rawList[i].split(" ")[0]);
            if(i != 0){
                sb.append(" ");
            }
        }}

        return sb.toString();
    }

/**
 * 对于一个给定的 source 字符串和一个 target 字符串，
 * 你应该在 source 字符串中找出 target 字符串出现的第一个位置(从0开始)。
 * 如果不存在，则返回 -1。
 */

public static  int strStr(String source, String target) {
    char[] sourceList = source.toCharArray();
    char[] targetList = target.toCharArray();
    if( target.equals("")){
        return 0;
    }
    int runDistance = source.length()-target.length();
    for(int i=0;i<=runDistance;i++){
        if(sourceList[i] == targetList[0]){
            for(int j=0;j<targetList.length;j++){
                if(sourceList[i+j] != targetList[j]){
                    break;
                }
                if(j == targetList.length-1){
                    return i;
                }
                continue;
            }
        }
    }
    return -1;
}

    /**
     * 给出一个字符串，找出第一个只出现一次的字符。
     * @param str
     * @return
     */
    public  char firstUniqChar(String str) {
        List<FirstUniqTurple> list = new ArrayList();
        HashMap<String,Integer> dic = new HashMap();
        char[] rawStr = str.toCharArray();
        int length = rawStr.length;
        int lastIndex = 0;
        for(int i=0;i<length;i++){
            Integer index = dic.get(String.valueOf(rawStr[i]));
            if(index == null){
                list.add(new FirstUniqTurple(rawStr[i]));
                dic.put(String.valueOf(rawStr[i]),lastIndex++);
                continue;
            }
            else{
                FirstUniqTurple t = list.get(index);
                t.times++;
            }
        }
        for(FirstUniqTurple turple:list){
            if(turple.times == 1){
                return turple.value;
            }
        }
        return '1';
    }
    public class FirstUniqTurple {
        char value;
        int times;
        FirstUniqTurple(char value){
            this.value = value;
            this.times = 1;
        }
    }
//--------------------------------------------------------


    /**
     * 给定一个字符串str,现在你需要统计出现次数最多的字母。返回这个字母出现的次数。
     * @param str
     * @return
     */
    public int mostFrequentlyAppearingLetters(String str) {
        int[] timeList = new int[str.length()];
        Map<String,Integer> indexMap = new HashMap<>();
        int lastIndex = 0;
        char[] strArray = str.toCharArray();
        for(int i=0;i<=strArray.length-1;i++){
            Integer index = indexMap.get(String.valueOf(strArray[i]));
            if(index != null){
                timeList[index]  = timeList[index]+1;
                continue;
            }
            indexMap.put(String.valueOf(strArray[i]),lastIndex);
            timeList[lastIndex++] = 1;
        }
        int maxCount = 0;
        for(int j=0;j<timeList.length;j++){
            if(timeList[j]>maxCount){
                maxCount = timeList[j];
            }
        }
        return maxCount;
    }
    //------------------------------------
    /**
     * 请判断字符串 str 是不是一个合法的标识符。
     * 合法的标识符由字母（A-Z，a-z）、数字（0-9）和下划线组成，并且首字符不能为数字。
     */
    public boolean isLegalIdentifier(String str) {
        char[] strArray = str.toCharArray();
        if(str.length() == 0||Character.isDigit(strArray[0])){
            return false;
        }
        for(char c : strArray){
            if(Character.isAlphabetic(c)||c == '_'||Character.isDigit(c))
                continue;
            return false;
        }
        return true;
    }

    //------------------------------
    /**
     * 给定一篇由大写字母、小写字母、逗号、句号组成的文章，求使文章不合法的字母数。
     * 文章不合法有2种情况：
     * 1.句子的第一个字母用了小写。
     * 2.不是单词的首字母用了大写。
     */
    public int count(String s) {
       char[] charArray = s.toCharArray();
       int illegalCount = 0;
       int phraseFlag = 0;
       int wordFlag = 0;
       for(char c: charArray){
           if(c == ' '){
               wordFlag = 0;
               continue;
           }
               if(phraseFlag == 0){
                   if(!Character.isUpperCase(c)){
                       illegalCount ++;
                   }
                   wordFlag ++;
                   phraseFlag = 1;
                   continue;
               }
               if(c == '.'){
                   phraseFlag = 0;
                   continue;
               }
                   if(Character.isUpperCase(c) && wordFlag>=1){
                       illegalCount++;
                   }
                   wordFlag ++;
                   continue;
               }

       return illegalCount;
    }


//------------------------

    /**
     * 顺序表插入查找
     * 二分查找
     * @param A
     * @param target
     * @return
     */
    public int searchInsert(int[] A, int target) {
        int left = 0;
        int right = A.length-1;
        int mid  = 0;
        while(left <= right){
            mid = (left+right)/2;
            if(A[mid] == target){
                return mid;
            }
            if(A[mid] < target){
                right = mid;
                continue;
            }
            //A[mid] > target
            left = mid;
            continue;
        }
        return left;
    }

    //--------------------------
    /**
     * 521. 去除重复元素
     * 中文English
     * 给一个整数数组，去除重复的元素。
     *
     * 你应该做这些事
     *
     * 1.在原数组上操作
     * 2.将去除重复之后的元素放在数组的开头
     * 3.返回去除重复元素之后的元素个数
     *          WA
     */
    public int deduplication(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        HashMap<Integer,Integer> dic = new HashMap();
        int lastUniq = nums.length-1;
        boolean uniqFlag;
        for(int i=0;i<=lastUniq;i++){
            uniqFlag = false;
            while(!uniqFlag && i<=lastUniq){
                Integer index = dic.get(nums[i]);
                if(index == null){
                    dic.put(nums[i],i);
                    uniqFlag = true;
                    continue;
                }
                if(index != null){
                    int temp = nums[i];
                    nums[i] = nums[lastUniq];
                    nums[lastUniq] = temp;
                    lastUniq--;
                }
            }
        }
        return nums.length - lastUniq +1;
    }
    //-----------------
    /**
     846. 多关键字排序
     *给定 n 个学生的学号(从 1 到 n 编号)以及他们的考试成绩，
     * 表示为(学号，考试成绩)，请将这些学生按考试成绩降序排序，若考试成绩相同，则按学号升序排序。
     * 样例1
     *
     * 输入: array = [[2,50],[1,50],[3,100]]
     * 输出: [[3,100],[1,50],[2,50]]
     * 样例2
     *
     * 输入: array = [[2,50],[1,50],[3,50]]
     * 输出: [[1,50],[2,50],[3,50]]
     * BubbleSort MineScore:60
     */
    public int[][] multiSort(int[][] array) {
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                int tempNO = array[i][0];
                int tempScore = array[i][1];
                if(array[i][1] == array[j][1]){
                    if(array[i][0] >array[j][0]){
                        exchange(array, i, j, tempNO, tempScore);
                        continue;
                    }
                }
                if(array[i][1] <array[j][1]){
                    exchange(array, i, j, tempNO, tempScore);
                }
            }
        }
        return array;
    }

    private void exchange(int[][] array, int i, int j, int tempNO, int tempScore) {
        array[i][0] = array[j][0];
        array[i][1] = array[j][1];
        array[j][0] = tempNO;
        array[j][1] = tempScore;
    }

    //----------------------
    /**
     * 给定一系列的会议时间间隔，包括起始和结束时间[[s1,e1]，[s2,e2]，…(si < ei)，确定一个人是否可以参加所有会议。
     * (0,8),(8,10)在8这这一时刻不冲突\
     * low efficient
     */
    public static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    //solution:sort(base on start) first,then operate
        public boolean canAttendMeetings(List<Interval> intervals) {
            intervals.sort(Comparator.comparingInt((Interval a) -> a.start));
            int end = 0;
            for (Interval interval : intervals) {
                if (interval.start < end && end != 0)
                    return false;
                end = interval.end;
            }
        return true;
        }



        //-------------------------

}