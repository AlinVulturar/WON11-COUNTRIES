import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BudgetManager {

    private List<Transaction> transactions;
    private Map<String, List<Transaction>> typeReport;
    private Map<String, List<Transaction>> productReport;

    public BudgetManager() {
        this.transactions = new ArrayList<>();
        this.typeReport = new HashMap<>();
        this.productReport = new HashMap<>();
    }

    public List<Transaction> getTransactions(String product, String type, Double minAmount, Double maxAmount) {
        return transactions.stream()
                .filter(t -> product == null || t.getProduct().equals(product))
                .filter(t -> type == null || t.getType().equals(type))
                .filter(t -> minAmount == null || t.getAmount() >= minAmount)
                .filter(t -> maxAmount == null || t.getAmount() <= maxAmount)
                .collect(Collectors.toList());
    }

    public Transaction getTransactionById(String id) {
        return transactions.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        typeReport.computeIfAbsent(transaction.getType(), k -> new ArrayList<>()).add(transaction);
        productReport.computeIfAbsent(transaction.getProduct(), k -> new ArrayList<>()).add(transaction);
    }

    public void replaceTransaction(String id, Transaction transaction) {
        transactions.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .ifPresent(t -> {
                    transactions.remove(t);
                    transactions.add(transaction);
                    typeReport.computeIfAbsent(transaction.getType(), k -> new ArrayList<>()).add(transaction);
                    productReport.computeIfAbsent(transaction.getProduct(), k -> new ArrayList<>()).add(transaction);
                });
    }

    public void deleteTransaction(String id) {
        transactions.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .ifPresent(t -> {
                    transactions.remove(t);
                    typeReport.get(t.getType()).remove(t);
                    productReport.get(t.getProduct()).remove(t);
                });
    }

    public Map<String, List<Transaction>> getTypeReport() {
        return typeReport;
    }

    public Map<String, List<Transaction>> getProductReport() {
        return productReport;
    }
}

public class Transaction {

    private String id;
    private String product;
    private String type;
