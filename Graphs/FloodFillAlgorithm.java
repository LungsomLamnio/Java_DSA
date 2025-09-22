public class FloodFillAlgorithm {
    public static void fill(int image[][], int sr, int sc, int oldColor, int newColor) {
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != oldColor) {
            return;
        }

        image[sr][sc] = newColor;
        fill(image, sr, sc-1, oldColor, newColor); //left
        fill(image, sr, sc+1, oldColor, newColor); //right
        fill(image, sr-1, sc, oldColor, newColor); //up
        fill(image, sr+1, sc, oldColor, newColor); //down
    }
    public static int[][] floodFill(int image[][], int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        fill(image, sr, sc, oldColor, color);
        return image;
    }
    public static void main(String[] args) {
        int image[][] = {
            {1,1,1},
            {1,1,0},
            {1,0,1}
        };
        int sr = 1;
        int sc = 1;
        int color = 2;
        int newImage[][] = floodFill(image, sr, sc, color);
        for(int i=0; i<newImage.length; i++) {
            for(int j=0; j<newImage[0].length; j++) {
                System.out.print(newImage[i][j] + " ");
            }
            System.out.println();
        }
    }
}
