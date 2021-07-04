package model;

import db.BaseRecord;

public class Pokemon extends BaseRecord {
    private int defense;
    private int attack;

    public Pokemon(String id, int defense, int attack) {
        this.setId(id);
        this.defense = defense;
        this.attack = attack;
    }

    public Pokemon() {
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    @Override
    public String toString() {
        return "model.Pokemon{" +
                "id=" + getId() +
                ", defense=" + defense +
                ", attack=" + attack +
                '}';
    }
}
