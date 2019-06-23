package com.cyd.leecode.module1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Question350 {
    /**
     * 通过遍历第二个数组 时对 map 匹配到 的数组 的频次 -1 如果减到 0  就删除掉他
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums1){
            Integer integer = map.get(num);
            if(integer == null){
                map.put(num,1);
            }else {
                map.put(num,integer+1);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int num : nums2){
            Integer integer = map.get(num);
            if(integer != null){
                list.add(num);
                if(integer -1 == 0){
                    map.remove(num);
                }else {
                    map.put(num,integer-1);
                }

            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < res.length;i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
