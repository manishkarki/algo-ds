package com.algo.dummy.main;

/**
 * @author mkarki
 */
public class Airplane {
    private String planeNumber;
    private int bookedFirstClassSeats;
    private int availableFirstClassSeats; // derived
    private int totalFirstClassSeats;
    private int bookedCoachSeats;
    private int availableCoachSeats; // derived
    private int totalCoachSeats;


    public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
        this.planeNumber = planeNumber;
        this.totalFirstClassSeats = totalFirstClassSeats;
        this.totalCoachSeats = totalCoachSeats;
    }

    public String getPlaneNumber() {
        return planeNumber;
    }

    public int getTotalFirstClassSeats() {
        return totalFirstClassSeats;
    }

    public int getTotalCoachSeats() {
        return totalCoachSeats;
    }

    public int getBookedCoachSeats() {
        return bookedCoachSeats;
    }

    public int getAvailableCoachSeats() {
        availableCoachSeats = totalCoachSeats - bookedCoachSeats;
        return availableCoachSeats;
    }

    public int getBookedFirstClassSeats() {
        return bookedFirstClassSeats;
    }

    public int getAvailableFirstClassSeats() {
        availableFirstClassSeats = totalFirstClassSeats - bookedFirstClassSeats;
        return availableFirstClassSeats;
    }

    public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) {
        if(forFirstClass) {
            if (totalFirstClassSeats >= totalNumberOfSeats) {
                bookedFirstClassSeats += totalNumberOfSeats;
                return true;
            }
        } else {
            if (totalCoachSeats >= totalNumberOfSeats) {
                bookedCoachSeats += totalNumberOfSeats;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Airplane airplane = new Airplane("coach", 2,3);
        airplane.reserveSeats(true, 1);
        airplane.reserveSeats(false, 2);

        System.out.println(airplane.getAvailableFirstClassSeats());
    }

}


