package io.github.muhammadredin;

abstract public class Entity implements Mortal {
    protected String name;
    protected int hp;
    protected int baseDamage;

    public Entity(String name, int hp, int baseDamage) {
        this.name = name;
        this.hp = hp;
        this.baseDamage = baseDamage;
    }

//    @Override
//    public abstract void receiveDamage(int damage);

    public abstract <T extends Entity & Mortal> void attack(T target);
    public abstract String getName();
    public abstract int getHpInfo();
}

final class Hero extends Entity implements Mortal {
    private Weapon weapon = new DullSword();
    private int exp = 0;
    private int level = 1;

    public Hero(String name) {
        super(name, 100, 10);
    }

    public void addExp(int exp) {
        this.exp += exp;
    }

    public void addLevel(int level) {
        this.level += level;
        this.exp = 0;
    }

    @Override
    public <T extends Entity & Mortal> void attack(T target) {
        target.receiveDamage(this.baseDamage + this.weapon.getBaseDamage());
    }

    @Override
    public void receiveDamage(int damage) {
        this.hp -= damage;
        if (this.hp <= 0) this.hp = 0;
        Integer floa = new Integer("3.0");
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getHpInfo() {
        return this.hp;
    }
}

class Goblin extends Entity implements Mortal {
    private static Goblin obj = new Goblin();

    private Goblin() {
        super("Goblin", 20, 5);
    }

    public static Goblin getObj() {
        return obj;
    }

    @Override
    public void attack(Entity target) {
        target.receiveDamage(this.baseDamage);
    }

    public void receiveDamage(int damage) {
        this.hp -= damage;
        if (this.hp <= 0) this.hp = 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getHpInfo() {
        return this.hp;
    }
}

class Orc extends Entity implements Mortal {
    private static Orc obj = new Orc();

    private Orc() {
        super("Orc", 50, 10);
    }

    public static Orc getObj() {
        return obj;
    }

    @Override
    public <T extends Entity & Mortal> void attack(T target) {
        target.receiveDamage(this.baseDamage);
    }

    public void receiveDamage(int damage) {
        this.hp -= damage;
        if (this.hp <= 0) this.hp = 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getHpInfo() {
        return this.hp;
    }
}