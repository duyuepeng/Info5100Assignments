package A6_5100.ATM;

import java.util.Objects;

public class User {
    private String name;
    private int age;
    private String address;
    private String phoneNumber;
    private String bankAccountNumber;

    public User(String name, int age, String address, String phoneNumber, String bankAccountNumber) {
        this.setName(name);
        this.setAge(age);
        this.setAddress(address);
        this.setPhoneNumber(phoneNumber);
        this.setBankAccountNumber(bankAccountNumber);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 130 || age < 14) {
            throw new AtmException("Invalid age.");
        }
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() > 11)
            throw new AtmException("Invalid phone number.");
        for (char c : phoneNumber.toCharArray()) {
            if (!Character.isDigit(c))
                throw new AtmException("Invalid phone number.");
        }
        this.phoneNumber = phoneNumber;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getBankAccountNumber().equals(user.getBankAccountNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBankAccountNumber());
    }

    public boolean compareInfo(String name, int age, String phoneNumber, String bankAccountNumber) {
        if (this.getName().equals(name) &&
                this.getAge() == age &&
                this.getPhoneNumber().equals(phoneNumber))
            return true;
        return false;
    }
}
