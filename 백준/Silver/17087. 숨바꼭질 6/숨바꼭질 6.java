import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]),x = Integer.parseInt(s[1]);
        s = br.readLine().split(" ");
        BigInteger ret = null;
        for(int i=0;i<n;i++){
            if(i==0) ret = new BigInteger(Integer.toString(Math.abs(x - Integer.parseInt(s[i]))));
            ret = ret.gcd(new BigInteger(Integer.toString(Math.abs(x - Integer.parseInt(s[i])))));
        }
        System.out.println(ret);

    }
}