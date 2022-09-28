// package cp연습_BF;

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.LinkedList;
// import java.util.List;
// import java.util.StringTokenizer;

// public class BOJ1062 {
//     static int N, K;
//     static String[] strs;
//     static boolean[] alpha = new boolean[26];
//     static List<Character> c = new LinkedList<>();
//     public static void main(String[] args) throws IOException{
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());

//         N = Integer.parseInt(st.nextToken());
//         K = Integer.parseInt(st.nextToken());

//         if(K < 5) {
//             System.out.println(0);
//             return ;
//         }

//         for(int i=0; i<N; i++)
//             strs[i] = br.readLine();
        
//         alpha['a'-97] = true;
//         alpha['n'-97] = true;
//         alpha['t'-97] = true;
//         alpha['i'-97] = true;
//         alpha['c'-97] = true;

//         go(0);

//     }


//     static void go(int curr) {
//         if(curr == K-5) {
//             for(String str : strs) {
//                 for(Character cc :c ) {
//                     if(str.co)
//                 }
//             }
//         }

//         for(int i=0; i<26; i++) {
//             if(!alpha[i]) {
//                 alpha[i] = true;
//                 c.add((char) (i+97));
//                 go(curr+1);
//                 c.remove((char) (i+97));
//             }
//         }
//     }
// }
