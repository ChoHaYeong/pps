package 바킹독_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1919 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alpha = new int[26];

        String str1 = br.readLine();
        for(int i=0; i<str1.length(); i++)
            alpha[str1.charAt(i)-97]++;
        
        String str2 = br.readLine();
        for(int i=0; i<str2.length(); i++)
            alpha[str2.charAt(i)-97]--;

        int count = 0;
        for(int a:alpha){
            while(a < 0){
                a++;
                count++;
            }

            while(a > 0) {
                a--;
                count++;
            }
        }

        System.out.println(count);
    }
    
}
