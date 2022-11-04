public class MovieGoer {
    private String name;
    private int mobileNumber;
    private String email;
    private Transaction[] pastTransactions;

    public MovieGoer(String name, int mobileNumber, String email, Transaction[] pastTransactions) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.pastTransactions = pastTransactions;
    }

    public String getName() {
        return name;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public Transaction[] getPastTransactions() {
        return pastTransactions;
    }
}
