import java.util.Arrays;

public class Question1 {

    static int[] productExceptSelf(int[] nums) {

        int[] answer = new int[nums.length];

        int left = 1;

        for (int i = 0; i < nums.length; i++) {
            answer[i] = left;
            left = left * nums[i];
        }

        int right = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] = answer[i] * right;
            right = right * nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};

        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}