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
    private String nameDistrict;

    public District() {
    }

    public District(int idDistrict, int idCanton, String nameDistrict) {
        this.idDistrict = idDistrict;
        this.idCanton = idCanton;
        this.nameDistrict = nameDistrict;
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

    public String getNameDistrict() {
        return nameDistrict;
    }

    public void setNameDistrict(String nameDistrict) {
        this.nameDistrict = nameDistrict;
    }
}
