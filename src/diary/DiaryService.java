package diary;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DiaryService {

    static Map<Integer, Diary> mapDiary = new HashMap<>();


    public static void addDiary(Diary diary) {
        mapDiary.put(diary.getId(), diary);
    }

    public static void showMapDiary() {
        for (Map.Entry<Integer, Diary> entry : mapDiary.entrySet())
            System.out.println(entry.getKey() + " - " + entry.getValue());
    }

    public static void deleteDiary(Integer key) {
        if (mapDiary.containsKey(key)) {
            mapDiary.remove(key);
            System.out.print("Задача с номером :" + key + " успешно удалена!  ");
        } else {
            System.out.print("Задача с номером :" + key + " не найдена!  ");
        }
    }


    public static void showDiarySpecifiedDay(Integer year, Integer month, Integer day) {
        LocalDate specificDate = LocalDate.of(year, month, day);

        for (Map.Entry<Integer, Diary> entry : mapDiary.entrySet()) {
            if (returnPresenceDate(specificDate, entry.getValue().getDiarySing(), entry.getValue().getCreationDate())) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            } else {
                System.out.print("На указанную дату " + specificDate + " задач не найдено!");
            }
        }

    }

    public static Boolean returnPresenceDate(LocalDate date, Sign sign, LocalDate createdDate) {
        if (sign == Sign.SINGLE) {
            if (date.equals(createdDate.plusDays(1))) {
                return true;
            }

        }
        if (sign == Sign.DAILY) {
            for (int i = 0; i < 365; i++) {
                if (date.equals(createdDate.plusDays(i))) {
                    return true;
                }

            }
        }
        if (sign == Sign.WEEKLY) {
            for (int i = 0; i < 52; i++) {
                if (date.equals(createdDate.plusWeeks(i))) {
                    return true;
                }
            }
        }
        if (sign == Sign.MONTHLY) {
            for (int i = 0; i < 12; i++) {
                if (date.equals(createdDate.plusWeeks(i))) {
                    return true;
                }
            }
        }
        if (sign == Sign.ANNUAL) {
            if (date.equals(createdDate.plusYears(1))) {
                return true;
            }
        }

        return false;

    }

}
