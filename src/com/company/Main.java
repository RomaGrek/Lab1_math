package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static javafx.application.Platform.exit;


public class Main {



    public static void main(String[] args) throws FileNotFoundException {
        int typeInput;
        System.out.println("Выбирите тип ввода: Введите 1 если ввод данных будет из файла, или 0 если ввод данных будет с консоли");
        Scanner scannerType = new Scanner(System.in);
        typeInput = scannerType.nextInt();
        System.out.println("Введите точнотсь. (Количество знаков после запятой)");
        int round = scannerType.nextInt();
        System.out.println(round);
        Scanner scanner;
        int size;
        double[][] matrixСoefficients;
        double[] vectorAnsers;
        if (typeInput == 1) {
            scanner = new Scanner(new File("2_matritsa_20_20_laboratornaya_1.txt"));
            size = scanner.nextInt();
            matrixСoefficients = new double[size][size];
            vectorAnsers = new double[size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrixСoefficients[i][j] =scanner.nextDouble();
                }
                vectorAnsers[i] = scanner.nextDouble();
            }
        }else {
            scanner = new Scanner(System.in);
            System.out.println("Введите размер матрицы:");
            size = scanner.nextInt();
            matrixСoefficients = new double[size][size];
            vectorAnsers = new double[size];
            System.out.println("Введите матрицу:");
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrixСoefficients[i][j] = scanner.nextDouble();
                }
                vectorAnsers[i] = scanner.nextDouble();
            }

        }

        System.out.println("Исходные данные:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrixСoefficients[i][j] + " ");
            }
            System.out.println(vectorAnsers[i]);
        }

            Matrix matrix = new Matrix(size, matrixСoefficients, vectorAnsers);
            matrix.setRound(round);

            GausMethod.gausMethod(matrix);
            if (matrix.getLol() % 2 == 0) {
                System.out.println("Определитель матрицы коэффицентов: " + matrix.getDet());
            }else {
                System.out.println("Определитель матрицы коэффицентов: " + matrix.getDet() * (-1));
            }

        System.out.println("Треугольная матрица:");
        matrixСoefficients = matrix.getMatrixСoefficients();
        vectorAnsers = matrix.getVectorAnswer();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrixСoefficients[i][j] + " ");
            }
            System.out.println(vectorAnsers[i]);
        }
            System.out.println("Вектор ответов:");
            for (int i = 0; i < size; i++) {
                System.out.println(matrix.getVectorX()[i]);
            }

            System.out.println("Вектор невязок:");
            GausMethod.searchVectorDiscrepancy(matrix, matrixСoefficients);
            for (int i = 0; i < matrix.getSize(); i++) {
                System.out.println(matrix.getVectorDiscrepancy()[i]);
            }

        }

    }
