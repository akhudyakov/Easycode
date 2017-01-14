package HomeTask_3;//package com.company;


import java.io.IOException;
import java.util.Arrays;

import static java.lang.String.valueOf;

public class Home3 {
    public static void main(String[] args) throws
            IOException {


        // Fill out main and opposite diagonals of array by 5




        // поменять местами єлементы массива  (инвертировать) через 1/2 длины массива

        System.out.println(" Invertion of array {1,2,3,4,5,6,7,8,9} ");

        int[] intArray;
        intArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        for (int i = 0; i < (intArray.length / 2 - 1); i++) {
            int curr = intArray[i];
            int curr2 = intArray[intArray.length - 1 - i];
            intArray[intArray.length - 1 - i] = curr;
            intArray[i] = curr2;

        }
        System.out.println(Arrays.toString(intArray));

        // Fill out main and opposite diagonals of array by 5

        System.out.println("\n Fill out main and opposite diagonals of array by 5");
        fillMainAndOpositediagonalOfArray();
        System.out.println();


        //  Origin Array

        //int originArray[] = {-9,  26, -3, 5, 12, -30,  17, -20, 6 }; // 9 items without 0
        int originArray[] = {-9, 0, 26, -3, 5, 12, -30, 0, 17, -20, 6, 0}; // 12 items

        // Calculate negative items of the origin array

        System.out.println("\n **** Calculate a sum of negative items of the origin array. Expected: -62 ****");
        int sumNegativeItems = calculateSumOfNegativeItemsofArray(originArray);

        System.out.println("\n Calculation a sum of negative items of the origin array = " + sumNegativeItems);


        // Calculate multiplication of items of the origin array which are located between Min and Max

        System.out.println("\n **** Calculate  multiplication of items of the origin array which are located between Min and Max. Expected: -180 ****");

        int multiple = ItemsofArrayBetweenMinAndMax(originArray);
        System.out.println("\n Calculation of multiplication of items of the origin array which are located between Min and Max = " + multiple); // - 180

        // Calculate multiplication of array's even members

        int multipleEvenMembers = 1;

        for (int e = 0; e < originArray.length; e++) {
            multipleEvenMembers = multipleEvenMembers * originArray[e];
            e = e + 1;
        }
        System.out.println("\n Calculation  multiplication of array's even members = " + multipleEvenMembers + " Expected: 3580200");


        // Calculate sum of array's item which are between first and last zero items
        findFirstAndLastPositionOfZero(originArray);

        // Sort array: first are positive and zeros, after negative items without sorting of the array
        int[] resultSortArray = sortArrayFirstPositiveItems(originArray);

        System.out.println("\n *****  Sorting of  array: first are positive and zeros, after negative items without sorting of the array ****");
        System.out.println("Result is: " + Arrays.toString(resultSortArray) + ". Expected: 0, 26, 5, 12, 0, 17, 6, 0, -9, -3, -30, -20] ");

        // return Max item of the array
        int maxItem = maxItemOfArray(originArray);
        System.out.println("\n ****   Max item of the array is = " + maxItem + ". Expected: 26");


        // Calculate a sum of array's items up to last positive item
        System.out.println("\n **** Calculate a sum of array's items up to last positive item ****");
        int lastPositivePosition = -1;


        for (int count = 0; count < originArray.length; count++) {
            if (originArray[count] > 0) {
                lastPositivePosition = count; // remember positions of positive items
            }
        }

        if (lastPositivePosition == -1) {
            System.out.println(" There is no positive items in the array  ");
        } else if (lastPositivePosition == 0) {
            System.out.println(" There is only 1 positive item in the array  in first position and sum = " + originArray[0]);
        } else {
            int sumUpToLastPositive = calculateSumOfArrayItemsBetweenFirstAndLstPositions(originArray, 0, lastPositivePosition);
            System.out.println(" Calculation of  a sum of array's items up to last positive item = " + sumUpToLastPositive + ". Expected: 4");
        }

        //Compress the array by removing digits belong to range Math.abs[10,20] including that values
        // Items that have removed should be replaced by value [0]

        int startRange = 10;
        //
        int endRange = 20;

        int replaceValue = 0;

        int[] newCopyArr = Arrays.copyOf(originArray, originArray.length); // work with another array

        newCopyArr = compressArrayInRange(newCopyArr, startRange, endRange, replaceValue);
        System.out.println("\n Compress the array by removing digits belong to range Math.abs[10,20] including that values: " + Arrays.toString(newCopyArr));
        System.out.println(" Expected: [-9, 0, 26, -3, 5, -30, 0, 6, 0, 0, 0, 0] ");


        // return Min item of the array
        int minItem = minItemOfArray(originArray);
        System.out.println("\n ****   Min item of the array is = " + minItem + ". Expected: -30 ****");


        // Calculate sum of Math.abs of array's items after First 0

        int findValue = 0;

        int firstPositionValue = findFirstPositionOfItemInArray(originArray, findValue);
        int sumModulesOfItemAfterFirstZero = calculateSumModulesOfItems(originArray, firstPositionValue + 1);

        if (sumModulesOfItemAfterFirstZero > 0) {
            System.out.println("\n **** Sum of items' modules after first " + findValue + " = " + sumModulesOfItemAfterFirstZero + ". Expected: 119");
        } else {
            System.out.println("\n There is no value " + findValue + " in the array to calculate sum of items' modules after " + findValue);
        }

        // Create an array from origin array next way:
        // even members are in the start of an array
        // odd members are in the end of the array

        int[] newEvenOddArray = Arrays.copyOf(originArray, originArray.length); // do not use origin array

        newEvenOddArray = getArrayEvenMemeberFirst(newEvenOddArray);
        System.out.println(" New array with First members are Even: " + Arrays.toString(newEvenOddArray) + ". Expected {-9, 26, 5, -30, 17, 6, 0, -3, 12, 0, -20, 0 } ");



        // Two sized array
        System.out.println("\n **************   Two-dimensional arrays  ******************* \n");

        int originTwoArray[][] = {{10, 0, -6, 33, 33, -60, 4},
                                 {-19, 73, 73, 73, 0, -55, 1},
                                 {2, 7, -42, 10, 18, 8, -12},
                                 {0, 13, -22, 11, 88, 15, -1},
                                 {9, 60, 4, -5, 6, 63, 28},
                                 {3, 5, 5, 5, 5, 18, -1},
                                 {8, -13, 44, -2, 9, 14, 17}};
        // array with unique items
        /* int originTwoArray[][] = {{10, 0, -6, 33, 99, -60, 140},
                                  {-19, 73, 98, 97, -4, -55, 1},
                                  {-2, 7, -42, 91, 18, 8, -12},
                                  {-20, -133, -22, 11, 88, 15, -1},
                                  {9, 60, 4, -5, 6, 63, 28},
                                  {3, 92, 89, 95, 94, 93, -92},
                                  {-61, -13, 44, -27, 90, 14, 17}};*/


        // Get number of rows without some value

        int withoutSomeValue = 0;

        int numberRowsWithoutValue = getNumberOfRowsWithoutSomeValue(originTwoArray, withoutSomeValue);

        System.out.println("\n *** Number of rows without the value " + withoutSomeValue + " equals = " + numberRowsWithoutValue + " rows *** ");



        // Find Max item of an array which meets more than 1 time


        int countMeetOfMaxInArray = 0; // number of times which specific Max item  encountered

        int countNotSuitableMax = 0; // number of Max items which meets 1 time during the search of suitable Max item

        int maxItemInArray = maxItemOfArray(originTwoArray); // find Max item

        int minItemInArray = minItemOfArray(originTwoArray); // find Min item to compare with it all items to find Max item
                                                             // otherwise we can find Max item  not more than [0,0]
                                                             // if we compare with it

        int [] maxItemsArray = new int [originTwoArray.length * originTwoArray.length ]; // array for storing Max items which are not suitable (only 1 times encountered)

        while (countMeetOfMaxInArray  <=  1 & countNotSuitableMax < originTwoArray.length * originTwoArray.length ) {

            countMeetOfMaxInArray = getCountOfNumberSomeValueMeets(originTwoArray, maxItemInArray);

            if (countMeetOfMaxInArray < 2) {

                maxItemsArray[countNotSuitableMax] = maxItemInArray;
                countNotSuitableMax++;
                maxItemInArray = maxItemOfArrayWithExcluding(originTwoArray, maxItemsArray, countNotSuitableMax, minItemInArray); // exclude items which are in array maxItemsArray

            }

        }

        if (maxItemInArray == minItemOfArray(originTwoArray)) {
            System.out.println("\n ***** There is no item in the array which meets more than 1 time ****");
        } else {
            System.out.println("\n *** Max item in array which meets more than 1 time  = " + maxItemInArray + "  *** ");
        }




        // Get number of rows with some value

        int withSomeValue = 0;

        int numberRowsWithSomeValue = getNumberOfRowsWithSomeValue(originTwoArray, withSomeValue);

        System.out.println("\n *** Number of rows contain the value " + withSomeValue + " equals = " + numberRowsWithSomeValue + " rows *** ");


        // Get number of row which contains the longest chain of numbers
        // Assumption is  that only 1 chain can be in 1 row

        int longestRaw = getRowNumberOfLongestChainOfMumbers (originTwoArray);
        System.out.println( "\n *** Array's row with longest chain of numbers  = " + longestRaw + ". Expected: 5 ****  ");

        // create chess table
        // with drawing edge of the table


        char [] [] arrWithDrawing = new char[10][10];

        // create chess table

        for (int i = 1; i < arrWithDrawing.length - 1; i++) {
            for (int j = 1; j < arrWithDrawing[i].length - 1 ; j++) {
                if (i%2 == 0 & j%2 == 0) {
                    arrWithDrawing[i][j] = 'B';
                } else if (i%2 != 0 & j%2 != 0) {
                    arrWithDrawing[i][j] = 'B';
                } else {
                    arrWithDrawing[i][j] = 'W';
                }
            }

        }

        // drawing edge of the table
        for (int i = 0; i < arrWithDrawing.length; i++) {
            for (int j = 0; j < arrWithDrawing[i].length ; j++) {

                arrWithDrawing[0][j] = '-';
                arrWithDrawing[9][j] = '-';
            }

            arrWithDrawing[i][0] = '|';
            arrWithDrawing[i][9] = '|';
        }


        //print chess table
        System.out.println("\n  ********* Here is our chess table ******** ");
        for (int i = 0; i < arrWithDrawing.length; i++) {
            System.out.println(arrWithDrawing[i]);

        }
    }


