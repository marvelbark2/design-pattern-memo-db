package observable;

public interface Listener<EventType> {
    void ev(EventType e);
}
