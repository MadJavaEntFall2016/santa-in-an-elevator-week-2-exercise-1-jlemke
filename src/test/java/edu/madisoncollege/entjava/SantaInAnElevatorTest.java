package edu.madisoncollege.entjava;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import static org.junit.Assert.*;

/**
 * Created by Joe on 9/14/2016.
 */
public class SantaInAnElevatorTest {

    private final Logger logger = Logger.getLogger(this.getClass());

    SantaInAnElevator santa = new SantaInAnElevator();

    String test1;
    int answer1;

    String test2;
    int answer2;

    String test3;
    String answer3;

    String line;

    @Before
    public void setUp() throws Exception {
        test1 = "((((((((";
        answer1 = 8;
        test2 = "))))";
        answer2 = -4;
        test3 = "()()";
        answer3 = "(())";
        File file = new File("C:\\Users\\Joe\\Documents\\GitHub\\santa-in-an-elevator-week-2-exercise-1-jlemke\\src\\main\\resources\\SantaUpDown.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            line = br.readLine();
        } catch(Exception e) {
            System.err.println(e.getMessage());
            logger.error("Failed to read file.");
        }
    }

    @Test
    public void testUp() throws Exception {
        assertEquals("are not equal", answer1, santa.whatFloor(test1));
    }

    @Test
    public void testDown() {
        assertEquals("are not equal", answer2, santa.whatFloor(test2));
    }

    @Test
    public void testSame() {
        assertEquals("are not equal", santa.whatFloor(answer3), santa.whatFloor(test3));
    }

    @Test
    public void findOutWhatFloor() {
        assertEquals("is this right?", 138, santa.whatFloor(line));
    }
}