import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод размера массива
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();

        // Ввод элементов массива
        int[] numbers = new int[size];
        System.out.print("Введите элементы массива: ");
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }

        // Поиск максимального значения
        int max = numbers[0];
        for (int i = 1; i < size; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        // Формирование массива слева от максимума
        int[] leftArray = new int[0]; // Инициализация пустого массива
        for (int i = 0; i < size; i++) {
            if (numbers[i] < max) {
                int[] newArray = new int[leftArray.length + 1];
                System.arraycopy(leftArray, 0, newArray, 0, leftArray.length);
                newArray[newArray.length - 1] = numbers[i];
                leftArray = newArray;
            }
        }

        // Формирование массива справа от максимума
        int[] rightArray = new int[0]; // Инициализация пустого массива
        for (int i = 0; i < size; i++) {
            if (numbers[i] > max) {
                int[] newArray = new int[rightArray.length + 1];
                System.arraycopy(rightArray, 0, newArray, 0, rightArray.length);
                newArray[newArray.length - 1] = numbers[i];
                rightArray = newArray;
            }
        }

        // Вывод результатов
        System.out.println("Максимальное значение: " + max);
        System.out.print("Массив слева от максимума: ");
        for (int i = 0; i < leftArray.length; i++) {
            System.out.print(leftArray[i] + " ");
        }
        System.out.println();
        System.out.print("Массив справа от максимума: ");
        for (int i = 0; i < rightArray.length; i++) {
            System.out.print(rightArray[i] + " ");
        }
    }
}
