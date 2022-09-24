package simulation;

import java.io.*;
import java.util.*;

public class BOJ16235 {
    static int N, M, K;
    static int[][] feed, A; //r,c 칸의 양분을 나타냄
    static ArrayList<Tree>[][] arr, n_arr;
    static class Tree implements Comparable<Tree>{
        int year;
        boolean live;

        Tree(int year, boolean live) {

            this.year = year;
            this.live = live;
        }

        @Override
        public int compareTo(Tree o) {
            if(Integer.compare(this.year, o.year) < 0 ) return -1;
            else if(Integer.compare(this.year, o.year) > 0 ) return 1;
            return 0;
        }


    }
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        feed = new int[N][N];
        A = new int[N][N];
        arr = new ArrayList[N][N];

        n_arr = new ArrayList[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                feed[i][j] = 5; //가장 처음에 양분은 모든 칸에 5만큼 들어있다.
                A[i][j] = Integer.parseInt(st.nextToken());
                arr[i][j] = new ArrayList<Tree>();
                n_arr[i][j] = new ArrayList<Tree>();
            }
        }

        for(int i=0; i<M; i++) {

            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken()) -1;
            int year = Integer.parseInt(st.nextToken());

            arr[r][c].add(new Tree(year, true));
        }

        for(int l=0; l<K; l++) {

            spring();
            summer();
            fall();
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if( n_arr[i][j].size() > 0) {

                       // System.out.println("size " + n_arr[i][j].size());
                        for(Tree k : n_arr[i][j]){
                           // System.out.println(k.year + " , " + k.live);
                            arr[i][j].add(k);
                        }
                    }
                }
            }

            n_arr = new ArrayList[N][N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++) {
                    n_arr[i][j] = new ArrayList<Tree>();
                }
            }
            winter();
        }

        int sum =0 ;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
               // for(Tree l : arr[i][j])
                    //System.out.println(l.live + " / " + l.year);
                sum += arr[i][j].size() ;
            }
        }
                //sum += arr[i][j].size() ;

        System.out.println(sum);
    }

    static void spring() {
        //나무들 나이순으로 정렬
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {

                Collections.sort(arr[i][j], new Comparator<Tree>() {

                @Override
                public int compare(Tree o1, Tree o2) {
                    // TODO Auto-generated method stub
                    if(Integer.compare(o1.year, o2.year) < 0) return -1;
                    else if(Integer.compare(o1.year, o2.year) > 0) return 1;
                    else return 0; 
                }
        
            });
            }

        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {

                if(arr[i][j].size() > 0) {
                    for(Tree l : arr[i][j]) {
                        if(feed[i][j] >= l.year) {

                           // System.out.println("원래 양분 " + feed[i][j] + " 나이 " + l.year + " ( " + i + " , " + j + " )");

                            feed[i][j] -= l.year; //나무가 나이만큼 양분을 ㅁ거음
                            l.year++; //나이 1 증가
                          //  System.out.println("남은 양분 " + feed[i][j] + " 나이 " + l.year+ " ( " + i + " , " + j + " )");
                        } else {
                            l.live = false; //양분을 먹지 못하면 즉시 죽음
                        }
                    }
                }

            }
        }

    }

    static void summer() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {

                if(arr[i][j].size() > 0) { //Tree l : arr[i][j
                    for(int k=arr[i][j].size()-1; k>=0; k--) {
                        if(arr[i][j].get(k).live == false) { //죽은 나무가 양분이 됨
                            feed[i][j] += arr[i][j].get(k).year/2;
                           // System.out.println("전 " + arr[i][j].size());
                            arr[i][j].remove(arr[i][j].get(k)); //죽은 나무는 나무리스트에서 지우기

                           // System.out.println("후 " + arr[i][j].size());
                        }
                    }
                }

            }
        }
    }

    static void fall() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {

                if(arr[i][j].size() > 0 ) {

                    for(Tree l : arr[i][j]) {
                        if(l.year % 5 ==0) {
                            for(int k=0; k<8; k++) {
                                int nx = i + dx[k];
                                int ny = j + dy[k];
        
                                if(nx >=0 && nx <N && ny>=0 && ny < N) n_arr[nx][ny].add(new Tree(1, true));
                            }
                        }
                    }

                    

                }

            }
        }
    }

    static void winter() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                feed[i][j] += A[i][j];
            }
        }
    }
}
