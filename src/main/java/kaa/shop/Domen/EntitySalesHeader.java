package kaa.shop.Domen;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "sales_header")
public class EntitySalesHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "date_doc", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date DateDoc;

    @NotNull
    @Column(name = "num_doc")
    private String NumDoc;

    @OneToMany(mappedBy = "SalesHeader")
    //@JoinColumn(name = "id_sales_header", referencedColumnName = "id")
    private List<EntitySalesTable> SalesTable;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_contragent")
    private EntityContragents Contragent;

    public EntitySalesHeader() {
    }

    public EntitySalesHeader(@NotNull Date dateDoc, @NotNull String numDoc, @NotNull EntityContragents contragent) {
        DateDoc = dateDoc;
        NumDoc = numDoc;
        Contragent = contragent;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateDoc() {
        return DateDoc;
    }

    public void setDateDoc(Date dateDoc) {
        DateDoc = dateDoc;
    }

    public String getNumDoc() {
        return NumDoc;
    }

    public void setNumDoc(String numDoc) {
        NumDoc = numDoc;
    }

    public List<EntitySalesTable> getSalesTable() {
        return SalesTable;
    }

    public void setSalesTable(List<EntitySalesTable> salesTable) {
        SalesTable = salesTable;
    }

    public EntityContragents getContragent() {
        return Contragent;
    }

    public void setContragent(EntityContragents contragent) {
        Contragent = contragent;
    }
}
