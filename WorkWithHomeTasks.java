package HomeTask4_classes;

/**
 * Created by adminnt on 17.01.17.
 */
public class WorkWithHomeTasks {

    public static int getAverageMarkByStudent(Student st) {
        int averageMark = 0; // initial value of average of mark
        int count = 0; // number of marks which are set
        int[][] array = Student.getListOfStudentTasksWithMarks(st);

        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array[i].length ; j++) {
            if (array[i][1] > 1) { //if mark is set it meas that mark is in range 2 - 12
                count++;
                averageMark += array[i][1];
            }

        }
        averageMark = averageMark / count;
        return averageMark;
    }
}