    public static void fillMainAndOpositediagonalOfArray() {

        double randomArray[][] = new double[10][10];

        for (int i = 0; i < randomArray.length; i++) {
            for (int j = 0; j < randomArray[i].length; j++) {
                if (i == j) {
                    randomArray[i][j] = 5.00; // output along mail diagonal
                }
                randomArray[i][(randomArray.length - i - 1)] = 5.00; // output along opposite diagonal
            }
        }
        System.out.print(Arrays.deepToString(randomArray) + "\t");
    }


    // Calculation of negative items of the origin array
    public static int calculateSumOfNegativeItemsofArray(int[] arr) {

        int sumNegative = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                sumNegative = sumNegative + arr[i];
            }
        }

        return sumNegative;
    }


    // Calculation of items of the origin array which are located between Min and Max
    // if there is case when Min value or Max value more than 1 value we member only first encounter
    public static int ItemsofArrayBetweenMinAndMax(int[] arr) {

        int multipleItmes = 0;
        int positionMin = 0;
        int positionMax = 0;

        int itemMax = arr[0];
        int itemMin = arr[0];

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] > itemMax) {
                itemMax = arr[i];
                positionMax = i;
            }
            if (arr[i] < itemMin) {
                itemMin = arr[i];
                positionMin = i;
            }
        }


        multipleItmes = multipleItemsofArrayBetweenMinAndMax(arr, positionMin, positionMax);
        return multipleItmes;
    }

    //Calculate multiplication of items of the origin array which are located between Min and Max
    public static int multipleItemsofArrayBetweenMinAndMax(int arr[], int positionMin, int positionMax) {

        int multipleItems = 1; // != 0 because it is start for multiplication

        if (positionMin > positionMax) { //we need to compare postions of Max and Min items for creating cycle FOR

            for (int i = positionMax + 1; i < positionMin; i++) { //don't include postions of Min and Max
                multipleItems = multipleItems * arr[i];
            }
        } else {

            for (int i = positionMin + 1; i < positionMax; i++) {
                multipleItems = multipleItems * arr[i];
            }
        }

        return multipleItems;
    }

    public static void findFirstAndLastPositionOfZero(int arr[]) {

        int firstPositionOfZero = -1; // it is possible that there is no zero in array
        int lastPositionOfZero = -1;
        boolean existZero = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0 && existZero == false) { // first position of zero
                firstPositionOfZero = i;
                existZero = true;
            } else if ((arr[i] == 0 && existZero)) { // more than 1 zero and we remember last position of zero
                lastPositionOfZero = i;
            }
        }
        if (firstPositionOfZero == -1) {
            System.out.println("\n There is no Zero in the array");
        } else if (firstPositionOfZero >= 0 && lastPositionOfZero == -1) {
            System.out.println("\n There is only 1 Zero in the array");
        } else {
            int sumOfItemsBetweenZeros = calculateSumOfArrayItemsBetweenFirstAndLstPositions(arr, firstPositionOfZero, lastPositionOfZero);
            System.out.println("\n Sum of items between 2 marginal Zeros = " + sumOfItemsBetweenZeros + ". Expected: 13 ");
        }
    }


    public static int calculateSumOfArrayItemsBetweenFirstAndLstPositions(int arr[], int firstPosition, int lastPosition) {

        int sumBeetweenMarginalPositions = 0;

        for (int i = firstPosition; i <= lastPosition; i++) {
            sumBeetweenMarginalPositions = sumBeetweenMarginalPositions + arr[i];
        }

        return sumBeetweenMarginalPositions;
    }

    public static int[] sortArrayFirstPositiveItems(int[] arr) {

        int negativeArr[] = new int[arr.length];  // create  array for negative values
        int positiveArr[] = new int[arr.length]; // create  array for positive (include 0) values
        int resultArr[] = new int[arr.length];


        int countNegativeArr = 0; //  count for negative values
        int countPositiveArr = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] < 0) {
                negativeArr[countNegativeArr] = arr[i];// fill out negatve  array starting with 0
                //arr[i] = arr [i+1];
                countNegativeArr++;
            } else {
                positiveArr[countPositiveArr] = arr[i]; // fill out positive (including 0) array starting with 0
                countPositiveArr++;
            }
        }

        for (int j = 0; j <= countPositiveArr; j++) {
            resultArr[j] = positiveArr[j];  // fill out existed array ARR by positive values from positive array
        }

        int negativeCount = arr.length - countNegativeArr; // number of negative itens
        int negativeStart = 0; // counter for neagative arrays, because it contains items starting from 0

        for (int y = negativeCount; y < arr.length; y++) {
            resultArr[y] = negativeArr[negativeStart];
            negativeStart++;
        }
        return resultArr;
    }


    public static int maxItemOfArray(int[] arr) {
        int maxItem = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (maxItem < arr[i]) {
                maxItem = arr[i];
            }
        }
        return maxItem;

    }


    public static int[] compressArrayInRange(int[] arr, int start, int end, int byValue) {

        int countItemsInNotRange = 0;

        int[] newArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (!(Math.abs(arr[i]) >= start & Math.abs(arr[i]) <= end)) { // items which should not be changed go into new array
                newArr[countItemsInNotRange] = arr[i];
                countItemsInNotRange++;
            }
        }


        if (countItemsInNotRange > 0) {
            Arrays.fill(newArr, countItemsInNotRange, newArr.length, byValue);
        }
        return newArr;
    }


    public static int minItemOfArray(int[] arr) {
        int minItem = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (minItem > arr[i]) {
                minItem = arr[i];
            }
        }
        return minItem;

    }


    public static int findFirstPositionOfItemInArray(int[] arr, int value) {

        int positionFirstValue = -100; // there is no the Value in the array

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                positionFirstValue = i;
                return positionFirstValue; // find first encounter of the Value
            }

        }
        return positionFirstValue;
    }

    public static int calculateSumModulesOfItems(int[] arr, int startPositionValue) {

        int sumModules = 0;

        if (startPositionValue >= 0) {
            for (int i = startPositionValue; i < arr.length; i++) {
                sumModules = sumModules + Math.abs(arr[i]);
            }
        } else {
            sumModules = -1;  // there is no the Value in the array
        }
        return sumModules;
    }


    public static int[] getArrayEvenMemeberFirst(int[] arr) {

        //int lengthArr = arr.length;
        //boolean evenMembers = false;

        int lenghtOddArr = arr.length / 2;
        int lenghtEvenArr = arr.length / 2;


        if (arr.length % 2 != 0) {
            // evenMembers = true;
            lenghtEvenArr = lenghtEvenArr + 1;
        }


        int[] evenArr = new int[lenghtEvenArr];
        int[] oddArr = new int[lenghtOddArr];

        int evenCounter = 0;
        int oddCounter = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                evenArr[evenCounter] = arr[i];
                evenCounter++;
            } else {
                oddArr[oddCounter] = arr[i];
                oddCounter++;
            }
        }

        for (int i = 0; i < evenCounter; i++) {
            arr[i] = evenArr[i];
        }

        for (int i = 0; i < oddCounter; i++) {
            arr[evenCounter] = oddArr[i];
            evenCounter++;
        }
        //arr = Arrays.copyOfRange(oddArr, 0, oddCounter);
        return arr;
    }


    public static int maxItemOfArray(int[][] arr) {

        int maxItem = arr[0][0];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (maxItem < arr[i][j]) {
                    maxItem = arr[i][j];
                }

            }

        }
        return maxItem;
    }

    public static int minItemOfArray(int[][] arr) {

        int minItem = arr[0][0];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if ( arr[i][j] < minItem ){
                    minItem = arr[i][j];
                }

            }

        }
        return minItem;
    }


    // get number of rows without some value


    public static int getNumberOfRowsWithoutSomeValue(int[][] arr, int value) {

        StringBuffer existValueInRow = new StringBuffer();

        int countRows = 0; // there is no the value in the array

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                if (arr[i][j] == value) {
                    if ((existValueInRow.indexOf(valueOf(i))) < 0) { // create string array with unique number of row
                                                                             // if there is no the value (position in array) in the array we add it to array
                        countRows ++; // number of rows with existed value
                        existValueInRow.append(i); // string array with number of each row which contains the value
                    }
                }
            }
        }
        int notExistedCountRow = arr.length - countRows; // number of rows which do not contains the value
        return notExistedCountRow;
    }

    public static int maxItemOfArrayWithExcluding(int[][] arr, int [] excludMax, int countExclud, int minItemOfArray) {

        int maxItem = minItemOfArray;
        boolean existInExclud = false;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                existInExclud = false;
                if (maxItem < arr[i][j]) {
                    for (int z = 0; z < countExclud; z++) {

                        if (arr[i][j] == excludMax[z]) {
                            existInExclud = true;
                        }
                    }
                        if (existInExclud == false ) {
                            maxItem = arr[i][j];
                        }
                }
            }

        }
        return maxItem;
    }

    public static int getCountOfNumberSomeValueMeets(int[][] arr, int value) {

        int countMeet = 0; // there is no the value in the array

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                if (arr[i][j] == value) {
                        countMeet ++; // number of rows with existed value

                }
            }
        }

        return countMeet;
    }

    public static int getNumberOfRowsWithSomeValue(int[][] arr, int value) {

        StringBuffer existValueInRow = new StringBuffer();

        int countRows = 0; // there is no the value in the array

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                if (arr[i][j] == value) {
                    if ((existValueInRow.indexOf(valueOf(i))) < 0) { // create string array with unique number of row
                        // if there is no the value (position in array) in the array we add it to array
                        countRows ++; // number of rows with existed value
                        existValueInRow.append(i); // string array with number of each row which contains the value
                    }
                }
            }
        }
        return countRows;
    }

    public static int getRowNumberOfLongestChainOfMumbers (int [] [] arr) {

        int numberOfRow = -1;

        int [] [] newArr = new int [arr.length] [arr.length];

        for (int i = 0; i < newArr.length; i++) {
            for (int j = 0; j < newArr.length; j++) {
                newArr [i] [j] = -1;
            }
        }


        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j <arr[i].length ; j++) {

                while (j < arr[j].length -1 ) {
                    if ( arr [i][j] == arr [i] [j+1]) {
                        if (newArr[i][0] == -1) { // if there is a case number encountered more than 1 we set to [i,0]  = i
                            newArr[i][0] = i;
                        }
                        newArr [i] [j] = arr [i] [j]; //the same if [j+1]; set number encountered more than 1 to its position (in array the count of numbers = real count - 1)
                    }
                    j++;
                }

            }

        }
        //System.out.println(Arrays.deepToString(newArr) + "\t");
        return  numberOfRow = handleUnSpecificArray(newArr);

    }

    public static int handleUnSpecificArray (int [][] arr) {

        int numberOfRow = -1;
        int count = 0;

        int [] newArr = new int [arr.length];

        for (int i = 0; i < arr.length ; i++) {
            for (int j = 1; j < arr[i].length; j++) { // start from 1 because in 0 position - number of row if there is chain of numbers

                if ( arr[i] [0] != -1) { // look at only rows with [i,0] >= 0; -1 - the row does not contain  chain of numbers
                    if (arr[i][j] != -1) {
                        count++; // count  of number != -1 in each row
                    }
                }
            }
            newArr [i] = count;
            count = 0; // we zero out for each row
        }

        //System.out.println(Arrays.toString(newArr) + "\t");
        return numberOfRow = getRowOfMaxItemOfArray(newArr);
    }


    public static int getRowOfMaxItemOfArray(int[] arr) {

        int maxItem = arr[0];

        int numberRowOfMax = 0;

        for (int i = 1; i < arr.length; i++) {
            if (maxItem < arr[i]) {
                maxItem = arr[i];
                numberRowOfMax = i;
            }
        }
        return numberRowOfMax;
    }
}
