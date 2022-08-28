package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        int max = 0, min = 0;

        //최대공약수
        for(int i=1; i<=Math.min(n1, n2); i++) {
            if(n1 % i == 0 && n2 % i ==0)
                max = i;
        }

        int idx = 1;
        while(true) {
            if(Math.max(n1, n2) * idx % Math.min(n1, n2) == 0){
                min = Math.max(n1, n2) * idx ;
                break;
            }
            idx++;
        }

        System.out.println(max + " " + min);
    }
}
