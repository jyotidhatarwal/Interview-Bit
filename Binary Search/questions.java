/*    ALLOCATE BOOKS  */

public class Solution {
    public int books(ArrayList<Integer> A, int B) {
        int max = Integer.MIN_VALUE;
        int sum =0;
        for(int i=0;i<A.size();i++){
            sum += A.get(i);
            max = Math.max(max,A.get(i));
        }
        int low =max;
        int hi = sum;
        int ans =0;
        if(B > A.size()){
            return -1;
        }
        while(low <= hi){
            int mid = low + (hi - low)/2;
            if(isPossible(A,mid,B)== true){
                ans = mid;
                hi = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    private boolean isPossible(ArrayList<Integer>A,int mid,int B){
        int student=1;
        int sum =0;
        for(int i=0;i<A.size();i++){
            sum += A.get(i);
            if(sum > mid){
                student++;
                sum = A.get(i);
            }
        }
        if(student <= B){
            return true;
        }
        return false;
    }
}
