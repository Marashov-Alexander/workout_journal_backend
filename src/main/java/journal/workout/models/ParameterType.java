package journal.workout.models;

import javax.persistence.*;

@Entity
@Table(name = "parametertypes", schema = "WJDB")
public class ParameterType {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    public Long findId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String findName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
