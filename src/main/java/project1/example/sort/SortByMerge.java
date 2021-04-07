package project1.example.sort;

import java.util.Arrays;

public class SortByMerge {
    public int[] sortArray(int[] arrayA) { // сортировка Массива который передается в функцию
        // проверяем не нулевой ли он?
        if (arrayA == null) {
            return null;
        }
        // проверяем не 1 ли элемент в массиве?
        if (arrayA.length < 2) {
            return arrayA; // возврат в рекурсию в строки ниже см комменты.
        }
        // копируем левую часть от начала до середины
        int[] arrayB = new int[arrayA.length / 2];
        System.arraycopy(arrayA, 0, arrayB, 0, arrayA.length / 2);
        System.out.println("ArrayB = " + Arrays.toString(arrayB));

        // копируем правую часть от середины до конца массива, вычитаем из длины первую часть
        int[] arrayC = new int[arrayA.length - arrayA.length / 2];
        System.arraycopy(arrayA, arrayA.length / 2, arrayC, 0, arrayA.length - arrayA.length / 2);

        System.out.println("ArrayC = " + Arrays.toString(arrayC));

        // рекурсией закидываем поделенные обе части обратно в наш метод, он будет крутится до тех пор,
        // пока не дойдет до 1 элемента в массиве, после чего вернется в строку и будет искать второй такой же,
        // точнее правую часть от него и опять вернет его назад
        arrayB = sortArray(arrayB); // левая часть возврат из рекурсии строкой return arrayA;
        arrayC = sortArray(arrayC); // правая часть возврат из рекурсии строкой return arrayA;

        System.out.println("__________________________________");
//        System.out.println("ArrayB = " + Arrays.toString(arrayB) + System.lineSeparator() + "ArrayC = " + Arrays.toString(arrayC));
        // далее опять рекурсия возврата слияния двух отсортированных массивов
        return mergeArray(arrayB, arrayC);
    }

    public int[] mergeArray(int[] arrayА, int[] arrayB) {

        int[] arrayC = new int[arrayА.length + arrayB.length];
        int positionA = 0, positionB = 0;

        for (int i = 0; i < arrayC.length; i++) {
            if (positionA == arrayА.length) {
                arrayC[i] = arrayB[positionB];
                positionB++;
            } else if (positionB == arrayB.length) {
                arrayC[i] = arrayА[positionA];
                positionA++;
            } else if (arrayА[positionA] < arrayB[positionB]) {
                arrayC[i] = arrayА[positionA];
                positionA++;
            } else {
                arrayC[i] = arrayB[positionB];
                positionB++;
            }
        }
        System.out.println("ArrayC в merge = " + Arrays.toString(arrayC));

        return arrayC;
    }
}
