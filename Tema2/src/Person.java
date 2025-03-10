/**
 * Aceasta este clasa virtuala Persoana din care clasa Teacher si Student mostenesc numele și data nașterii.
 */

import java.time.LocalDate;
abstract class Person {
    protected String name;
    protected LocalDate birthDate;

    public Person(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }


}
