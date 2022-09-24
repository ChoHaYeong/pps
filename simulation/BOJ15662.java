package simulation;

import java.io.*;
import java.util.*;

public class BOJ15662 {
    static int T, K, num, dir;
    static int[][] arr; 
    static class Gear{
        int num, dir;
        Gear(int num, int dir) {
            this.num = num;
            this.dir = dir;
        }
    }
    static Queue<Gear> list = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        arr = new int[T][8]; //arr[i][j] i번째 톱니바퀴의 j번째 
        for(int i=0; i<T; i++) {
            String str = br.readLine();
            for(int j=0; j<8; j++)
                arr[i][j] = Integer.parseInt(Character.toString(str.charAt(j)));
        }
        
        K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list = new LinkedList<>();
            num = Integer.parseInt(st.nextToken())-1;
            dir = Integer.parseInt(st.nextToken());
            int n = num;
            int d = dir;
            list.add(new Gear(n, dir)); 
            
            if(n == 0) { //첫번째 톱니바퀴면 오른쪽만 확인
                while(n+1 < T && arr[n][2] != arr[n+1][6]) {
                    n++; 
                    dir = 0 - dir; 
                    list.add(new Gear(n, dir)); 
                }
            }
            else if(n == T-1) { //마지막 톱니바퀴면 왼쪽만 확인
                while(n >0 && arr[n][6] != arr[n-1][2]) {
                    n--; 
                    dir = 0 - dir; 
                    list.add(new Gear(n, dir)); 
                }
            } 
            else { //중간에 있는것이면 왼쪽오른쪽 다 확인
                //list.add(new Gear(n, dir)); //0 -1
                while(n+1 < T && arr[n][2] != arr[n+1][6]) {
                    n++; // 2
                    dir = 0 - dir; // -1
                    list.add(new Gear(n, dir)); // 1 1 2 -1
                }
                n = num;
                dir = d;
                while(n >0 && arr[n][6] != arr[n-1][2]) {
                    n--; // 2
                    dir = 0 - dir; // -1
                    list.add(new Gear(n, dir)); // 1 1 2 -1
                }

            }

            rotate();

            // System.out.println();
            // for(int k=0; k<T; k++) {
            //     for(int j=0; j<8; j++)
            //         System.out.print(arr[k][j]); 
            //     System.out.println();
            // }
        }
        int cnt = 0;
        for(int i=0; i<T; i++) {
           if(arr[i][0] == 1) cnt++;
        }
        System.out.println(cnt);
        

    }

    static void rotate() {
        while(!list.isEmpty()) {
            Gear out = list.poll();
            if(out.dir == -1) {
                int start = arr[out.num][0];
                for(int i=0; i<7; i++) {
                    arr[out.num][i] = arr[out.num][i+1];
                }
                arr[out.num][7] = start;
            }
            if(out.dir == 1) {
                int end = arr[out.num][7];
                for(int i=7; i>0; i--) {
                    arr[out.num][i] = arr[out.num][i-1];
                }
                arr[out.num][0] = end;
            }
        }
    }
}
