package com.easycode.institute.domainobject;

import com.easycode.institute.store.HomeTaskStore;

import java.util.UUID;

/**
 * Created by Andrey on 16.01.2017.
 */
public class HomeTask {
    private UUID id;
    private HomeTaskStore homeTaskStore;
    private String subjectOfHt;
    private int numberOfHt;
    private String headerOfHt;
    private String textOfHt;
    private static int count;

    public HomeTask(String subjectOfHt, String headerOfHt, String textOfHt) {
        this.id = UUID.randomUUID();
        this.numberOfHt = count++;
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

    public int getNumberOfHt() { return numberOfHt;  }

    public String getHeaderOfHt() {
        return headerOfHt;
    }

    public String getTextOfHt() {
        return textOfHt;
    }

    public HomeTaskStore getHomeTaskStore() { return homeTaskStore;  }

    public static int getCount() { return count;  }

    public void setHomeTaskStore(HomeTaskStore homeTaskStore) { this.homeTaskStore = homeTaskStore; }

    public void setSubjectOfHt(String subjectOfHt) {  this.subjectOfHt = subjectOfHt;    }

    public void setNumberOfHt(int numberOfHt) {     this.numberOfHt = numberOfHt;    }

    public void setHeaderOfHt(String headerOfHt) {     this.headerOfHt = headerOfHt;    }

    public void setTextOfHt(String textOfHt) {        this.textOfHt = textOfHt;    }

    public String toString() {
        String result = "Home task with number: " + getNumberOfHt() + " with the  Subject: " + getSubjectOfHt() +
                "; the header is: " + getHeaderOfHt() + " and text is: " + getTextOfHt();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(this instanceof Object)) return false;
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

/*
    public int getMark() {
        return mark.getMark();

    }

    public static int getMarkOfHomeTask(HomeTask ht) {
        int mark = ht.getMark();
        return mark;
    }

    public void setMarkToHomeTask(Marks mark) {
        this.mark = mark;
    }
*/
}

