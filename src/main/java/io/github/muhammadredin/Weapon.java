package io.github.muhammadredin;

abstract public class Weapon {
    protected int baseDamage;
    protected WeaponType type;

    abstract public int getBaseDamage();
    abstract public WeaponType getType();
}

class DullSword extends Weapon {
    private final int baseDamage = 10;
    private final WeaponType type = WeaponType.BASIC;

    public int getBaseDamage() {
        return baseDamage;
    }

    public WeaponType getType() {
        return type;
    }
}
