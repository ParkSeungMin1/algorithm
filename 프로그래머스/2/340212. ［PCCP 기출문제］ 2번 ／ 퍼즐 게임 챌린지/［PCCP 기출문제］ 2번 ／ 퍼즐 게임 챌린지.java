class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = boundrySearch(diffs,times,limit);
        return answer;
    }
    public static int boundrySearch(int[] diffs, int[] times, long limit){
        int left = 1;
        int right = Integer.MAX_VALUE-5;
        int mid;
        int answer=0;
        for(;left<=right;){
            mid = (left + right +1) / 2;
            if(puzzle(diffs,times,limit,mid)){
                right = mid-1;
                answer = mid;
            }
            else{
                left = mid+1;
            }
        }
        return answer;
    }
    public static boolean puzzle(int[] diffs, int[] times, long limit,int level){
        long totalTime=0;
        for(int i=0;i<diffs.length;i++){
            if(diffs[i]<=level) totalTime+=times[i];
            else{
                totalTime += (times[i-1]+times[i])*(diffs[i]-level) + times[i];
            }
        }
        if(limit>=totalTime) return true;
        else return false;
    }
}