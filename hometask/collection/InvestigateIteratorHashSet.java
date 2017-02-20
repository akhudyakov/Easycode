package hometask.collection;

import HomeTaskInstituteOnList.Student;
import lesson8.Holiday;

import java.sql.Date;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Andrey on 14.02.2017.
 *
 *    IT IS NOT HOME TASK
 *
 */
public class InvestigateIteratorHashSet {
    public static void main(String[] args) {
        HashSet<Student> studentHashSet = new HashSet<>();
        Student newStudent1 = new Student("Ivanov", "Petr", "Sergeevich", Date.valueOf("1973-11-25"), "passport", "MK123456");

        Student newStudent2 = new Student("Petrov", "Andriy", "Igorevich", Date.valueOf("1985-09-19"), "passport", "MH987654");
        Student newStudent3 = new Student("Sidorov", "Ivan", "Nikolaevich", Date.valueOf("1995-06-21"), "passport", "MC761254");
        Student newStudent4 = new Student("Aronov", "Nikolay", "Semenovich", Date.valueOf("2001-01-11"), "passport", "ME51298");


        studentHashSet.add(newStudent1);
        studentHashSet.add(newStudent2);
        studentHashSet.add(newStudent3);
        studentHashSet.add(newStudent4);


//        Iterator<Student> studentIterator = studentHashSet.iterator();
        Iterator<Student> studentIterator = studentHashSet.iterator();


        System.out.println(studentIterator.next());
        System.out.println(studentIterator.next());

        studentHashSet.remove(newStudent1);
        System.out.println(studentIterator.next());


    }




}
