import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Exception;

public class Months {
    public static boolean isLeapYear(int year) throws InvalidYearException {
        if (year < 1) {
            throw new InvalidYearException("Некорректный год, идиота ты кусок :(");
        }
        if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] months = {"январь", "февраль", "март", "апрель", "май",
                "июнь", "июль", "август", "сентябрь", "октябрь", "ноябрь", "декабрь"};
        int[] dom = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        try {
            System.out.println("Введите число от 1 до 12: ");
            try {
                int chislo = input.nextInt();
                System.out.println("Месяц: " + months[chislo - 1]);
                if (months[chislo - 1] == "февраль") {
                    System.out.println("Введите год: ");
                    try {
                        int year = input.nextInt();
                        if (isLeapYear(year) == true) {
                            System.out.println("Количество дней: 29");
                        } else {
                            System.out.println("Количество дней: " + dom[chislo - 1]);
                        }
                    } catch (InvalidYearException f) {
                        System.out.println("Некорректный год");
                    }
                } else {
                    System.out.println("Количество дней: " + dom[chislo - 1]);
                }
            }catch (InputMismatchException r) {
                System.out.println("Неверный тип данных!");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Недопустимое число.");
        }
    }
}
