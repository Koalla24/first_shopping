package kaa.shop.Domen;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "contragents")
public class EntityContragents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "name")
    private String Name;

    @OneToMany(mappedBy = "Contragent")
    //@JoinColumn(name = "Contragent" /*, referencedColumnName = "Contragent"*/)
    private List<EntitySalesHeader> SalesHeader;

    public EntityContragents() {
    }

    public EntityContragents(@NotNull String name) {
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

    public List<EntitySalesHeader> getSalesHeader() {
        return SalesHeader;
    }

    public void setSalesHeader(List<EntitySalesHeader> salesHeader) {
        SalesHeader = salesHeader;
    }

    @Override
    public String toString() {
        return "EntityContragents{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", SalesHeader=" + SalesHeader +
                '}';
    }
}
