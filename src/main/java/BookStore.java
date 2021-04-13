import java.util.*;

public class BookStore {
    Set<Integer> uniqKeys = new TreeSet<>();
    List<Integer> notUniq = new ArrayList<>();
    double count = 0; //Сумма денег
    int counts = 0; //Количество уникальных книг
    boolean first = true;  //Запуск только один раз
    int forFive, forThree;

    public double calculateBasketCost(List<Integer> books) {
        if (first) {  //Так как List<Integer> books является не модифицируемым листом
            first = false; //то забиваем его в наш лист.
            notUniq.addAll(books);
        }
        uniqKeys.addAll(notUniq); //Переносим все значения в TreeSet, благодаря чему получаем только уникальные значения, без повторений
        for (int i = 0; i < uniqKeys.toArray().length; i++) {
            counts++; //Прибавляем книгу в "связку" уникальных книг
            notUniq.remove(uniqKeys.toArray()[i]); //Удаляем уникальное число из корзины
        }
        switch (counts) {
            case 1:
                count += 400;
                break;
            case 2:
                count += 800 * 0.95;
                break;
            case 3:
                forThree++;
                break;
            case 4:
                count += 1600 * 0.80;
                break;
            case 5:
                forFive++;
                break;
        }
        counts = 0;
        uniqKeys.clear();
        if (notUniq.size() > 0) {
            calculateBasketCost(notUniq); //Если массив еще полностью не очищен, запускаем заново.
        }
        //Рассчет
        while (forThree > 0 || forFive > 0) { //Пока имеются уникальные наборы книг по 3 и 5 штук
            if (forThree != 0 && forFive != 0) { // Разбиваем по 4 группы
                count += (1600 * 0.80) * 2;
                forThree--;
                forFive--;
            } else if (forThree == 0) { // Заносим в итоговую стоимость уникальную группу книг из 5
                count += 2000 * 0.75;
                forFive--;
            } else {
                count += 1200 * 0.90; // Заносим в итоговую стоимость уникальную группу книг из 3
                forThree--;
            }
        }
        return this.count; //Возвращаем сумму
    }
}
