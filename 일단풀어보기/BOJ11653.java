package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class BOJ11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //int 가능 - 1 ≤ N ≤ 10,000,000
        List<Integer> list = new ArrayList<>();

        int i= 2;
        while(N != 1) {
           // for(int i=2; i<=N; i++) {
                if(N % i == 0) {
                    list.add(i);
                    N /= i;
                    //System.out.println(N + " , size : " + list.size());
                    
                } else {
                    i++;
                }
            //}
        }
        

        Collections.sort(list);
        for(int l: list)
            System.out.println(l);
    }
}
