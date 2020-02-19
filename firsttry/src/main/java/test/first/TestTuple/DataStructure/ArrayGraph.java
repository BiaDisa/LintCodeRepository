package test.first.TestTuple.DataStructure;

import test.first.TestTuple.annotation.recursive;
import test.first.TestTuple.annotation.unfinished;
import test.first.TestTuple.annotation.unrecursive;

import java.util.Stack;

public class ArrayGraph {

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }



    @unrecursive
    public static void DFSNotRe(int[][] graph) {
        int x = graph.length, y = graph[0].length;
        System.out.println();
        boolean[][] dic = new boolean[x][y];
        Stack<Node> s = new Stack();
        s.push(new Node(0, 0));
        dic[0][0] = true;
        int[][] direction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while (!s.isEmpty()) {
            Node wrk = s.pop();
            System.out.print(graph[wrk.x][wrk.y]+" ");
            for (int i = 0; i < 3; i++) {
                if (wrk.x + direction[i][0] <= x-1 && wrk.x + direction[i][0] >= 0
                        && wrk.y + direction[i][1] <= y-1 && wrk.y + direction[i][1] >= 0) {
                    if (!dic[wrk.x + direction[i][0]][wrk.y + direction[i][1]]){
                        dic[wrk.x + direction[i][0]][wrk.y + direction[i][1]] = true;
                        s.push(new Node(wrk.x + direction[i][0],wrk.y + direction[i][1]));
                        break;
                    }
                }
            }
        }
    }

    @recursive
    public static void DFSRecuriedMain(int[][] graph) {
        boolean[][] dic = new boolean[graph.length][graph[0].length];
        DFSRecuriedTurple(graph, dic, 0, 0);
    }

    public static void DFSRecuriedTurple(int[][] graph, boolean[][] dic, int x, int y) {
        int[][] direction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int maxX = graph.length-1,maxY = graph[0].length-1;
        dic[x][y] = true;
        System.out.print(graph[x][y] + " ");
        for (int i = 0; i < 3; i++) {
            if (x + direction[i][0] <= maxX && x + direction[i][0] >= 0
                    && y + direction[i][1] <= maxY && y + direction[i][1] >= 0) {
                if (!dic[x + direction[i][0]][y + direction[i][1]]) {
                    DFSRecuriedTurple(graph, dic, x + direction[i][0], y + direction[i][1]);
                }
            }
        }
    }

    public static void main(String[] args){
        int[][] testTurple = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        DFSRecuriedMain(testTurple);
        DFSNotRe(testTurple);
    }
}
