import java.util.*;

public class BookStore {
    MoneyCounter moneyCounter = new MoneyCounter();
    Set<Integer> uniqKeys = new TreeSet<>();
    List<Integer> notUniq = new ArrayList<>();
    double count = 0;
    boolean first = true;
    boolean minDiscount = false;

    public double calculateBasketCost(List<Integer> books) {
        if (first){
            first = false;
            notUniq.addAll(books);}
        uniqKeys.addAll(notUniq);
        for (int i = 0; i < uniqKeys.toArray().length; i++) {
            if(i == 4 && books.size() % 8 == 0){
                minDiscount = true;
                break;
            }
            notUniq.remove(uniqKeys.toArray()[i]);
        }
        if(minDiscount){
            this.count += moneyCounter.counter(notUniq,count);minDiscount = false;}
        else{
        this.count += moneyCounter.counter(new ArrayList<>(uniqKeys),count);}
        uniqKeys.clear();
        if (notUniq.size() > 0) {
            calculateBasketCost(notUniq);
        }
        return this.count;
    }

}