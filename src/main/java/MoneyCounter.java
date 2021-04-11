
public class MoneyCounter {
    public double counter(int counts) { //Рассчет
        switch (counts) {
            case 1:
                return 400;
            case 2:
                return 800 * 0.95;
            case 3:
                return 1200 * 0.90;
            case 4:
                return 1600 * 0.80;
            case 5:
                return 2000 * 0.75;
        }
        return 0;
    }
}
