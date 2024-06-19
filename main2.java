import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод количества игроков
        System.out.print("Введите количество игроков: ");
        int numberOfPlayers = scanner.nextInt();

        // Ввод номера игрока с которого начинается игра
        System.out.print("Введите номер игрока с которого начинается игра (от 1 до " + numberOfPlayers + "): ");
        int startingPlayer = scanner.nextInt() - 1; // -1, чтобы индекс массива совпадал с номером игрока

        // Создание массива для хранения оставшихся игроков
        int[] remainingPlayers = new int[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            remainingPlayers[i] = i + 1; // Заполнение массива номерами игроков
        }

        // Игра
        int currentPlayer = startingPlayer;
        int eliminatedCount = 0;
        while (remainingPlayers.length > 1) {
            currentPlayer = (currentPlayer + 2) % remainingPlayers.length; // Вычисление следующего игрока
            eliminatedCount++;

            System.out.println("Выбыл игрок #" + remainingPlayers[currentPlayer]);

            // Удаление выбывшего игрока из массива
            remainingPlayers = removeElement(remainingPlayers, currentPlayer);
        }

        // Вывод победителя
        System.out.println("Победил игрок #" + remainingPlayers[0]);
    }

    // Функция для удаления элемента из массива
    private static int[] removeElement(int[] arr, int index) {
        int[] newArr = new int[arr.length - 1];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i != index) {
                newArr[j++] = arr[i];
            }
        }
        return newArr;
    }
}
