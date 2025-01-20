import java.io.*;
import java.util.*;

class Solution {
    int [][] sPoints;
    int [][] sRoutes;
    int sAnswer=0;
    ArrayList<ArrayDeque<Integer>> robotRoutes = new ArrayList<>();
    ArrayList<Pair<Integer,Integer>> robotCur = new ArrayList<>();
    
    class Pair<X,Y>{
        public X x;
        public Y y;
        
        public Pair(X x, Y y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] points, int[][] routes) {
        sPoints = points;
        sRoutes= routes;
        setting();
        bfs();
        return sAnswer;
    }
    public void setting(){
        for(int i=0;i<sRoutes.length;i++){
            ArrayDeque<Integer> tmp = new ArrayDeque<>();
            for(int j=0;j<sRoutes[i].length;j++){
                if(j==0){
                    robotCur.add(new Pair(sPoints[sRoutes[i][j]-1][0],sPoints[sRoutes[i][j]-1][1]));
                    continue;    
                }
                tmp.add(sRoutes[i][j]-1);
            }
            robotRoutes.add(tmp);
        }
    }
    public void checkCrash(){
        int [][] check = new int[101][101];
        for(Pair<Integer,Integer> tmp : robotCur) check[tmp.x][tmp.y]+=1;
        for(int i=1;i<=100;i++){
            for(int j=1;j<=100;j++){
                if(check[i][j]>1) {
                    sAnswer++;
                }
            }
        }
    }
    public void bfs(){
        int x=0,y=0,dx=0,dy=0,cnt=0,returnCnt=0;
        for(;;){
            checkCrash();
            for(int i=0;i<robotCur.size();i++){
                x = robotCur.get(i).x;
                y = robotCur.get(i).y;
                if(x==0 && y==0) continue;
                dx = sPoints[robotRoutes.get(i).peek()][0];
                dy = sPoints[robotRoutes.get(i).peek()][1];
                if(x == dx && y == dy){
                    robotRoutes.get(i).poll();
                    if(robotRoutes.get(i).isEmpty()) {
                        robotCur.get(i).x=0;
                        robotCur.get(i).y=0;
                        returnCnt+=1;
                    }
                    else{
                        dx = sPoints[robotRoutes.get(i).peek()][0];
                        dy = sPoints[robotRoutes.get(i).peek()][1];
                    }
                }
                
                if(x != dx){
                    if(dx>x) robotCur.get(i).x+=1;
                    else robotCur.get(i).x-=1;
                } 
                else if (y!= dy){
                    if(dy>y) robotCur.get(i).y+=1;
                    else robotCur.get(i).y-=1;
                }
                
                
            }
            if(returnCnt==robotCur.size()) break;
        }
    }

}