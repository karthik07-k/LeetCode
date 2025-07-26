package com.leetcode.string;

public class StringToNumber {

    public static void main(String[] args) {
        String s = "   -0025g67";

        System.out.println("The String to Number is :" +StringToInteger(s));
    }

    private static int StringToInteger(String s) {
        
        int sign = 1;
        int res = 0;
        int index = 0;

        //1. Ignoring the leading white spaces
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }

        //2. Store the sign of number
        if (index < s.length() && (s.charAt(index) == '-' || s.charAt(index) == '+')){
            if(s.charAt(index++) == '-'){
                sign = -1;
            }
        }

        //3. construct the numbers by digit
        while(index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9'){

            //Handling overflow/underflow test case
            if( res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && s.charAt(index)-'0' > 7){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            //append the digits by *10

            res = 10 * res + (s.charAt(index++)-'0');

        }

        return sign * res;
    }

}
