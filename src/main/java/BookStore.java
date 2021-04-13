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
        }
//здесь
        while(count < Collections.max(books) && count <Collections.max(copyingOfBooks.values())){
            for (int i = 1; i < copyingOfBooks.size()+2; i++) {
                try{
                if(size % 8 == 0 && count == 4){
                    finalPrice += check.counter(count);
                    count = 0;
                    break;}
                if (copyingOfBooks.get(i) > 1 && y!=i) {
                    y = i;
                    copyingOfBooks.replace(i, copyingOfBooks.get(i) - 1);
                    count++;
                }
                else if (y!=i && copyingOfBooks.get(i) == 1 && Collections.max(copyingOfBooks.values()) ==1)  {
                    copyingOfBooks.replace(i, copyingOfBooks.get(i) - 1);
                    count++;
                }
                    y=0;
                }catch(NullPointerException e){}
            }}
        finalPrice += check.counter(count);
        count = 0;
        if (Collections.max(copyingOfBooks.values()) > 0)
            calculateBasketCost(books);
        return finalPrice;
    }
}
