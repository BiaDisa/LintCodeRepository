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
               left = mid+1;
                continue;
            }
            //A[mid] > target
            right = mid -1;
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
        return lastUniq+1;
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
    /**
     * 1663. 忧郁
     * CAT 专属题目
     * 中文English
     * 有 n 道可选的题可以做，每一题都有特定的忧郁值，你会从中选择 k 题。如果这 k 题的忧郁值总和大于等于 m，那么你就会感到忧郁，反之，你就感受不到忧郁。
     * 那么，请问，有没有可能你做完 k 题之后感受不到忧郁？
     * 如果可能，返回 yes。
     * 如果不可能，即你一定会感到忧郁，那么返回 no。
     */
    public String depress(int m, int k, int[] arr) {
        int min[] = new int[k];
        int minIndex = 0;
        for(int i =0;i<arr.length;i++){
            if(minIndex<k){
                min[minIndex++] = arr[i];
                continue;
            }
            if(minIndex == k){
                int cmp = arr[i];
                int exchange = 0;
                for(int j=0;j<=k-1;j++) {
                    if(cmp < min[j]){
                        exchange = min[j];
                        min[j] = cmp;
                        cmp = exchange;
                    }
                }
                continue;
            }
        }
        int sum = 0;
        for(int i=0;i<k;i++)  sum += min[i];
        return sum>=m?"no":"yes";
    }


    //----------------
    /**
     * 1662. 中位数下标
     * 给出一个含有 n 个互不相等整数的无序数组，找到其中中位数的下标。下标从 0 开始。
     *
     * 中位数是指这些数排序后最中间的数。
     *
     * 若 n 为偶数，则中位数是数组排序后的第 n/2 个数。
     * WA solution：中位数查找\
     * D - should learn later
     */
    public  int getAns(int [] a){
        int[] b = deepCopy(a);
        int length = a.length;
        a = sort(a);
        int target;
        if(length %2 == 0){
            target =  a[(length/2)-1];
        }
        else {
            target =  a[(length/2)];
        }
        for(int m = 0;m<length;m++){
            if(b[m] == target)
                return m;
        }
        return 0;
    }
    public int[] deepCopy(int[] a){
        int[] b = new int[a.length];
        for(int i =0;i<a.length;i++){
            b[i] = a[i];
        }
        return b;
    }

    public int[] sort(int[] a){
        int ext = 0;
        for(int i=0;i<a.length;i++){
            for(int j =i+1;j<a.length;j++){
                if(a[i] > a[j]){
                    ext = a[i];
                    a[i] = a[j];
                    a[j] = ext;
                }
            }
        }
        return a;
    }
