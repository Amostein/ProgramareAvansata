public class Problem {
    protected String name;
    Teacher author;
    Student student;

    public Problem(String name, Teacher author) {
        this.name = name;
        this.author = author;
        this.student=null;
    }
    public void setAuthor(Teacher author) {
        this.author = author;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public String getName() {
        return name;
    }

    /**
     * Cand printez o problema vreau sa arat cine a creat-o si cine e responsabil de ea.
     * @return
     */
    @Override
    public String toString() {
        if(this.student==null) {
            return "Project " + " was created by " + author.getName() + " and doesn't have a student.";
        }
        else {
            return "Project " + " was created by " + author.getName() + " and it's assigned to "+this.student.getName();
        }
    }
}
