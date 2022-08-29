package 일단풀어보기;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class BOJ1676 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BigInteger[] D = new BigInteger[N+1];
        D[0] = new BigInteger(Integer.toString(1));
        for(int i=1; i<=N; i++)
            D[i] =  D[i-1].multiply(new BigInteger(Integer.toString(i)));

        StringBuilder sb = new StringBuilder(D[N].toString());
        System.out.println(sb);
        sb = sb.reverse();

        int cnt = 0;
        while(sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
            cnt++;
        }

        // int num = D[N];
        // int cnt = 0;
        // while(num % 10 == 0){
        //     cnt++;
        //     num /= 10;
        // }
        System.out.println(cnt);
    }
    
}