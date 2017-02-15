package HomeTaskInstituteOldOnArrays;


import java.util.Arrays;

/**
 * Created by adminnt on 17.01.17.
 */

public class WorkWithHomeTasks {

    public static double getAverageMarkByStudent(Student st) {
        double averageMark = 0; // initial value of average of mark
        int count = 0; // number of marks which are set
        HomeTask[] arrHT = st.getArrayOfHt();

        HomeTask tempTask;
        int mark;

        for (int i = 0; i < arrHT.length; i++) {
//            for (int j = 0; j < array[i].length ; j++) {
            tempTask = arrHT[i]; //each task for the student
            mark = tempTask.getMark(); // mark for specific task
            if (mark >=  2) { //if mark is set it meas that mark is in range 2 - 12
                count++;
                averageMark += mark; // general sum (not average))
            }

        }
        if (averageMark >= 2) {
            averageMark = averageMark / count; //average
        } else {
            averageMark = 0;
        }
        return averageMark;
    }

    public static void getWorstStudentInTheGroup(Group gr) {

        double[][] studentWithAverageMark = new double[gr.getCountOfGroupMembers()][2];
        double averageMark;
        double numberStudent = -1;

        Student studentTemp;

        Student[] arrayStudentInGroup = Group.getArrayOfStudentsInTheGroup(gr);
        for (int i = 0; i < arrayStudentInGroup.length; i++) {
            studentTemp = arrayStudentInGroup[i];
            averageMark = getAverageMarkByStudent(studentTemp);

            studentWithAverageMark[i][0] = studentTemp.getNumberStudent();
            studentWithAverageMark[i][1] = averageMark;
        }
        numberStudent = studentWithAverageMark[getPositionOfMinInTwoDimArray(studentWithAverageMark)] [0];
        averageMark = studentWithAverageMark[getPositionOfMinInTwoDimArray(studentWithAverageMark)] [1];
        System.out.println("The worst student is a student with number: " + (int)numberStudent + " with average mark: " + averageMark);
    }

    public static void getBestStudentInTheGroup(Group gr) {

        double[][] studentWithAverageMark = new double[gr.getCountOfGroupMembers()][2];
        double averageMark;
        double numberStudent = -1;

        Student studentTemp;

        Student[] arrayStudentInGroup = Group.getArrayOfStudentsInTheGroup(gr);
        for (int i = 0; i < arrayStudentInGroup.length; i++) {
            studentTemp = arrayStudentInGroup[i];
            averageMark = getAverageMarkByStudent(studentTemp);

            studentWithAverageMark[i][0] = studentTemp.getNumberStudent();
            studentWithAverageMark[i][1] = averageMark;
        }
        numberStudent = studentWithAverageMark[getPositionOfMaxInTwoDimArray(studentWithAverageMark)] [0];
        averageMark = studentWithAverageMark[getPositionOfMaxInTwoDimArray(studentWithAverageMark)] [1];
        System.out.println("The best student is a student with number: " + (int)numberStudent + " with average mark: " + averageMark);
    }




    public static int getPositionOfMinInTwoDimArray (double[][] arr){
        double min = arr [0][1]; //average mark value
        int position = 0;

        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i] [1] ) {
                min = arr[i] [1];
                position = i;
            }
        }
        return position;
    }

    public static int getPositionOfMaxInTwoDimArray (double[][] arr){
        double max = arr [0][1]; //average mark value
        int position = 0;

        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i] [1] ) {
                max = arr[i] [1];
                position = i;
            }
        }
        return position;
    }


//    public static Student [] GetStudentArrayWithMarkMoreThanValue (Student [] emptyArr, Student[] studentArr, double value) {
//
//
//        int i = emptyArr.length;
//        if (i == studentArr.length) {
//            return emptyArr;
//        } else {
//            double averageMark = getAverageMarkByStudent(studentArr[i]);
//            if (averageMark > value) {
//                emptyArr = Arrays.copyOf(emptyArr, i+1);
//                emptyArr[i] = studentArr[i];
//            }
//        }
//        return GetStudentArrayWithMarkMoreThanValue(emptyArr, studentArr, value); // , Student studentArr, double value);
//    }

    public static Student [] GetStudentArrayWithMarkMoreThanValue (Student [] emptyArr, Student[] studentArr, double value) {


        int i = studentArr.length;
        int z = emptyArr.length;

        if (i == 0) {
            return emptyArr;
        } else {
            double averageMark = getAverageMarkByStudent(studentArr[i - 1]);
            if (averageMark > value) {
                emptyArr = Arrays.copyOf(emptyArr, z+1);
                emptyArr[z] = studentArr[i - 1];
            }
            studentArr = Arrays.copyOf(studentArr, i-1);
        }
        return GetStudentArrayWithMarkMoreThanValue(emptyArr, studentArr, value); // , Student studentArr, double value);
    }



}




