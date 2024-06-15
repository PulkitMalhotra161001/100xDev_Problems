Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

 

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
  
Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]
  
Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]
 


  
Constraints:
2 <= nums.length <= 10^4
-10^9 <= nums[i] <= 10^9
-10^9 <= target <= 10^9
Only one valid answer exists.



  
Solution:
import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int a[] = new int[n];
    for(int i=0;i<n;i++){
      a[i] = sc.nextInt();
    }
    int target = sc.nextInt();
    int ans[] = twoSum(a,target);
    System.out.println(ans[0]+" "+ans[1]);
  }
  public static int[] twoSum(int[] nums, int target) {
    Map<Integer,Integer>  map = new HashMap<>();

    int n=nums.length;
    for(int i=0;i<n;i++){
        if(map.containsKey(target-nums[i])){
            int value_id = map.get(target-nums[i]);
            
            int ans[] = new int[2];
            ans[0]=value_id;
            ans[1]=i;
            return ans;
            
        }
        map.put(nums[i],i);
    }
    
    return new int[]{-1,-1};
}

}



TestCases:


Input: 
13
5 67 -2 895 2582 682 55 -275 2 -872 25 0 -275
5
Output: 
0 11

Input: 
9
6 2 5 7 -52 -27 -72 -722 -87     
-20
Output: 
3 5

Input: 
9
7 3 295 92 592 59825 29824 982 595     
985
Output:
1 7

Input: 
11
7 23 -482 -825 -69 -82 58 2 592 92 -92     
25
Output: 
1 7

Input: 
13
82 9 92 191 492 4951 -51 21954 -5 2935 -24 -2 9     
80
Output: 
0 11
