package TextFinance.saveload;

import TextFinance.exception.ModelException;
import TextFinance.model.*;
import TextFinance.model.Currency;

import java.util.*;

public class SaveData {
    private static SaveData instance;

    private final Filter filter;
    private Common oldCommon;
    private boolean isSaved = true;


    private List<Article> articles = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();
    private List<Currency> currencies = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();
    private List<Transfer> transfers = new ArrayList<>();

    private SaveData() {
        load();
        this.filter = new Filter();
    }

    public void load() {
        SaveLoad.load(this);
        sort();
    }

    private void sort() {
        this.articles.sort((t1, t2) -> t1.getTitle().compareToIgnoreCase(t2.getTitle()));
        this.accounts.sort((t1, t2) -> t1.getTitle().compareToIgnoreCase(t2.getTitle()));
        this.transactions.sort((t1, t2) -> (int) t1.getDate().compareTo(t2.getDate()));
        this.transfers.sort((t1, t2) -> (int) t1.getDate().compareTo(t2.getDate()));
        this.currencies.sort(new Comparator<Currency>() {
            @Override
            public int compare(Currency o1, Currency o2) {
                if (o1.isBase()) {
                    return -1;
                }
                if (o2.isBase()) {
                    return 1;
                }
                if (o1.isOn() ^ o2.isOn()) {
                    if (o2.isOn()) return 1;
                    else return -1;

                }
                return o1.getTitle().compareToIgnoreCase(o2.getTitle());
            }
        });
    }

    public void save() {
        SaveLoad.save(this);
        isSaved = true;
    }

    public boolean isSaved() {
        return isSaved;
    }

    public static SaveData getInstance() {
        if (instance == null) {
            instance = new SaveData();
        }
        return instance;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public List<Transfer> getTransfers() {
        return transfers;
    }

    public Currency getBaseCurrency() {
        for (Currency c : currencies) {
            if (c.isBase()) {
                return c;
            }
        }
        return new Currency();
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void setTransfers(List<Transfer> transfers) {
        this.transfers = transfers;
    }

    public List<Currency> getEnabledCurrencies() {
        List<Currency> list = new ArrayList<>();
        for (Currency c : currencies) {
            if (c.isOn()) {
                list.add(c);
            }
        }
        return list;
    }

    public List<Transaction> getFilterTransactions() {
        List<Transaction> list = new ArrayList<>();
        for (Transaction t : transactions) {
            if (filter.check(t.getDate())) {
                list.add(t);
            }
        }
        return list;
    }

    public List<Transfer> getFilterTransfers() {
        List<Transfer> list = new ArrayList<>();
        for (Transfer t : transfers) {
            if (filter.check(t.getDate())) {
                list.add(t);
            }
        }
        return list;
    }

    public List<Transaction> getTransactionsOnCount(int count) {
        return new ArrayList<>(transactions.subList(0, Math.min(count, transactions.size())));
    }

    public Common getOldCommon() {
        return oldCommon;
    }

    public void add(Common c) throws ModelException {
        List ref = getRef(c);
        if (ref.contains(c)) {
            throw new ModelException(ModelException.IS_EXISTS);
        }
        ref.add(c);
        c.postAdd(this);
        sort();
        isSaved = false;
    }

    public void edit(Common oldC, Common newC) throws ModelException {
        List ref = getRef(oldC);
        if (ref.contains(newC) && oldC != ref.get(ref.indexOf(newC))) {
            throw new ModelException(ModelException.IS_EXISTS);
        }
        ref.set(ref.indexOf(oldC), newC);
        oldCommon = oldC;
        newC.postEdit(this);
        sort();
        isSaved = false;
    }

    public void remove(Common c) {
        getRef(c).remove(c);
        c.postDelete(this);
        isSaved = false;
    }

    private List getRef(Common c) {
        if (c instanceof Account) {
            return accounts;
        }
        if (c instanceof Article) {
            return articles;
        }
        if (c instanceof Currency) {
            return currencies;
        }
        if (c instanceof Transaction) {
            return transactions;
        }
        if (c instanceof Transfer) {
            return transfers;
        }
        return null;
    }

    @Override
    public String toString() {
        return "SaveData{" +
                "articles=" + articles +
                ", accounts=" + accounts +
                ", currencies=" + currencies +
                ", transactions=" + transactions +
                ", transfers=" + transfers +
                '}';
    }

    public void updateCurrencies() throws Exception {
        HashMap<String, Double> rates = RateCurrency.getRates(getBaseCurrency());
        for (Currency c : currencies)
            c.setRate(rates.get(c.getCode()));
        for (Account a : accounts)
            a.getCurrency().setRate(rates.get(a.getCurrency().getCode()));
        isSaved = false;
    }


    public ArrayList<Currency> getEnableCurrencies() {
        ArrayList<Currency> list = new ArrayList();
        for (Currency c : currencies)
            if (c.isOn()) list.add(c);
        return list;
    }

    public Filter getFilter() {
        return filter;
    }

    public void  clear() {
        articles.clear();
        accounts.clear();
        currencies.clear();
        transactions.clear();
        transfers.clear();
    }
}
