Problem: 
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"  
Write the code that will take a string and make this conversion given a number of rows:


Solution:

class Solution {
    public String convert(String s, int numRows) {
        if(numRows ==1 || numRows>=s.length()){
            return s;
        }
        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i =0; i<numRows; i++){
            rows[i]= new StringBuilder();
        }
        int currentRow = 0;
        boolean godown = false;
        for(char c : s.toCharArray()){
            rows[currentRow].append(c);
            if(currentRow==0 || currentRow == numRows-1){
                godown =! godown;
            }
            currentRow += godown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        return result.toString();
    }
}
