package HomeTask4_classes;

import java.util.UUID;

/**
 * Created by Andrey on 16.01.2017.
 */
public class HomeTask {
    private UUID id;
    private String subjectOfHt;
    private int numberOfHt;
    private String headerOfHt;
    private String textOfHt;
    private static int count;

    private final static int minMark = 2;
    private final static int maxMark = 12;


    public HomeTask(String subjectOfHt, String headerOfHt, String textOfHt) {
        count++;

        this.id = UUID.randomUUID();
        this.numberOfHt = count;
        this.subjectOfHt = subjectOfHt;
        this.headerOfHt = headerOfHt;
        this.textOfHt = textOfHt;
    }

    public UUID getId() {
        return id;
    }

    public String getSubjectOfHt() {
        return subjectOfHt;
    }

    public int getNumberOfHt() {
        return numberOfHt;
    }

    public String getHeaderOfHt() {
        return headerOfHt;
    }

    public String getTextOfHt() {
        return textOfHt;
    }

    public static int getMinMark() {
        return minMark;
    }

    public static int getMaxMark() {
        return maxMark;
    }

    public String toString() {
        String result = "Home task with ID: " + getId() + " and its number: " + getNumberOfHt() + " has the  Subject: " + getSubjectOfHt() +
                "; the header is: " + getHeaderOfHt() + " and text is: " + getTextOfHt();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this instanceof Object) return true;
        if (this.getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return false;

        HomeTask ht = (HomeTask) o;
        if (this.id != ht.id) return false;
        if (this.subjectOfHt != ht.subjectOfHt) return false;
        if (this.headerOfHt != ht.headerOfHt) return false;
        if (this.textOfHt != ht.textOfHt) return false;
        if (this.numberOfHt != ht.numberOfHt) return false;

        return true;
    }
}
