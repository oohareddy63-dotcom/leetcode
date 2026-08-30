class Solution {
    public int trap(int[] height) {
      int n=height.length;
      if(n==0)
      return 0;
    int[] rightmax=new int[n];
    int[] leftmax=new int[n];
    leftmax[0]=height[0];
    rightmax[n-1]=height[n-1];
    for(int i=1;i<n;i++){
        leftmax[i]=Math.max(leftmax[i-1],height[i]);
    }
    for(int i=n-2;i>=0;i--){
        rightmax[i]=Math.max(rightmax[i+1],height[i]);
    }
    int tw=0;
    for(int i=0;i<n;i++){
        tw+=Math.min(rightmax[i],leftmax[i])-height[i];
    }
    return tw;
    }
}