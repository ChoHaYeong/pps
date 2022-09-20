package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1629 {
    static int a, b ,c;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        long ans = multi(1, 0);
        System.out.println(ans);
    }

    static long multi(long sum, int curr) {
        if(curr == b) {
            return sum % c;
        }
        return multi((sum * a)%c, curr+1);
    }
}
