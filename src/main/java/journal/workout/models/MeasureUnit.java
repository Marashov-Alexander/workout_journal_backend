package journal.workout.models;

import javax.persistence.*;

@Entity
@Table(name = "measureunits", schema = "WJDB")
public class MeasureUnit {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "acronym")
    private String acronym;

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

    public String findAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }
}
