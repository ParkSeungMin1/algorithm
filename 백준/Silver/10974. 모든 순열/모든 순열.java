import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int n;
    static boolean[] check = new boolean[9];
    static int[] ret = new int[9];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        back(1);
        System.out.println(sb);
    }

    public static void back(int depth){
        if(depth>n){
            for(int i=1;i<=n;i++){
                sb.append(ret[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1;i<=n;i++){
            if(!check[i]){
                check[i] = true;
                ret[depth] = i;
                back(depth+1);
                ret[depth] = 0;
                check[i] = false;
            }
        }
    }
}