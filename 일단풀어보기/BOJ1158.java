package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new LinkedList<>();

        for(int i=1; i<=N; i++) {
            queue.add(i);
        }

        int idx = 1;
        while(!queue.isEmpty()) {
            if(idx % K == 0) 
                list.add(queue.poll());
            else
                queue.add(queue.poll());
            idx++;
        }


        System.out.print("<");
        for(int i=0; i<list.size()-1; i++)
            System.out.print(list.get(i) + ", ");
        System.out.print(list.get(list.size()-1) + ">");
    }
    
}
