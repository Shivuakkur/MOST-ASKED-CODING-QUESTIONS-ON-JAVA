package com.employe.getData;

public class Matrix {
	
 public static void main(String[] args) {
		        int[][] matrix = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
		        rotateMatrix(matrix);
		        for (int i = 0; i < matrix.length; i++) {
		            for (int j = 0; j < matrix[0].length; j++) {
		                System.out.print(matrix[i][j] + " ");
		            }
		            System.out.println();
		        }
		    }

		    public static void rotateMatrix(int[][] matrix) {
		        int n = matrix.length;
		        // Transpose the matrix
		        for (int i = 0; i < n; i++) {
		            for (int j = i; j < n; j++) {
		                int temp = matrix[i][j];
		                matrix[i][j] = matrix[j][i];
		                matrix[j][i] = temp;
		            }
		        }
		        // Reverse each row
		        for (int i = 0; i < n; i++) {
		            for (int j = 0; j < n / 2; j++) {
		                int temp = matrix[i][j];
		                matrix[i][j] = matrix[i][n - j - 1];
		                matrix[i][n - j - 1] = temp;
		                
		            }
		        }
		    }
		}


		