package ÜBUNGSBEISPIELTRANSACTIONS;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TransactionLoader {

    public ArrayList<Transaction> loadTransactions(String path) throws TransactionLoadException {

        ArrayList<Transaction> transactions = new ArrayList<>();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));


        String line = null;

        try {
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length != 3) {
                    throw new TransactionLoadException("falsches Format!" + line);
                }

                String name = fields[0];
                String date = fields[1];
                double amount = Double.parseDouble(fields[2]);

                Transaction transaction = new Transaction(date, name, amount);
                transactions.add(transaction);

            }
        }
        catch (IOException e) {
            throw new TransactionLoadException("Fehler beim Lesen der Datei");
            }
        } catch (FileNotFoundException e) {
            throw new TransactionLoadException("Fehler beim Laden der Datei " + e.getMessage());
        }

        return transactions;

        }


    }


