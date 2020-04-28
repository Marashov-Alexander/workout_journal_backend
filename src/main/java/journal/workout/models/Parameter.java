package journal.workout.models;

import javax.persistence.*;

@Entity
@Table(name = "parameters", schema = "WJDB")
public class Parameter {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "measure_unit_id")
    private MeasureUnit measureUnit;

    @ManyToOne
    @JoinColumn(name = "parameter_type_id")
    private ParameterType parameterType;

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

    public MeasureUnit findMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(MeasureUnit measureUnit) {
        this.measureUnit = measureUnit;
    }

    public ParameterType findParameterType() {
        return parameterType;
    }

    public void setParameterType(ParameterType parameterType) {
        this.parameterType = parameterType;
    }
}
