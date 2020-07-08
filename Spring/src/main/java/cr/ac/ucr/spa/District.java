package cr.ac.ucr.spa;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="District",  schema = "BS_ISem_2020")
public class District {

    @Id
    @Column(name="Id_District")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idDistrict;

    @Column(name="Id_Canton")
    @NotNull
    private int idCanton;

    @Column(name="Name")
    @NotNull
    private String name;

    public District() {
    }

    public District(int idDistrict, int idCanton, String name) {
        this.idDistrict = idDistrict;
        this.idCanton = idCanton;
        this.name = name;
    }

    public int getIdDistrict() {
        return idDistrict;
    }

    public void setIdDistrict(int idDistrict) {
        this.idDistrict = idDistrict;
    }

    public int getIdCanton() {
        return idCanton;
    }

    public void setIdCanton(int idCanton) {
        this.idCanton = idCanton;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
