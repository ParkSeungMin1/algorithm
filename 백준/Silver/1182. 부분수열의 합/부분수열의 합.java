import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int [] arr;
    static int n,m,ret=0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        arr = new int[n];
        String[] s1 = br.readLine().split(" ");
        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(s1[i]);
        }
        Arrays.sort(arr);
        back(-1,0);
        sb.append(ret);
        System.out.println(sb);
    }

    public static void back(int preIndex,int sum){
        if(preIndex>=n) return;
        if(sum == m && preIndex!=-1){
            ret++;
        }
        for(int i=preIndex+1;i<n;i++){
            back(i,sum+arr[i]);
        }
    }
}