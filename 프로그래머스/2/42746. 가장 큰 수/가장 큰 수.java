import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
    int size = numbers.length;
    String[] strNums = new String[size];
    
    
    for (int i = 0; i < size; i++) {
        strNums[i] = String.valueOf(numbers[i]);
    }
    
    Arrays.sort(strNums, (a, b) -> (b + "" + a).compareTo(a + "" + b));
    
    StringBuilder sb = new StringBuilder();
    for (String s : strNums) {
        sb.append(s);
    }
        
     if (sb.toString().startsWith("0")) {
        return "0";
    }
    
    return sb.toString();
    }
}