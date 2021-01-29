package expert.springframework.classicbooks.model;

import java.io.Serializable;

public class BaseEntity implements Serializable {

    //Clase creada para que otras puedan heredar el campo id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
