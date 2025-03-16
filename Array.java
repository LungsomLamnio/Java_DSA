import java.util.Scanner;

public class Array {
    public static void updateArray(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            arr[i] += 1;
        }
    }

    public static int findLargest(int arr[]) {
        int largest = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++) {
            if(arr[i] > largest) {
                largest = arr[i];
            }
        }

        return largest;
    }

    public static int binarySearch(int arr[], int target) {
        int left = 0;
        int right = arr.length-1;

        while(left <= right) {
            int mid = left + (right - left)/2;

            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void reverseArray(int arr[]) {
        int size = arr.length;
        for(int i=0; i<=size/2; i++) {
            int temp = arr[i];
            arr[i] = arr[size - 1 - i];
            arr[size - 1 - i] = temp;
        }
    }

    public static void pairsArray(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                System.out.print("(" + arr[i] + "," + arr[j] + ")");
            }
            System.out.println();
        }
    }

    public static void subArrays(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            for(int j=i; j<arr.length; j++) {
                for(int k=i; k<=j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static int maxSubArraySum(int arr[]) {
        int currSum;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            for(int j=i; j<arr.length; j++) {
                currSum = 0;
                for(int k=i; k<=j; k++) {
                    currSum += arr[k];
                    System.out.print(arr[k] + " ");
                }
                if(currSum > maxSum) {
                    maxSum = currSum;
                }
                System.out.println("sum: " + currSum);
            }
            System.out.println();
        }
        return maxSum;
    }

    public static int prefixSum(int arr[]) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        int prefixArray[] = new int[arr.length];
        prefixArray[0] = arr[0];

        for(int i=1; i<prefixArray.length; i++) {
            prefixArray[i] = prefixArray[i-1] + arr[i];
        }

        for(int i=0; i<prefixArray.length; i++) {
            currSum = 0;
            for(int j=i; j<prefixArray.length; j++) {
                currSum = i == 0? prefixArray[j] : prefixArray[j] - prefixArray[i-1];
            }
            if(currSum > maxSum) {
                maxSum = currSum;
            }
            System.out.println("sum: " + currSum);
        }
        return maxSum;
    }

    public static int kadances(int arr[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++) {
            currSum += arr[i];
            if(currSum < 0) {
                currSum = 0;
            }
            if(maxSum < currSum) {
                maxSum = currSum;
            }
        }

        return maxSum;
    }

    public static int rainWater(int height[]) {
        int n = height.length;
        int leftMax[] = new int[n];
        int rightMax[] = new int[n];

        leftMax[0] = height[0];
        for(int i=1; i<leftMax.length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }

        rightMax[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        int trappedWater = 0;
        for(int i=0; i<height.length; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);

            trappedWater += waterLevel - height[i];
        }

        return trappedWater;
        
    }

    public static int buySellStock(int arr[]) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i=0; i<arr.length; i++) {
            if(buyPrice < arr[i]) {
                int profit = arr[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice = arr[i];
            }
        }

        return maxProfit;
    }

    public static boolean distVal(int nums[]) {
        for(int i=0; i<nums.length-1; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i] == nums[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void findTriplets(int arr[]) {
        for(int i=0; i<arr.length-2; i++) {
            for(int j=i+1; j<arr.length-1; j++) {
                for(int k=j+1; k<arr.length; k++) {
                    if(arr[i]+arr[j]+arr[k] == 0) {
                        System.out.println("["+arr[i]+","+arr[j]+","+arr[k]+"]");
                    } 
                }
            }
        }
    }

    public static void twoDArrays() {
        int matrix[][] = new int[3][3];

        Scanner sc = new Scanner(System.in);

        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        print2DArray(matrix);
        searchElement(matrix, 5);
    }

    public static void print2DArray(int matrix[][]) {
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void searchElement(int matrix[][], int target) {
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j] == target) {
                    System.out.println("Target value found at index: " + "(" + i + "," + j + ")");
                }
            }
        }
    }

    public static void printSpriralMatrix(int matrix[][]) {
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length-1;
        int endCol = matrix[0].length-1;

        while(startRow <= endRow && startCol <= endCol) {
            for(int j=startCol; j<=endCol; j++) {
                System.out.print(matrix[startRow][j] + " ");
            }
            
            for(int i=startRow+1; i<=endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }
            
            for(int j=endCol-1; j >= startCol; j--) {
                if(startRow == endRow) {
                    break;
                }
                System.out.print(matrix[endRow][j] + " ");
            }

            for(int i=endRow-1; i >= startRow+1; i--) {
                if(startCol == endCol) {
                    break;
                }
                System.out.print(matrix[i][startCol] + " ");
            }

            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
    }

    public static int diagonalSum(int matrix[][]) {
        int sum = 0;
        // if(matrix.length%2 == 0) {
        //     for(int i=0; i<matrix.length; i++) {
        //         for(int j=0; j<matrix[0].length; j++) {
        //             if(i == j || i+j == matrix.length-1) {
        //                 sum += matrix[i][j];
        //             }
        //         }
        //     }
        // } else {
        //     for(int i=0; i<matrix.length; i++) {
        //         for(int j=0; j<matrix[0].length; j++) {
        //             if(i == j || i+j == matrix.length-1) {
        //                 sum += matrix[i][j];
        //             }
        //         }
        //     }
        // }

        for(int i=0; i<matrix.length; i++) {
            sum += matrix[i][i];

            if(i != matrix.length-1-i) {
                sum += matrix[i][matrix.length-1-i];
            }
        }
        return sum;
    }

    public static void searchInSortedMatrix(int matrix[][], int key) {
        int i = 0, j = matrix[0].length-1;
        while(i <= matrix.length-1 && j >= 0) {
            if(matrix[i][j] == key) {
                System.out.println("Key found in index: (" + i + "," + j + ")");
                break;
            } else if(matrix[i][j] < key) {
                i++;
            } else {
                j--;
            }
        }
        
        if(i > matrix.length-1 || j < 0) {
            System.out.println("Key not found!");
        }

    }

    public static int countNumber(int matrix[][], int num) {
        int count = 0;
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j] == num) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int sumRow(int matrix[][]) {
        int sum = 0;
        for(int j=0; j<matrix[0].length; j++) {
            sum += matrix[1][j];
        }
        return sum;
    }

    public static int[][] transposeOfMatrix(int matrix[][]) {
        int newMatrix[][] = new int[matrix[0].length][matrix.length];
        
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                newMatrix[j][i] = matrix[i][j];
            }
        }
        return newMatrix;
    }
    public static void main(String[] args) {
        
        int matrix[][] = {
            {1,4,9},
            {11,5,3}

            //1 , 11
            //4 , 5
            //9 , 3
        };
        matrix = transposeOfMatrix(matrix);
        print2DArray(matrix);
    }
}
