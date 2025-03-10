/**
 * Clasa student care moștenește atributele din Person
 */

import java.time.LocalDate;
import java.util.Objects;

public class Student extends  Person{
    protected Project project;
    /**
     * Am considerat ca un student poate să aibă maxim 2 preferințe referitor la proiecte/probleme
     */
    protected String Pref1;
    protected String Pref2;
    public  Student(String name, LocalDate birth_date, String Pref1, String Pref2) {
        super(name, birth_date);
        this.Pref1 = Pref1;
        this.Pref2 = Pref2;
    }

    /**
     * setters si getters pentru variabile
     * @return
     */
    public String getPref1() {
        return Pref1;
    }
    public String getPref2() {
        return Pref2;
    }
    public void setProject(String  project, Project[] listaProject) {
        if(project==null) {
            this.project = null;
            return;
        }
        for(Project p : listaProject){
            if(Objects.equals(project, p.getNume())){
                this.project=p;
            }
        }
    }
    public Project getProject() {
        return project;
    }
    public String getProjectName() {
        if(project==null)
            return "";
        return this.project.getNume();
    }

    /**
     * override pentru functia de print a unui student
     * @return
     */
    @Override
    public String toString() {
        return "Student " + name + " got the "+ getProjectName() +" project.";
    }
}
