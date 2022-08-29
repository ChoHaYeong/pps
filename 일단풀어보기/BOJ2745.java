package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        long sum = 0;
        for(int i=0; i<N.length(); i++) {
            
            if(N.charAt(i) >= 65 && N.charAt(i) <= 90){
                sum += (int) (N.charAt(i) - 55) * Math.pow(B, N.length()-(i+1)); 
               // System.out.println("1. sum " + sum);
            }
            else{
              //  System.out.println("sum " + sum);
                sum += (N.charAt(i) - '0') * Math.pow(B, N.length()-(i+1)); 
              //  System.out.println("2. sum " + sum + " 더해진 것 " + i + " 번째 수 "  + (N.charAt(i) - '0') + " , "  + Math.pow(B, N.length()-(i+1))) ;
            }
        }

        System.out.println(sum);
    }
}
