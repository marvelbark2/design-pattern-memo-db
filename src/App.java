import db.*;
import model.Pokemon;

public class App {
    public static void main(String[] args) {
        Database<Pokemon> db = InMemoryDB.getInstance("memo");
        Pokemon spinosaur = new Pokemon("Spinosaur", 750, 350);
        Pokemon bulbasaur = new Pokemon("Bulbasaur", 800, 200);

        db.onBeforeAdd(e -> {
            System.out.println("Value; " + e.getValue());
            System.out.println("New value: " +e.getNewValue());
        });

        db.set(spinosaur);
        db.onAfterAdd(e -> System.out.println(e.getValue()));
        db.set(bulbasaur);
        db.onAfterAdd(e -> System.out.println(e.getValue()));
        db.visit(p -> System.out.println(p.getId()));
        Pokemon bestAttack = db.selectBest((p  )-> p.getAttack());
        Pokemon bestDefense = db.selectBest((p  )-> p.getDefense());

        System.out.println(String.format("Best defense = %s \n" + "Best attack = %s", bestDefense.getId(), bestAttack.getId()) );
    }
}
