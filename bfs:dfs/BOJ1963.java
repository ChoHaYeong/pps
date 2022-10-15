import java.util.*;
import java.io.*;

public class BOJ1963 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] prime = new boolean[10001];
        for(int i=2; i<=10000; i++) {
            if(!prime[i]) {
                for(int j=i*i; j<=10000; j+=i) 
                    prime[j] = true;
            }
        }

        for(int i=0; i<=10000; i++) 
            prime[i] = !prime[i];

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] dist = new int[10001];
            Arrays.fill(dist, -1);
            dist[n] = 0;

            Queue<Integer> queue = new LinkedList<>();
            queue.add(n);

            while(!queue.isEmpty()) {
                int out = queue.poll();

                for(int i=0; i<4; i++) {
                    for(int j=0; j<=9; j++) {
                        int next = change(out, i, j);

                        if(next != -1 && prime[next] && dist[next] == -1) {
                            queue.add(next);
                            dist[next] = dist[out] + 1;
                        }
                    }
                }
            }
            System.out.println(dist[m]);
        }
    }

    static int change(int num, int idx, int digit) { //num의 idx번째 숫자를 digit으로 바꾸기
        if(idx == 0 && digit == 0) {
            return -1;
        }

        String s = Integer.toString(num);
        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(idx, (char) (digit + '0'));
        return Integer.parseInt(sb.toString());
    }
}
