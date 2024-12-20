Problem:
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target.
You may return the combinations in any order.
The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the 
frequency of at least one of the chosen numbers is different.
The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

Solution:

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;    
    }
    private void backtrack(int[] candidates, int target, int start, List<Integer>currentcombination, List<List<Integer>>result){
        if(target == 0){
            result.add(new ArrayList<>(currentcombination));
            return;
        }
        for(int t = start; t< candidates.length; t++){
            if(candidates[t]>target){
                continue;
            }
            currentcombination.add(candidates[t]);
            backtrack(candidates, target - candidates[t], t, currentcombination, result);
            currentcombination.remove(currentcombination.size() - 1);

        }
    }
}

 
