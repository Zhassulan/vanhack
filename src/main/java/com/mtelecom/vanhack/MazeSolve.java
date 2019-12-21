package com.mtelecom.vanhack;

import java.util.*;

public class MazeSolve {

    private int[][] arr;
    private int cols;
    private int rows;

    public void setCols(int cols) {
        this.cols = cols;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    private class Node {

        int x, y, distance;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.distance = dist;
        }
    }

    public void print() {
        System.out.println();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%3d ", arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private void convert(List<List<Integer>> lstArr) {
        int[][] array = new int[lstArr.size()][];
        for (int i = 0; i < array.length; i++) {
            array[i] = new int[lstArr.get(i).size()];
        }
        for (int i = 0; i < lstArr.size(); i++) {
            for (int j = 0; j < lstArr.get(i).size(); j++) {
                array[i][j] = lstArr.get(i).get(j);
            }
        }
        arr = array;
        cols = arr.length;
        rows = arr[0].length;
    }

    private boolean isValid(int mat[][], boolean visited[][], int row, int col) {
        return ((row >= 0) && (row < rows)) && ((col >= 0) && (col < cols)) && (mat[row][col] == 1) && (!visited[row][col]);
    }

    public int bfs(int i, int j, int x, int y) {
        int row[] = {-1, 0, 0, 1};
        int col[] = {0, -1, 1, 0};
        boolean[][] visited = new boolean[rows][cols];
        Queue<Node> q = new LinkedList<Node>();
        visited[i][j] = true;
        q.add(new Node(i, j, 0));
        int minimum_distance = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Node node = q.poll();
            i = node.x;
            j = node.y;
            int dist = node.distance;
            if (i == x && j == y) {
                minimum_distance = dist;
                break;
            }
            for (int k = 0; k < 4; k++) {
                if (isValid(arr, visited, i + row[k], j + col[k])) {
                    visited[i + row[k]][j + col[k]] = true;
                    Node n = new Node(i + row[k], j + col[k], dist + 1);
                    q.add(n);
                }
            }
        }
        if (minimum_distance == Integer.MAX_VALUE) {
            System.out.print("Destination cannot be reached");
        } else {
            System.out.print("The shortest path has length " + minimum_distance);
        }
        return minimum_distance;
    }

    public static int minMoves(List<List<Integer>> maze, int x, int y) {
        MazeSolve mazeSolve = new MazeSolve();
        mazeSolve.convert(maze);
        return mazeSolve.bfs(0, 0, x, y);
    }

}
