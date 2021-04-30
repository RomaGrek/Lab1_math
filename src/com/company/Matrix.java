package com.company;

public class Matrix {
    private int size;
    private double[][] matrixСoefficients;
    private double[] vectorAnswer;
    private double[] vectorX;
    private double[] vectorDiscrepancy;
    private int round;
    private double det;
    private int lol = 0;


    public Matrix() {}

    public Matrix(int size, double[][] matrixСoefficients, double[] vectorAnswer) {
        this.size = size;
        this.matrixСoefficients = matrixСoefficients;
        this.vectorAnswer = vectorAnswer;
    }

    public double getDet() {
        return det;
    }

    public void setLol(int lol) {
        this.lol = lol;
    }

    public int getLol() {
        return lol;
    }

    public void setDet(double det) {
        this.det = det;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getRound() {
        return round;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setMatrixСoefficients(double[][] matrixСoefficients) {
        this.matrixСoefficients = matrixСoefficients;
    }

    public void setVectorAnswer(double[] vectorAnswer) {
        this.vectorAnswer = vectorAnswer;
    }

    public void setVectorDiscrepancy(double[] vectorDiscrepancy) {
        this.vectorDiscrepancy = vectorDiscrepancy;
    }

    public void setVectorX(double[] vectorX) {
        this.vectorX = vectorX;
    }

    public int getSize() {
        return this.size;
    }

    public double[][] getMatrixСoefficients() {
        return matrixСoefficients;
    }

    public double[] getVectorAnswer() {
        return vectorAnswer;
    }

    public double[] getVectorDiscrepancy() {
        return vectorDiscrepancy;
    }

    public double[] getVectorX() {
        return vectorX;
    }
}
