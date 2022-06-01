/*import java.util.ArrayList;

public enum Student
{
    Student_1(001, "Boris", "Johnson"),
    Student_2 (002, "Andrzei", "Duda"),
    Student_3 (003, "Egils", "Levits"),
    Student_4 (004, "Gitanas", "Nauseda"),
    Student_5 (005, "Alar", "Karis");

    int student_ID;
    String name;
    String surname;
    boolean headman;
    String item;
    boolean homework_done;

    Student (int student_ID, String name, String surname)
    {
        this.student_ID = student_ID;
        this.name = name;
        this.surname = surname;

    }
    public void ChangeTheHeadman (int student_ID) //отдельный класс
    {
        ArrayList<Student> studList = new ArrayList<>(); //список студентов

        for (Student student: Student.values())
        {
            studList.add(student);
        }

        for (int i = 0; i < studList.size(); i++)
        {
            if(student_ID == studList.get(i).student_ID)
            {
                studList.get(i).headman = true;
            }
            else studList.get(i).headman = false;
        }
        for (Student student:Student.values())
        {
            System.out.println("Student_ID " + student.student_ID + " Headman " + student.headman);
        }
    }
    public void AddTaskForGroup(String item)
    {
        for (Student student: Student.values())
        {
            student.item = item;
            System.out.println("Student_ID " + student.student_ID + " has an item? " + item);
        }
    }
    public void CheckedHomework (int indexOfStudent, boolean homework_done)
    {
        for (Student student: Student.values())
        {
            if (student.student_ID == indexOfStudent)
            {
               student.homework_done = homework_done;
            }
           System.out.println("Student_ID " + student.student_ID + " CheckedHomework " + student.homework_done);
        }
    }
    public void ChangeStudent (int indexOfStudent, String name, String surname)
    {
        for (Student student: Student.values())
        {
            if (student.student_ID == indexOfStudent)
            {
                student.name = name;
                student.surname = surname;
            }
            System.out.println("Student_ID " + indexOfStudent + " New Name " + student.name + " New Surname " + student.surname);
        }
    }
}*/

