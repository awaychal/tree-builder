package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] inputArr = new int[4][2];
        inputArr[0][0] = 4;
        inputArr[0][1] = 5;
        inputArr[1][0] = 5;
        inputArr[1][1] = 3;
        inputArr[2][0] = 1;
        inputArr[2][1] = 5;
        inputArr[3][0] = 2;
        inputArr[3][1] = 1;
        System.out.println(Arrays.deepToString(inputArr));
        Node n = TreeBuilder.constructTree(inputArr);
        System.out.println(n.toString());
    }
}