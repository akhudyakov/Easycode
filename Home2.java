package HomeTask_2;

import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.setOut;
import static jdk.nashorn.internal.objects.NativeString.charAt;
import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

/**
 * Created by Andrey on 24.12.2016.
 */
public class Home2 {
    public static void main(String[] args) throws IOException {

        //replace "ссылка"  на "вырезано цензурой

        System.out.println("*************  Replacment Censor *****************\n");

        String ln = "";

        ln = getContextfromConsole();
        ln = ln.replace("ссылка", "вырезано цензурой");
        System.out.println("Result of replacement  \"ссылка\"  to \"вырезано цензурой\"  is:   " + ln);


        // calculate sum of all symbols' weight

        int length = ln.length();
        //System.out.println(length);

        int count = 0;
        int sum = 0;

        while (count < length) {
            sum = sum + ln.charAt(count);
            //  System.out.println(ln.charAt(count));
            count++;
        }
        System.out.println("\n sum of all symbols' weight is: " + sum);
        //System.out.println(count);


        // Create Ananim
        System.out.println();
        System.out.println("*************  Ananim *****************");


        String ananim = "";

        while (count > 0) {
            count--;
            ananim = ananim + ln.charAt(count);
        }
        System.out.println("Ananim is: " + ananim);


        // Transformation long FIO to short
        // first is Last Name, second - Middle Name, third is First Name

        System.out.println();
        System.out.println("*************  Short view of FIO *****************");

        String fullfio =  new String();


        int numberTokens = 0;
        //System.out.println("number of token: " + numberTokens);

        do {
            fullfio = getContextfromConsole();
            numberTokens = getNumberTokens(fullfio);

            //System.out.println("number of token: " + numberTokens);
            if (numberTokens != 3) {
                System.out.println("You inputted " + numberTokens + " parts. It is incorrect!!! ");
                System.out.println("You need to input 3 parts as first part  is Last Name, second part is Middle Name, third part is First Name\n");
            }
            else {
                break;
            }
        }
        while (numberTokens != 3) ;

        String fullfiobyTokens [] = new String[numberTokens];
        fullfiobyTokens = getTokens(fullfio); // get massive of word divided by Token


        String lastName = fullfiobyTokens[0];
        char firstLetterofLastName = lastName.charAt(0);
        lastName = toUpperCase(firstLetterofLastName) + lastName.substring(1) ;

        String firstName = fullfiobyTokens[1];
        char firstLetterofFirstName = firstName.charAt(0);
        firstName = toUpperCase(firstLetterofFirstName);

        String middleName = fullfiobyTokens[2];
        char firstLetterofMiddleName = middleName.charAt(0);
        middleName = toUpperCase(firstLetterofMiddleName);

        String shortFIO = lastName + " " + firstName + "." + middleName + ".";

        System.out.println("Short view of FIO is: " + shortFIO);


        // Determine whether inputted text is Палиндром
        System.out.println();
        System.out.println("*************  Палиндром with IgnoreCase *****************");

        boolean comparisonResult;
        String inputLine = new String();

        inputLine = getContextfromConsole();
        int lenghtPalidrom = inputLine.length();

        if (lenghtPalidrom%2 != 0) {
            System.out.println(" Inputted text is NOT Палидром");
        } else {

            comparisonResult = IsPalidrom(inputLine);

            if (comparisonResult) {
                System.out.println("Inputted text is Палидром ");
            } else {
                System.out.println("Inputted text is NOT Палидром");
            }
        }


        // Capitalize first letter for each word
        System.out.println();
        System.out.println("*************  Capitalize first letter for each word *****************");

        String notCapitalString = getContextfromConsole();

        String capitalizeString = makeFirstLetterUpper(notCapitalString);

        System.out.println(capitalizeString);


        // Output of numbers via coma
        System.out.println();
        System.out.println("*************  Output of numbers via coma *****************");

        String digitalNotHandleString = getContextfromConsole();
        int numberOfSymbols = digitalNotHandleString.length();

        String resultDigitalString = new String();

        for (int i = 0; i < numberOfSymbols; i++) {

            char separateSymbol = digitalNotHandleString.charAt(i);

            if (separateSymbol >= 48 && separateSymbol <= 57) {   // select only digits (code 0 is 48; code 9 is 57)

                if (i == numberOfSymbols - 1) {
                    resultDigitalString = resultDigitalString + separateSymbol; // after last symbol we do not add coma
                } else {
                    resultDigitalString = resultDigitalString + separateSymbol + ',';
                }
            }
        }

        System.out.println(" Here should only digits with coma: " + resultDigitalString);


        // Splitting String regarding specified width
        System.out.println();
        System.out.println("*************  Splitting String regarding specified width *****************");

        getConsoleContextAndDivideStringBuffer();

        /*
        int lastSymbol = arrNotSplittedText.lastIndexOf("stop");

        while (lastSymbol <= 0 ) {
            System.out.println("You did  not input word \"stop\" ");
            arrNotSplittedText = getContextfromConsole();
            lastSymbol = arrNotSplittedText.lastIndexOf("stop");
        }
        //int lenghtString = arrNotSplittedText.length();
        //System.out.println(lenghtString);
        System.out.println(lastSymbol);
        */
    }


    public static String getContextfromConsole() {

        Scanner sc = new Scanner(in);
        String con ="";

        System.out.println("Input your text: ");
        con = sc.nextLine();
        return con;
    }

