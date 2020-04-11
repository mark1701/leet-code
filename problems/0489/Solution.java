/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
class Solution {
    public void cleanRoom(Robot robot) {
        Random random = new Random();
        robot.clean();
        int count = 500000;
        while(count > 0){
            int moves = random.nextInt(3);
            while(robot.move() && moves > 0){
                robot.clean();
                moves--;
            }
            int choice = random.nextInt(2);
            if(choice == 0)
                robot.turnLeft();
            else
                robot.turnRight();
            count--;
        }
    }
}