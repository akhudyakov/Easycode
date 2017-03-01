package com.easycode.institute;

import com.easycode.institute.domainobject.Group;
import com.easycode.institute.domainobject.HomeTask;
import com.easycode.institute.domainobject.Marks;
import com.easycode.institute.domainobject.Student;
import com.easycode.institute.store.GroupStore;
import com.easycode.institute.store.HomeTaskStore;
import com.easycode.institute.store.StudentsStore;

import java.sql.Date;


/**
 * Created by adminnt on 15.01.17.
 */
public class MyInstitute {

    public static void main(String[] args) {


        // adding new Students
        Student newStudent1 = new Student("Ivanov", "Petr", "Sergeevich", Date.valueOf("1973-11-25"), "passport", "MK123456");
        Student newStudent2 = new Student("Petrov", "Andriy", "Igorevich", Date.valueOf("1985-09-19"), "passport", "MH987654");
        Student newStudent3 = new Student("Sidorov", "Ivan", "Nikolaevich", Date.valueOf("1995-06-21"), "passport", "MC761254");
        Student newStudent4 = new Student("Aronov", "Nikolay", "Semenovich", Date.valueOf("2001-01-11"), "passport", "ME51298");

        // new Student Store1
        StudentsStore studentsStore1 = new StudentsStore();
        // adding Students to the Store1
        studentsStore1.addStudentToStore(newStudent1);
        studentsStore1.addStudentToStore(newStudent2);
        studentsStore1.addStudentToStore(newStudent3);
        studentsStore1.addStudentToStore(newStudent4);

        //create Store of Groups
        GroupStore groupStore1 = new GroupStore();

        // adding new Groups
        Group newGroup1 = new Group(1, 3, "7");
        Group newGroup2 = new Group(1, 3, "8");

        groupStore1.addGroupToStore(newGroup1);
        groupStore1.addGroupToStore(newGroup1); //negative
        groupStore1.addGroupToStore(newGroup2);



        // adding Students:1,2,3 to Group1
        newGroup1.addStudentToGroup(newStudent1);
        newGroup1.addStudentToGroup(newStudent1); // negative. add existed Student 1
        newGroup1.addStudentToGroup(newStudent2);
        newGroup1.addStudentToGroup(newStudent3);
        // adding Student4 to Group2
        newGroup2.addStudentToGroup(newStudent4);

        /**
         *  First Group print by method with Iterator
         */
        System.out.println("\nFirst Group print by method with Iterator");
        newGroup1.printListOfStudentsInTheGroup();

        /**
         *  Second Group print by method with Foreach
         */

        System.out.println("\nSecond Group print by method with Foreach");
        for (Student s: newGroup1) {
            System.out.println("s = " + s);
        }


        HomeTaskStore storeOfHomeTasks = new HomeTaskStore();

        HomeTask newHomeTask1 = new HomeTask("Subject1", "Header1", "Text1");
        // add hometask1 to Home Task store
        storeOfHomeTasks.addHomeTask(newHomeTask1);

        newStudent1.addHomeTaskToStudentWithoutMark(newHomeTask1); // adding only a HomeTask
        newStudent1.addHomeTaskToStudentWithMark(newHomeTask1, Marks.SEVEN); // set a Mark for the HomeTask (the Hometask had already been added)


        HomeTask newHomeTask2 = new HomeTask("Subject2", "Header2", "Text2");
        // add hometask2 to Home Task store
        storeOfHomeTasks.addHomeTask(newHomeTask2);

        newStudent1.setMarkToHomeTask(newHomeTask2, Marks.ELEVEN); // negative case (student newStudent1 does not have the task newHomeTask2)
        newStudent1.addHomeTaskToStudentWithoutMark(newHomeTask2);
        newStudent1.setMarkToHomeTask(newHomeTask2, Marks.ELEVEN);

        HomeTask newHomeTask3 = new HomeTask("Subject3", "Header3", "Text3");
        // add hometask3 to Home Task store
        storeOfHomeTasks.addHomeTask(newHomeTask3);
        newStudent3.addHomeTaskToStudentWithMark(newHomeTask3, Marks.NINE);

        HomeTask newHomeTask4 = new HomeTask("Subject4", "Header4", "Text4");
        // add hometask4 to Home Task store
        storeOfHomeTasks.addHomeTask(newHomeTask2); // negative - hometask2 already exists in store
        storeOfHomeTasks.addHomeTask(newHomeTask4); // positive

//        storeOfHomeTasks.printAllHomeTasks();
        newStudent1.addHomeTaskToStudentWithMark(newHomeTask4, Marks.SIX);



        HomeTask newHomeTask5 = new HomeTask("Subject5", "Header5", "Text5");
        storeOfHomeTasks.addHomeTask(newHomeTask5); 
        HomeTask newHomeTask6 = new HomeTask("Subject6", "Header6", "Text6");
        storeOfHomeTasks.addHomeTask(newHomeTask6); 
        HomeTask newHomeTask7 = new HomeTask("Subject5", "Header7", "Text7");
        storeOfHomeTasks.addHomeTask(newHomeTask7); 

        newStudent2.addHomeTaskToStudentWithMark(newHomeTask5, Marks.NINE);
        newStudent2.addHomeTaskToStudentWithMark(newHomeTask6, Marks.TEN);
        newStudent2.addHomeTaskToStudentWithMark(newHomeTask7, Marks.ELEVEN);


        newStudent1.printListOfStudentTasksWithMarks();
        newStudent2.printListOfStudentTasksWithMarks();
        newStudent3.printListOfStudentTasksWithMarks();


        System.out.println("-----------------------------");
        System.out.println("Leave the institute " + newStudent3);

        newStudent3.leaveInstitute();
        System.out.println(newGroup1.getArrayWithStudents());
        System.out.println(studentsStore1);

        System.out.println("-----------------------------");

        System.out.println(studentsStore1);
        System.out.println(storeOfHomeTasks);
        newStudent1.printListOfStudentTasks();
        newStudent3.printListOfStudentTasksWithMarks();

/*
       System.out.println();

       System.out.println("Student1 has average mark: " + WorkWithHomeTasks.getAverageMarkByStudent(newStudent1));
       System.out.println("Student2 has average mark: " + WorkWithHomeTasks.getAverageMarkByStudent(newStudent2));
       System.out.println("Student3 has average mark: " + WorkWithHomeTasks.getAverageMarkByStudent(newStudent3));

        System.out.println();

        WorkWithHomeTasks.getWorstStudentInTheGroup(newGroup1);
//        WorkWithHomeTasks.getBestStudentInTheGroup(newGroup1);


        //Recursion
        Student[] empty = new Student[0];
//        Student[] arrayAfterRecursion = WorkWithHomeTasks.GetStudentArrayWithMarkMoreThanValue(empty, Group.getArrayOfStudentsInTheGroup(newGroup1), 9);
//        System.out.println("\n Result of factorial's work");
//        System.out.println(Arrays.toString(arrayAfterRecursion));

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
*/
    }
}
