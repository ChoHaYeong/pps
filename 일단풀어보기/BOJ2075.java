package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ2075 {
    static class Arr implements Comparable<Arr> {
        int n ;
        Arr(int n){
            this.n = n;
        }

        @Override
        public int compareTo(Arr o) {
            // TODO Auto-generated method stub
            if(Integer.compare(this.n, o.n) < 0) return 1;
            else if(Integer.compare(this.n, o.n) > 0) return -1;
            return 0;
        }
    }
    static PriorityQueue<Arr> queue = new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {    
                arr[i][j] = Integer.parseInt(st.nextToken());
                queue.add(new Arr(arr[i][j]));
            }
        }
        int cnt = 1;
        while(cnt < N && !queue.isEmpty()) {
            queue.poll();
            cnt++;
        }
        System.out.println(queue.peek().n);



    }
}
