package sample;



//import static java.lang.System.exit;

public class Controller {

    private String Result;

    /**
     * Description:
     * The aim of this program is to convert a given date to a day of the week.
     *
     * Inputs:
     * The program takes in a date in a MMM DD YYYY format. For example, 1 Jan 2017
     *
     * Outputs:
     * The program will return the day which the inserted date falls on. The output is in an AAA format, where AAA is the abbreviation of a day of the week. For example, Jan 1 2017 will print out Sun, representing Sunday.
     *
     * Caveats:
     * The program will only accept MMM DD YYYY input and is not case sensitive.
     * The program will also quit after yielding the result.
     */


    //standard error
    public void errMes()
    {
        //System.out.print("Input not valid\n");
        //System.exit(0);

        this.setResult("Input is not valid");
    }

    public String getResult()
    {
        return Result;
    }

    public void setResult(String newResult)
    {
        this.Result = newResult;
    }

    public void mainAlg(String m, int d, int y)
    {

        Controller res = new Controller();

        int day, year, yearMod, yearDiv, yearCalc, yearCode;
        int monthCode, centuryCode, leapCode, finalResult;
        String month;

        //finalResult = 999;
        monthCode = 999;
        centuryCode = 999;


        /*The following checks whether the user has inserted the correct amount of arguments and throws an exception if not.*/

        // if (argc != 4) {
        //      System.out.print("Input not valid\n");
        //exit(2);
        // }

        /*The arguments are assigned to variables in order to use them throughout the program.*/


        month = m;
        day = d;
        year = y;


        /*This is the formula used to find the "year code" which will later be used in the final formula.*/
        yearMod = year % 100;
        yearDiv = yearMod / 4;
        yearCalc = yearDiv + yearMod;
        yearCode = yearCalc % 7;


        /*This assigns each month a "month code" and throws an exception if the input is invalid*/

        if (((month.equalsIgnoreCase("Jan")) || (month.equalsIgnoreCase("Oct"))))
        {
            monthCode = 0;
        }
        else if ((month.equalsIgnoreCase("Feb")) || (month.equalsIgnoreCase("Mar")) || (month.equalsIgnoreCase("Nov")))
        {
            monthCode = 3;
        }
        else if ((month.equalsIgnoreCase("Apr")) || (month.equalsIgnoreCase("Jul")))
        {
            monthCode = 6;
        }
        else if (month.equalsIgnoreCase("May"))
        {
            monthCode = 1;
        }
        else if (month.equalsIgnoreCase("Jun"))
        {
            monthCode = 4;
        }
        else if ((month.equalsIgnoreCase("Aug")))
        {
            monthCode = 2;
        }
        else if ((month.equalsIgnoreCase("Sep")) || (month.equalsIgnoreCase("Dec")))
        {
            monthCode = 5;
        }
        else
        {
            System.out.println("month code issue");
            res.setResult("Invalid input month code");
            monthCode = 999;
        }


        /*A "century code" is assigned the for later use. Exception is thrown if not valid*/

        if (year >= 1901 && year < 2000) {
            centuryCode = 0;
        } else if (year >= 2000 && year < 2100) {
            centuryCode = 6;
        } else if (year >= 2100 && year < 2200) {
            centuryCode = 4;
        } else if (year >= 2200 && year < 2300) {
            centuryCode = 2;
        } else if (year >= 2300 && year <= 2038) {
            centuryCode = 0;
        } else {
            System.out.println("cent code case");
            res.setResult("Invalid input cent code");
        }


        /*The following uses a formula similar to 'fizzbuzz' to determine whether a year is a leap year or not*/

        if (year % 400 == 0) {
            leapCode = 1;
        } else if (year % 100 == 0) {
            leapCode = 0;
        } else if (year % 4 == 0) {
            leapCode = 1;
        } else {
            leapCode = 0;
        }



        /*The following checks whether a day is valid for that month, e.g., February cannot have 30 days.*/
        if (day < 1 || day > 31) {
            System.out.println("wrong amount of days");
            setResult("Invalid input wrong am of days");
            monthCode = 999;
        }

        if ((leapCode == 1) && (month.equalsIgnoreCase("Feb")) && day > 29) {
            System.out.println("month ignore case. feb issue");
            setResult("Invalid input feb issue 1");
            monthCode = 999;
        } else if ((leapCode == 0) && (month.equalsIgnoreCase("Feb")) && day > 28) {
            System.out.println("month ignore case. feb issue 2");
            setResult("Invalid input feb issue 2");
            monthCode = 999;
        }

        if (((month.equalsIgnoreCase("Sep")) || (month.equalsIgnoreCase("Nov")) || (month.equalsIgnoreCase("Apr")) || (month.equalsIgnoreCase("Jun"))) && day > 30) {

            System.out.println("month ignore case. sep apr nov etc");
            monthCode = 999;
        }


        /*The following is the main formula and determines the day as a number. The if statement handles leap years*/

        if (centuryCode == 999 || monthCode == 999)
        {
            res.setResult("Invalid input that highlighted one");
            finalResult = 999;
        }

        else if (leapCode == 1 && ((month.equalsIgnoreCase("mar")) || (month.equalsIgnoreCase("apr")) || (month.equalsIgnoreCase("may")) || (month.equalsIgnoreCase("jun")) || (month.equalsIgnoreCase("jul")) || (month.equalsIgnoreCase("aug")) || (month.equalsIgnoreCase("sep")) || (month.equalsIgnoreCase("oct")) || (month.equalsIgnoreCase("nov")) || (month.equalsIgnoreCase("dec")))) {
            finalResult = (yearCode + monthCode + centuryCode + day - leapCode + 1) % 7;
        } else {
            finalResult = (yearCode + monthCode + centuryCode + day - leapCode) % 7;
        }


        /*The final result, as a number, gets printed as a day of the week.*/

        switch (finalResult)
        {

            case (0):
                setResult("Sunday");
                break;

            case (1):
                setResult("Monday");

                break;

            case (2):
                setResult("Tuesday");
                break;

            case (3):
                setResult("Wednesday");
                break;
            case (4):
                setResult("Thursday");
                break;

            case (5):
                setResult("Friday");
                break;

            case (6):
                setResult("Saturday");
                break;

             default: setResult("Invalid input");
                break;
        }
        m = "0";
        d = 0;
        y = 0;

    }
}