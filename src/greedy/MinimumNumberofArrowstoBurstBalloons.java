package greedy;

import java.util.*;

/**
 * Created by xiaoping on 7/27/17.
 */
public class MinimumNumberofArrowstoBurstBalloons {
    public static int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0)    return 0;

        int arrows = 1;
        int arrowPos = points[0][1];
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for(int i = 1; i < points.length; i++){
            if(arrowPos >= points[i][0]){
                continue;
            }

            arrows++;
            arrowPos = points[i][1];
        }

        return arrows;
    }

    public static void main(String[] args){
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        findMinArrowShots(points);
    }
}
