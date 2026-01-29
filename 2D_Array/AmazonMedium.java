public class AmazonMedium {
    public static void right(int grid[][], int m, int n) {
        if(grid[m][n+1] == 1) {
            grid[m][n+1] = 2;
        }
    }

    public static void left(int grid[][], int m, int n) {
       if(grid[m][n-1] == 1) {
            grid[m][n-1] = 2;
        }
    }

    public static void up(int grid[][], int m, int n) {
       if(grid[m-1][n] == 1) {
            grid[m-1][n] = 2;
        }
    }

    public static void down(int grid[][], int m, int n) {
       if(grid[m+1][n] == 1) {
            grid[m+1][n] = 2;
        }
    }

    public static boolean checkRotten(int grid[][]) {
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    return false;
                }
            }
        }

        return true;
    }
    public static int rottenOranges(int grid[][]) {
        int m = grid.length;
        int n = grid[0].length;
        int min = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 2) {
                    if(i == 0) {
                        down(grid, i, j);
                    } 
                    if(j == 0) {
                        right(grid, i, j);
                    }
                    if(i == m) {
                        up(grid, i, j);
                    }
                    if(j == n) {
                        left(grid, i, j);
                    } else {
                        up(grid, i, j);
                        down(grid, i, j);
                        right(grid, i, j);
                        left(grid, i, j);
                    }
                    if(!checkRotten(grid)) {
                        min++;
                    } else {
                        return min;
                    }
                }
            }
        }

        if(!checkRotten(grid)) {
            return min;
        } else {
            return -1;
        }
    }

    public static void dfs(int grid[][], int i, int j, int m, int n) {
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) {
            return;
        }

        if(grid[i][j] == 1) {
            grid[i][j] = 0;
            dfs(grid, i, j-1, m, n); //left
            dfs(grid, i, j+1, m, n); //right
            dfs(grid, i-1, j, m, n); //up
            dfs(grid, i+1, j, m, n); //down
        }
    }

    public static int countIslands(int grid[][]) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    count++;
                    dfs(grid, i, j, m, n);
                }
            }
        }

        return count;
    }
    public static void main(String[] args) {
        int grid[][] = {{1,1,0,0,0}, {1,1,0,0,0}, {0,0,1,0,0}, {0,0,0,1,1}};
        System.out.println(countIslands(grid));
    }
}
