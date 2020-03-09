给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。

注意你不能在买入股票前卖出股票。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        int min=prices[0];
        int res=0;
        for(int i=1;i<prices.length;i++){
            res=Math.max(res,prices[i]-min);
            min=Math.min(min,prices[i]);
        }
        return res;
    }
}

从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new LinkedList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null){
            return list;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> row=new LinkedList<>();
            while(size!=0){
                TreeNode node=queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                row.add(node.val);
                size--;
            }
            list.add(row);
        }
        return list;
    }
}

在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

class Solution {
    public int findRepeatNumber(int[] nums) {
        for(int i=0;i<nums.length;i++){
            while(i!=nums[i]){
                if(nums[i]==nums[nums[i]]){
                    return nums[i];
                }
                int tmp=nums[i];
                nums[i]=nums[tmp];
                nums[tmp]=tmp;
            }
        }
        return -1;
    }
   
        
 
}

输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res=new int[2];
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int sum=nums[left]+nums[right];
            if(sum==target){
                res[0]=nums[left];
                res[1]=nums[right];
                return res;
            }else if(sum<target){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }
}


class Solution {
    public int[] exchange(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while(left<right){
            while(left<right&&nums[left]%2!=0){
                left++;
            }
            while(left<right&&nums[right]%2==0){
                right--;
            }
            int tmp=nums[left];
            nums[left]=nums[right];
            nums[right]=tmp;
        }
        return nums;
    }
}

