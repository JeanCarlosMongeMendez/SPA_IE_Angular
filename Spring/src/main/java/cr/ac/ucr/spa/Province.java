package cr.ac.ucr.spa;

import org.springframework.lang.Nullable;
import javax.validation.constraints.NotNull;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Province",  schema = "BS_ISem_2020")
public class Province {
    @Id
    @Column(name="Id_Province")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProvince;

    @Column(name="Name")
    @NotNull
    private String name;

    public Province() {
    }

    public Province(int idProvince, String name) {
        this.idProvince = idProvince;
        this.name = name;
    }


    public int getIdProvince() {
        return idProvince;
    }

    public void setIdProvince(int idProvince) {
        this.idProvince = idProvince;
    }

    public String getName() {
        return name;
    }

    public void setName(String nameProvince) {
        this.name = name;
    }
}
