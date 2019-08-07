import java.util.Scanner;

public class QuestionData {

    public static boolean checkBetween(int tester, int floor, int ceiling) {
        return ((tester > floor) && (tester < ceiling));
    }

    public static Integer IntegerInput() {
        Scanner Read = new Scanner(System.in);
        try {
            return Read.nextInt();
        } catch (Exception e) {
            System.out.println("Error! Incorrect input, try again!");
        }
        return IntegerInput();
    }

    public static String MonthInput() {
        Scanner Read = new Scanner(System.in);
        String Input = Read.nextLine();

        String Checker = Input.split(" ")[1].toUpperCase();
        Integer Day = Integer.parseInt(Input.split(" ")[0]);
        System.out.println(Day);

        if (Checker.equals("FEBRUARY") || Checker.equals("MARCH") || Checker.equals("MAY") || Checker.equals("JULY") || Checker.equals("AUGUST") || Checker.equals("OCTOBER") || Checker.equals("DECEMBER")
                || Checker.equals("APRIL") || Checker.equals("JUNE") || Checker.equals("SEPTEMBER") || Checker.equals("NOVEMBER") || Checker.equals("JANUARY")) {
            if (checkBetween(Day, 0, 32)) {
                return Input;
            }
        }
        System.out.println("Error! Incorrect input, try again!");
        return MonthInput();
    }

    public void askFirstName(EmployeeData TestSubject) {
        Scanner Read = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String tempString = Read.nextLine();
        TestSubject.setEmployeeFirstName(tempString);
    }

    public void askSurname(EmployeeData TestSubject) {
        Scanner Read = new Scanner(System.in);
        System.out.println("Enter your surname: ");
        String tempString = Read.nextLine();
        TestSubject.setEmployeeSurname(tempString);
    }

    public void askSalary(EmployeeData TestSubject) {
        System.out.println("Enter your annual salary: ");
        Integer tempInt = IntegerInput();
        TestSubject.setSalary(tempInt);
    }

    public void askSuperRate(EmployeeData TestSubject) {
        System.out.println("Enter your super rate: ");
        Integer tempInt = IntegerInput();
        TestSubject.setSuperRate(tempInt);
    }

    public void askStartDate(EmployeeData TestSubject) {
        System.out.println("Enter your payment start date: ");
        String tempString = MonthInput();
        TestSubject.setStartDate(tempString);
    }

    public void askEndDate(EmployeeData TestSubject) {
        System.out.println("Enter your payment end date: ");
        String tempString = MonthInput();
        TestSubject.setEndDate(tempString);
    }

    interface question{
        void askQuestion();
    }

    public EmployeeData employeeToQuestion;

    void setEmployeeToQuestion(EmployeeData testSubject)
    {
        employeeToQuestion = testSubject;
    }

    private question[] questions = new question[] {
            new question() { public void askQuestion() { askFirstName(employeeToQuestion); } },
            new question() { public void askQuestion() { askSurname(employeeToQuestion); } },
            new question() { public void askQuestion() { askSalary(employeeToQuestion); } },
            new question() { public void askQuestion() { askSuperRate(employeeToQuestion); } },
            new question() { public void askQuestion() { askStartDate(employeeToQuestion); } },
            new question() { public void askQuestion() { askEndDate(employeeToQuestion); } },
    };

    public void askQuestion(int index) {
        questions[index].askQuestion();
    }

    public int questionAmount = questions.length;
}
