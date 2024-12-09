public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int area =0;
        int left = 0,right = height.length-1;
        while(right > left){
            area = Math.max(area, Math.min(height[left],height[right])*(right-left));
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return area;
    }
}
