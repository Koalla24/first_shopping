package kaa.shop.Domen;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sales_table")
public class EntitySalesTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sales_header")
    private EntitySalesHeader SalesHeader;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_good")
    private EntityGoods Good;

    @NotNull
    @Column(name = "count_weight", columnDefinition = "float DEFAULT 0.0")
    private float CountWeight;

    @NotNull
    @Column(name = "sum", columnDefinition = "float DEFAULT 0.0")
    private float Sum;

    public EntitySalesTable() {
    }

    public EntitySalesTable(@NotNull EntitySalesHeader salesHeader, @NotNull EntityGoods good, @NotNull float countWeight, @NotNull float sum) {
        SalesHeader = salesHeader;
        Good = good;
        CountWeight = countWeight;
        Sum = sum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public EntitySalesHeader getSalesHeader() {
        return SalesHeader;
    }

    public void setSalesHeader(EntitySalesHeader salesHeader) {
        SalesHeader = salesHeader;
    }

    public EntityGoods getGood() {
        return Good;
    }

    public void setGood(EntityGoods good) {
        Good = good;
    }

    public float getCountWeight() {
        return CountWeight;
    }

    public void setCountWeight(float countWeight) {
        CountWeight = countWeight;
    }

    public float getSum() {
        return Sum;
    }

    public void setSum(float sum) {
        Sum = sum;
    }
}
