package com.dheeraj.learning.datastructures.map;


import com.dheeraj.learning.datastructures.linkedlist.ListNode;
import com.dheeraj.learning.utilities.ListUtility;

import java.util.ArrayList;

/**
 * Created by dgopali on 11/17/2015.
 */
public class MergeKList {
    public static void main(String[] args) {
        MergeKList obj = new MergeKList();
        ArrayList<ListNode> list = new ArrayList<ListNode>();
        list.add(ListNode.create(ListUtility.buildList("1,10,20")));
        list.add(ListNode.create(ListUtility.buildList("4,11,13")));
        list.add(ListNode.create(ListUtility.buildList("3,8,9")));
        ListNode res = obj.mergeKLists(list);
        ListNode.display(res);
    }

    public ListNode mergeKLists(ArrayList<ListNode> a) {
        ListNode resNode = null;
        ListNode lastNode = null;
        while(true){
            if(a.size()==0)
                break;
            ListNode temp = findLeast(a);
            if(resNode == null){
                resNode = temp;
                lastNode = temp;
            }
            else{
                lastNode.next = temp;
                lastNode = temp;
            }
        }
        return resNode;
    }

    public ListNode findLeast(ArrayList<ListNode> list){
        int minIndex = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<list.size();i++){
            if(min > list.get(i).val){
                min = list.get(i).val;
                minIndex = i;
            }
        }
        ListNode minimum = list.get(minIndex);
        list.set(minIndex,minimum.next);
        if(minimum.next == null)
            removeNullNodes(list, minIndex);
        return minimum;
    }

    public void removeNullNodes(ArrayList<ListNode> list, int minIndex){
        for(int i=minIndex+1;i<list.size()-1;i++){
            list.set(i,list.get(i+1));
        }
        list.remove(list.size()-1);
    }
}