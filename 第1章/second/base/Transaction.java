import edu.princeton.cs.algs4.Date;

/**
 * 1.2.14
 */

public class Transaction implements Comparable<Transaction> {
    private final String who;
    private final Date when;
    private final double amount;

    public Transaction(String who, Date when, double amount) {
        this.who = who;
        this.when = when;
        this.amount = amount;
    }

    public Transaction(String transaction) {
        String[] fields = transaction.split(" ");
        if (fields.length != 3) {
            throw new IllegalArgumentException("Invalid transaction");
        }
        who = fields[0];
        when = new Date(fields[1]);
        amount = Double.parseDouble(fields[2]);
    }

    public String who() {
        return who;
    }

    public Date when() {
        return when;
    }

    public double amount() {
        return amount;
    }

    @Override
    public String toString() {
        return who + " " + when.toString() + " " + amount;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that)
            return true;
        if (that == null)
            return false;
        if (this.getClass() != that.getClass())
            return false;
        Transaction other = (Transaction) that;
        return (this.who.equals(other.who)) && (this.when.equals(other.when)) && (this.amount == other.amount);
    }

    @Override
    public int compareTo(Transaction that) {
        if (this.when.compareTo(that.when) != 0) {
            return this.when.compareTo(that.when);
        } else {
            return Double.compare(this.amount, that.amount);
        }
    }

    @Override
    public int hashCode() {
        return who.hashCode() + when.hashCode() + (int) amount;
    }

    public static void main(String[] args) {
        Date date = new Date("5/22/1939");
        Transaction transaction = new Transaction("Turing", date, 190.10);
        System.out.println(transaction);
    }
}
