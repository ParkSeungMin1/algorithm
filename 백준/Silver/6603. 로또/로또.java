import java.io.*;
import java.util.ArrayList;
public class Main {
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> ret = new ArrayList<>();
    static int n;
    static Integer[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(;;){
            String[] s = br.readLine().split(" ");
            if(s[0].equals("0")) break;
            n = Integer.parseInt(s[0]);
            arr = new Integer[Integer.parseInt(s[0])];
            for(int i =1;i<s.length;i++){
                arr[i-1] = Integer.parseInt(s[i]);
            }
            back(-1);
            sb.append("\n");
        }
        System.out.print(sb);

    }
    public static void back(int preIndex){
        if(ret.size() == 6){
            for(int tmp : ret){
                sb.append(tmp).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=preIndex+1;i<n;i++){
            ret.add(arr[i]);
            back(i);
            ret.remove(ret.size()-1);
        }

    }
}