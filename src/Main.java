import diary.Diary;
import diary.DiaryDataValidationException;
import diary.Sign;
import diary.Type;
import diary.DiaryService;

import java.util.Scanner;

import static diary.DiaryService.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner);
                            break;
                        case 2:
                            showMapDiary();
                            System.out.print("Введите порядковый номер для удаления задачи: ");
                            Integer diaryDeleteId = scanner.nextInt();
                            deleteDiary(diaryDeleteId);
                            break;

                        case 3:
                            System.out.print("Введите год ");
                            Integer year = scanner.nextInt();
                            System.out.print("Введите месяц ");
                            Integer month = scanner.nextInt();
                            System.out.print("Введите день ");
                            Integer day = scanner.nextInt();
                            showDiarySpecifiedDay(year, month, day);
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }

    private static void inputTask(Scanner scanner) {
        System.out.print("Введите название задачи: ");
        String taskName = scanner.next();
        System.out.print("Введите описание задачи: ");
        String taskDescription = scanner.next();
        System.out.print("Введите тип задачи: 1.Рабочая 2.Личная : ");
        Integer diaryType = scanner.nextInt();
        System.out.print("Введите очередность задачи: 1.Однократная 2.Ежедневная 3.Еженедельная 4.Ежемесячная 5.Ежегодная: ");
        Integer diarySign = scanner.nextInt();

        try {
            Diary diary = new Diary(taskName, taskDescription, inputDiaryType(diaryType), inputDiarySign(diarySign));
            addDiary(diary);
            System.out.print("Задача успешно добавлена ");
            showMapDiary();
        } catch (DiaryDataValidationException e) {
            e.printStackTrace();
        }

    }

    public static Type inputDiaryType(Integer value) {

        switch (value) {
            case 1:
                return Type.WORKING;
            case 2:
                return Type.PERSONAL;
        }

        return Type.WORKING; //возвращает по умолчнанию рабочую заметку

    }

    public static Sign inputDiarySign(Integer value) {

        switch (value) {
            case 1:
                return Sign.SINGLE;
            case 2:
                return Sign.DAILY;
            case 3:
                return Sign.WEEKLY;
            case 4:
                return Sign.MONTHLY;
            case 5:
                return Sign.ANNUAL;
        }

        return Sign.SINGLE; //возвращает по умолчнанию одноктратную заметку

    }


    private static void printMenu() {
        System.out.println(
                "1. Добавить задачу " +
                        "2. Удалить задачу " +
                        "3. Вывести задачи на указанную дату ");
    }

}