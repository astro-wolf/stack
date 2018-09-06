import java.util.Stack;

public class NextGreater {

    public static void main(String[] args) {
        NextGreater nextGreater = new NextGreater();
        nextGreater.findNearestGreater(new int[]{4, 1, 2, 3, 5});
    }

    public void findNearestGreater(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[0]);
        int element, nextNearestGreater;
        for (int i = 1; i < nums.length; i++) {
            nextNearestGreater = nums[i];
            if (!stack.isEmpty()) {
                element = stack.pop();
                while (element < nextNearestGreater) {
                    System.out.print("Next greater for " + element + " is " + nextNearestGreater + "\n");
                    if (stack.isEmpty())
                        break;
                    element = stack.pop();
                }
                if(element > nextNearestGreater)
                    stack.push(element);
            }
            stack.push(nextNearestGreater);
        }
        while (!stack.isEmpty()) {
            element = stack.pop();
            nextNearestGreater = -1;
            System.out.print("Next greater for " + element + " is " + nextNearestGreater);
        }
    }

}
