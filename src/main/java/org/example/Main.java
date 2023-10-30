package org.example;

import java.time.Month;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        //1 recursive
        count(1, 5);
        //2 regex
        var testString = "555 Straight Stave Ave, San Francisco, CA 94104\n" +
                "444 Ave Maria Stairway St., San Francisco, CA 94104\n" +
                "9032 Flave Steep Str, San Francisco, CA 94104";
        replaceStringWithRegex(testString);
        replaceStringWithoutRegex(testString);
        //3 light color
        calculateColor();
        //4 moth name length by substring
        System.out.println("Month Length:");
        System.out.println(getMonthLength("EMBER"));
    }


    public static void count(int currentCount, int endCount) {

        System.out.println(currentCount);
        if (currentCount != endCount) {
            count(currentCount + (currentCount < endCount ? 1 : -1), endCount);
        }


    }

    public static String replaceStringWithRegex(String input) {
        System.out.println("With regex");

        var regex = "(Ave\\.|Ave,|St\\.|St,|Str\\.|Str,)";
        var pattern = Pattern.compile(regex);
        var matcher = pattern.matcher(input);
        var wordPairMap = new HashMap<String, String>();
        wordPairMap.put("Ave,", "Avenue,");
        wordPairMap.put("Ave.", "Avenue");
        wordPairMap.put("St,", "Street,");
        wordPairMap.put("St.", "Street");
        wordPairMap.put("Str,", "Street,");
        wordPairMap.put("Str.", "Street");
        var result = new StringBuffer();
        while (matcher.find()) {
            var matcherAbb = matcher.group();
            matcher.appendReplacement(result, wordPairMap.get(matcherAbb));
        }
        matcher.appendTail(result);
        System.out.println(result);
        return result.toString();
    }

    public static String replaceStringWithoutRegex(String input) {
        System.out.println("Without regex");
        input = input.replace("Ave.", "Avenue");
        input = input.replace("Ave,", "Avenue,");
        input = input.replace("St.", "Street");
        input = input.replace("St,", "Street,");
        input = input.replace("Str.", "Street");
        input = input.replace("Str,", "Street,");
        System.out.println(input);
        return input;
    }

    public static void calculateColor() {
        System.out.println("Enter current minutes");
        var scanner = new Scanner(System.in);
        var currentTime = scanner.nextInt();
        var fullTime = currentTime % 5;
        var color = "Off";
        if (fullTime < 3) {
            color = "green";
        } else if (fullTime < 4) {
            color = "yellow";
        } else {
            color = "red";
        }
        System.out.println("Color is: " + color);
        scanner.close();
    }

    public static List<Integer> getMonthLength(String subString) {
        return Arrays.stream(Month.values()).filter(month -> month.name().contains(subString))
                .map(month -> month.name().length()).distinct().toList();
    }
}


