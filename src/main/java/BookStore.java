import java.util.*;

public class BookStore {
    MoneyCounter moneyCounter = new MoneyCounter();
    Set<Integer> uniqKeys = new TreeSet<>();
    List<Integer> notUniq = new ArrayList<>();
    double count = 0; //Сумма денег
    int counts = 0; //Количество уникальных книг
    boolean first = true;  //Запуск только один раз
    boolean minDiscount = false;

    public double calculateBasketCost(List<Integer> books) {
        if (first) {  //Так как List<Integer> books является не модифицируемым листом
            first = false; //то забиваем его в наш лист.
            notUniq.addAll(books);
        }
        uniqKeys.addAll(notUniq); //Переносим все значения в TreeSet, благодаря чему получаем только уникальные значения, без повторений
        for (int i = 0; i < uniqKeys.toArray().length; i++) {
            if (i == 4 && books.size() % 8 == 0) { //Если размер корзины делится с остатком на 8, с большой вероятностью
                this.count += moneyCounter.counter(counts); //она выгоднее по 4 штуки в связке
                minDiscount = true;
                counts = 0;
                break;
            }
            counts++; //Прибавляем книгу в "связку" уникальных книг
            notUniq.remove(uniqKeys.toArray()[i]); //Удаляем уникальное число из корзины
        }
        if (minDiscount) {
            minDiscount = false;
        } else {
            this.count += moneyCounter.counter(counts);
            counts = 0;
        }
        uniqKeys.clear();
        if (notUniq.size() > 0) {
            calculateBasketCost(notUniq); //Если массив еще полностью не очищен, запускаем заново.
        }
        return this.count; //Возвращаем сумму
    }

}
/* Попытка сделать через HashMap
    int count = 0;
    int finalPrice = 0;
    MoneyCounter check = new MoneyCounter();
    List<Integer> books = Arrays.asList(1, 1, 2, 3, 3, 3, 5, 4, 4, 5, 1);
    HashMap<Integer, Integer> copyingOfBooks = new HashMap();
        for (Integer b : books) {
                int newValue = copyingOfBooks.getOrDefault(b, 0) + 1;
                copyingOfBooks.put(b, newValue);
                }
public void doIt(HashMap<Integer, Integer> copyingOfBooks){
        for (int i = 1; i < copyingOfBooks.size() + 1; i++) {
        System.out.println(copyingOfBooks.values());
        while (copyingOfBooks.containsKey(i) && copyingOfBooks.get(i) > 1) {
        count++;
        copyingOfBooks.replace(i, copyingOfBooks.get(i), copyingOfBooks.get(i) - 1);
        continue;
        }
        if(!copyingOfBooks.containsValue(2)){
        count++;
        copyingOfBooks.replace(i, copyingOfBooks.get(i), copyingOfBooks.get(i) - 1);}

        //else{copyingOfBooks.replace(i, copyingOfBooks.get(i), copyingOfBooks.get(i) - 1);count++;}
        }
        System.out.println(copyingOfBooks);} */