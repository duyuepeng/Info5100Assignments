/*
 * Complete all TODO
 * Submit before 22nd September 12:00pm
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Assignment2 {
    private static final String ORGANISATION = "Northeastern";
    private static final String[] STRS = new String[] {
            // firstname,lastname,age,salary,email,designation
            "John,Doe,24,5400,johndoe@gmail.com,Engineer", 
            "Sara,Jones,26,6300,sarajones@gmail.com,TechnicalRecruiter",
            "Noah,Trevor,32,5300,noahtrevor@gmail.com,Writer", 
            "Jill,Meyer,34,6800,jillmeyer@gmail.com,Manager",
            "Chris,Strat,36,7600,chrisstrat@gmail.com,Director", 
            "Ching,Chi,25,4000,chingchi@gmail.com,Developer",
            "Yue,Hui,28,4900,yuehui@gmail.com,Tester",
            "Amit,Agarwal,27,5700,yuehui@gmail.com,SeniorDeveloper",
            "Tianyu,Wang,26,4500,tianyuwang@gmail.com,Researcher",
            "Ram,Menon,29,5700,rammenon@gmail.com,DataScientist" };

    private final Employee[] employees = new Employee[10];

    class Employee implements Comparable<Employee> {
        private String firstName;
        private String lastName;
        private int age;
        private int salary;
        private String email;
        private String designation;
        private String org;

        Employee(String firstName, String lastName, int age, int salary, String email, String designation, String org) {
            // @TODO
            // initialize all members here
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.salary = salary;
            this.email = email;
            this.designation = designation;
            this.org = org;
        }

        // generate getter setters for all Employee members
        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getDesignation() {
            return designation;
        }

        public void setDesignation(String designation) {
            this.designation = designation;
        }

        public String getOrg() {
            return org;
        }

        public void setOrg(String org) {
            this.org = org;
        }

        @Override
        public int compareTo(Employee o) {
            // compare employee by their salary, if salaries are equal, compare by age
            int salaryDiff = this.getSalary() - o.getSalary();
            if (salaryDiff == 0) {
                return this.getAge() - o.getAge();
            }
            return salaryDiff;
        }

        @Override
        public boolean equals(Object o) {
            // implement equals for Employee
            if (this == o)
                return true;
            if (!(o instanceof Employee))
                return false;
            Employee employee = (Employee) o;
            return getAge() == employee.getAge() && getSalary() == employee.getSalary()
                    && java.util.Objects.equals(getFirstName(), employee.getFirstName())
                    && java.util.Objects.equals(getLastName(), employee.getLastName())
                    && java.util.Objects.equals(getEmail(), employee.getEmail())
                    && java.util.Objects.equals(getDesignation(), employee.getDesignation())
                    && java.util.Objects.equals(getOrg(), employee.getOrg());
        }

        @Override
        public int hashCode() {
        // implement hashcode for employee
        return Objects.hash(getFirstName(), getLastName(), getAge(), getSalary(),
        getEmail(), getDesignation(), getOrg());
        }
    }

    public void initializeEmployees() {
        // use STRS to create employee objects and store them in employees array
        for (int i = 0; i < this.employees.length && i < STRS.length; i++) {
            String[] info = STRS[i].split(",");
            this.employees[i] = new Employee(info[0], info[1], Integer.parseInt(info[2]), Integer.parseInt(info[3]),
                    info[4], info[5], ORGANISATION);
        }
    }

    public int sumOfSalariesGreaterThanFiveThousands() {
        // calculate the sum of salaries of employees having salary greater than 5000
        int sum = 0;
        for (Employee employee : this.employees) {
            if (employee.getSalary() > 5000) {
                sum++;
            }
        }
        return sum;
    }

    public void swapSalaries() {
        // swap salary of even numbered employee with odd numbered employee
        // swap salary of employees[0] with employees[1], employees[2] with employees[3]
        // and so on..
        for (int i = 0; i + 1 < this.employees.length; i += 2) {
            int oddSalary = this.employees[i + 1].getSalary();
            this.employees[i + 1].setSalary(this.employees[i].getSalary());
            this.employees[i].setSalary(oddSalary);
        }
    }

    public void customSort() {
        // sort employees array on the basis of firstName and print
        Arrays.sort(this.employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee a, Employee b) {
                return a.firstName.compareToIgnoreCase(b.firstName);
            }
        });
        for (Employee employee : employees) {
            System.out.println(employee.firstName);
        }
        
        // sort employees array on the basis of age and print
        Arrays.sort(this.employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee a, Employee b) {
                return a.age - b.age;
            }
        });
        for (Employee employee : employees) {
            System.out.println(employee.firstName);
        }
    }

    public static void main() {
        Assignment2 assignment2 = new Assignment2();
        // you can verify/test your code here
        assignment2.initializeEmployees();
        assignment2.sumOfSalariesGreaterThanFiveThousands();
        assignment2.swapSalaries();
        for (Employee employee : assignment2.employees) {
            System.out.println(employee.firstName+employee.salary);
        }
        assignment2.swapSalaries();
        assignment2.customSort();
        System.out.println(assignment2.employees[0].compareTo( assignment2.employees[1]));
        System.out.println(assignment2.employees[4].compareTo( assignment2.employees[6]));
        System.out.println(assignment2.employees[2].equals(assignment2.employees[3]));
        String[] info = STRS[6].split(",");
        System.out.println(assignment2.new Employee(info[0], info[1], Integer.parseInt(info[2]), Integer.parseInt(info[3]), info[4], info[5], ORGANISATION).equals(assignment2.employees[5]));
        System.out.println(assignment2.new Employee(info[0], info[1], Integer.parseInt(info[2]), Integer.parseInt(info[3]), info[4], info[5], ORGANISATION).hashCode() == assignment2.employees[5].hashCode());
    }

}