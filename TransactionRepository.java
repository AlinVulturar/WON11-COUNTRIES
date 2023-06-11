import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {
    private List<Transaction> transactions;

    public TransactionRepository() {
        this.transactions = new ArrayList<>();
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void updateTransaction(Transaction transaction) {
        for (int i = 0; i < transactions.size(); i++) {
            if (transactions.get(i).getId() == transaction.getId()) {
                transactions.set(i, transaction);
                break;
            }
        }
    }

    public void deleteTransaction(int id) {
        transactions.removeIf(transaction -> transaction.getId() == id);
    }
}