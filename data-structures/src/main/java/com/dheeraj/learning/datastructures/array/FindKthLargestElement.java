package com.dheeraj.learning.datastructures.array;

import java.util.*;

public class FindKthLargestElement {
    public static void main(String[] args) {
        FindKthLargestElement obj = new FindKthLargestElement();
        int[] nums={1,2,4,5,5};
        System.out.println(obj.findKthLargest(nums, 3));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; i++) {
            if (queue.isEmpty() || queue.size()<=k) {
                queue.add(nums[i]);
                if(queue.size()>k)
                    queue.poll();
            }
        }

        return queue.poll();
    }

    public int findKthLargest2(int[] nums, int k) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (list.isEmpty() || list.size()<k || (list.size() == k && list.get(list.size() - 1) < nums[i])) {
                addToList(list, nums[i]);
                if(list.size()>k)
                    list.remove(list.size()-1);
            }
        }

        return list.get(list.size() - 1);
    }

    public void addToList(List<Integer> list, int num) {
        int i;
        for (i = 0; i < list.size(); i++) {
            if (list.get(i) < num) {
                break;
            }
        }
        list.add(i, num);
    }

}
