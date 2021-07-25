package java;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;

        int lower = Math.min(height[i], height[j]);
        int max = lower * (j-i);

        while(i < j){
            lower = Math.min(height[i], height[j]);
            max = Math.max(max, (j-i) * lower);

            for (int k = i + 1; k < j; k++) {
                if(height[k] > lower) break;

                if(k == j-1 && height[k] <= lower) return max;
            }

            if(height[i] < height[j])
                i++;
            else
                j--;
        }

        return max;
    }

    public static void main(String[] args){
        System.out.println(maxArea(new int[]{1,8,100,2,100,4,8,3,7}));
    }
}
