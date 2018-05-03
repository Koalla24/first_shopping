package kaa.shop.Domen;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "goods")
public class EntityGoods {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "name")
    private String Name;

    @OneToMany(mappedBy = "Good")
    @JoinColumn(name = "id_good", referencedColumnName = "id")
    private List<EntitySalesTable> SalesTable;

    public EntityGoods() {
    }

    public EntityGoods(@NotNull String name) {
        Name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<EntitySalesTable> getSalesTable() {
        return SalesTable;
    }

    public void setSalesTable(List<EntitySalesTable> salesTable) {
        SalesTable = salesTable;
    }
}
