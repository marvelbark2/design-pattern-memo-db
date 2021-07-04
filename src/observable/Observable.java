package observable;

import java.util.ArrayList;
import java.util.List;

public class Observable<EventType> {
    List<Listener<EventType>> listeners = new ArrayList<>();

    public void subscribe(Listener<EventType> listener) {
        listeners.add(listener);
    }

    public void publish(EventType event) {
        listeners.forEach(listener -> listener.ev(event));
    }
}
