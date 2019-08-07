import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    public static ArrayList<EmployeeData> populateThroughCSV()
    {
        ArrayList<EmployeeData> Employees = new ArrayList<EmployeeData>();
        Path pathToFile = Paths.get("data.csv");
        int i = 0;

        try (BufferedReader fileReader = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {
            String currentLine = fileReader.readLine();
            while (currentLine != null)
            {
                Employees.add(new EmployeeData());
                Employees.get(i).setEmployeeFirstName(currentLine.split(",")[0]);
                Employees.get(i).setEmployeeSurname(currentLine.split(",")[1]);
                Employees.get(i).setSalary(Integer.valueOf(currentLine.split(",")[2]));
                Employees.get(i).setSuperRate(Integer.valueOf(currentLine.split(",")[3]));
                Employees.get(i).setStartDate(currentLine.split(",")[4]);
                Employees.get(i).setEndDate(currentLine.split(",")[5]);
                currentLine = fileReader.readLine();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Employees;
    }

    public static void generateData(EmployeeData TestSubject)
    {
        System.out.println(System.lineSeparator() + "Your payslip has been generated: " + System.lineSeparator());
        System.out.println("Name: " + TestSubject.getEmployeeFirstName() + " " + TestSubject.getEmployeeSurname());
        System.out.println("Pay Period: " + TestSubject.CalculatePayMonth());
        System.out.println("Gross Income: " + TestSubject.CalculateGrossPay());
        System.out.println("Income Tax: " + TestSubject.CalculateIncomeTax());
        System.out.println("Net Income: " + TestSubject.CalculateNetIncome());
        System.out.println("Super: " + TestSubject.CalculateSuper());
        System.out.println("Thank you for using MYOB!");
    }

    public static void main(String[] args) {
        EmployeeData TestSubject = new EmployeeData();
        QuestionData questionsToAsk = new QuestionData();
        questionsToAsk.setEmployeeToQuestion(TestSubject);

        System.out.println("Would you like to manually input data (1) or read in a file (2):");
        String Input;
        Scanner Reader = new Scanner(System.in);
        Input = Reader.nextLine();

        if (Input.equals(1))
        {
            for (int i = 0; i < questionsToAsk.questionAmount; i++)
            {
                questionsToAsk.askQuestion(i);
            }
            generateData(TestSubject);
        }
        else
        {
            ArrayList<EmployeeData> Employees = populateThroughCSV();
            for (EmployeeData employee : Employees) {
                generateData(employee);
                System.out.println("\n");
            }
        }
    }
}
