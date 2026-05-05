public class MaxWater {
    static void main(String[] args) {
        MaxWater mw = new MaxWater();
        int[] test = {3, 4, 5, 3, 6, 1, 7, 4};
        System.out.println(mw.maxArea(test));
    }


    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            int area = width * h;

            max = Math.max(max, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}
