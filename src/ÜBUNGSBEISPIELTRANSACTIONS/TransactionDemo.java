package ÜBUNGSBEISPIELTRANSACTIONS;

import java.util.ArrayList;


public class TransactionDemo {

    public static void main(String[] args) {
        TransactionLoader tl = new TransactionLoader();
        ArrayList<Transaction> transactions;

        try {
            transactions = tl.loadTransactions("C:\\Users\\Mario\\IdeaProjects\\PruefungUebungenII\\src\\ÜBUNGSBEISPIELTRANSACTIONS\\transactions.csv");
        } catch (TransactionLoadException e) {
            throw new RuntimeException(e);
        }
        transactions.sort(new PriceProductComparator());

        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }

    }
}
