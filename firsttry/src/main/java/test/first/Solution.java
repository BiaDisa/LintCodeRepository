package test.first;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


}