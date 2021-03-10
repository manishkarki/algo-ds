package com.algo.string;

/**
 * You are given a string time in the form of hh:mm, where some of the digits in the string are hidden (represented by ?).
 * <p>
 * The valid times are those inclusively between 00:00 and 23:59.
 * <p>
 * Return the latest valid time you can get from time by replacing the hidden digits.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: time = "2?:?0"
 * Output: "23:50"
 * Explanation: The latest hour beginning with the digit '2' is 23 and the latest minute ending with the digit '0' is 50.
 * Example 2:
 * <p>
 * Input: time = "0?:3?"
 * Output: "09:39"
 * Example 3:
 * <p>
 * Input: time = "1?:22"
 * Output: "19:22"
 *
 * @author mkarki
 */
public class MaximumTime {
    public String maximumTime(String time) {
        char[] timeChars = time.toCharArray();

        if (timeChars[0] == '?') {
            timeChars[0] = timeChars[1] <= '3' || timeChars[1] == '?' ? '2' : '1';
        }

        if (timeChars[1] == '?') {
            timeChars[1] = timeChars[0] == '2' ? '3' : '9';
        }
        if (timeChars[3] == '?') {
            timeChars[3] = '5';
        }

        if (timeChars[4] == '?') {
            timeChars[4] = '9';
        }

        return new String(timeChars);
    }
}
