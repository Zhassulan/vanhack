package com.mtelecom.vanhack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MazeTest {

    public static <T> List<T> asList(T ... items) {
        List<T> list = new ArrayList<T>();
        for (T item : items) {
            list.add(item);
        }
        return list;
    }

    @Test
    public void maze0() {
        List<List<Integer>> maze = asList(
                asList(0,2,0),
                asList(0,0,1),
                asList(1,1,1)
                );
        MazeSolve mazeSolve = new MazeSolve();
        System.out.println(" - " + mazeSolve.minMoves(maze, 2, 2));
    }

}
