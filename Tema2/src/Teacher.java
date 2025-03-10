import java.time.LocalDate;

/**
 * Aceasta este clasa Profesor
 */
public class Teacher extends Person {
    protected String idNumber;
    protected Problem[] listOfProblems;
    protected int numberOfProblems;
    public Teacher(String nume, LocalDate birthDate, String idNumber) {
        super(nume,birthDate);
        this.idNumber=idNumber;
        this.numberOfProblems=0;
        this.listOfProblems=new Problem[100];
    }
    public void createProblem(String name)
    {
        Problem problem = new Problem(name,this);
        this.listOfProblems[this.numberOfProblems]=problem;
        numberOfProblems++;
    }
    public Problem[] getListOfProblems() {
        return listOfProblems;
    }
    public int getNumberOfProblems(){
        return numberOfProblems;
    }
    public String getIdNumber() {
        return idNumber;
    }
}
