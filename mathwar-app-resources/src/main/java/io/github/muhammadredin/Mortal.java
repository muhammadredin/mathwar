package io.github.muhammadredin;

public interface Mortal {
    public void receiveDamage(int damage);
}

//public interface Mortal<T extends Number> {
//    public void receiveDamage(T damage);
//}
/*
 * Jika menggunakan generics pada interface maka kita bisa membuat
 * interface yang dinamis untuk tipe datanya, sehingga dapat menyesuaikan
 * dengan class yang mengimplementasi interface tersebut
 */
