import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        BigInteger tmp1 = new BigInteger("1");
        BigInteger tmp2 = new BigInteger("1");
        BigInteger tmp3 = new BigInteger("1");

        tmp1 = fact(n);
        tmp2 = fact(n-m);
        tmp3 = fact(m);

        System.out.print(tmp1.divide(tmp2.multiply(tmp3)));
    }

    public static BigInteger fact(int a){
        BigInteger ret = new BigInteger("1");

        for(int i=1;i<=a;i++){
            ret = ret.multiply(new BigInteger(Integer.toString(i)));
        }

        return ret;
    }

}