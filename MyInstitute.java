package HomeTask4_classes;

import java.sql.Date;
import java.util.Arrays;


/**
 * Created by adminnt on 15.01.17.
 */
public class MyInstitute {

        public static void main(String[] args) {


//            Student newStudent1 = new Student ("Ivanov", "Petr", "Sergeevich", Date(1973,11,25), "passport", "MK123456" );
            Student newStudent1 = new Student ("Ivanov", "Petr", "Sergeevich", Date.valueOf("1973-11-25"), "passport", "MK123456" );
            //String d = newStudent1.toString();
            System.out.println(newStudent1.toString());
            Student newStudent2 = new Student ("Petrov", "Andriy", "Igorevich", Date.valueOf("1985-09-19"), "passport", "MH987654" );
            System.out.println(newStudent2.toString());

            Group newGroup1 = new Group(1, 3 , "7");

            newGroup1.addStudentToGroup(newGroup1.getIdGroup(), newStudent1);
            System.out.println(newGroup1.toString());
            System.out.println((newGroup1.getCountOfGroupMembers(newGroup1.getIdGroup())));

            newGroup1.addStudentToGroup(newGroup1.getIdGroup(), newStudent1); // negative. add existed Student 1
            newGroup1.addStudentToGroup(newGroup1.getIdGroup(), newStudent2); // positive. add second student


            System.out.println((newGroup1.getCountOfGroupMembers(newGroup1.getIdGroup())));
//            System.out.println(newGroup1.getIdOfStudent(0));
//            System.out.println(newGroup1.getIdOfStudent(1));
            newGroup1.listOfStudentsInTheGroup();
            System.out.println();

            HomeTask newHomeTask1 = new HomeTask("Subject1", "Header1", "Text1");
            System.out.println(newHomeTask1.toString());
            newStudent1.addHomeTaskToStudent(newHomeTask1);

            HomeTask newHomeTask2 = new HomeTask("Subject2", "Header2", "Text2");
            System.out.println(newHomeTask2.toString());
            newStudent2.addHomeTaskToStudent(newHomeTask2);

            HomeTask newHomeTask3 = new HomeTask("Subject3", "Header3", "Text3");
            System.out.println(newHomeTask3.toString());
            newStudent1.addHomeTaskToStudent(newHomeTask3);

//            Student.listOfStudentTasks(newStudent1);
            Student.setTaskMarkToStudentByNumberTask(newStudent1,2, 12);
            Student.setTaskMarkToStudentByNumberTask(newStudent1,3, 6);
            Student.listOfStudentTasksWithMarks(newStudent1);

            Student.listOfStudentTasks(newStudent1);
            Student.listOfStudentTasks(newStudent2);



        }
}
