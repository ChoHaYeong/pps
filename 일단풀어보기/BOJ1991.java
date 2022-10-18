package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1991 {
    static int N;
    static class Node{
        char val;
        Node left;
        Node right;
        Node(char val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    static Node head = new Node('A', null, null);
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char curr = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            insert(head, curr, left, right);
        }

        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        postOrder(head);
    }

    static void insert(Node comp, char curr, char left, char right) {
        if(comp.val == curr) {
            if(left == '.') comp.left = null;
            else comp.left = new Node(left, null, null);

            if(right == '.') comp.right = null;
            else comp.right = new Node(right, null, null);
        }
        else {
            if(comp.left != null) insert(comp.left, curr, left, right);
            if(comp.right != null) insert(comp.right, curr, left, right);
        }
    }

    static void preOrder(Node head) {
        if(head == null) return ;
        System.out.print(head.val);
        preOrder(head.left);
        preOrder(head.right);
    }

    static void inOrder(Node head) {
        if(head == null) return ;
        inOrder(head.left);
        System.out.print(head.val);
        inOrder(head.right);
    }

    static void postOrder(Node head) {
        if(head == null) return ;
        postOrder(head.left);
        postOrder(head.right);
        System.out.print(head.val);
    }
}
