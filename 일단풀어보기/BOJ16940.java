package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16940 {
    static int N, idx = 1;
    static ArrayList< ArrayList<Integer> > list = new ArrayList<ArrayList<Integer>>();
    static int[] order, result;
    //static Queue<Integer> queue2 = new LinkedList<>();
    static Queue<Integer> queue = new LinkedList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N+1; i++) {
            list.add(new ArrayList<>());
        }
        order = new int[N+1]; // 1~ N
        result = new int[N+1]; // 1~N
        visited = new boolean[N+1];

        for(int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        StringTokenizer st = new StringTokenizer(br.readLine()); 
        for(int i=1; i<=N; i++) {
            int num = Integer.parseInt(st.nextToken());
            order[num] = i; // order[i] : 숫자 i의 순서 order[1] = 1 1은 첫번째 order[2] = 3 2는 3번째 
            //queue2.add(num);
        }   

        if(order[1] != 1) {
            System.out.println(0);
            return ;
        }
        
        for(int i=1; i<=N; i++) {
            Collections.sort(list.get(i), new Comparator<Integer>() {

                @Override
                public int compare(Integer o1, Integer o2) {
                    // TODO Auto-generated method stub
                    if(Integer.compare(order[o1], order[o2]) < 0) return -1;
                    else if(Integer.compare(order[o1], order[o2]) > 0) return 1;
                    else return 0; 
                }
        
            });
        }

        queue.add(1);
        visited[1] = true;
       // System.out.println("size : " + queue2.size());
        //queue2.poll();
        bfs();

        boolean flag = true;
        for(int i=1; i<=N; i++) {
            //System.out.println(result[i] + " " + order[i]);
            if(result[i] != order[i]){
                System.out.println(0);
                flag = false;
                break;
            }
        }

        if(flag)
            System.out.println(1);

    }

    static void bfs() {
       // System.out.println("ㅁㅓ임...");
        while(!queue.isEmpty()) {
            int out = queue.poll();
             result[idx] = out;
             idx++;

            for(int l : list.get(out)) {
                if(!visited[l] ) {
                    queue.add(l);
                  //  queue2.poll();
                    visited[l] = true;
                }
            }
        }

        // if(queue2.isEmpty())
        //     System.out.println(1);
        // else
        //     System.out.println(0);
        

    }
    
}
