// package codeplus_2;

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;

// public class BOJ1748 {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int N = Integer.parseInt(br.readLine());
//         String str = "";

//         for(int i=1; i<=N; i++) {
//             str += Integer.toString(i);
//         }
//         System.out.println(str.length());
//     }
    
// }


package codeplus_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = "";

        int num = 10;
        int plus = 1;
        long leng = 0;
        for(int i=1; i<=N; i++) {
            if(i % num == 0) {
                plus ++;
                num *= 10;
            }
            leng += plus;
           // str += Integer.toString(i);
        }
        System.out.println(leng);
    }
    
}
