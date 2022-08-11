package codeplus_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9095 {
    static int N , method = 0;
    static int[] arr = {1, 2, 3};
    static boolean[] visited = new boolean[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            N = Integer.parseInt(br.readLine());
            func(0, 0);
            System.out.println(method);
            method = 0;
        }

    }

    static void func(int curr, int sum) {
        if(sum == N){
            method ++;
            return ;
        }
        if(sum > N)
            return ;
        for(int i=0; i<arr.length; i++) {
           // if(!visited[i]) {
           //     visited[i] = true;
                //System.out.println(sum + "sum : " + arr[i]);
            func(curr+1, sum+arr[i]);
            //    visited[i] = false;
            //}
        }
    }
    
}
