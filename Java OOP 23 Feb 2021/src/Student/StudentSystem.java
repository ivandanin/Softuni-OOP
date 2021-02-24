package Student;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repo;

    public StudentSystem()
    {
        this.repo = new HashMap<>();
    }

    public void ParseCommand(String[]args)
    {
        switch (args[0]) {
            case "Create": {
                String name = args[1];
                int age = Integer.parseInt(args[2]);
                double grade = Double.parseDouble(args[3]);
                if (!repo.containsKey(name)) {
                    Student student = new Student(name, age, grade);
                    repo.put(name, student);
                }
                break;
            }
            case "Show": {
                String name = args[1];
                if (repo.containsKey(name)) {
                    Student student = repo.get(name);
                    String view = String.format("%s is %s years old.", student.getName(), student.getAge());

                    if (student.getGrade() >= 5.00) {
                        view += " Excellent student.";
                    } else if (student.getGrade() >= 3.50) {
                        view += " Average student.";
                    } else {
                        view += " Very nice person.";
                    }

                    System.out.println(view);
                }
                break;
            }
        }
    }
}
