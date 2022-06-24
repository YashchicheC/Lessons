import java.util.ArrayList;

public class Main
{


    public static void main(String[] args)
    {
        GroupOfStudents groupOfStudents = new GroupOfStudents();
        int rand = groupOfStudents.getRand();
        ArrayList<StudentData> arGroupStud = groupOfStudents.getListOfStudent();

        groupOfStudents.fillingGroup();
        groupOfStudents.randomHeadman(rand);
        groupOfStudents.addStudent(006, "Vasya", "Pupkin");
        groupOfStudents.deleteStudent(001);
        groupOfStudents.renameStudent(006, "Sysan", "Pupkini");
        groupOfStudents.changeHeadman(003);
        groupOfStudents.newHometask("do the new task");
        groupOfStudents.homeworkHasDone(3, "do the new task", true);
        groupOfStudents.lookAllStudents();
    }
}
