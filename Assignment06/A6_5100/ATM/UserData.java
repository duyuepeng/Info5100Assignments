package A6_5100.ATM;

import java.util.*;

public class UserData {
    private static String SALT = "*Ug^YH7yed(I";
    private Map<User, AccountInfo> data;

    private class AccountInfo {
        String password;
        Integer availableBalance;
        List<String> transactions;

        public AccountInfo(String password, Integer availableBalance, List<String> transactions) {
            this.password = password;
            this.availableBalance = availableBalance;
            this.transactions = transactions;
        }
    }

    public UserData() {
        this.data = new HashMap<>();
    }

    public void createUser(User user, String password) {
        this.data.put(user, new AccountInfo("",
                0,
                new ArrayList<>()));
        this.resetPassword(user, password);
    }

    public boolean validatePassword(User user, String password) {
        AccountInfo info = this.data.get(user);
        return info.password.equals(convertStringToHex(password + SALT));
    }

    public User getUser(String bankAccountNumber) {
        for (User user : this.data.keySet()) {
            if (user.getBankAccountNumber().equals(bankAccountNumber))
                return user;
        }
        return null;
    }

    public Integer availableBalance(User user) {
        return this.data.get(user).availableBalance;
    }

    public void resetPassword(User user, String password) {
        if (password.length() < 6)
            throw new AtmException("Password too short.");
        AccountInfo accountInfo = this.data.get(user);
        accountInfo.password = convertStringToHex(password + SALT);
    }

    public Integer withDrawl(User user, Integer amount) {
        AccountInfo accountInfo = this.data.get(user);
        if (accountInfo.availableBalance - amount < 0)
            return -1;
        else {
            accountInfo.availableBalance -= amount;
            accountInfo.transactions.add("withDrawal - " + amount);
            return amount;
        }
    }

    public void deposit(User user, Integer amount) {
        AccountInfo accountInfo = this.data.get(user);
        accountInfo.availableBalance += amount;
        accountInfo.transactions.add("deposit - " + amount);
    }

    public List<String> getRecentTransactions(User user) {
        AccountInfo accountInfo = this.data.get(user);
        List<String> list = new ArrayList<>();
        for (int i = accountInfo.transactions.size() - 10; i < accountInfo.transactions.size(); i++) {
            list.add(accountInfo.transactions.get(i));
        }
        return list;
    }

    private static String convertStringToHex(String str) {

        char[] chars = str.toCharArray();

        StringBuffer hex = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            hex.append(Integer.toHexString((int) chars[i]));
        }

        return hex.toString();
    }
}
