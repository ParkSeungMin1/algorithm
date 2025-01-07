import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        int a = Integer.parseInt(s);
        int ret = 0;
        for(int i=1;i<=a;i++){
            ret += i;
        }

        sb.append(ret);
        System.out.println(sb.toString());
    }
}