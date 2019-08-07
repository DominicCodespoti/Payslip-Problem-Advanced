class EmployeeData {
    private String EmployeeFirstName;
    private String EmployeeSurname;
    private Integer Salary;
    private Integer SuperRate;
    private String StartDate;
    private String EndDate;

    public EmployeeData() {
        this.EmployeeFirstName = "";
        this.EmployeeSurname = "";
        this.Salary = 0;
        this.SuperRate = 0;
        this.StartDate = "";
        this.EndDate = "";
    }

    public String getEmployeeFirstName() {return EmployeeFirstName;}
    public String getEmployeeSurname() {return EmployeeSurname;}
    public Integer getSalary() {return Salary;}
    public Integer getSuperRate() {return SuperRate;}
    public String getStartDate() {return StartDate;}
    public String getEndDate() {return EndDate;}

    public void setEmployeeFirstName(String FirstName) {this.EmployeeFirstName = FirstName;}
    public void setEmployeeSurname(String Surname) {this.EmployeeSurname = Surname;}
    public void setSalary(Integer Salary) {this.Salary = Salary;}
    public void setSuperRate(Integer SuperRate) {this.SuperRate = SuperRate;}
    public void setStartDate(String StartDate) {this.StartDate = StartDate;}
    public void setEndDate(String EndDate) {this.EndDate = EndDate;}

    public Integer CalculateGrossPay()
    {
        return Math.round(getSalary() / 12);
    }

    public Integer CalculateIncomeTax()
    {
        if(getSalary() <= 37000 && getSalary() >= 18201)
        {
            return Math.toIntExact(Math.round(((getSalary() - 18200) * 0.19) / 12));
        }
        if(getSalary() <= 87000 && getSalary() >= 37001)
        {
            return Math.toIntExact(Math.round((3572 + (getSalary() - 37000) * 0.325) / 12));
        }
        if(getSalary() <= 180000 && getSalary() >= 87001)
        {
            return Math.toIntExact(Math.round((19822 + (getSalary() - 87000) * 0.37) / 12));
        }
        if(getSalary() >= 180001)
        {
            return Math.toIntExact(Math.round((54232 + (getSalary() - 180000) * 0.45) / 12));
        }
        return 0;
    }

    public Integer CalculateNetIncome()
    {
        return CalculateGrossPay() - CalculateIncomeTax();
    }

    public Integer CalculateSuper()
    {
        return (int)Math.floor(CalculateGrossPay()  * (getSuperRate() / 100.0f));
    }

    public String CalculatePayMonth()
    {
        String Checker = getStartDate().split("-")[1].toUpperCase();
        String Month = getStartDate().split("-")[1];
        if(Checker.equals("FEBRUARY") || Checker.equals("MARCH") || Checker.equals("MAY") || Checker.equals("JULY")
                || Checker.equals("AUGUST") || Checker.equals("OCTOBER") || Checker.equals("DECEMBER"))
        {
            return "01 " + Month + " - 31 " + Month;
        }
        if(Checker.equals("APRIL") || Checker.equals("JUNE") || Checker.equals("SEPTEMBER") || Checker.equals("NOVEMBER"))
        {
            return "01 " + Month + " - 30 " + Month;
        }
        return "01 " + Month + " - 28 " + Month;
    }
}
