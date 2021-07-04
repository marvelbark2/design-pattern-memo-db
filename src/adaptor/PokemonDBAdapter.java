package adaptor;

import com.fasterxml.jackson.databind.JsonNode;
import db.Database;
import db.InMemoryDB;
import model.Pokemon;

public class PokemonDBAdapter implements RecordHandler<Pokemon>{
    @Override
    public void addRecord(Pokemon obj) {
        Database<Pokemon> db = InMemoryDB.getInstance("memo");
        db.set(obj);
    }
}
