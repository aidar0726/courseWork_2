package diary;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Diary {

    private String header;
    private String description;


    private Type diaryType;
    private Sign diarySing;


    private Integer sing;

    static private Integer id = 0;
    private LocalDate creationDate;

    private LocalTime creationTime;

    private LocalDate nextDiaryDate;

    public Diary(String header, String description, Type type, Sign sign) throws DiaryDataValidationException {
        this.header = validateString(header);
        this.description = validateString(description);
        diaryType = type;
        diarySing = sign;
        creationDate = LocalDate.now();
        creationTime = LocalTime.now();
        id = id + 1;
    }

    public String getHeader() {
        return header;
    }

    public String getDescription() {
        return description;
    }

    public Type getDiaryType() {
        return diaryType;
    }

    public Sign getDiarySing() {
        return diarySing;
    }

    public static Integer getId() {
        return id;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }


    public LocalTime getCreationTime() {
        return creationTime;
    }


    public String validateString(String value) throws DiaryDataValidationException {
        if (value == null || value.isBlank() || value.isEmpty()) {
            throw new DiaryDataValidationException("Введите корректные данные!");
        } else {
            return value;
        }
    }


    @Override
    public String toString() {
        return "Diary{" +
                "header='" + getHeader() + '\'' +
                ", description=" + getDescription() + '\'' +
                ", diaryType = " + getDiaryType() +
                ", diarySign = " + getDiarySing() +
                ", creationDate = '" + getCreationDate() + '\'' +
                ", creationTime = '" + getCreationTime() + '\'' +
                '}';
    }
}
