package com.company;

import javax.swing.*;

public class GausMethod {
    static int lol = 0;

    static double roundCoordinate(double cor, int round) {
        double quantity = Math.pow(10, round);
        double result = Math.ceil(cor * quantity) / quantity;
        return result;
    }

    /*columnNumber - номер столбца в котором чекаем всю движуху*/
    static void searchGeneralElement(Matrix matrix, int columnNumber) {
        double[][] matrixCof = matrix.getMatrixСoefficients();
        double[] vectorAnswer = matrix.getVectorAnswer();
        int maxColumn = columnNumber;
        double maxElement = matrixCof[columnNumber][columnNumber];
        for (int i = columnNumber + 1; i < matrix.getSize(); i++) {
            if (Math.abs(matrixCof[i][columnNumber]) > Math.abs(maxElement)) {
                maxElement = matrixCof[i][columnNumber];
                maxColumn = i; // тут хранится значение строки где максимальный элемент
            }

        }
        if (maxColumn != columnNumber) {
            matrix.setLol(matrix.getLol() + 1);
            double[] vector = new double[matrix.getSize()];
            for (int i = 0; i < matrix.getSize(); i++) {
                if (i == columnNumber) {
                    if (matrix.getSize() >= 0) System.arraycopy(matrixCof[i], 0, vector, 0, matrix.getSize());
                    matrixCof[i] = matrixCof[maxColumn];
                }
                if (i == maxColumn) {
                    matrixCof[i] = vector;
                }
            }
            double ans = vectorAnswer[columnNumber];
            vectorAnswer[columnNumber] = vectorAnswer[maxColumn];
            vectorAnswer[maxColumn] = ans;
        }
        matrix.setMatrixСoefficients(matrixCof);
    }

    static Matrix gausMethod(Matrix matrix) {
        double subtractor;
        double[][] matrixCof = matrix.getMatrixСoefficients();
        double[] vectorAnswer = matrix.getVectorAnswer();
        for (int p = 0; p < (matrix.getSize() - 1); p++) { // столбец/ типо скольой раз сдвигаем
            searchGeneralElement(matrix, p);
            for (int i = p + 1; i < matrix.getSize(); i++) { // строка
                subtractor = roundCoordinate(matrixCof[i][p] / matrixCof[p][p], matrix.getRound());
                vectorAnswer[i] = vectorAnswer[i] - (subtractor * vectorAnswer[p]);
                for (int j = p; j < matrix.getSize(); j++) {
                    matrixCof[i][j] = matrixCof[i][j] - (subtractor * matrixCof[p][j]);
                }


            }
        }
        double det = 1;
        for (int i = 0; i < matrix.getSize(); i++) {
            det = det * matrixCof[i][i];
        }
        if (det == 0) {
            System.exit(0);
        }
        matrix.setDet(det);
        matrix.setMatrixСoefficients(matrixCof);
        matrix.setVectorAnswer(vectorAnswer);
        double[] vectorX = new double[matrix.getSize()];
        for (int i = (matrix.getSize() - 1); i > -1; i--) {
            double sum = 0;
            for (int k = i + 1; k < matrix.getSize(); k++) {
                sum = sum + vectorX[k] * matrixCof[i][k];
            }
            vectorX[i] = (vectorAnswer[i] - sum) / matrixCof[i][i];
        }
        matrix.setVectorX(vectorX);
        return matrix;
    }

    public static void searchVectorDiscrepancy(Matrix matrix, double[][] oldA) {
        double[] vectorDiscrepancy = new double[matrix.getSize()];
        double[] matrixX = matrix.getVectorX();                 // X
        double[] matrixAx = new double[matrix.getSize()];
        double[] vectorAns = matrix.getVectorAnswer();
        double sum = 0;
        for (int i = 0; i < matrix.getSize(); i++) {
            for (int j = 0; j< matrix.getSize(); j ++) {
                sum = sum + (oldA[i][j] * matrixX[j]);
            }
            matrixAx[i] = sum;
            sum = 0;
        }
        for (int i = 0; i < matrix.getSize(); i++) {
            vectorDiscrepancy[i] = matrixAx[i] - vectorAns[i];
        }
        matrix.setVectorDiscrepancy(vectorDiscrepancy);
    }



}
