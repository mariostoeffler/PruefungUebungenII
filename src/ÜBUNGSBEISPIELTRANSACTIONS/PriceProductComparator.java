package ÜBUNGSBEISPIELTRANSACTIONS;

import java.util.Comparator;

public class PriceProductComparator implements Comparator<Transaction> {

    public int compare(Transaction t1, Transaction t2) {
        int priceComparison = Double.compare(t1.getPrice(), t2.getPrice());
        if (priceComparison != 0) {
            return priceComparison;
        }

        return t2.getProduct().compareTo(t1.getProduct());
    }
}
