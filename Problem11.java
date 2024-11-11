Problem:
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
  
Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Solution:

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateCombinations(result,"",0,0,n);
        return result;
    }
    private void generateCombinations(List<String> result,String current,int open, int close, int max){
        if(current.length()==max*2){
            result.add(current);
            return;
        }
        if(open < max){
            generateCombinations(result, current + "(", open + 1, close, max);
        }
        if (close < open) {
            generateCombinations(result, current + ")", open, close + 1, max);
        }
    }
}
