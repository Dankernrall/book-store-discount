import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> books = Arrays.asList(1, 1, 2, 3, 4, 4, 5, 5);
        BookStore bookStore = new BookStore();
        //HashMap<Integer, Integer> copyingOfBooks = new HashMap();
            //for (Integer b : books) {
               // int newValue = copyingOfBooks.getOrDefault(b, 0) + 1;
                //copyingOfBooks.put(b, newValue);}
        System.out.println(bookStore.calculateBasketCost(books));

    }
}
