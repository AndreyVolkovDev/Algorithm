public class Main {

    public static boolean isSuffix(String str1, String str2) {
        if (str1.length() < str2.length()) {
            return false;
        }

        int str1Index = str1.length() - str2.length();

        for (int i = 0; i < str2.length(); i++) {
            if (str1.charAt(str1Index + i) != str2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "bc";

        if (isSuffix(str1, str2)) {
            System.out.println("Вторая строка является окончанием первой");
        } else {
            System.out.println("Вторая строка не является окончанием первой");
        }
    }
}
