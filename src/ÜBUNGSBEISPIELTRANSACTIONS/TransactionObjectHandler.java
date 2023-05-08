package ÜBUNGSBEISPIELTRANSACTIONS;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TransactionObjectHandler {

    public void saveTransactions(ArrayList<Transaction> list, String path) throws TransactionObjectException {

        try {
            FileOutputStream fo = new FileOutputStream(path);
            ObjectOutputStream oo = new ObjectOutputStream(fo); {
    oo.writeObject(list);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }}
