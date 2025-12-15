package ArraysAndHashing;

import java.util.*;

public class containsDuplicates {

    //brute force
    public boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for(int i =0;i<nums.length-1;i++){
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }

    //hashmap
        public boolean containsDuplicate2(int[] nums) {
            HashMap<Integer, Integer> hp = new HashMap<>();
            for(int i =0;i<nums.length;i++){
                if(hp.containsKey(nums[i])){
                    return true;
                }
                hp.put(nums[i],1);
            }
            return false;
        }
    //hashset
    public boolean containsDuplicate3(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i =0;i<nums.length;i++){
            if(hs.contains(nums[i])){
                return true;
            }
            hs.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        containsDuplicates cd = new containsDuplicates();
        int[] nums = {1,2,3,1};
        System.out.println(cd.containsDuplicate1(nums));
        System.out.println(cd.containsDuplicate2(nums));
        System.out.println(cd.containsDuplicate3(nums));
    }

}
