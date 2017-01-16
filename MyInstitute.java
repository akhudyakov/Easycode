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
            String d = newStudent1.toString();
            System.out.println(d);

            Group newGroup = new Group(1, 3 , "7");
            newGroup.addStudentToGroup(newGroup.getIdGroup(), newStudent1.getId());
            System.out.println(newGroup.toString());
            System.out.println((newGroup.getCountOfGroupMembers(newGroup.getIdGroup())));

        }
}
