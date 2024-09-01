package io.github.muhammadredin;

public enum WeaponType {
    BASIC("Basic"), LIGHT("Light"), HEAVY("Heavy");
    private final String type;

    WeaponType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
