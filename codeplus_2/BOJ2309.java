package codeplus_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2309 {
    static int[] height = new int[9];
    static int[] arr = new int[7];
    static boolean[] visited = new boolean[9];
    static boolean flag = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<9; i++){
            height[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(height);
        func(0);

    }

    static void func(int curr) {
        if(curr == 7) {
            int sum = 0;
            for(int a: arr) {
                sum += a;
            }
            if(sum == 100 && flag){
               // Arrays.sort(arr);
               flag = false;
                for(int a: arr) {
                    System.out.println(a);
                }
                System.out.println("=====================");
            }

            return ;
        }

        for(int i=0; i<height.length; i++) {
            if(!visited[i] && (curr < 1 || arr[curr-1] < height[i])) {
                visited[i] = true;
                arr[curr] = height[i];
                func(curr+1);
                // System.out.println("?" + height[i]);
                visited[i] = false;
            }
        }
    }
    
}
