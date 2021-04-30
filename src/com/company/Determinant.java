package com.company;

public class Determinant {

    static void getCofactor(double[][] mat, double[][] temp,
                            int p, int q, int n)
    {
        int i = 0, j = 0;

        // Цикл для каждого элемента
        // матрицы
        for (int row = 0; row < n; row++)
        {
            for (int col = 0; col < n; col++)
            {
                // Копирование во временную матрицу
                // только те элементы, которые
                // не находятся в данной строке и столбце
                if (row != p && col != q)
                {
                    temp[i][j++] = mat[row][col];
                    // Строка заполнена, поэтому увеличьте
                    // индекс строки и сброс col
                    // индекс
                    if (j == n - 1)
                    {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }

    /* Рекурсивная функция для нахождения определителя
    матрицы. n - текущее измерение mat[][]. */
    static double determinantOfMatrix(double[][] mat, int n, int size)
    {
        double D = 0; // Initialize result

        // Базовый случай : если матрица содержит один
        // элемент
        if (n == 1)
            return mat[0][0];

        // Для хранения кофакторов
        double[][] temp = new double[size][size];

        // To store sign multiplier
        int sign = 1;

        // Итерация для каждого элемента первой строки
        for (int f = 0; f < n; f++)
        {
            // Получение кофактора mat[0][f]
            getCofactor(mat, temp, 0, f, n);
            D += sign * mat[0][f]
                    * determinantOfMatrix(temp, n - 1, size);

            // термины должны быть добавлены с
            // альтернативный знак
            sign = -sign;
        }

        return D;
    }
}
