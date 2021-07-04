package strategy;

import db.BaseRecord;

public class StrategyClass <T extends BaseRecord> {
    private int max = 0;
    private T item = null;

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "StrategyClass{" +
                "max=" + max +
                ", item=" + item +
                '}';
    }
}
