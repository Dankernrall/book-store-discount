import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class BookStore {
    MoneyCounter check = new MoneyCounter();
    int count = 0;
    int finalPrice = 0;
    int y = 0;
    int size = 0;
    boolean first = true;
    HashMap<Integer, Integer> copyingOfBooks = new HashMap();

    public int calculateBasketCost(List<Integer> books) {
        if(books.isEmpty())
            return 0;
        if(first){
        for (Integer b : books) {
            size++;
            int newValue = copyingOfBooks.getOrDefault(b, 0) + 1;
            copyingOfBooks.put(b, newValue);
        }
        first = false;
        }                        //здесь
        while(count < Collections.max(copyingOfBooks.values())){
            for (int i = 1; i < copyingOfBooks.size()+1; i++) {
                if(size % 8 == 0 && count == 4){
                    finalPrice += check.counter(count);
                    count = 0;
                    break;}
                while (copyingOfBooks.containsKey(i) && copyingOfBooks.get(i) > 1) {
                    y = i;
                    count++;
                    copyingOfBooks.replace(i, copyingOfBooks.get(i), copyingOfBooks.get(i) - 1);
                    break;
                }
                if(count==5)
                    break;
                if (!copyingOfBooks.containsValue(2) && !copyingOfBooks.containsValue(3) && copyingOfBooks.get(i) != 0 && y != i) {
                    copyingOfBooks.replace(i, copyingOfBooks.get(i), copyingOfBooks.get(i) - 1);
                    count++;
                }
                y=0;


            }}
        finalPrice += check.counter(count);
        count = 0;
        if (Collections.max(copyingOfBooks.values()) > 0)
            calculateBasketCost(books);
        return finalPrice;
    }
}
