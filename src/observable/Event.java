package observable;

public class Event{
    public static class BeforeSetEvent <T>  {
        private T value;
        private T newValue;

        public BeforeSetEvent() {
        }

        public BeforeSetEvent(T value, T newValue) {
            this.value = value;
            this.newValue = newValue;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public T getNewValue() {
            return newValue;
        }

        public void setNewValue(T newValue) {
            this.newValue = newValue;
        }
    }

    public static class AfterSetEvent <T>{
        private T value;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }
}
