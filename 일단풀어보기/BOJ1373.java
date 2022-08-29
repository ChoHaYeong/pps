package 일단풀어보기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ1373 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String binaryNum = br.readLine();
        BigInteger num10 = new BigInteger(binaryNum, 2); //2진수 -> 10진수
        String num8 = num10.toString(8); //10진수 ->

        System.out.println(num8);
    }   
}
 //숫자의 자리수가  1,000,000을 넘지 않는 다는 것, int의 범위를 넘어갈 수 있다는 것 아닌가 ..