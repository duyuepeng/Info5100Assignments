package Assignment2;

/**
 * Submit it on or before 22nd September 2019 , 12:00 pm
 */
public class Assignment2 {
    /*
     * This method should return the sum of salaries of employees having salary
     * greater than 5000 Note: Employee array is passed, not employee
     */
    public double salaryGreaterThanFiveThousand(Employee[] employees) {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee.getSalary() > 5000) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    /*
     * This method should print either "Fizz", "Buzz" or "FizzBuzz" "Fizz" - if id
     * of employee is divisible by 3 "Buzz" - if id of employee is divisible by 5
     * "FizzBuzz" - if id of employee is divisible by both 3 and 5
     */
    public void fizzBuzz(Employee employee) {
        String out = "";
        if ((employee.getId() % 3) == 0)
            out += "Fizz";
        if ((employee.getId() % 5) == 0)
            out += "Buzz";
        if (out.length() > 0)
            System.out.println(out);
    }

    /*
     * This method should calculate tax for an employee in dollars If salary of
     * employee is less than or equal to 2500, tax should be 10% If salary of
     * employee is greater than 2500 but less than or equal to 5000, tax should be
     * 25% If salary of employee is greater than 5000, tax should be 35%
     */
    public double calculateTax(Employee employee) {
        double salary = employee.getSalary();
        if (salary < 0)
            throw new IllegalArgumentException("Salary should not be less than 0.");
        if (salary <= 2500)
            return salary * 0.1;
        if (salary <= 5000)
            return 2500 * 0.1 + (salary - 2500) * 0.25;
        return 2500 * 0.1 + (5000 - 2500) * 0.25 + (salary - 5000) * 0.35;
    }

    /*
     * We are given two employee objects. Implement this method to swap salaries of
     * employees
     */
    public void swap(Employee firstEmployee, Employee secondEmployee) {
        double salary = firstEmployee.getSalary();
        firstEmployee.setSalary(secondEmployee.getSalary());
        secondEmployee.setSalary(salary);
    }

    /*
     * Return number of employees whose age is greater than 50 Note: Employee array
     * is passed, not employee
     */
    public int employeesAgeGreaterThan50(Employee[] employees) {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee.getAge() > 50) {
                sum++;
            }
        }
        return sum;
    }

    /*
     * Implement this method to reverse firstName of employee. Ex. Before:
     * employee.getFirstName() -> "John" After : employee.getFirstName() -> "nhoJ"
     */
    public void reverseFirstName(Employee employee) {
        String firstName = employee.getFirstName();
        employee.setFirstName(new StringBuilder(firstName).reverse().toString());
    }

    /*
     * Print "true" if employee's first name contain one or more digits Print
     * "false" if employee's first name doesn't contain any digit Ex:
     * employee.getFirstName() -> "ha8l" == true employee.getFirstName() -> "hail"
     * == false
     */
    public void isContainDigit(Employee employee) {
        String firstNmae = employee.getFirstName();
        for (int i = 0; i < firstNmae.length(); i++) {
            if (Character.isDigit(firstNmae.charAt(i))) {
                System.out.println("true");
                return;
            }
        }
        System.out.println("false");
    }

    /*
     * Write a method to raise an employee's salary to three times of his/her
     * original salary. Eg: original salary was 1000/month. After using this method,
     * the salary is 3000/month. DO NOT change the input in this method. Try to add
     * a new method in Employee class: public void raiseSalary(double byPercent)
     * Call this new method.
     */
    public void tripleSalary(Employee employee) {
        employee.raiseSalary(200);
    }

    // Additional question for extra credit
    /*
     * Implement this method to convert String[] to employees array. Ex: String[]
     * employees = new String[]{"1,John,24,7500", "2,Hail,28,7899.90"}; This String
     * array of length 2 contains 2 employees in form of string, where id = 1
     * firstName=John age=24 salary=7500 convert each string to employee object.
     * Hint: Use String methods. Refer :
     * https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
     */
    public Employee[] createEmployees(String[] employeesStr) {
        Employee[] employees = new Employee[employeesStr.length];
        for (int i = 0; i < employeesStr.length; i++) {
            String[] info = employeesStr[i].split(",");
            employees[i] = new Employee(Integer.parseInt(info[0]), info[1], Integer.parseInt(info[2]),
                    Double.parseDouble(info[3]));
        }
        return employees;
    }

    public static void main(String[] args) {
        Assignment2 assignment2 = new Assignment2();
        Employee[] employees = assignment2
                .createEmployees(new String[] { "3,John,24,7500", "5,Hail,28,7899.90", "15,Y5an,51,2500.36" });
        System.out.println(assignment2.salaryGreaterThanFiveThousand(employees));
        for (Employee employee : employees) {
            assignment2.fizzBuzz(employee);
        }
        System.out.println(assignment2.calculateTax(employees[0]));
        assignment2.swap(employees[1], employees[2]);
        for (Employee employee : employees) {
            System.out.println(employee.getFirstName() + employee.getSalary());
        }
        System.out.println(assignment2.employeesAgeGreaterThan50(employees));
        assignment2.reverseFirstName(employees[1]);
        System.out.println(employees[1].getFirstName());
        for (Employee employee : employees) {
            assignment2.isContainDigit(employee);
        }
        assignment2.tripleSalary(employees[1]);
        System.out.println(employees[1].getFirstName() + employees[1].getSalary());
    }
}
