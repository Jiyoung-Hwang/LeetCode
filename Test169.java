import java.util.Arrays;
import java.util.HashMap;

public class Test169 {
    public static void main(String args[]) throws Exception{

        int[] nums = new int[]{1,3,5,7,3,3,3};

        System.out.println(Test169.majorityElement_myApproach(nums));
        System.out.println(Test169.majorityElement_myApproach2(nums));
        System.out.println(Test169.majorityElement_best(nums));
        System.out.println(Test169.majorityElement_best2(nums));
    }

    private static int majorityElement_best2(int[] nums){
        int[] bitCnt = new int[32];

        for(int num: nums){
            for(int i=0;i<32;i++){
                if((num>>i & 1) == 1) bitCnt[i]++;
            }
        }

        int result = 0;
        for(int i=0;i<32;i++){
            if(bitCnt[i] > nums.length/2)
                result = result | (1<<i);
        }

        return result;

    }
    private static int majorityElement_best(int[] nums){
        int major = nums[0];
        int cnt = 0;
        for(int i=1;i<nums.length;i++){
            if(cnt==0){
                major = nums[i];
                cnt++;
            }else if(major == nums[i]){
                cnt++;
            }else{
                cnt--;
            }
        }

        return major;
    }

    private static int majorityElement_myApproach(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    private static int majorityElement_myApproach2(int[] nums) throws Exception{
        HashMap<Integer, Integer> map = new HashMap<>();
        int threshHold = nums.length/2;

        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.containsKey(nums[i])? map.get(nums[i]) + 1 : 1);
            if(map.get(nums[i]) >= threshHold)
                return nums[i];
        }

        throw new Exception("No majority Elements.");
    }
}
