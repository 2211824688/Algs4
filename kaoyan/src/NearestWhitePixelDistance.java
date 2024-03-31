import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NearestWhitePixelDistance {
    public static int[][] nearestWhitePixel(int n, int m, int[][] bitmap) {
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = n * m;
            }
        }

        Queue<int[]> queue = new LinkedList<>();

        // 找到所有白色像素的位置，并将其距离设为0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (bitmap[i][j] == 1) {
                    dist[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // 广度优先搜索
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] pixel = queue.poll();
            int row = pixel[0];
            int col = pixel[1];

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && dist[newRow][newCol] > dist[row][col] + 1) {
                    dist[newRow][newCol] = dist[row][col] + 1;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();  // 读取换行符

        int[][] bitmap = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            for (int j = 0; j < m; j++) {
                bitmap[i][j] = Integer.parseInt(parts[j]);
            }
        }

        int[][] result = nearestWhitePixel(n, m, bitmap);

        // 输出结果
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(result[i][j]);
                if (j < m - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}