//-------------------------------------
    /**
     * 228. 链表的中点
     * 找链表的中点。
     */
    public ListNode middleNode(ListNode head) {
        HashMap<Integer,ListNode> dic = new HashMap();
        int index = 0;
        while(head!=null){
            index++;
            dic.put(index,head);
            head = head.next;
        }
        int midIndex = index%2 ==0?index/2:((index/2)+1);
        return dic.get(midIndex);
    }

    //-----------------
    /**
     * 219. 在排序链表中插入一个节点
     * 在链表中插入一个节点。
     */
    public ListNode insertNode(ListNode head, int val) {
        ListNode valNode = new ListNode(val);
        ListNode startNode = head ;
        ListNode lastStepNode = head;
        if(head == null){
            return valNode;
        }
        if(head.val>val){
            valNode.next = head;
            return valNode;
        }
        while(head.next!=null){
            if(head.val <=val){
                lastStepNode = head;
                head=head.next;
            }
            if(head.val > val){
                lastStepNode.next = valNode;
                valNode.next = head;
                break;
            }
        }
        if(head.next == null && head.val<=val){
            head.next = valNode;
        }
        return startNode;
    }

    //-------------------
    /**
     *822. 相反的顺序存储
     * 给出一个链表，并将链表的值以倒序存储到数组中。
     */
    public List<Integer> reverseStore(ListNode head) {
        if(head!=null)
            return reverseStoreRecursion(head,new ArrayList<Integer>());
        return new ArrayList<Integer>();
    }

    public List<Integer> reverseStoreRecursion(ListNode head,List<Integer> result) {
        if(head.next!=null){
            reverseStoreRecursion(head.next,result);
        }
        result.add(head.val);
        return result;
    }
    //----------------------
    /**
     *1664. 链表节点计数 II
     * 计算一个链表中值为非负奇数的节点的个数。
     */
    public int countNodesII(ListNode head) {
        int count = 0;
        while(head!=null){
            if(head.val>0 && head.val%2 !=0){
                count ++;
            }
            head = head.next;
        }
        return count;
    }

    //----------------------
    /**
     *376. 二叉树的路径和
     * 给定一个二叉树，找出所有路径中各节点相加总和等于给定 目标值 的路径。
     * 一个有效的路径，指的是从根节点到叶节点的路径。
     * note:
     *      1.路径值可能为负数
     *      2.注意所求路径均需要从根节点到叶子节点
     */

    public static List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> roadList = new ArrayList();
        binaryTreePathSumRecursion(root,target,result,roadList);
        return result;
    }

   public  static void  binaryTreePathSumRecursion(TreeNode root,int target,List<List<Integer>> result,List<Integer> roadList){

       if( root == null){
            return;
       }
        ArrayList<Integer> temp = new ArrayList(roadList);
       temp.add(root.val);
       int sum = 0;
       for(Integer i : temp)
           sum+=i;
       if(sum == target && root.left == null && root.right == null){
           result.add(new ArrayList<>(temp));
       }
       binaryTreePathSumRecursion(root.left,target,result,temp);
       binaryTreePathSumRecursion(root.right,target,result,temp);
    }

    //--------------
    /**
     * 67. 二叉树的中序遍历
     * 给出一棵二叉树,返回其中序遍历
     */

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList();
        if(root != null){
            inorderTraversalRecursion(root,result);
        }
        return result;
    }

    public void inorderTraversalRecursion(TreeNode root,List<Integer> result){
        if(root!=null){
            inorderTraversalRecursion(root.left,result);
            result.add(root.val);
            inorderTraversalRecursion(root.right,result);
        }
    }

    //----------------
    /**
     * 66. 二叉树的前序遍历
     * 给出一棵二叉树，返回其节点值的前序遍历。
     */

    public static List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> resultList = new ArrayList();
        if(root == null){
             return resultList;
        }
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        TreeNode nowNode;
        while(!stack.isEmpty()){
            nowNode = stack.pop();
            resultList.add(nowNode.val);
            if(nowNode.right!=null)
                stack.push(nowNode.right);
            if(nowNode.left != null)
                stack.push(nowNode.left);

        }
        return resultList;
    }
    //--------------

    /**
     * 97. 二叉树的最大深度
     * 给定一个二叉树，找出其最大深度。
     * 二叉树的深度为根节点到最远叶子节点的距离。
     */
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int heightL = 1;
        int heightR = 1;
        if(root!=null){
            heightL+=maxDepth(root.left);
            heightR+=maxDepth(root.right);
        }
        return heightR>heightL?heightR:heightL;

    }

    //-----------------------------

    /**
     480. 二叉树的所有路径
     给一棵二叉树，找出从根节点到叶子节点的所有路径。
     */
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        List<Integer> roadList = new ArrayList<>();
        binaryTreePathsRecursion(root,list,roadList);
        return list;
    }
     public static void binaryTreePathsRecursion(TreeNode root,List<String> list,List<Integer> roadList){
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            StringBuilder sb = new StringBuilder();
            roadList.add(root.val);
            sb.append(roadList.get(0));
            for(int i=1;i<roadList.size();i++){
                sb.append("->").append(roadList.get(i));
            }
            list.add(sb.toString());
            return;
        }
        List<Integer> temp ;
        if(root.left != null){
            roadList.add(root.val);
            temp = new ArrayList<>(roadList);
            binaryTreePathsRecursion(root.left,list,temp);
        }
         if(root.right != null){
             if(root.left == null)
                roadList.add(root.val);
             temp = new ArrayList<>(roadList);
             binaryTreePathsRecursion(root.right,list,temp);
         }
     }
    //---------------------

    /**
     175. 翻转二叉树
     翻转一棵二叉树。左右子树交换。
     */
    public void invertBinaryTree(TreeNode root) {
        if(root!=null){
            TreeNode node = root.left;
            root.left = root.right;
            root.right = node;
            invertBinaryTree(root.left);
            invertBinaryTree(root.right);
        }
    }
    //---------------

    /**
     1751. 牛郎织女
     又到了七夕节，牛郎织女相约一起去一个n*m大小的迷宫maze里玩耍。
     然而没过多久，他们就倒霉地走散了。
     现在给定由.,*,S,T组成的矩阵maze，其中.表示空地,*表示障碍物,S表示牛郎的位置 ,T表示织女的位置，
     牛郎和织女都会试图寻找对方，不停地在矩阵中走动(他们可以每次向上下左右四个方向移动一格或者站着不动，
     但是不能走到迷宫外面或者障碍物)，请问他们是否有可能重逢?如果有可能，返回True，否则返回False。
     n<=2,m<=1000
     */
     class findHerXY{
        int x;
        int y;

         findHerXY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public  boolean findHer(String[] maze) {
        String first = maze[0];
        char charMaze[][] = new char[maze.length][first.length()];
        int pathDic[][] = new int[maze.length][first.length()];
        for(int i=0;i<maze.length;i++){
            charMaze[i] = maze[i].toCharArray();
        }
        int n = 0,m = 0;
        for(int i=0;i<maze.length;i++) {
            for (int j = 0; j < first.length(); j++) {
                if (charMaze[i][j] == 'S') {
                    n = i;
                    m = j;
                    break;
                }
            }
        }
            for(int i=0;i<maze.length;i++)
                for(int j=0;j<first.length();j++)
                    pathDic[i][j] = 0;
        return find(charMaze,n,m,maze.length,first.length(),pathDic);
    }
    //cause stackOverFlow Error or RAMOverFlow
    public  boolean find(char[][] maze,int i,int j,int iLimit,int jLimit,int[][] pathDic){
        int[][] next = {{0,1},{1,0},{0,-1},{-1,0}};
        Stack<findHerXY> XYStack = new Stack<>();
        XYStack.push(new findHerXY(i,j));
        while(!XYStack.isEmpty()){
            findHerXY temp = XYStack.pop();
            i = temp.x;
            j = temp.y;
            pathDic[i][j] = 1;
            if(maze[i][j] == 'T')
                return true;
            for(int k=0;k<=3;k++){
                int tx = i+next[k][0];
                int ty = j+next[k][1];
                if(tx<0 || ty<0 || tx>(iLimit-1) || ty>(jLimit-1)|| maze[tx][ty] == '*' ||pathDic[tx][ty] == 1)
                    continue;
                XYStack.push(new findHerXY(tx,ty));
            }
        }

        return false;


    }

    //----------------

    /**
     1759. 二叉树的结点
     给出一棵二叉树，返回其节点数。
     */
    public int getAns(TreeNode root) {
        if(root == null)
            return 0;
        int sum = 0;
        if(root!=null){
            sum ++;
            sum +=getAns(root.left);
            sum +=getAns(root.right);
        }
        return sum;
    }


    //-----------------

    /**
     1666. 组合+判断素数
     给定 n 个整数和一个整数 k, 你可以从中选择 k 个整数, 现在，要求你计算出k个数和为素数共有多少种方案。
     n 不超过 10
     k 不超过 n
     */
    class PrimeNode {
        int val;
        int index;
        PrimeNode(int val, int index){
            this.val = val;
            this.index = index;
        }
    }

    public int getWays(int[] a, int k) {
        List<PrimeNode> elements = new ArrayList<>();
        Stack<PrimeNode> stack = new Stack<>();
        int primeCount = 0;
        int lastIndex = 0;//a[]中最后一个数
        for(int i=0;i<a.length-k;i++){
            addOpt(i,a,stack,elements);
            while(!stack.isEmpty()){
                if(elements.size()<k){
                    addOpt(++lastIndex,a,stack,elements);
                }
                if(elements.size() == k){
                    if(isPrimeNum(sum(elements)))
                        primeCount++;
                    PrimeNode node = elements.get(k-1);
                    int limit = 1;
                    while(node.index == (a.length-limit) && !stack.isEmpty()){
                       node = removeOpt(k-limit,stack,elements);
                       lastIndex = node.index;
                       limit ++;
                    }
                }
            }
        }
        return primeCount;
    }

    public void addOpt(int index,int a[],Stack<PrimeNode> stack,List<PrimeNode> elements){
        PrimeNode firstNode = new PrimeNode(a[index],index);
        elements.add(firstNode);
        stack.push(firstNode);
    }

    public PrimeNode removeOpt(int index,Stack<PrimeNode> stack,List<PrimeNode> elements){
        elements.remove(index);
        return stack.pop();
    }


    public boolean isPrimeNum(int i){
        int half = i/2;
        int divPart;
        for(int j=2;j<=half;j++){
            divPart = i/j;
            if(j*divPart == i)
                return false;
        }
        return true;
    }

    public int sum(List<PrimeNode> a){
        int sum = 0;
        for(int i=0;i<a.size();i++)
            sum+=a.get(i).val;
        return sum;
    }

    //---------------------

    /**
     * 461. 无序数组K小元素
     * 中文English
     * 找到一个无序数组中第K小的数
     base on BFPRT
     */
    public int kthSmallest(int k, int[] nums) {
        // write your code here
        return 0;
    }


    //-----------------


    //----------------
    /**
     143. 排颜色 II
     给定一个有n个对象（包括k种不同的颜色，并按照1到k进行编号）的数组，将对象进行分类使相同颜色的对象相邻，并按照1,2，...k的顺序进行排序。
     */
    public void sortColors2(int[] colors, int k) {
        for(int i=0;i<colors.length;i++){
            for(int j=i;j<colors.length;j++){
                if(colors[i] > colors[j])
                    swap(colors,i,j);
            }
        }
    }
    public void swap(int[] colors,long i,long j){
        int temp = colors[Math.toIntExact(i)];
        colors[Math.toIntExact(i)] = colors[Math.toIntExact(j)];
        colors[Math.toIntExact(j)] = temp;
    }


    //-----------------

    /**
     57. 三数之和
     给出一个有n个整数的数组S，在S中找到三个整数a, b, c，找到所有使得a + b + c = 0的三元组。
     在三元组(a, b, c)，要求a <= b <= c。
     结果不能包含重复的三元组。
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        if(numbers.length == 0)
            return null;
        HashMap<Integer,Integer> restMap = new HashMap();//restVal,Integer
        HashMap<String,List<Integer>> resultMap = new HashMap<>();
        for(int i=0;i<numbers.length-2;i++){
            if(numbers[i] == numbers[i+1])
                continue;
            int stand ;
            for(int j=i+1;j<=numbers.length-2;j++){
                stand = j;
                if(restMap.get((-(numbers[i]+numbers[j])))!=null&&numbers[j] == restMap.get((-(numbers[i]+numbers[j]))) )
                    continue;
                restMap.put(-(numbers[i]+numbers[j]),numbers[j]);

                for(int k=j+1;k<=numbers.length-1;k++){
                    if(k == stand)
                        continue;
                    if(null !=restMap.get(numbers[k])&& (numbers[i]+numbers[j]+numbers[k]) == 0){
                        List<Integer> currentList = new ArrayList<>();
                        currentList.add(numbers[i]);
                        currentList.add(numbers[j]);
                        currentList.add(numbers[k]);
                        currentList.sort(Integer::compare);
                        String prefix = new String();
                        for(Integer in : currentList){
                            prefix = prefix + in;
                        }
                        resultMap.put(prefix,currentList);
                    }
                }

            }
        }
        List<List<Integer>> collection = new ArrayList(resultMap.values());
        return collection;
    }


    //------------------

    /**
     31. 数组划分
     给出一个整数数组 nums 和一个整数 k。划分数组（即移动数组 nums 中的元素），使得：
     所有小于k的元素移到左边
     所有大于等于k的元素移到右边
     返回数组划分的位置，即数组中第一个位置 i，满足 nums[i] 大于等于 k。
     */
    public int partitionArray(int[] nums, int k) {
        int i,j;
        i=0;
        j=nums.length-1;
        while(i<j) {
            while (nums[i] < k && i < nums.length-1)
                i++;
            if (i == nums.length - 1)
                return nums.length;
            while (nums[j] > k && j > 0)
                j--;
            if (j == 0)
                return 0;
            swap(nums,i,j);
            i++;
            j--;
        }
        return i;
        }


    //-------------------

    /**
     * 快速排序
     */
    public void quickSort(int[] nums,int start,int end){
        if(start >=end)
            return ;
        convertMiddleToStart(nums,start,end);
        int left = start;
        int right = end;
        int tmp = nums[left];
            while(left<right){
                while(nums[right]>=tmp && right>start)
                    right--;
                if(left<right)
                    nums[left++] = nums[right];
                while(nums[left]<=tmp && left<right)
                    left++;
                if(left<right)
                    nums[right--] = nums[left];
            }
        nums[left] = tmp;//如果没有赋值，start位的数字将丢失
        quickSort(nums,start,left-1);
        quickSort(nums,left+1,end);

    }
    public void convertMiddleToStart(int[] nums, int start, int end){
        int middle = (start+end)/2;
        int l=nums[start],r=nums[end],m=nums[middle];
        if((l<=m && m<=r) || (l>=m && m>=r)) swap(nums,start,middle);
        else if((m>=r&&r>=l) || (l>=r&&r>=m) ) swap(nums,start,end);
        //还有2种情况start处于中位，因此不需要互换
    }
    //-------------------------

    //---------------

    /**
     * 5. 第k大元素
     * 在数组中找到第 k 大的元素。
     * @param args
     */


    //-------------------------

    /**
     1670. 回合制游戏
     QW 是一个回合制游戏的玩家，今天他决定去打怪。
     QW 在一场战斗中会碰到 n 个怪物，每个怪物有攻击力 atk[i]，
     每回合结束时如果第 i 个怪物还活着，就会对 QW 造成 atk[i] 的伤害。
     QW 只能在每回合开始时击杀一个怪物，请帮 QW 出他打完所有怪物最少需要损失多少生命值。*/
    public long getAnsAtk(int[] atk) {
        long total = 0L;
        Arrays.sort(atk);
        return getSum(atk);
    }
    public long getSum(int[] nums){
        long lastTotal = 0L;
        long sum = 0L;
        long times = 1L;
        for(int i=nums.length-2;i>=0;i--) {
            sum += nums[i]*times;
            times++;
        }
        return sum;
    }



    //--------------

    /**
     1667. 区间统计

     给定一个01数组 arr 和 一个整数 k, 统计有多少区间符合如下条件:
     区间的两个端点都为 0 (允许区间长度为1)
     区间内 1 的个数不多于 k
     */
    public long intervalStatistics(int[] arr, int k) {
        int[] zeroIndex = new int[tenPow(5)];
        long scale = 0L;
        int index = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 0)
                zeroIndex[index++] = i;
        }
        for(int i=0;i<zeroIndex.length;i++){
            int firstHead = zeroIndex[i];
            int zeroNums = 0;
            if(i != 0 && zeroIndex[i] == 0)
                break;
            for(int j=i;j<zeroIndex.length;j++){
                int secondHead = zeroIndex[j];
                zeroNums++;
                if(secondHead - firstHead+1-zeroNums > k || (j != 0 && zeroIndex[j] == 0)){
                    break;
                }
                scale++;
            }
        }
        return scale;
    }

    //------------

    /**
     1668. 区间最小覆盖
     数轴上有 n 个区间. 现在需要在数轴上选取一些点, 使得任意一个区间内至少包含一个点.
     返回最少选取的点的数目.     */
    public int getAns(List<Interval> a) {
        a.sort(Comparator.comparingInt((Interval b) -> b.start));
        int result = 1;
        int right = a.get(0).end;
        for(int i = 1; i<=a.size()-1;++i){
            if(a.get(i).start<=right){
                right = Math.min(a.get(i).end,right);
            }else{
                result++;
                right = a.get(i).end;
            }
        }
        return result;
    }
    //-----------------------

    /**
     61. 搜索区间
     中文English
     给定一个包含 n 个整数的排序数组，找出给定目标值 target 的起始和结束位置。
     */
    public int[] searchRange(int[] A, int target) {
        int[] failArr = {-1,-1};

        if(A.length == 0 || A[0] >target || A[A.length-1]<target){
            return failArr;
        }
        int originIndex = binarySearch(A,target,0,A.length-1);
        int left = originIndex;
        int right = left;
        while(left>0 && A[left-1] == target)
            left--;
        while(right<A.length-1 && A[right+1] == target)
            right++;
        int[] resultArr = {left,right};
        return resultArr;

    }
    public int binarySearch(int[] A,int target,int start,int end){
        if( A[end] < target|| (start == end) && A[end] != target){
            return -1;
        }
        int mid = (start+end)/2;
        if(A[(start+end)/2]==target){
            return mid;
        }
        else if(A[(start+end)/2]<target){
            return binarySearch(A,target,mid+1,end);
        }
        else{
            return binarySearch(A,target,start,mid-1);
        }
    }
    //-----------------




    public static void main(String[] args){
      List<Interval> list = new ArrayList<>();
      list.add(new Interval(1,5));
      list.add(new Interval(4,8));
      list.add(new Interval(10,12));
      int[] atk = {1};
      Solution engine = new Solution();
      engine.searchRange(atk,1);
      int[] testBS = {1,2,3,4,5,6,7,8,9};
        System.out.println(engine.binarySearch(testBS,1,0,8));
    }

}