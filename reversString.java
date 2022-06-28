public class MyClass {
    
    // a function to reverse a string
    public static String reverseIt(String str) {
        char[] ch = str.toCharArray();
        String reversedStr = "";
        
        for(int i = ch.length - 1; i >= 0; i--) {
            reversedStr += Character.toString(ch[i]);
        }
        
        return reversedStr;
    }
    
    public static void main(String args[]) {
      String testCase = "ReverseMe"; // This is the test case for this code
      
      System.out.println("String before reverse operation: " + testCase + "\nString after reverse operation: " + reverseIt(testCase));
    }
}
