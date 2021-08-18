package java_sol.hard;

public class TrappingRainWater {
    public static int trap(int[] height) {
        int[] leftTop = new int[height.length];
        int[] rightTop = new int[height.length];

        int top = 0;
        for (int i = 0; i < height.length; i++) {
            top = Math.max(height[i], top);
            leftTop[i] = top;
        }

        top = 0;
        for (int i = height.length-1; i >= 0; i--) {
            top = Math.max(height[i], top);
            rightTop[i] = top;
        }

        int answer = 0;
        for (int i = 1; i < height.length-1; i++) {
            int higher = Math.min(leftTop[i-1], rightTop[i+1]);
            if(higher > height[i]){
                answer += (higher-height[i]);
            }
        }

        return answer;
    }

    public static void main(String[] args){
        System.out.println(trap(new int[]{4,2,0,3,2,5}));
    }
}
