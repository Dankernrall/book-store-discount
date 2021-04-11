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