// 代码生成时间: 2025-10-24 19:01:53
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class provides a library for matrix operations.
 * It includes methods for matrix addition, subtraction, multiplication,
 * and transpose.
 */
@ManagedBean
@SessionScoped
public class MatrixOperations {

    /**
     * Adds two matrices.
     * @param matrixA First matrix.
     * @param matrixB Second matrix.
     * @return The sum of the two matrices.
     * @throws IllegalArgumentException If matrices are not of the same dimension.
     */
    public double[][] add(double[][] matrixA, double[][] matrixB) {
        if (matrixA.length != matrixB.length || matrixA[0].length != matrixB[0].length) {
            throw new IllegalArgumentException("Matrices must be of the same dimension.");
        }

        double[][] result = new double[matrixA.length][matrixA[0].length];
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[0].length; j++) {
                result[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        return result;
    }

    /**
     * Subtracts one matrix from another.
     * @param matrixA First matrix.
     * @param matrixB Second matrix.
     * @return The difference of the two matrices.
     * @throws IllegalArgumentException If matrices are not of the same dimension.
     */
    public double[][] subtract(double[][] matrixA, double[][] matrixB) {
        if (matrixA.length != matrixB.length || matrixA[0].length != matrixB[0].length) {
            throw new IllegalArgumentException("Matrices must be of the same dimension.");
        }

        double[][] result = new double[matrixA.length][matrixA[0].length];
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[0].length; j++) {
                result[i][j] = matrixA[i][j] - matrixB[i][j];
            }
        }
        return result;
    }

    /**
     * Multiplies two matrices.
     * @param matrixA First matrix.
     * @param matrixB Second matrix.
     * @return The product of the two matrices.
     * @throws IllegalArgumentException If the number of columns in the first matrix
     * does not match the number of rows in the second matrix.
     */
    public double[][] multiply(double[][] matrixA, double[][] matrixB) {
        if (matrixA[0].length != matrixB.length) {
            throw new IllegalArgumentException("The number of columns in the first matrix must match the number of rows in the second matrix.");
        }

        double[][] result = new double[matrixA.length][matrixB[0].length];
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixB[0].length; j++) {
                for (int k = 0; k < matrixA[0].length; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return result;
    }

    /**
     * Transposes a matrix.
     * @param matrix The matrix to transpose.
     * @return The transposed matrix.
     */
    public double[][] transpose(double[][] matrix) {
        double[][] result = new double[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    // Additional methods for other matrix operations can be added here.

    // Example usage within JSF managed bean methods or other parts of the application.
}