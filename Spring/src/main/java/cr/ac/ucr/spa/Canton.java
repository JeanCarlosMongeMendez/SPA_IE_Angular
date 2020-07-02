package cr.ac.ucr.spa;

import javax.persistence.*;

@Entity
@Table(name="Canton",  schema = "BS_ISem_2020")
public class Canton {

    @Column(name="Id_Canton")
    private int idCanton;

    @Column(name="Name")
    private String name;

    @Column(name="Id_Province")
    private int idProvince;

    public Canton() {
    }

    public Canton(int idCanton, String name, int idProvince) {
        this.idCanton = idCanton;
        this.name = name;
        this.idProvince = idProvince;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public int getIdProvince() {
        return idProvince;
    }

    public void setIdProvince(int idProvince) {
        this.idProvince = idProvince;
    }
}
