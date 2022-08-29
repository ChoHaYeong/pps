package 일단풀어보기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ6588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = -1;
        
        // for(int i=2; i<=Math.sqrt(1000000); i++) {
        //     for(int j=i*i; j<=1000000; j +=i){
        //         isPrime[j] = true; //이 숫자들은 소수가 아님
        //     }
        // }


        while((num = Integer.parseInt(br.readLine())) != 0) {
            // boolean[] isPrimeA = new boolean[1000001];
            // boolean[] isPrimeB = new boolean[1000001];
            // isPrimeA[0] = true;
            // isPrimeA[1] = true;

            // isPrimeB[0] = true;
            // isPrimeB[1] = true;


            int b = num-2;
            int a = 2;

            boolean isWrong = true;

            while(b >= a) {



                boolean stop = false;
                boolean flag = true;

                for(int i=2; i<=Math.sqrt(a); i++) { // 3
                    if(a % i == 0){ //a는 소수가 아닌거잖아
                        stop = true;
                        break;
                    }
                }

                if(!stop) { //a가 소수가 아닐 때 
                    for(int i=2; i<=Math.sqrt(b); i++) { //5
                        if(b % i == 0){ // b가 소수가 아닌거잖아
                         //  System.out.println(b + " /"  +i);
                            flag = false;
                          //  break;
                        }
                    }
                    if(flag){ //a랑 b가 둘다 소수야 
                        bw.write(num + " = " + a + " + " + b + "\n");
                        isWrong = false;
                        break;
                    }

                }

                
                
                b--;
                a++;
               // System.out.println("a : " + a + " b " + b + " flag " + flag);
            }

            if(isWrong)
                bw.write(" Goldbach's conjecture is wrong.\n");


        }   

        bw.flush();
        bw.close();
    }

    // static void isPrime(int x) {
    //     for(int i=2; i<=Math.sqrt(x); i++) {
    //         if(x % i)
    //     }
    // }
    
}
