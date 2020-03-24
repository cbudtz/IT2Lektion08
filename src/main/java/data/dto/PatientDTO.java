package data.dto;

public class PatientDTO extends BaseDTO{
    private String name;

    public PatientDTO(String name, String id) {
        super(id);
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
