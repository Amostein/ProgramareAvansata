public class Project {
    public enum Typee {
        theoretical, practical
    }
    private final String nume;
    private final Typee type;

    public Project(String nume,Typee type) {
        this.nume = nume;
        this.type=type;
    }

    public String getNume() {
        return nume;
    }
    public Typee getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Project{name='" + nume + "', type=" + type + "}";
    }
}
