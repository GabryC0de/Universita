/**
 * Classe che rappresenta uno studente con nome, voto della prova scritta
 * e voto della prova orale.
 */
public class Student {
    private final String name;
    private final int written;
    private final int oral;

    /** Costruttore */
    public Student(String name, int written, int oral) {
        this.name = name;
        this.written = written;
        this.oral = oral;
    }

    public String getName() {
        return name;
    }

    public int getWritten() {
        return written;
    }

    public int getOral() {
        return oral;
    }

    /** Restituisce la media aritmetica dei due voti */
    public double getAverage() {
        return (written + oral) / 2.0;
    }

    @Override
    public String toString() {
        return name + " " + written + " " + oral;
    }
}
