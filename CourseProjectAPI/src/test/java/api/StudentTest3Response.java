package api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentTest3Response
{
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("first_name")
    private String first_name;
    @JsonProperty("last_name")
    private String last_name;

    public String sessionToken;

    public StudentTest3Response(Integer id, String first_name, String last_name)
    {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
    }
    public StudentTest3Response(){}

    public Integer getId()
    {
        return id;
    }

    public String getFirst_name()
    {
        return first_name;
    }

    public String getLast_name()
    {
        return last_name;
    }
}
