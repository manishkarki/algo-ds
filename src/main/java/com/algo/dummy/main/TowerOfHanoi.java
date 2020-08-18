package com.algo.dummy.main;

import java.util.Scanner;

/**
 * @author mkarki
 */
public class TowerOfHanoi {
    private static final char[] TOWERS_LITERAL = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

    /**
     * driver method to get the steps to transfer disks from src tower to destination tower
     *
     * @param nDisks
     * @param nTower
     */
    public static void towerOfHanoi(int nDisks, int nTower) {
        int end = 0;
        if (nTower % 2 == 0) {
            end = 3;
            System.out.println("nTowers is even:" + nTower + "so going with 4");
            towerOfHanoi4(nDisks, TOWERS_LITERAL[0], TOWERS_LITERAL[end], TOWERS_LITERAL[1], TOWERS_LITERAL[2]);
        } else {
            end = 2;
            towerOfHanoi3(nDisks, TOWERS_LITERAL[0], TOWERS_LITERAL[end], TOWERS_LITERAL[end - 1]);
        }

        while ((end + 1) < nTower) {
            System.out.println("end is:" + end);
            towerOfHanoi3(nDisks, TOWERS_LITERAL[end], TOWERS_LITERAL[end + 2], TOWERS_LITERAL[end + 1]);
            end = end + 2;
        }

    }

    /**
     * @param n
     * @param from_tower
     * @param to_tower
     * @param aux_tower1
     * @param aux_tower2
     */
    static void towerOfHanoi4(int n, char from_tower,
                              char to_tower, char aux_tower1,
                              char aux_tower2) {
        if (n == 0)
            return;
        if (n == 1) {
            System.out.println("Move disk " + n +
                    " from tower " + from_tower +
                    " to tower " + to_tower);
            return;
        }

        towerOfHanoi4(n - 2, from_tower, aux_tower1, aux_tower2,
                to_tower);
        System.out.println("Move disk " + (n - 1) + " from tower " + from_tower +
                " to tower " + aux_tower2);
        System.out.println("Move disk " + n + " from tower " + from_tower +
                " to tower " + to_tower);
        System.out.println("Move disk " + (n - 1) + " from tower " + aux_tower2 +
                " to tower " + to_tower);
        towerOfHanoi4(n - 2, aux_tower1, to_tower, from_tower,
                aux_tower2);
    }

    /**
     * @param nDisks
     * @param src
     * @param dest
     * @param intermediary
     */
    private static void towerOfHanoi3(int nDisks, char src, char dest, char intermediary) {
        if (nDisks == 0) {
            return;
        }
        if (nDisks == 1) {
            System.out.println("Moving disk " + nDisks + " from tower " + src
                    + " to tower:" + dest);
            return;
        }
        towerOfHanoi3(nDisks - 1, src, intermediary, dest);
        System.out.println("Moving disk " + nDisks + " from tower " + src + " to tower " + dest);
        towerOfHanoi3(nDisks - 1, intermediary, dest, src);
    }

    public static void main(String[] args) {
        System.out.println("Enter the number of towers (Constraints: 5 <= n <= 10)");
        Scanner scan = new Scanner(System.in);
        int numberOfTowers = scan.nextInt();
        if (numberOfTowers < 5 || numberOfTowers > 10) {
            System.out.println("Wrong input, exiting...");
            System.exit(0);
        }
        System.out.println("Enter the number of discs (Constraints: 3 <= n <= 40)");
        int numberOfDiscs = scan.nextInt();
        if (numberOfDiscs < 3 || numberOfDiscs > 40) {
            System.out.println("Wrong input, exiting...");
            System.exit(0);
        }
        towerOfHanoi(numberOfDiscs, numberOfTowers);
    }
}
