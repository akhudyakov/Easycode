package HomeTask4_classes;

import java.sql.Date;
import java.util.Arrays;


/**
 * Created by adminnt on 15.01.17.
 */
public class MyInstitute {

        public static void main(String[] args) {


//            Student newStudent = new Student ("Ivanov", "Petr", "Sergeevich", Date(1973,11,25), "passport", "MK123456" );
            Student newStudent = new Student ("Ivanov", "Petr", "Sergeevich", Date.valueOf("1973-11-25"), "passport", "MK123456" );
            String d = newStudent.toString();
            System.out.println(d);


        }
}
