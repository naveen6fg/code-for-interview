package stream.problem.given.by.Aadi;

public class Student {
    private String name;
    private String grade;
    private double score;

    public Student(String name, String grade, double score) {
        this.name = name;
        this.grade = grade;
        this.score = score;
    }

    public String getName() { return name; }
    public String getGrade() { return grade; }
    public double getScore() { return score; }
}