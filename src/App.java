import adaptor.Loader;
import adaptor.PokemonDBAdapter;
import db.*;
import model.Pokemon;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class App {
    public static void main(String[] args) {
        Database<Pokemon> db = InMemoryDB.getInstance("memo");
        Pokemon spinosaur = new Pokemon("Spinosaur", 800, 350);
        Pokemon bulbasaur = new Pokemon("Bulbasaur", 801, 200);

        db.onBeforeAdd(e -> {
            System.out.println("Value; " + e.getValue());
            System.out.println("New value: " +e.getNewValue());
        });

        db.set(spinosaur);
        db.onAfterAdd(e -> System.out.println(e.getValue()));
        db.set(bulbasaur);
        db.onAfterAdd(e -> System.out.println(e.getValue()));

        new Loader<>("src/data.json", new PokemonDBAdapter(), Pokemon.class);

        db.visit(p -> System.out.println(p.getId()));
//        Pokemon bestAttack = db.selectBest((p  )-> p.getAttack());
//        Pokemon bestDefense = db.selectBest((p  )-> p.getDefense());

//        System.out.println(String.format("Best defense = %s \n" + "Best attack = %s", bestDefense.getId(), bestAttack.getId()) );

    }
}
