The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.
Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

 

Example 1:

Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
- 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
- 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.

Example 2:

Input: nums1 = [2,4], nums2 = [1,2,3,4]
Output: [3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
- 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -1.
 

Constraints:

1 <= nums1.length <= nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 10^4
All integers in nums1 and nums2 are unique.
All the integers of nums1 also appear in nums2.


  

Test Case 1:
Input: nums1 = [8,10,6], nums2 = [5,6,7,8,9,10]
Output: [9,-1,7]

Test Case 2:
Input: nums1 = [4,7,9,12,15,89,67] nums2 = [12,15,4,89,67,7,14,9,41]
Output: [89,14,41,15,89,-1,-1]

Test Case 3:
Input: nums1 = [5,3,7], nums2 = [1,3,5,7,9]
Output: [7,7,9]

Test Case 4:
Input: nums1 = [5,25,7,28,6,20,65,24,52,95,4,1,2]
Num2 = [5,2,52,74,13,65,8,1,20,95,24,25,252,6,525,28,51,4,7]
Output: [52,252,-1,51,525,95,95,25,74,252,7,20,52]

Test Case 5:
Input: nums1 = [20,15,25,30], nums2 = [10,15,20,25,30,35]
Output: [25,20,30,35]


  


SOLUTION:
class Solution {
    public int[] nextGreaterElement(int[] n1, int[] n2) {
        Stack<Integer> s1=new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>(); 
        for(int i=n2.length-1;i>=0;i--){
            int num=n2[i];
            while(!s1.isEmpty() && s1.peek()<=num){
               s1.pop(); 
            }
            if(s1.isEmpty()) map.put(num,-1);
            else map.put(num,s1.peek());
            
        s1.push(num);
        }
    
     for (int i = 0; i < n1.length; i++) {  
            n1[i] = map.containsKey(n1[i]) ? map.get(n1[i]) : -1;  
        }
        return n1;
    }
}