    public static int getNumberTokens (String arr){

        StringTokenizer myTokenizer = new StringTokenizer(arr);
        int numnerToken = myTokenizer.countTokens();
        return numnerToken;
    }

    public static String [] getTokens (String arr) {

        StringTokenizer myTokenizer = new StringTokenizer(arr);
        int numnerToken = getNumberTokens(arr);

        String[] tokens = new String[numnerToken];

        for (int count = 0; count < numnerToken; count++) {
            tokens[count] = myTokenizer.nextToken();
        }
        return tokens;
    }


    public static String [] getTokensWithDelimeters (String arr) {

        StringTokenizer st = new StringTokenizer(arr," ",true);

        int numnerToken = getNumberTokens(arr);

        String[] tokensWithDelim = new String[numnerToken];

        for (int count = 0; count < numnerToken; count++) {
            tokensWithDelim[count] = st.nextToken();
        }
        return tokensWithDelim;
    }


    public static boolean IsPalidrom (String str) {

        int endFirstPart = 0;

        int lenghtPalidrom = str.length();

        endFirstPart = lenghtPalidrom / 2;


        //String[] firstPart  = new String [endFirstPart];
        //String[] secondPartArr = new String[endFirstPart];

        String firstPart = new String();
        String secondPart = new String();

        char[] secondPartCharArr = new char[endFirstPart];

        firstPart = str.substring(0, endFirstPart);

        //secondPartArr = inputLine.substring(endFirstPart);

        str.getChars(endFirstPart, lenghtPalidrom, secondPartCharArr, 0);// copy remain part to second char array


        int returncount = endFirstPart - 1; //because of array starts with 0. Start with last element
        for (int count = 0; count < endFirstPart; count++) { //count - number of elements of second part of Palidrom

            secondPart = secondPart + String.valueOf(secondPartCharArr[returncount]); // turn over in the opposite direction
            returncount--;
        }
        //System.out.println(secondPart);
        boolean result = firstPart.equalsIgnoreCase(secondPart); //comparison 2 arrays without considering Case
        return result;
    }


    public static String makeFirstLetterUpper (String str) {

        //String [] strByTokens = getTokensWithDelimeters(str);
        String [] strByTokens = getTokens(str);
        int numberTokens = getNumberTokens(str);

        String resultString = new String();

        for (int i=0; i < numberTokens; i++) {

            String firstLetter = toUpperCase(strByTokens[i].charAt(0));
            resultString = resultString + firstLetter + strByTokens[i].substring(1) + " ";
        }
        return resultString;
    }


    public static void  getConsoleContextAndDivideStringBuffer () {

        Scanner sc = new Scanner(in);
        StringBuffer sf = new StringBuffer();
        int [] lenghtWord = new int [1000]; // array for input stream as max = 1000 words

        int width = 0; // init of width of text
        System.out.println("Input your desired WIDTH of text : ");
        width = sc.nextInt(); // read by each word up to space (space is not included)


        String tempWord; // temp for saving each inputted word

        int count = 0; // number of words

        System.out.println("Input your text (word \"stop\" is finished) : ");

        while (!(tempWord = sc.next() ).equalsIgnoreCase("stop")) { // word "stop" is last and is not included

            lenghtWord[count] = tempWord.length(); // array for length of each word
            sf.append(tempWord); // all words are in one stringBuffer sf; all symbols are in one row without spaces

            count++;
        }


        int firstNextLetter = 0;  // position of a word which should be inserted in the next step considering 'space'
        int firstCurrentLetter = 0; // current position after word has been inserted

        String str = "";  // word which is going to be insereted

        for (int i = 0; i < count; i++) {

            firstNextLetter = firstNextLetter + lenghtWord[i] + 1; // word's lenght + space

            if (lenghtWord[i] > width) { // word's lenght is more then width and it needs to be splitted to 2 rows
                                         // if rest part also should be divided - it is not happend. Should be improved
                str = String.valueOf(sf.subSequence(firstCurrentLetter, firstCurrentLetter + width));
                System.out.printf("\n" + str + " ");
                lenghtWord[i] = lenghtWord [i] - width; // remains after  inserting to 1 row ( for inserting to 2 row)
                firstNextLetter = firstNextLetter + lenghtWord[i] + 1;
                firstCurrentLetter = firstCurrentLetter + width;

            }
            if (firstNextLetter <= width ) { // if word fits to width with space
                str = String.valueOf(sf.substring(firstCurrentLetter,firstCurrentLetter+lenghtWord[i]));
                System.out.printf(str);
                System.out.printf(" ");
                firstCurrentLetter = firstCurrentLetter + lenghtWord[i];
            }  else if ((firstNextLetter = firstNextLetter - 1) <= width) { //if word fits to width without space
                str = String.valueOf(sf.subSequence(firstCurrentLetter, firstCurrentLetter+lenghtWord[i]));
                System.out.printf(str);
                firstCurrentLetter = firstCurrentLetter + lenghtWord[i];
            } else { //  transfer of the word on other line
                str = String.valueOf(sf.subSequence(firstCurrentLetter,firstCurrentLetter+lenghtWord[i]));
                System.out.printf("\n"+str + " ");
                firstNextLetter = lenghtWord[i] + 1;
                firstCurrentLetter = firstCurrentLetter + lenghtWord[i];
            }
        }
    }
}

