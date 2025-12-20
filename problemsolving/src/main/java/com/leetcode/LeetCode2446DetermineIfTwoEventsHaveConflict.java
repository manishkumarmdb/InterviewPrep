package com.leetcode;

public class LeetCode2446DetermineIfTwoEventsHaveConflict {

    public static boolean haveConflict(String[] event1, String[] event2) {
        int e1st = Integer.parseInt(event1[0].substring(0,2)) * 60 + Integer.parseInt(event1[0].substring(3));
        int e1et = Integer.parseInt(event1[1].substring(0,2)) * 60 + Integer.parseInt(event1[1].substring(3));
        int e2st = Integer.parseInt(event2[0].substring(0,2)) * 60 + Integer.parseInt(event2[0].substring(3));
        int e2et = Integer.parseInt(event2[1].substring(0,2)) * 60 + Integer.parseInt(event2[1].substring(3));
        System.out.println(e1st + ", " + e1et);
        System.out.println(e2st + ", " + e2et);
        return e2st <= e1et && e1st <= e2et;
    }

    public static void main(String[] args) {
        String[] event1 = new String[]{"01:00","02:00"};
        String[] event2 = new String[]{"03:00","04:30"};
        System.out.println(haveConflict(event1, event2));
    }
}
