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


    public HomeTask(String subjectOfHt, String headerOfHt, String textOfHt) {
        count ++;

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


    public String toString() {
        String result = "Home task with ID: " + getId() + " and its number: " + getNumberOfHt() + " has the  Subject: " + getSubjectOfHt() +
                "; the header is: " + getHeaderOfHt() + " and text is: " + getTextOfHt();
        return result;
    }



}
