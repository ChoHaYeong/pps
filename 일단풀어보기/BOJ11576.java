package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ11576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        
        int num = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++)
            num += Integer.parseInt(st.nextToken()) * Math.pow(A, m-(i+1));

        List<Integer> list = new ArrayList<>();
        while(num != 0) {
            list.add(num % B);
            num /= B;
        }

        for(int i=list.size()-1; i>=0; i--)
            System.out.print(list.get(i) + " ");
    }    
}
