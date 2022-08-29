package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Integer.toString(3);
        String octalString = br.readLine();
        String[] arr = {"000", "001", "010", "011", "100", "101", "110", "111"};

        if(octalString.equals("0")){
            System.out.println(0);
            return ;
        }

        StringBuilder binaryString = new StringBuilder();
        for(int i=0; i<octalString.length(); i++) {
            int n = octalString.charAt(i) - '0' ;
            String miniString = "";
            //miniString += arr[n];
           // System.out.println("이번에 변환할 숫자 : " + n);
            if(n == 0)
                miniString += "000";
            while(n != 0) {
                miniString += n%2;
                n /= 2;
                //System.out.println(miniString);
            }
           // System.out.println(miniString);
            StringBuffer sb = new StringBuffer(miniString);
           
            if(sb.length() == 1) binaryString.append("00" + sb.reverse().toString()); // ("00" + sb.reverse().toString());
            else if(sb.length() == 2) binaryString.append("0" + sb.reverse().toString());
            else binaryString.append(sb.reverse().toString());
            //System.out.println(binaryString);

        }
        if (binaryString.charAt(0)=='0') binaryString.deleteCharAt(0);
        if (binaryString.charAt(0)=='0') binaryString.deleteCharAt(0);
        System.out.println(binaryString);
    }
    
}
