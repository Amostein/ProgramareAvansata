import java.time.LocalDate;

public class Main {
    public static boolean isGood(Student[] listaStudenti, Problem[] listaProblem)
    {
        int[] check= new int[listaProblem.length];
        for (Student student : listaStudenti) {
            if (student == null)
                return false;
            for(int i=0;i<listaProblem.length;i++) {
                if(student.getProjectName().equals(listaProblem[i].getName()))
                    if(check[i]==1)
                        return false;
                    check[i]=1;
                    break;
                }
            }
        return true;
    }
    public static void assignP(int i, Student[] listaStudenti, Project[] listaProject, boolean[] usedProjects, Problem[] listaProblem){
        if (i == listaProject.length) {
            return;
        }
        for(int j=0;j<listaProject.length;j++) {
            listaStudenti[i].setProject(listaStudenti[i].getPref1(), listaProject);
            usedProjects[j]=true;
            assignP(i + 1, listaStudenti, listaProject,usedProjects,listaProblem);
            if(isGood(listaStudenti,listaProblem)){
                return;
            }
            listaStudenti[i].setProject(null,listaProject);
            usedProjects[j]=false;
        }

        for(int j=0;j<listaProject.length;j++) {
            listaStudenti[i].setProject(listaStudenti[i].getPref2(), listaProject);
            usedProjects[j]=true;
            assignP(i + 1, listaStudenti, listaProject,usedProjects,listaProblem);
            if(isGood(listaStudenti,listaProblem)){
                return;
            }
            listaStudenti[i].setProject(null,listaProject);
            usedProjects[j]=false;
        }

    }
    public static void main(String[] args) {
        Student student = new Student("S1", LocalDate.of(2003,5,13),"P1","P2");
        Student student2 = new Student("S2", LocalDate.of(2003,2,20),"P1", "P3");
        Student student3 = new Student("S3", LocalDate.of(2003,10,3),"P3", "P4");
        Student student4 = new Student("S4", LocalDate.of(2003,7,8),"P1", "P4");

        Student[] listaStudenti=new Student[4];
        listaStudenti[0]=student;
        listaStudenti[1]=student2;
        listaStudenti[2]=student3;
        listaStudenti[3]=student4;

        Teacher[] listaTeacher=new Teacher[2];
        Teacher teacher=new Teacher("Prof1", LocalDate.of(1980,5,13), "10001");
        Teacher teacher2=new Teacher("Prof1", LocalDate.of(1977,8,30), "10002");
        listaTeacher[0]=teacher;
        listaTeacher[1]=teacher2;

        teacher.createProblem("P1");
        teacher.createProblem("P2");
        teacher2.createProblem("P3");
        teacher2.createProblem("P4");

        Project project=new Project("P1", Project.Typee.theoretical);
        Project project2=new Project("P2", Project.Typee.theoretical);
        Project project3=new Project("P3", Project.Typee.practical);
        Project project4=new Project("P4", Project.Typee.practical);

        int ProblemListSize=0;
        for(Teacher i:listaTeacher) {
            ProblemListSize+=i.getNumberOfProblems();
        }
        Problem[] listaProblem=new Problem[ProblemListSize];
        int k=0;
        for(Teacher i:listaTeacher) {
            for(Problem j:i.getListOfProblems()){
                if(j!=null) {
                    listaProblem[k++] = j;
                }
            }
        }

        Project[] listaProject=new Project[4];
        listaProject[0]=project;
        listaProject[1]=project2;
        listaProject[2]=project3;
        listaProject[3]=project4;

        boolean[] usedProjects = new boolean[4];
        assignP(0, listaStudenti, listaProject, usedProjects,listaProblem);

        for (Student value : listaStudenti) {
            System.out.println(value);
        }

    }
}