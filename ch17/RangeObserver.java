package hw.ch17;

public class RangeObserver implements Observer {
    @Override
    public void update(NumberGenerator generator) {
        int num = generator.getNumber();
        if (num < 10) {
            System.out.println("RangeObserver: [Low] " + num);
        } else if (num < 20) {
            System.out.println("RangeObserver: [Mid] " + num);
        } else {
            System.out.println("RangeObserver: [High] " + num);
        }
    }
}