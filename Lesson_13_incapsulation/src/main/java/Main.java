import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        showHeadman(Student.Student_1);
        AddTheHomeTask();
        CheckedHomework ();
        WannaChangeGroup();
    }
    public static void showHeadman(Student student)
    {
        Student checkHead = student;
        checkHead.ChangeTheHeadman(003);
    }
    public static void AddTheHomeTask()
    {
        Student.Student_1.AddTaskForGroup("New task");
    }
    public static void CheckedHomework ()
    {
        Student.Student_1.CheckedHomework(004, true);
    }
    public static void WannaChangeGroup ()
    {
        Student.Student_1.ChangeStudent(001, "Vasya", "Pupkin");
    }
}
