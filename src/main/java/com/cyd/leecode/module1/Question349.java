package com.cyd.leecode.module1;

import java.util.*;

public class Question349 {

    public static void main(String[] args) {
        Question349 question349 = new Question349();
        int[] nums1 = {1,2,2,1}, nums2 = {2,2};
        System.out.println(question349.intersection(nums1,nums2));
    }
    // 利用map 能存 当前数组存了几次 来确定交集
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i< nums1.length;i++){
            Integer integer = map.get(nums1[i]);
            if(integer == null){
                map.put(nums1[i],1);
            }
        }
        for(int i = 0;i< nums2.length;i++){
            Integer integer = map.get(nums2[i]);
            if(integer != null){
                map.put(nums2[i],integer + 1);
            }
        }
        int[] arr = new int[map.size()];

       int i = 0;
        for(Integer integer : map.keySet()){
            Integer integer1 = map.get(integer);
            if(integer1 != 1){
                arr[i] = integer;
                i++;
            }
        }
        int[] arr2 = new int[i];
        for(int j = 0; j < i; j++){
            arr2[j] = arr[j];
        }
        return arr2;
    }


    public int[] intersection2(int[] nums1, int[] nums2) {
       Set<Integer> set = new HashSet<>();
       for(int i = 0; i < nums1.length; i++){
           set.add(nums1[i]);
       }
       ArrayList<Integer> list = new ArrayList();
       for(int i = 0; i < nums2.length;i++){
           if(set.contains(nums2[i])){
               list.add(nums2[i]);
               set.remove(nums2[i]);
           }
       }
       int[] res = new int[list.size()];
       for(int i = 0; i < res.length;i++){
           res[i] = list.get(i);
       }
       return res;
    }
    public int[] intersection3(int[] nums1, int[] nums2) {
        return Arrays.stream(nums1).filter(x ->  Arrays.stream(nums2).anyMatch(x2 -> x==x2)).distinct().toArray();
    }

}
