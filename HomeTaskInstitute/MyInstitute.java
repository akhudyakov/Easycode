package HomeTaskInstitute;

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
        Student newStudent4 = new Student("Aronov", "Nikolay", "Semenovich", Date.valueOf("2001-01-11"), "passport", "ME51298");

        Group newGroup1 = new Group(1, 3, "7");
        Group newGroup2 = new Group(1, 3, "8");

        newGroup1.addStudentToGroup(newStudent1);
//      newGroup1.addStudentToGroup(newStudent1); // negative. add existed Student 1
        newGroup1.addStudentToGroup(newStudent2); // positive. add second student
        newGroup1.addStudentToGroup(newStudent3);

        newGroup2.addStudentToGroup(newStudent4);

//        newGroup1.printListOfStudentsInTheGroup();
//        newGroup2.printListOfStudentsInTheGroup();


        HomeTask newHomeTask1 = new HomeTask("Subject1", "Header1", "Text1");

        newStudent1.addHomeTaskToStudent(newHomeTask1);

        HomeTask newHomeTask2 = new HomeTask("Subject2", "Header2", "Text2");

        newStudent2.addHomeTaskToStudent(newHomeTask2);

        HomeTask newHomeTask3 = new HomeTask("Subject3", "Header3", "Text3");

        newStudent1.addHomeTaskToStudent(newHomeTask3);


        newHomeTask1.setMarkToHomeTask(12);
        newHomeTask3.setMarkToHomeTask(6);


        HomeTask newHomeTask4 = new HomeTask("Subject4", "Header4", "Text4");

        newStudent1.addHomeTaskToStudent(newHomeTask4);
        newHomeTask4.setMarkToHomeTask(4);


        HomeTask newHomeTask5 = new HomeTask("Subject5", "Header5", "Text5");
        HomeTask newHomeTask6 = new HomeTask("Subject6", "Header6", "Text6");
        HomeTask newHomeTask7 = new HomeTask("Subject5", "Header7", "Text7");

        newStudent2.addHomeTaskToStudent(newHomeTask5);
        newStudent2.addHomeTaskToStudent(newHomeTask7);
        newStudent3.addHomeTaskToStudent(newHomeTask6);

        System.out.println();


        newHomeTask2.setMarkToHomeTask(8);
        newHomeTask5.setMarkToHomeTask(9);
        newHomeTask7.setMarkToHomeTask(10);
        newHomeTask6.setMarkToHomeTask(11);

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


        //Recursion
        Student  [] empty = new Student[0];
        Student [] arrayAfterRecursion = WorkWithHomeTasks.GetStudentArrayWithMarkMoreThanValue(empty, Group.getArrayOfStudentsInTheGroup(newGroup1), 9);
        System.out.println("\n Result of factorial's work");
        System.out.println(Arrays.toString(arrayAfterRecursion));

        Teacher Teacher1 = new Teacher("Prepod1", "Petr", "Sergeevich", Date.valueOf("1965-10-23"), "passport", "MC523784");
        Teacher Teacher2 = new Teacher("Prepod2", "Alex", "Artemovich", Date.valueOf("1965-05-22"), "passport", "MB823712");
        Teacher Teacher3 = new Teacher("Prepod3", "Andrey", "Igorevich", Date.valueOf("1952-02-22"), "passport", "MB333754");
        Teacher Teacher4 = new Teacher("Prepod4", "Andrey", "Evgenievich", Date.valueOf("1942-06-23"), "passport", "MH712547");

        System.out.println();

        System.out.println("Array with teachers before Teacher3 has left the Institute");
        System.out.println(Arrays.deepToString(Teacher.getArrayOfAllTeachers()));
        Teacher3.leaveInstitute();
        System.out.println("Array with teachers after Teacher3 has left the Institute");
        System.out.println(Arrays.deepToString(Teacher.getArrayOfAllTeachers()));


        System.out.println();
        System.out.println("List of Sudents before Leave");
        newGroup1.printListOfStudentsInTheGroup();
        newStudent2.leaveInstitute();
        System.out.println("\n List of Sudents after Leave");
        newGroup1.printListOfStudentsInTheGroup();

    }
}
