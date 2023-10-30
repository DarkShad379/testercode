package org.example;

    public class Main {
        public static void main(String[] args) {
            count(1,5);
        }

        public static void count(int currentCount, int endCount) {

            System.out.println(currentCount);
            if (currentCount != endCount) {
                count(currentCount + (currentCount < endCount ? 1 : -1), endCount);
            }
        }
    }
