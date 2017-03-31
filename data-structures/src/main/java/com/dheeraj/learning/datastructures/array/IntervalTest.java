package com.dheeraj.learning.datastructures.array;

import java.util.ArrayList;

/**
 * Created by dgopali on 10/18/2015.
 */
public class IntervalTest {
    public static void main(String[] args) {
        IntervalTest it = new IntervalTest();
        ArrayList<Interval> list = new ArrayList<Interval>();
        list.add(new Interval(1,3));
        list.add(new Interval(6,9));
        /*list.add(new Interval(6,7));
        list.add(new Interval(8,10));
        list.add(new Interval(12, 16));
        */System.out.println(it.insert(list, new Interval(10, 8)));

    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        int start, end;
        int startIndex, endIndex;
        int i;

        start = newInterval.start;
        end = newInterval.end;
        i = 0;

        startIndex = endIndex = -1;

        for (Interval in : intervals) {

            if (start >= in.start && start <= in.end)
                startIndex = i;

            if (end >= in.start && end <= in.end)
                endIndex = i;

            i++;
        }

        if (startIndex == -1 && endIndex == -1) {

            startIndex = 0;

            for (i = 0; i < intervals.size(); i++) {
                if (start > intervals.get(i).end) {
                    startIndex = i + 1;
                }
            }

            endIndex = intervals.size() - 1;

            for (i = intervals.size() - 1; i >= 0 ; i--) {
                if (end < intervals.get(i).start) {
                    endIndex = i - 1;
                }
            }

            for (i = startIndex; i <= endIndex; i++) {
                intervals.remove(startIndex);
            }

            intervals.add(startIndex, newInterval);

            return intervals;
        }

        if (startIndex == -1) {
            for (i = intervals.size() - 1; i >= 0 ; i--) {
                if (start <= intervals.get(i).start)
                    startIndex = i;
            }
        }

        if (endIndex == -1) {
            for (i = 0; i < intervals.size(); i++) {
                if (end >= intervals.get(i).end)
                    endIndex = i;
            }
        }

        start = Math.min(intervals.get(startIndex).start, start);
        end = Math.max(intervals.get(endIndex).end, end);

        intervals.get(startIndex).start = start;
        intervals.get(startIndex).end = end;

        for (i = startIndex + 1; i <= endIndex; i++) {
            intervals.remove(startIndex + 1);
        }

        return intervals;

    }

    public ArrayList<Interval> insert2(ArrayList<Interval> intervals, Interval newInterval) {
        boolean iDone=false;
        int indexi=0;
        int indexj=0;
        for(int i=0;i<intervals.size();i++){
            if(Math.max(intervals.get(i).start,newInterval.start)<=Math.min(intervals.get(i).end,newInterval.end)){
                if(!iDone){
                    indexi=i;
                    indexj=i;
                    iDone=true;
                }else{
                    indexj=i;
                }
            }
        }

        ArrayList<Interval> list = new ArrayList<Interval>();
        for(int i=0;i<intervals.size();i++){
            if(indexi==i&&indexj==i){
                int start = Math.min(intervals.get(i).start,newInterval.start);
                int end = Math.max(intervals.get(i).end,newInterval.end);
                list.add(new Interval(start, end));
                //min(interval[i].start, newInterval.start), max(interval[j].end, newInterval.end)
            }else{
                if(indexi==i){
                    int start=Math.min(intervals.get(i).start,newInterval.start);
                    while(indexj!=i){
                        i++;
                    }
                    int end=Math.max(intervals.get(i).end,newInterval.end);
                    list.add(new Interval(start, end));
                }else{
                    list.add(intervals.get(i));
                }

            }
        }
        return list;
    }
}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }

    @Override
    public String toString() {
        return "["+start + "," + end+"]";

    }
}