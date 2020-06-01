package com.jxiao.year20;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 * <p>
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * <p>
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 * <p>
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * <p>
 * 示例 2：
 * <p>
 * 输入：[[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 * <p>
 * 示例 3：
 * <p>
 * 输入：[[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] 仅为 0、1 或 2
 * <p>
 * 广度优先
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotting-oranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OrangesRotting994 {
    public int orangesRotting(int[][] grid) {
        int fors = 0;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    fors++;
                }

            }
        }

        int dep = 0;
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] temp = queue.remove();
            for (int[] a : dir) {
                int dx = temp[0] + a[0];
                int dy = temp[1] + a[1];
                if (dx < 0 || dx >= grid.length) {
                    continue;
                }
                if (dy < 0 || dy >= grid[0].length) {
                    continue;
                }
                if (grid[dx][dy] != 1) {
                    continue;
                }
                grid[dx][dy] = grid[temp[0]][temp[1]] + 1;
                fors--;
                queue.add(new int[]{dx,dy});
                dep = grid[dx][dy] - 2;

            }
        }


        return fors == 0 ? dep : -1;
    }
}
