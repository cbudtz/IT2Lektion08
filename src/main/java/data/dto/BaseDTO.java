package data.dto;

import java.io.Serializable;

public class BaseDTO implements Serializable {
    private String id;

    public BaseDTO(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
