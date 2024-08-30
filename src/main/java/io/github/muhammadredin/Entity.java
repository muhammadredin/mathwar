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

    @Override
    public abstract void attack(Entity target);
    public abstract String getName();
    public abstract int getHpInfo();
}

class Hero extends Entity implements Mortal {
    private Weapon weapon = new DullSword();

    public Hero(String name) {
        super(name, 100, 10);
    }

    @Override
    public void attack(Entity target) {
        target.receiveDamage(this.baseDamage + this.weapon.getBaseDamage());
    }

    @Override
    public void receiveDamage(int damage) {
        this.hp -= damage;
        if (this.hp <= 0) this.hp = 0;
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
    public Goblin() {
        super("Goblin", 50, 5);
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