package codeplus_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17427 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int sum =0;
        for(int i=1; i<=N; i++) {
            sum += (N / i) * i;
        }

        System.out.println(sum);
    }
    
}


/**
 * 숫자 N
 * 약수로 1을 가진 값이 몇개일까 N개
 * 약수로 2를 가진 값이 몇개일까 N/2개
 * 약수로 3를 가진 값이 몇개일까 N/3개
 * 약수로 4를 가진 값이 몇개일까 N/4개
 * 약수로 5를 가진 값이 몇개일까 N/5개
 * 
 */