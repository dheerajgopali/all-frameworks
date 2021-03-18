package com.dheeraj.learning.datastructures.array;

import com.dheeraj.learning.utilities.ListUtility;

import java.util.*;

/**
 * Created by dgopali on 10/23/2015.
 */
public class ArrayThreeSum {
    public static void main(String[] args) {
        ArrayThreeSum ats = new ArrayThreeSum();
        //List<Integer> list = ListUtility.buildList("1,-4,0,0,5,-5,1,0,-2,4,-4,1,-1,-4,3,4,-1,-1,-3");
        int[] nums = {-1,2,1,-4};
        System.out.println(ats.threeSumClosest(nums, 1));
        //System.out.println(ats.threeSumClosest(new ArrayList<Integer>(list), 6));
    }

    /**
     * https://leetcode.com/problems/3sum-closest/
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        int n=nums.length;
        Arrays.sort(nums);
        int closestDiff = Integer.MAX_VALUE;
        for(int i=0;i<n && closestDiff!=0;i++){
            for(int j=i+1;j<n-1;j++) {
                int complement = target - nums[i] - nums[j];
                int idx = binarySearch(nums, j+1, complement);
                int hi = idx >= 0 ? idx : ~idx;
                int lo = hi - 1;

                if(hi < n && Math.abs(complement-nums[hi]) < Math.abs(closestDiff))
                    closestDiff = complement-nums[hi];
                if(lo > j && Math.abs(complement-nums[lo]) < Math.abs(closestDiff))
                    closestDiff = complement-nums[lo];
            }
        }
        return target - closestDiff;
    }

    public int binarySearch(int[] nums, int start, int target) {
        int end=nums.length-1;
        while(start<end) {
            int mid=(start+end)/2;
            if(nums[mid] < target) {
                start = mid+1;
            } else if(nums[mid] > target) {
                end = mid-1;
            } else {
                return mid;
            }
        }
        return -(start+1); //+1 to handle when the insertion point is 0.
    }

    public int binarySearch2(int[] nums, int start, int target) {
        int end=nums.length-1;
        while(start<end) {
            int mid=(start+end+1)/2;
            if(nums[mid] < target) {
                start = mid;
            } else if(nums[mid] > target) {
                end = mid-1;
            } else {
                return mid;
            }
        }
        return start;
    }

    /**
     * 12th March 2021 - Solution from Leetcode - BASIC - 1
     * https://leetcode.com/problems/3sum/solution/
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        //Iterate over the pivot ele from 0 to n-2 ##TODO Check why needed to traverse till n
        //If curr ele is greater than zero, skip it. (As we are only traversing right, all the elements towards right will be greater and cant get zero sum)
        //If curr ele is same as previous ele, skip it.
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n && nums[i]<=0;i++) {
            if(i==0 || nums[i-1] != nums[i]) {
                twoSum(nums, i, res);
            }
        }

        return res;
    }

    public void twoSum(int[] nums, int i, List<List<Integer>> res) {
        int n = nums.length;
        int left = i+1;
        int right = n-1;
        while(left < right) {
            int sum = nums[i]+nums[left]+nums[right];
            if(sum < 0) {
                left++;
            } else if(sum > 0) {
                right--;
            } else {
                res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                left++;
                right--;
                while(left<right && nums[left+1]==nums[left]) {
                    left++;
                }
            }
        }
    }

    /**
     * 12th March 2021 - Solution from Leetcode - INTERMEDIATE
     * https://leetcode.com/problems/3sum/solution/
     * Here hashset is used to reduce number of checks.
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        //Iterate over the pivot ele from 0 to n-2 ##TODO Check why needed to traverse till n
        //If curr ele is greater than zero, skip it. (As we are only traversing right, all the elements towards right will be greater and cant get zero sum)
        //If curr ele is same as previous ele, skip it.
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n && nums[i]<=0;i++) {
            if(i==0 || nums[i-1] != nums[i]) {
                twoSum1(nums, i, res);
            }
        }

        return res;
    }

    public void twoSum1(int[] nums, int i, List<List<Integer>> res) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for(int j=i+1;j<n; j++) {
            int complement = -nums[i]-nums[j];
            if(set.contains(complement)) {
                res.add(Arrays.asList(nums[i],nums[j],complement));
                while(j+1<n && nums[j]==nums[j+1])
                    j++;
            }
            set.add(nums[j]);
        }
    }

    /**
     * 12th March 2021 - Solution from Leetcode - Without sorting
     * https://leetcode.com/problems/3sum/solution/
     * Uses a set to avoid duplicates. Earlier methods uses sorted list to avoid duplicates.
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSumWithoutSorting(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Set<Integer> dups = new HashSet<>();
        for (int i = 0; i < nums.length; ++i)
            if (dups.add(nums[i])) {
                Set<Integer> seen = new HashSet<>();
                for (int j = i + 1; j < nums.length; ++j) {
                    int complement = -nums[i] - nums[j];
                    if (seen.contains(complement)) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], complement);
                        Collections.sort(triplet);
                        res.add(triplet);
                    }
                    seen.add(nums[j]);
                }
            }
        return new ArrayList(res);
    }


    public ArrayList<ArrayList<Integer>> threeSumStandard(ArrayList<Integer> a) {
        /*HashSet<Integer> set = new HashSet<Integer>(array);
        ArrayList<Integer> a = new ArrayList<Integer>(set);*/
        Collections.sort(a);
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<a.size()-2;i++){
            int l=i+1;
            int r=a.size()-1;
            while(l<r){
                long sum = a.get(i)+a.get(l)+a.get(r);
                if(sum == 0 && i!=l && l!=r && r!=i){
                    ArrayList<Integer> row = new ArrayList<Integer>();
                    row.add(a.get(i));
                    row.add(a.get(l));
                    row.add(a.get(r));
                    if(!list.contains(row));
                        list.add(row);
                    l++;
                }else
                    if(sum < 0){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return list;
    }

    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> a) {
        Collections.sort(a);
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<a.size()-2;){
            int l=i+1;
            int r=a.size()-1;
            while(l<r){
                long sum = a.get(i)+a.get(l)+a.get(r);
                if(sum == 0 ){
                    if(i!=l && l!=r && r!=i){
                    ArrayList<Integer> row = new ArrayList<Integer>();
                    row.add(a.get(i));
                    row.add(a.get(l));
                    row.add(a.get(r));
                    list.add(row);
                    }
                    int ele = a.get(l);
                    while(a.get(l)==ele)
                        l++;
                }else if(sum < 0){
                    int ele = a.get(l);
                    while(a.get(l)==ele)
                        l++;
                }else {
                    int ele = a.get(r);
                    while(a.get(r)==ele)
                        r--;
                }
            }
            int ele = a.get(i);
            while(a.get(i)==ele)
                i++;
        }
        return list;
    }

    public int threeSumClosest(ArrayList<Integer> a, int target) {
        int minTarget = Integer.MIN_VALUE;
        boolean maxBool = false;
        int maxTarget = Integer.MAX_VALUE;
        boolean minBool = false;
        a = sort(a);
        for(int i=0;i<a.size()-2;i++){
            int l=i+1;
            int r=a.size()-1;
            while(l<r){
                int sum = a.get(i)+a.get(l)+a.get(r);
                if(sum > target && sum < maxTarget) {
                    maxTarget = sum;
                    maxBool=true;
                }
                if(sum < target && sum > minTarget) {
                    minTarget = sum;
                    minBool = true;
                }
                if(sum == target){
                    return sum;
                }else if(sum < target){
                    l++;
                }else{
                    r--;
                }
            }
        }
        if (maxBool && !minBool){
            return maxTarget;
        }else if(minBool && !maxBool){
            return minTarget;
        }else if(maxBool && minBool){
            int diff1 = target - maxTarget;
            int diff2 = target - minTarget;
            if(Math.abs(diff1) > Math.abs(diff2)){
                return minTarget;
            }else{
                return maxTarget;
            }
        }
        return  -1;
    }



    public ArrayList<Integer> sort(ArrayList<Integer> inputArr) {

        if (inputArr == null || inputArr.size() == 0) {
            return null;
        }
        int length = inputArr.size();
        ArrayList<Integer> outputArray = quickSort(0, length - 1, inputArr);
        return outputArray;
    }

    private ArrayList<Integer> quickSort(int lowerIndex, int higherIndex, ArrayList<Integer> array) {

        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = array.get(lowerIndex+(higherIndex-lowerIndex)/2);
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (array.get(i) < pivot) {
                i++;
            }
            while (array.get(j) > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j, array);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(lowerIndex, j, array);
        if (i < higherIndex)
            quickSort(i, higherIndex, array);

        return array;
    }

    private void exchangeNumbers(int i, int j, ArrayList<Integer> array) {
        int temp = array.get(i);
        array.set(i,array.get(j));
        array.set(j,temp);
    }
}
