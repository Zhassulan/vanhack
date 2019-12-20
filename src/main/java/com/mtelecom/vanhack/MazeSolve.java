package com.mtelecom.vanhack;

import java.util.*;

public class MazeSolve {

    private int n;
    private int[][] a;

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int[][] getA() {
        return a;
    }

    public void setA(int[][] a) {
        this.a = a;
    }

    private class CELL {
        public static final int FREE = 0;
        public static final int BOCKED = 1;
        public static final int GOLD = 2;
        public static final int SOL = 3;
    }

    private void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%5d ", a[i][j]);
            }
            System.out.println();
        }
    }

    private int[][] convert(List<List<Integer>> listArr) {
        int[][] arr = new int[listArr.size()][];
        for (int i = 0; i < listArr.size(); i++) {
            List<Integer> aList = listArr.get(i);
            Integer arrInt[] = aList.toArray(new Integer[aList.size()]);
            for (int j = 0; j < arrInt.length; j++)
                arr[i][j] = arrInt[j].intValue();
        }
        return arr;
    }


    public int minMoves(List<List<Integer>> maze, int x, int y) {
        a = convert(maze);
        print();
        return 0;
    }

}
