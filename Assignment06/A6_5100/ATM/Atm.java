package A6_5100.ATM;


import java.util.Arrays;
import java.util.List;

public class Atm {
    private static int inc = 1;
    private int availableAmountInMachine;
    private Integer transactionFee;
    private UserData userData;

    private User current;

    public Atm() {
        this.availableAmountInMachine = 1000000;
        this.transactionFee = 1;
        this.userData = new UserData();
    }

    public Atm(int availableAmountInMachine, Integer transactionFee) {
        this();
        this.availableAmountInMachine = availableAmountInMachine;
        this.transactionFee = transactionFee;
    }

    public void login(String bankAccountNumber, String password) {
        User current = this.userData.getUser(bankAccountNumber);
        if (current == null)
            throw new AtmException("Account not exists.");
        if (!this.userData.validatePassword(current, password)) {
            throw new AtmException("Wrong password.");
        }
        this.current = current;
    }

    public void forgetPassword(String name, int age, String phoneNumber, String bankAccountNumber, String newPassword) {
        User current = this.userData.getUser(bankAccountNumber);
        if (current == null)
            throw new AtmException("Account not exists.");
        if (!current.compareInfo(name, age, phoneNumber, bankAccountNumber)) {
            throw new AtmException("Information not correspond.");
        }
        this.userData.resetPassword(current, newPassword);
    }

    public User createUser(String name, int age, String address, String phoneNumber, String password) {
        User newUser = new User(name, age, address, phoneNumber, String.format("%012d", Atm.inc++));
        this.userData.createUser(newUser, password);
        return newUser;
    }

    public Integer availableBalance() {
        if (this.current == null)
            throw new AtmException("No user logon.");
        return this.userData.availableBalance(this.current);
    }

    public Integer withDrawl(Integer amount) {
        if (this.current == null)
            throw new AtmException("No user logon.");
        if (amount > this.availableAmountInMachine)
            throw new AtmException("No enough amount in machine.");
        this.availableAmountInMachine -= amount;
        amount = this.userData.withDrawl(this.current, amount + this.transactionFee);
        if (amount < 0) {
            throw new AtmException("No enough amount in bank account.");
        }
        return amount;
    }

    public void deposit(Integer amount) {
        if (this.current == null)
            throw new AtmException("No user logon.");
        this.availableAmountInMachine += amount;
        this.userData.deposit(this.current, amount - this.transactionFee);
    }

    public List<String> recentTransactions() {
        if (this.current == null)
            throw new AtmException("No user logon.");
        return this.userData.getRecentTransactions(this.current);
    }

    public boolean changePassword(String oldPassword, String password) {
        if (this.current == null)
            throw new AtmException("No user logon.");
        if (this.userData.validatePassword(this.current, oldPassword)) {
            this.userData.resetPassword(this.current, password);
            return true;
        }
        return false;
    }

    public void exit() {
        if (this.current == null)
            throw new AtmException("No user logon.");
        this.current = null;
    }

    public static void main(String[] args) {
        Atm atm = new Atm();
        String password = "testpassword";
        Integer money = 1000;
        atm.createUser("Sara", 23, "Test Address", "2062306676", password);
        User user = atm.createUser("John", 20, "Test Address", "2062306666", password);
        System.out.println(user.getBankAccountNumber());

        atm.login(user.getBankAccountNumber(), password);
        try {
            money += atm.withDrawl(10000);
        } catch (AtmException e) {
            System.out.println(e.getMessage());
        }
        atm.deposit(money);
        atm.deposit(money);
        atm.deposit(money);
        atm.withDrawl(1000);
        atm.deposit(money);
        atm.deposit(money);
        atm.deposit(money);
        atm.withDrawl(1000);
        atm.withDrawl(1000);
        atm.withDrawl(1000);
        atm.withDrawl(1000);
        System.out.println(atm.availableBalance());
        System.out.println(Arrays.toString(atm.recentTransactions().toArray()));
        String newPassword = "passwordTest";
        atm.changePassword(password, newPassword);
        atm.exit();
        try {
            money += atm.withDrawl(10000);
        } catch (AtmException e) {
            System.out.println(e.getMessage());
        }

        try {
            atm.login(user.getBankAccountNumber(), password);
        } catch (AtmException e) {
            System.out.println(e.getMessage());
        }

        atm.login(user.getBankAccountNumber(), newPassword);
        atm.exit();

        String forgetPassword = "PasswordTest";
        try {
            atm.forgetPassword("John", 20, "2063206666", user.getBankAccountNumber(), forgetPassword);
        } catch (AtmException e) {
            System.out.println(e.getMessage());
        }
        atm.forgetPassword("John", 20, "2062306666", user.getBankAccountNumber(), forgetPassword);


        try {
            atm.login(user.getBankAccountNumber(), newPassword);
        } catch (AtmException e) {
            System.out.println(e.getMessage());
        }

        atm.login(user.getBankAccountNumber(), forgetPassword);
        try {
            atm.withDrawl(1000000);
        } catch (AtmException e) {
            System.out.println(e.getMessage());
        }
    }
}
