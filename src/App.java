import db.Database;
import db.Event;
import db.InMemoryDB;
import db.Visitor;
import model.Pokemon;

public class App {
    public static void main(String[] args) {
        Database<Pokemon> db = InMemoryDB.getInstance("memo");
        Pokemon spinosaur = new Pokemon("Spinosaur", 150, 750);
        Pokemon bulbasaur = new Pokemon("Bulbasaur", 400, 1150);

        db.onBeforeAdd(e -> {
            System.out.println("Value; " + e.getValue());
            System.out.println("New value: " +e.getNewValue());
        });

        db.set(spinosaur);
        db.onAfterAdd(e -> System.out.println(e.getValue()));
        db.set(bulbasaur);
        db.onAfterAdd(e -> System.out.println(e.getValue()));
        db.visit(p -> System.out.println(p.getId()));
    }
}
