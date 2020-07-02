package cr.ac.ucr.spa;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
//@NamedStoredProcedureQuery(name = "Canton.getCantonByProvince", procedureName =  "SelectStudentById",resultClasses = Canton.class,parameters = {@StoredProcedureParameter(mode = ParameterMode.IN, name = "Id_Province", type = Integer.class)})
@Table(name="Canton",  schema = "BS_ISem_2020")
public class Canton {
    @Id
    @Column(name="Id_Canton")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCanton;

    @Column(name="Name")
    @NotNull
    private String nameCanton;

    @Column(name="Id_Province")
    @NotNull
    private int idProvince;

    public Canton() {
    }

    public Canton(int idCanton, String nameCanton, int idProvince) {
        this.idCanton = idCanton;
        this.nameCanton = nameCanton;
        this.idProvince = idProvince;
    }


    public int getIdCanton() {
        return idCanton;
    }

    public void setIdCanton(int idCanton) {
        this.idCanton = idCanton;
    }

    public String getNameCanton() {
        return nameCanton;
    }

    public void setNameCanton(String nameCanton) {
        this.nameCanton = nameCanton;
    }

    public int getIdProvince() {
        return idProvince;
    }

    public void setIdProvince(int idProvince) {
        this.idProvince = idProvince;
    }
}
