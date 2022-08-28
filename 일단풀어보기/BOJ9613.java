package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9613 {
    static int[] arr;
    static int T;
    static long sum = 0;
    static boolean[] visited;
    static int[] pair = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T = Integer.parseInt(st.nextToken());
            arr = new int[T];
            visited = new boolean[T];

            for(int j=0; j<T; j++) 
                arr[j] = Integer.parseInt(st.nextToken());

            for(int j=0; j<T; j++) {
                for(int k=j; k<T; k++) {
                    if(j != k){
                      //  System.out.println(arr[j] + " " + arr[k] + " = > " + getGCD(arr[j], arr[k]));
                        sum += getGCD(arr[j], arr[k]);
                    }
                        
                }
            }

           // dfs(0);
            System.out.println(sum);
            sum = 0;
        }
    } 

    // static void dfs(int curr) {
    //     if(curr == 2) {
    //         int a = Math.max(pair[0], pair[1]);
    //         int b = Math.min(pair[0], pair[1]);
    //         //System.out.println(a + " , " +  b + " => " + getGCD(a, b));
    //         sum += getGCD(a, b);
    //         return ;
    //     }

    //     for(int i=0; i<T; i++) {
    //         if(!visited[i] && (curr == 0 || (curr >0 && pair[curr-1] <= arr[i]))) {
    //             visited[i] = true;
    //             pair[curr] = arr[i];
    //             dfs(curr+1);
    //             visited[i] = false;
    //         }
    //     }

    // }

    static int getGCD(int n1, int n2) {

        //System.out.println("n1 : " + n1 + " n2 " + n2 +  " / " + Math.max(n1, n2) + " ," + Math.min(n2, n2));
        int a = Math.max(n1, n2);

        int b = Math.min(n1, n2);

       
       // System.out.println("1. a " + a + " b " + b);

        int n = a % b;
       // System.out.println("2. n : " + n + " a " + a + " b " + b);
        if(n == 0) return b;
        else {
            a = b;
            b = n;
            return getGCD(a, b);
        }
    }
}
