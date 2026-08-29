import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] mat) {

        List<Integer> ret = new ArrayList<>();

        int rowb = 0;
        int rowe = mat.length - 1;
        int colb = 0;
        int cole = mat[0].length - 1;

        while (rowb <= rowe && colb <= cole) {

            // Left -> Right
            for (int j = colb; j <= cole; j++) {
                ret.add(mat[rowb][j]);
            }
            rowb++;
            
            // Top -> Bottom
            for (int i = rowb; i <= rowe; i++) {
                ret.add(mat[i][cole]);
            }
            cole--;

            // Right -> Left
            if (rowb <= rowe) {
                for (int j = cole; j >= colb; j--) {
                    ret.add(mat[rowe][j]);
                }
                rowe--;
            }

            // Bottom -> Top
            if (colb <= cole) {
                for (int i = rowe; i >= rowb; i--) {
                    ret.add(mat[i][colb]);
                }
                colb++;
            }
        }

        return ret;
    }
}