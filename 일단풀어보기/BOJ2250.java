package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2250 {
    static int n, depth = 0, idx =0;
    static class Node {
        int val;
        Node left, right;
        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    static Node head = new Node(1, null, null);
    static int[] dist;
    static int[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dist = new int[n+1];
        Arrays.fill(dist, -1);
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int val = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            insert(head, val, l, r);

            
            
        }
        dist[0] = 0;
        idx = 0;
        inOrder(head, 0);
        arr = new int[depth][n];
        inOrder2(head, 0);
        System.out.println(depth + " ");
        for(int i=0; i<depth; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void insert(Node comp, int curr, int left, int right) {
        if(comp.val == curr) {
            if(left == -1) comp.left = null;
            else comp.left = new Node(left, null, null);

            if(right == -1) comp.right = null;
            else comp.right = new Node(right, null, null);
        }
        else {
            if(comp.left != null) insert(comp.left, curr, left, right);
            if(comp.right != null) insert(comp.right, curr, left, right);

        }
    }

    static void inOrder(Node node, int curr) {
        if(node == null) {depth = Math.max(depth, curr); return ; }
        inOrder(node.left, curr+1);
       
        inOrder(node.right, curr+1);
    }

    static void inOrder2(Node node, int curr) {
        if(node == null) return ;
        inOrder2(node.left, curr+1);
        arr[curr][idx] = node.val;
        idx++;
        inOrder2(node.right, curr+1);
        idx--;
    }
}
