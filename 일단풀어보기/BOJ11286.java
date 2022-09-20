package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11286 {
    static int N, num;
    static class Arr implements Comparable<Arr> {
        int n;

        Arr(int n){
            this.n = n;
        }

        @Override
        public int compareTo(Arr o) {
            // TODO Auto-generated method stub
            //배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다. 절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.
            if(Integer.compare(Math.abs(this.n), Math.abs(o.n)) < 0 ) return -1;
            else if(Integer.compare(Math.abs(this.n), Math.abs(o.n)) > 0) return 1;
            else {
                if(Integer.compare(this.n, o.n) < 0 ) return -1;
                else if(Integer.compare(this.n, o.n) > 0) return 1;
            }
            return 0;
        }  
    }

    static PriorityQueue<Arr> queue = new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            num = Integer.parseInt(br.readLine());
            if(num == 0) {
                //배열에서 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다
                if(queue.size() == 0) System.out.println(0);
                else{
                    int n = queue.poll().n;
                    System.out.println(n);
                    //while(!queue.isEmpty() && queue.peek().n == n) queue.poll();
                }
            }
            else {
                queue.offer(new Arr(num));
            }
        }
    }
}
