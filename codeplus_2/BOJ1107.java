package codeplus_2;

import java.io.*;
import java.util.*;

public class BOJ1107 {
    static int N, M;
    static int[] arr = new int[10];
    static int[] num;
    static int min = 1000000, sum =0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if(N == 100){
            System.out.println(0);
            return ;
        }

        num = new int[Integer.toString(N).length()];
        M = Integer.parseInt(br.readLine());

        for(int i=0; i<10; i++)
            arr[i] = i;
        // for(int i=0; i<10; i++) {
        //     System.out.print(i + " ");
        // }
        if(M != 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++) {
                arr[Integer.parseInt(st.nextToken())] = -1;
            }
        }

        for(int i=0; i<=999999; i++) {
            //고장난 수로 인해 바로 누르지 못하면 다음 수로 넘어가기
            //그게 아니라면 숫자의 길이와 |N-숫자| 더하기
            //최솟값 업뎃하기
            boolean flag = true;

            int count = 0;
            for(int j=0; j<Integer.toString(i).length(); j++) {
                //System.out.println(" i : " + i + " / " + arr[Integer.toString(i).charAt(j)-'0']);
                if(arr[Integer.toString(i).charAt(j)-'0'] == -1){
                    flag = false;
                    break;
                }
            }
            if(flag) {
                count = Integer.toString(i).length() + Math.abs(N-i);
                //System.out.println("count : " + count);
                if(min > count) {
                   // System.out.println("min : " + min + " count : " + count);
                    min = count;
                }
            }
            // if(min > count) {
            //     System.out.println("min : " + min + " count : " + count);
            //     min = count;
            // }
        }

        
        
        // else{
        //     func(0);
        //     if(Math.abs(100-N) < Integer.toString(sum).length())
        //         System.out.println(Math.abs(100-N));
        //     else{
        //         System.out.println("len :  " + Integer.toString(sum).length() + " / " + sum);
        //         System.out.println("min:  " + min);
        //         System.out.println((Integer.toString(sum).length() + min));
        //     }
        // }
        //else 

        if(Math.abs(100-N) < min)
                System.out.println(Math.abs(100-N));
        else
            System.out.println(min);
    }

    // static void func(int curr) {
    //     if(curr == Integer.toString(N).length()) {
    //         sum = 0;
    //         for(int n: num) {
    //             sum = (sum * 10) + n;
    //         }

    //         int between = Math.abs(N-sum);
    //         if(min > between) {
    //             System.out.println("N " + N + " sum " + sum + " N-sum " + (N-sum));
    //             min = between;
    //         }

    //         return ;
    //     }

    //     for(int i=0; i<arr.length; i++){
    //         if(arr[i] != -1) { //고장난 버튼은 사용하지 않음
    //             num[curr] = arr[i];
    //             func(curr+1);
    //         }
    //     }

    // }


    
}
