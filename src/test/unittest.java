package org.phase.mavenproject.org.phase.mavenproject;
import org.phase.mavenproject.org.phase.mavenproject.Robot;
import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;


public class UnitTest {
	
	static Robot robot;

    @BeforeClass
    public static void setup() {
        robot = new Robot();
    }
