package HomeTask4_classes;

import java.sql.Date;
import java.util.Arrays;


/**
 * Created by adminnt on 15.01.17.
 */
public class MyInstitute {

    public static void main(String[] args) {



        Student newStudent1 = new Student("Ivanov", "Petr", "Sergeevich", Date.valueOf("1973-11-25"), "passport", "MK123456");

        Student newStudent2 = new Student("Petrov", "Andriy", "Igorevich", Date.valueOf("1985-09-19"), "passport", "MH987654");
        Student newStudent3 = new Student("Sidorov", "Ivan", "Nikolaevich", Date.valueOf("1995-06-21"), "passport", "MC761254");


        Group newGroup1 = new Group(1, 3, "7");

        newGroup1.addStudentToGroup(newStudent1);



//      newGroup1.addStudentToGroup(newStudent1); // negative. add existed Student 1
        newGroup1.addStudentToGroup(newStudent2); // positive. add second student

        newGroup1.addStudentToGroup(newStudent3);



//        newGroup1.printListOfStudentsInTheGroup();


        HomeTask newHomeTask1 = new HomeTask("Subject1", "Header1", "Text1");

        newStudent1.addHomeTaskToStudent(newHomeTask1);

        HomeTask newHomeTask2 = new HomeTask("Subject2", "Header2", "Text2");

        newStudent2.addHomeTaskToStudent(newHomeTask2);

        HomeTask newHomeTask3 = new HomeTask("Subject3", "Header3", "Text3");

        newStudent1.addHomeTaskToStudent(newHomeTask3);

        Student.setTaskMarkToStudentByNumberTask(newStudent1, 1, 12);
        Student.setTaskMarkToStudentByNumberTask(newStudent1, 3, 6);


        HomeTask newHomeTask4 = new HomeTask("Subject4", "Header4", "Text4");

        newStudent1.addHomeTaskToStudent(newHomeTask4);
        Student.setTaskMarkToStudentByNumberTask(newStudent1, 4, 4);


        HomeTask newHomeTask5 = new HomeTask("Subject5", "Header5", "Text5");
        HomeTask newHomeTask6 = new HomeTask("Subject6", "Header6", "Text6");
        HomeTask newHomeTask7 = new HomeTask("Subject5", "Header7", "Text7");

        newStudent2.addHomeTaskToStudent(newHomeTask5);
        newStudent2.addHomeTaskToStudent(newHomeTask7);
        newStudent3.addHomeTaskToStudent(newHomeTask6);

        System.out.println();

        Student.setTaskMarkToStudentByNumberTask(newStudent2, 2, 8);
        Student.setTaskMarkToStudentByNumberTask(newStudent2, 5, 9);
        Student.setTaskMarkToStudentByNumberTask(newStudent2, 7, 10);


        Student.setTaskMarkToStudentByNumberTask(newStudent3, 6, 11);

        System.out.println();


        Student.printListOfStudentTasksWithMarks(newStudent1);
        Student.printListOfStudentTasksWithMarks(newStudent2);
        Student.printListOfStudentTasksWithMarks(newStudent3);

       System.out.println();

       System.out.println("Student1 has average mark: " + WorkWithHomeTasks.getAverageMarkByStudent(newStudent1));
       System.out.println("Student2 has average mark: " + WorkWithHomeTasks.getAverageMarkByStudent(newStudent2));
       System.out.println("Student3 has average mark: " + WorkWithHomeTasks.getAverageMarkByStudent(newStudent3));

        System.out.println();

        WorkWithHomeTasks.getWorstStudentInTheGroup(newGroup1);
        WorkWithHomeTasks.getBestStudentInTheGroup(newGroup1);


        //Factorial
        Student  [] empty = new Student[0];
        Student [] arrayAfterRecursion = WorkWithHomeTasks.GetStudentArrayWithMarkMoreThanValue(empty, Group.getArrayOfStudentsNumbersInTheGroup(newGroup1), 9);
        System.out.println("\n Result of factorial's work");
        System.out.println(Arrays.toString(arrayAfterRecursion));
    }
}
