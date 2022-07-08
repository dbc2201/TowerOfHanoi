package io.github.dbc;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@TestMethodOrder(org.junit.jupiter.api.MethodOrderer.OrderAnnotation.class)
class TowerOfHanoiSolverTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private TowerOfHanoiSolver solver;

    @BeforeEach
    void setUp() {
        solver = new TowerOfHanoiSolver();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void solveTowerOfHanoiForThreeDisks() {
        solver.solveTowerOfHanoi(3, 'A', 'C', 'B');
        Assertions.assertEquals(7, outputStreamCaptor.toString().split(System.lineSeparator()).length, "Minimum steps required to solve Tower of Hanoi for three disks is 7");
    }

    @Test
    void solveTowerOfHanoiForFourDisks() {
        solver.solveTowerOfHanoi(4, 'A', 'C', 'B');
        Assertions.assertEquals(15, outputStreamCaptor.toString().split(System.lineSeparator()).length, "Minimum steps required to solve Tower of Hanoi for four disks is 15");
    }

    @Test
    void solveTowerOfHanoiForFiveDisks() {
        solver.solveTowerOfHanoi(5, 'A', 'C', 'B');
        Assertions.assertEquals(31, outputStreamCaptor.toString().split(System.lineSeparator()).length, "Minimum steps required to solve Tower of Hanoi for five disks is 31");
    }

    @Test
    void solveTowerOfHanoiForThreeDisksFirstStep() {
        solver.solveTowerOfHanoi(3, 'A', 'C', 'B');
        Assertions.assertEquals("Move disk from A to C", outputStreamCaptor.toString().split(System.lineSeparator())[0], "First step of Tower of Hanoi for three disks is 'Move disk from A to C'");
    }

    @Test
    void solveTowerOfHanoiForThreeDisksLastStep() {
        solver.solveTowerOfHanoi(3, 'A', 'C', 'B');
        Assertions.assertEquals("Move disk from A to C", outputStreamCaptor.toString().split(System.lineSeparator())[6], "Last step of Tower of Hanoi for three disks is 'Move disk from A to C'");
    }

    //

    @Order(1)
    @Test
    void solveTowerOfHanoiForThreeDisksCheckIfSomethingIsPrintedOnTheScreen() {
        solver.solveTowerOfHanoi(3, 'A', 'C', 'B');
        Assertions.assertNotEquals("", outputStreamCaptor.toString(), "The steps to solve the Tower of Hanoi for three disks should be printed on the screen!");
    }


}