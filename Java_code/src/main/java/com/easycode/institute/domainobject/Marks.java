package com.easycode.institute.domainobject;

/**
 * Created by Andrey on 15.02.2017.
 */
public enum Marks {
    A(5),
    B(4),
    C(4),
    D(3),
    E(3),
    FX(2),
    F(2);

    private int mark;

    Marks(int mark) {
        this.mark = mark;
    }

    public int getMark() {
        return mark;
    }

    public static int getIntMarkByBolonMark(Marks m) {
        int intMark;
        switch (m) {
            case A:
                intMark = 5;
                break;
            case B:
                intMark = 4;
                break;
            case C:
                intMark = 4;
                break;
            case D:
                intMark = 3;
                break;
            case E:
                intMark = 3;
                break;
            case FX:
                intMark = 2;
                break;
            default:
                intMark = 2;
                break;
        }
        return intMark;
    }
}
