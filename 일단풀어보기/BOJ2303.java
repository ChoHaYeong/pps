package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ2303 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] D = new int[N+1];
        int M = Integer.parseInt(br.readLine());

        List<Integer> list = new LinkedList<>();
        for(int i=0; i<M; i++)
            list.add(Integer.parseInt(br.readLine()));

       // System.out.println("size " + queue.size());
        D[1] = 1;
        //if(!queue.isEmpty() && queue.peek() == 1) queue.poll();
        for(int i=2; i<=N; i++) {
            //System.out.println("queue의 맨 위" + queue.peek());
           /* if(!queue.isEmpty() && i == queue.peek())*/  
            if(list.contains(i)){
               // System.out.println(queue.peek());
                D[i] = D[i-1];
                D[i+1] = D[i];
                i++;
                //queue.poll();
            }
            else if(i==2)
                D[i] = 2;
            else{
                D[i] = D[i-1] + D[i-2];
            }
           // System.out.println(i + ": "+ D[i]);
        }

        System.out.println(D[N]);
    }
}
