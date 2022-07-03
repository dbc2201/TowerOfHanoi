package io.github.dbc;

public class TowerOfHanoiSolver {
    /**
     * This method prints the solution of the Tower of Hanoi problem.
     *
     * @param numberOfDisks the number of disks to be used in the game.
     * @param fromTower     the tower to move disks from.
     * @param toTower       the tower to move disks to.
     * @param auxTower      the tower to move disks temporarily to.
     */
    public void solveTowerOfHanoi(int numberOfDisks, char fromTower, char toTower, char auxTower) {
        if (numberOfDisks == 1) {
            System.out.println("Move disk from " + fromTower + " to " + toTower);
            return;
        }
        solveTowerOfHanoi(numberOfDisks - 1, fromTower, auxTower, toTower);
        System.out.println("Move disk from " + fromTower + " to " + toTower);
        solveTowerOfHanoi(numberOfDisks - 1, auxTower, toTower, fromTower);
    }

    public static void main(String[] args) {
        TowerOfHanoiSolver solver = new TowerOfHanoiSolver();
        solver.solveTowerOfHanoi(4, 'A', 'C', 'B');
    }
}
