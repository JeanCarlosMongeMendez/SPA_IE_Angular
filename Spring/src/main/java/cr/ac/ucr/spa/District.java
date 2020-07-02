package cr.ac.ucr.spa;

import javax.persistence.*;

@Entity
@Table(name="District",  schema = "BS_ISem_2020")
public class District {

    @Column(name="Id_District")
    private int idDistrict;

    @Column(name="Id_Canton")
    private int idCanton;

    @Column(name="Name")
    private String name;

    public District() {
    }

    public District(int idDistrict, int idCanton, String name) {
        this.idDistrict = idDistrict;
        this.idCanton = idCanton;
        this.name = name;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
