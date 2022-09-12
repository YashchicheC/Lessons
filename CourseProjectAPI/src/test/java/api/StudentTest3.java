package api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentTest3 {

    @JsonProperty("first_name")
    private String first_name = "StudentName";
    @JsonProperty("last_name")
    private String last_name = "StudentLastName";

    public StudentTest3(String first_name, String last_name)
    {
        this.first_name = first_name;
        this.last_name = last_name;
    }
    public StudentTest3(){}

    public String getFirst_name()
    {
        return first_name;
    }

    public String getLast_name()
    {
        return last_name;
    }
}
