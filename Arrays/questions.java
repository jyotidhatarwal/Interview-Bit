/*    Merge Intervals   */


/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> list = new ArrayList<>();
        int idx =0;
        for(Interval interval : intervals){
            if(interval.start < newInterval.start){
                list.add(interval);
            }else{
                break;
            }
        }
        
        if(list.size() == 0 || (newInterval.start > list.get(list.size()-1).end)){
            list.add(newInterval);
        }else{
            Interval prevInterval = list.get(list.size()-1);
            prevInterval.end = Math.max(prevInterval.end,newInterval.end);
        }
        
        while(idx < intervals.size()){
            Interval prevInterval = list.get(list.size()-1);
            if(prevInterval.end >= intervals.get(idx).start){
                // merging
                prevInterval.end = Math.max(prevInterval.end,intervals.get(idx).end);
            }else{
                list.add(intervals.get(idx));
            }
            idx++;
        }
        return list;
    }
}



/*    MERGE OVERLAPPING INTERVALS   */



/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals,(a,b)->{
            return a.start - b.start;
        });
        
        ArrayList<Interval> list = new ArrayList<>();
        for(Interval interval : intervals){
            if(list.size() == 0){
                list.add(interval);
            }else{
                Interval prevInterval = list.get(list.size()-1);
                if(interval.start <= prevInterval.end){
                    prevInterval.end = Math.max(prevInterval.end,interval.end);
                }else{
                    list.add(interval);
                }
            }
        }
        return list;
    }
}



/*    KTH ROW OF PASCAL'S TRIANGLE    */


public class Solution {
    public ArrayList<Integer> getRow(int A) {
        ArrayList<Integer> list = new ArrayList<>();
        int val =1;
        for(int i=0;i<=A;i++){
            list.add(val);
            long ans = (long)val*(long)(A-i)/(i+1);
            val = (int)ans;
        }
        return list;
    }
}

