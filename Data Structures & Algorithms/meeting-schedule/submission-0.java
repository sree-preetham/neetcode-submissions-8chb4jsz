/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */
// import java.util.Comparator;
class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        // sort by end time
        // check each one - one after other
        intervals.sort(Comparator.comparingInt(interval -> interval.end));
        int prevEndTime = -1;
        for(Interval interval: intervals){
            int start = interval.start;
            if(start < prevEndTime) return false;
            prevEndTime = interval.end;
        }
        return true;
    }
}
