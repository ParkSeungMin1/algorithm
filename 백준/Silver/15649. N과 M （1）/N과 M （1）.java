import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static boolean [] check = new boolean[9];
    static int n,m;
    static ArrayList<Integer> arr = new ArrayList<Integer>();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] s = bf.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        back();
        System.out.println(sb);
    }

    public static void back(){
        if(arr.size() == m ){
            for(Integer tmp : arr){
                sb.append(tmp).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1;i<=n;i++){
            if(!check[i]){
                check[i] = true;
                arr.add(i);
                back();
                arr.remove(arr.size()-1);
                check[i] = false;
            }
        }
    }
}