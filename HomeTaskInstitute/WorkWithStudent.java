package HomeTaskInstitute;

/**
 * Created by Andrey on 26.01.2017.
 */
public class WorkWithStudent {

    public static String getStudentFullNameByStudent(Student st) {
        String result = st.getLastName() + " " + st.getFisrtName() + " " + st.getMiddleName();
        return result;
    }
}
