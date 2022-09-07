package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.border.Border;

public class BOJ18808 {
    static int N, M, K, r, c;
    static List<int[][]> list = new LinkedList<>();
    static int[][] board, copy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        // board[0][0] = 1;
        // board[0][1] = 1;

        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            int[][] arr = new int[r][c];
            for(int j=0; j<r; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<c; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            list.add(arr);
        }

        for(int[][] l : list){
            // for(int i=0; i<r; i++) {
            //     for(int j=0; j<c; j++) {
            //         System.out.print(l[i][j] + " ");
            //     }
            //     System.out.println();
            // }

            stickerCnt(l);

            // System.out.println();
            // for(int i=0; i<N; i++) {
            //     for(int j=0; j<M; j++) {
            //         System.out.print(board[i][j]);
            //     }
            //     System.out.println();
            // }
        }

        int cnt = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(board[i][j] == 1)
                    cnt++;
            }
        }

        System.out.println(cnt);

        
    }

    static void stickerCnt(int[][] l) {
        // copy = new int[N][M];
        // for(int i=0; i<N; i++) {
        //     for(int j=0; j<M; j++) {
        //         copy[i][j] = board[i][j];
        //     }
        // }

        // else{ //회전시켜야함 ? 
                    
        //     rotate(); //90도 회전 => l은 파라미터로 넘겨지는 것이기 때문에 rotate된 값들이 반영되지 않음

        //     if(canAttatch( i, j)) {
        //         //System.out.println("붙일 수 있어 ?");
        //         return ;
        //     } 
        //     else{ //회전시켜야함 
                
        //         rotate(); //180도 회전
        //         if(canAttatch( i, j)) 
        //             return ;

        //         else {//회전시켜야함 
                    
        //             rotate(); //270도 회전
        //             if(i == N-1 && j == M-1)
        //                 return ;
        //         }   
                
        //     }

        // }

        copy = l;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(canAttatch(i, j)) {
                    return ;
                } 
            }
        }
        rotate(); //90도 회전
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(canAttatch(i, j)) {
                    return ;
                } 
            }
        }
        rotate(); //180도 회전
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(canAttatch(i, j)) {
                    return ;
                } 
            }
        }
        rotate(); //270도 회전
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(canAttatch(i, j)) {
                    return ;
                } 
            }
        }

        return ; //스티커를 붙이지 못함


        
    }


    static boolean canAttatch(int x, int y) {

        for(int i=0; i<copy.length; i++) { //스티커의 세로길이만큼
            for(int j=0; j<copy[i].length; j++) { //스티커의 가로길이만큼
                if(copy[i][j] == 1) { //스티커의 영역에서 
                    int nx = i+x; 
                    int ny = j+y; 
                    if(nx < 0 || ny < 0 || nx >= N || ny >= M) return false; //노트북을 벗어남
                    if(/*nx >= 0 && ny >=0 && nx<N && ny <M &&*/ board[nx][ny] != 0) return false; //다른 스티커와 겹침
                    //else board[i+x][j+y] = 1; //노트북 벗어나지도 않고, 다른 스티커와 겹치지도 않으면 스
                }
            }
        }


        for(int i=0; i<copy.length; i++) { 
            for(int j=0; j<copy[i].length; j++) { 
                if(copy[i][j] == 1) 
                    board[i+x][j+y] = 1; //스티커 붙일 수 있어서 보드에 스티커 붙임 
            }
        }
        return true;

        
    }

    static void rotate() {
       // System.out.println(copy[0].length + " , " + copy.length);
        int R = copy[0].length; //원래 스티커의 가로길이가 회전하면 세로길이가 된다.
        int C = copy.length; //원래 스티커의 세로길이가 회전하면 가로길이가 된다
        int[][] n_copy = new int[R][C];
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                //System.out.println("(" + (C-1-j) + " , " + i + ") : " +  l[C-1-j][i]);
                n_copy[i][j] = copy[C-1-j][i];
            }
        }

        //이전 배열을 새로운 배열로 업뎃.. 음..
        copy = new int[R][C];
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                copy[i][j] = n_copy[i][j];
            }
        }

        // for(int k=0; k<R; k++) {
        //     for(int m=0; m<C; m++) {
        //         System.out.print(copy[k][m]+" ");
        //     }
        //     System.out.println();
        // }

    }
}
