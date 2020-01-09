package com.unisound.algorithm.hashset;

import java.util.HashMap;
import java.util.Map;

public class TwoSum
{

    public int[] twoSum(int[] arr, int target)
    {
        Map<Integer, Integer> tmp = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            int substract = target - arr[i];
            if (tmp.containsKey(substract)) {
                return new int[] {tmp.get(substract), i};
            }
            tmp.put(arr[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");

    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
