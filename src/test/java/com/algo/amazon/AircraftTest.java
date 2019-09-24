package com.algo.amazon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author mkarki
 */
class AircraftTest {
    private Aircraft aircraft;

    @BeforeEach
    void setup() {
        aircraft = new Aircraft();
    }

    @Test
    void testGeetIdPairsForOptimal() {
        List<List<Integer>> forward = new ArrayList<List<Integer>>() {{
            add(new ArrayList<Integer>() {{
                add(1);
                add(3000);
            }});
            add(new ArrayList<Integer>() {{
                add(2);
                add(5000);
            }});
            add(new ArrayList<Integer>() {{
                add(3);
                add(7000);
            }});
            add(new ArrayList<Integer>() {{
                add(4);
                add(10000);
            }});
        }};
        List<List<Integer>> returnRoute = new ArrayList<List<Integer>>() {{
            add(new ArrayList<Integer>() {{
                add(1);
                add(2000);
            }});
            add(new ArrayList<Integer>() {{
                add(2);
                add(3000);
            }});
            add(new ArrayList<Integer>() {{
                add(3);
                add(4000);
            }});
            add(new ArrayList<Integer>() {{
                add(4);
                add(5000);
            }});
        }};
        System.out.println(aircraft.getIdPairsForOptimal(10000, forward, returnRoute));
    }

    @Test
    void random() {
        int n = 11;
        for( int i = 2; i * i <= n; i++) {
            System.out.println("i:"+i);
            if(n % i == 0) {
                System.out.println("false");
            }
        }
        System.out.println("true");
    }
}