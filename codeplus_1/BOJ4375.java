package codeplus_1;

import java.io.*;
import java.util.*;

/**
 * 1 ~ 1로만 이루어진 n의 배수를 찾을 때까지 모든 수를 다 탐색함 => 시간이 진짜 왕창걸림
 * 애초에 1로만 이루어진 수들 중에서 n의 배수를 찾는다. (1, 11, 111, ...)
 * num = num * 10 + 1 을 반복한다.
 * 자료형으로 표시할 수 있는 범위를 넘어갈 수 있기 때문에
 * (num * 10 + 1 ) % n 이라는 것을 이용해서 계산한다. ==> 이게 왜인지 이해가 잘 안감.. 
 */

public class BOJ4375 {
    public static void main(String[] args) throws IOException{
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //   //  StringTokenizer st = new StringTokenizer(br.readLine());

    //  //   int n = 3;
    //     String str = "";
    //     while((str = br.readLine()) != null) {

    //         int idx = 1;
    //         boolean flag = true;
    //         int n = Integer.parseInt(str);

    //         while(true) {

    //            // System.out.println(" n : " + n);
    //             String str_num = Long.toString(n*idx);

    //             for(int i=0; i<str_num.length(); i++) {
    //                 if(str_num.charAt(i) != '1') {
    //                     flag = false;
    //                     break;
    //                 }
    //             }
    
    //             if(flag){
    //                 System.out.println(str_num.length());
    //                 break;
    //             }
    //             else {
    //                 flag = true;
    //                 idx++;
    //             }
    //         }
            
    //     }

    }
    
}
