package cr.ac.ucr.spa;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Province",  schema = "BS_ISem_2020")
public class Province {
    @Column(name="Id_Province")
    private int idProvince;

    @Column(name="Name")
    private String name;

    public Province() {
    }

    public Province(int idProvince, String name) {
        this.idProvince = idProvince;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdProvince() {
        return idProvince;
    }

    public void setIdProvince(int idProvince) {
        this.idProvince = idProvince;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
