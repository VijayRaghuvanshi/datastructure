package com.udemy.ds.hastable;

import java.util.*;

public class HashTableMain {


    public static void main(String[] arg){
      /*  int[] nums = {1, 2, 3, 2, 1, 4, 5, 4};
        List<Integer> duplicates = findDuplicates(nums);
        System.out.println(duplicates);*/
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 10)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 7)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 3)));
        System.out.println(Arrays.toString(twoSum(new int[]{}, 0)));

        /*
            EXPECTED OUTPUT:
            ----------------
            [0, 1]
            [1, 2]
            [0, 1]
            []
            [2, 3]
            [0, 1]
            []

        */

    }

    public static int longestConsecutiveSequence(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static List<int[]> findPairs(int[] arr1, int[] arr2, int target){

        Set<Integer> arr2Set = new HashSet<>();
        for (Integer i: arr2 ) {
            arr2Set.add(i);
        }
        int sec = 0;
        List<int[]> pairs = new ArrayList<>();
        for (Integer i: arr1 ) {
             sec = target-i;
            if( arr2Set.contains(sec)){
                pairs.add(new int[]{i,sec});
            }
        }
        return pairs;
    }

    public static boolean hasUniqueChars(String string){
        Set<Character> uniqueChar = new HashSet<>();
        for (Character c: string.toCharArray() ) {
            if(!uniqueChar.add(c)){
                return false;
            }
        }
        return true;
    }
    public static List<Integer> removeDuplicates(List<Integer> myList){
        Set<Integer> uniqueEle = new HashSet<>();
        uniqueEle.addAll(myList);
        return new ArrayList<>(uniqueEle);
    }

    public static int[] subarraySum(int[] nums, int target) {

        Map<Integer, Integer> subArraySum = new HashMap<>();
        subArraySum.put(0,-1);
        int currentSum = 0;
        for(int i=0; i<nums.length; i++){
            currentSum += nums[i];

            if(subArraySum.containsKey(currentSum-target)){
                return new int[]{subArraySum.get(currentSum-target)+1,i};
            }
            subArraySum.put(currentSum,i);
        }

        return new int[]{};
    }


    /**
     * N square time complexty.
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumSlow(int[] nums, int target){
        int[] result = new int[2];

        if (nums != null && nums.length>1){
            for(int i=0;i< nums.length-1;i++){
                for (int j=1; j<nums.length;j++){
                    int total = nums[i]+nums[j];
                    if (target==total){
                        result[0]=i;
                        result[1]=j;
                        return result;
                    }
                }
            }

        }
        return new int[]{};
    }


    public static int[] twoSum(int[] nums, int target){

        Map<Integer,Integer> numMap = new HashMap<>();
        if (nums != null && nums.length>1){
            for(int i=0;i< nums.length;i++){
                int num = nums[i];
                int complement = target-num;
                if (numMap.containsKey(complement)){
                    return new int[]{numMap.get(complement),i };
                }else{
                    numMap.put(num, i);
                }
            }
        }
        return new int[]{};
    }
    public static boolean itemInCommon(int[] arryy1, int[] array2){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i: arryy1) {
            map.put(i, i);
        }
        for (int j: array2) {
            if(map.get(j) !=null){
                return true;
            }
        }
        return false;
    }

    public static List<Integer> findDuplicates(int[] array){
        List<Integer> duplicates = new ArrayList<>();
        if (array !=null && array.length < 2){
            return duplicates;
        }
        Hashtable<Integer , Integer> uniqueEle = new Hashtable<>();
        for (Integer num: array) {
            if (uniqueEle.containsKey(num)){
                int count = uniqueEle.get(num);
                if (count==1) {
                    duplicates.add(num);
                }
                uniqueEle.put(num, (count+1));

            }else{
                uniqueEle.put(num,1);
            }

        }
        return duplicates;
    }

    public static Character firstNonRepeatingChar(String inputString){
        if (inputString==null || inputString.length() < 1){
            return null;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c: inputString.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (char c: inputString.toCharArray() ) {
            if(map.get(c)==1){
                return c;
            }
        }
        return null;
    }

    public static List<List<String>> groupAnagrams(String[] strings){
        HashMap<String, List<String>> anagramsMap = new HashMap<>();
        if(strings != null && strings.length>0) {
            for (String s : strings) {
                char[] chars = s.toCharArray();
                 Arrays.sort(chars);
                 String cnonical = new String(chars);
                 if (anagramsMap.containsKey(cnonical)) {
                     anagramsMap.get(cnonical).add(s);
                 }else {
                     List<String> lst = new ArrayList<>();
                     lst.add(s);
                     anagramsMap.put(cnonical, lst);

                 }

            }
        }
        return new ArrayList<>(anagramsMap.values());
    }


}
