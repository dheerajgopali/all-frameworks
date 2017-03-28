package com.dheeraj.learning.datastructures.recursive;

import com.dheeraj.learning.utilities.ListUtility;
import com.dheeraj.learning.utilities.comparator.ListOfInteger;

import java.util.*;

/**
 * Created by dgopali on 10/30/2015.
 */
public class GenerateAllSubset {

    ArrayList<ArrayList<Integer>> res;
    ArrayList<Integer> A;
    int N;

    public static void main(String[] args) {
        GenerateAllSubset gas = new GenerateAllSubset();
        ArrayList<ArrayList<Integer>> list = gas.subsets(new ArrayList<Integer>(ListUtility.buildList("1,2,3")));
        System.out.println(list);
    }

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<Integer> temp;
        res = new ArrayList<ArrayList<Integer>>();
        temp = new ArrayList<Integer>();
        this.A = A;
        N = A.size();
        Collections.sort(A);

        subset(0, temp);

        Collections.sort(res, new ListOfInteger());

        return res;

    }

    private void subset(int index, ArrayList<Integer> arr) {

        if (index == N) {
            res.add(new ArrayList<Integer>(arr));
            return;
        }

        subset(index + 1, arr);
        arr.add(A.get(index));
        subset(index + 1, arr);
        arr.remove(arr.size() - 1);

    }


    public ArrayList<ArrayList<Integer>> subsets2(ArrayList<Integer> S) {
        ArrayList<ArrayList<Integer>> list = subsetsRecursive(S);
        Collections.sort(list, new Comparator<List<Integer>>() {
            public int compare(List<Integer> o1, List<Integer> o2) {
                int len1 = o1.size();
                int len2 = o2.size();
                if(len1==0)
                    return -11;
                if(len2 == 0)
                    return 1;
                if(len1>len2){
                    for(int i=0;i<len2;i++){
                        if(o1.get(i).equals(o2.get(i)))
                            continue;
                        else if (o1.get(i) > o2.get(i))
                            return 1;
                        else
                            return -1;
                    }
                    return 1;
                }else if(len1 <  len2){
                    for(int i=0;i<len1;i++){
                        if(o1.get(i).equals(o2.get(i)))
                            continue;
                        else if (o1.get(i) > o2.get(i))
                            return 1;
                        else
                            return -1;
                    }
                    return -1;
                }else{
                    for(int i=0;i<len1;i++){
                        if(o1.get(i).equals(o2.get(i)))
                            continue;
                        else if (o1.get(i) > o2.get(i))
                            return 1;
                        else
                            return -1;
                    }
                    return -1;
                }
            }
        });
        return list;
    }

    public ArrayList<ArrayList<Integer>> subsetsRecursive(ArrayList<Integer> S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(S.size() == 0){
            res.add(new ArrayList<Integer>());
            return res;
        }
        Collections.sort(S);
        int head = S.get(0);
        ArrayList<Integer> rest = new ArrayList<Integer>();
        for(int i=1;i<S.size();i++){
            rest.add(S.get(i));
        }
        for(ArrayList<Integer> list : subsetsRecursive(rest)){
            ArrayList<Integer> newList = new ArrayList<Integer>();
            newList.add(head);
            newList.addAll(list);
            res.add(list);
            res.add(newList);
        }
        return res;
    }

/*    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {

    }*/
}
