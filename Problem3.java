Problem: CONTAINER WITH MOST WATER
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]). 
Find two lines that together with the x-axis form a container, such that the container contains the most water.Return the maximum amount of water a container can store.

solution:

class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n-1;
        int max_water = 0;
        while(left < right){
            int width = right-left;
            int current_height = Math.min(height[left],height[right]);
            int current_area = width*current_height;
            max_water = Math.max(max_water,current_area);

            if(height[left]<height[right]){
                left = left+1;
            }
            else{
                right = right-1;
            }
        }
        return max_water;
    }
}
