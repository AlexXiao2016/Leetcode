package array;

import java.util.*;

/**
 * Created by xiaoping on 1/2/18.
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if(intervals.size() <= 0)   return res;

        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b){
                return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
            }
        });

        for(Interval interval : intervals){
            if(res.isEmpty() || res.get(res.size() - 1).end < interval.start){
                res.add(interval);
            }else{
                res.get(res.size() - 1).end = Math.max(res.get(res.size() - 1).end, interval.end);
            }
        }
        return res;
    }

    public static void main(String[] args){
        Interval a = new Interval(1, 3);
        Interval b = new Interval(2, 6);
        Interval c = new Interval(8, 10);
        Interval d = new Interval(15, 18);

        List<Interval> res = new ArrayList<>();
        res.add(a);
        res.add(b);
        res.add(c);
        res.add(d);

        MergeIntervals mi = new MergeIntervals();
        List<Interval> list = mi.merge(res);

        for(Interval i : list){
            System.out.println(i.start + " " + i.end);
        }

    }
}
