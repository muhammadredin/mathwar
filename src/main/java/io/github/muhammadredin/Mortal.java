package io.github.muhammadredin;

import java.util.Optional;

public interface Mortal {
    public void attack(Entity target);
    public void receiveDamage(int damage);
}
