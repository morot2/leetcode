package java.hard;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class MedianOfTwoArrays {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{}, new int[]{2,3}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final double medianIdx = (nums1.length + nums2.length - 1) / 2.0;

        int idx1 = 0;
        int idx2 = 0;
        int totalIdx = 0;
        int[] mergedArray = new int[nums1.length + nums2.length];

        for (int i = 0; i < nums1.length + nums2.length; i++) {
            if(idx1 >= nums1.length && idx2 < nums2.length){
                mergedArray[totalIdx] = nums2[idx2++];
            } else if(idx2 >= nums2.length && idx1 < nums1.length){
                mergedArray[totalIdx] =  nums1[idx1++];
            } else {
                if(nums1[idx1] > nums2[idx2])
                    mergedArray[totalIdx] = nums2[idx2++];
                else
                    mergedArray[totalIdx] = nums1[idx1++];
            }

            if( totalIdx == medianIdx )
                return mergedArray[totalIdx];
            else if(totalIdx > medianIdx){
                if(nums1.length + nums2.length == 1)
                    return mergedArray[0] ;
                else if(nums1.length + nums2.length == 0)
                    return 0.0;

                return (mergedArray[totalIdx] + mergedArray[totalIdx-1]) / 2.0;
            }

            totalIdx++;
        }

        return mergedArray[totalIdx];
    }
}
