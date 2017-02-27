package HomeTaskInstituteOnList.entity;

/**
 * Created by Andrey on 15.02.2017.
 */
public enum Marks {
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    ELEVEN(11),
    TWELVE(12);

    private int mark;

    Marks(int mark) {
        this.mark = mark;
    }

    public int getMark() {
        return mark;
    }
}
