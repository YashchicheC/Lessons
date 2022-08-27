import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class StudentToGroup
{
    @JsonProperty
    public String name;

    @JsonProperty
    List<Integer> students;

    public StudentToGroup(String name, List<Integer> students) {
        this.name = name;
        this.students = students;
    }

    public StudentToGroup() {}
}
