Problem :
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Solution:

class Solution{
    private static final Map<Character, String> phoneMap = new HashMap<>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        
        Queue<String> queue = new LinkedList<>();
        queue.offer("");  

        for (char digit : digits.toCharArray()) {
            String letters = phoneMap.get(digit);
            if (letters == null) {
                continue;
            }
            
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String combination = queue.poll();
                for (char letter : letters.toCharArray()) {
                    queue.offer(combination + letter);
                }
            }
        }        
        result.addAll(queue);  
        return result;
    }
}
