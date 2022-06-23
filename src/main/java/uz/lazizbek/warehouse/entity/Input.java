package uz.lazizbek.warehouse.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Input {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Timestamp date;

    @ManyToOne
    private Warehouse warehouse;

    @ManyToOne
    private Supplier supplier;

    @ManyToOne
    private Currency currency;

    private String factureNumber;

    @Column(nullable = false, unique = true)
    private String code;

    public Input() {
    }

    public Input(Integer id, Timestamp date, Warehouse warehouse, Supplier supplier, Currency currency, String factureNumber, String code) {
        this.id = id;
        this.date = date;
        this.warehouse = warehouse;
        this.supplier = supplier;
        this.currency = currency;
        this.factureNumber = factureNumber;
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getFactureNumber() {
        return factureNumber;
    }

    public void setFactureNumber(String factureNumber) {
        this.factureNumber = factureNumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
