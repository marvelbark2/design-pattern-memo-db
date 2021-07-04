package db;

import observable.Event;
import observable.Listener;
import strategy.Strategy;

public interface Database<T extends BaseRecord> {
    T get(String id);
    void set(T newValue);
    void onBeforeAdd(Listener<Event.BeforeSetEvent<T>> event);
    void onAfterAdd(Listener<Event.AfterSetEvent<T>> event);
    void visit(Visitor<T> obj);
    T selectBest(Strategy<T> obj);
}