import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class WalkingRobotSimulation_874 {
    static int[] commands = {4,-1,4, -2, 4};
    static int[][] obstacles = {{2,4}};

    public static void main(String[] args) {
        Solution874 sol = new Solution874();
        int res = sol.robotSim(commands, obstacles);
        System.out.println(res);
    }
}

class Solution874 {
    private static long hashCoor(int x, int y) {
            return x + 60006L * y;
        }
    public int robotSim(int[] commands, int[][] obstacles) {

        Set<Long> obs = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obs.add(hashCoor(obstacle[0], obstacle[1]));
        }

        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int maxDistSq = 0;
        int[] curPosition = {0,0};
        int curDirection = 0;

        for (int cmd : commands) {
            if (cmd == -1) {curDirection = (curDirection + 1)%4;}
            else if (cmd ==-2) {curDirection = (curDirection + 3)%4;}

            else {
                int[] dir = directions[curDirection];
                for (int steps = 0; steps < cmd; steps++) {
                    int x = curPosition[0] + dir[0];
                    int y = curPosition[1] + dir[1];
                    if (obs.contains(hashCoor(x,y))) break;

                    curPosition[0] = x;
                    curPosition[1] = y;

                    maxDistSq = Math.max(maxDistSq, x*x + y*y);
                }
            }
        }
        return maxDistSq;
    }
}
