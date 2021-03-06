package db;

import observable.Event;
import observable.Listener;
import observable.Observable;
import strategy.Strategy;
import strategy.StrategyClass;

import java.util.HashMap;
import java.util.Map;

public class InMemoryDB {
    private  InMemoryDB() { }

    public static <E extends BaseRecord> Database<E> getInstance(String db) {
        if(db.equalsIgnoreCase("memo"))
            return InMemoDBSG.INSTANCE;
        else
            return null;
    }

    private enum InMemoDBSG implements  Database {
        INSTANCE;
        private final Map<String, BaseRecord> db;
        private Observable<Event.BeforeSetEvent> beforeAddListeners = new Observable<>();
        private Observable<Event.AfterSetEvent> afterAddListeners = new Observable<>();

        InMemoDBSG() {
            db = new HashMap<>();
        }

        @Override
        public BaseRecord get(String id) {
            return db.get(id);
        }

        @Override
        public void set(BaseRecord newValue) {
            Event.BeforeSetEvent before = new Event.BeforeSetEvent(get(newValue.getId()), newValue);
            this.beforeAddListeners.publish(before);
            db.put(newValue.getId(), newValue);
            Event.AfterSetEvent after = new Event.AfterSetEvent();
            after.setValue(newValue);
            this.afterAddListeners.publish(after);
        }

        @Override
        public void visit(Visitor obj) {
           db.values().forEach(obj);
        }

        @Override
        public BaseRecord selectBest(Strategy obj) {
            StrategyClass<BaseRecord> found = new StrategyClass<>();
            return db.values().stream().reduce(found.getItem(), (f, item) -> {
                int score = (int) obj.apply(item);

                if(score > found.getMax()) {
                    found.setItem(item);
                    found.setMax(score);
                }
                return found.getItem();
            });
        }


        @Override
        public void onAfterAdd(Listener event) {
            this.afterAddListeners.subscribe(event);
        }

        @Override
        public void onBeforeAdd(Listener event) {
            this.beforeAddListeners.subscribe(event);
        }
    }
}
