package uz.lazizbek.warehouse.entity;

import javax.persistence.*;

@Entity
public class OutputProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Product product;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private Double price;

    @ManyToOne
    private Output output;

    public OutputProduct() {
    }

    public OutputProduct(Integer id, Product product, Double amount, Double price, Output output) {
        this.id = id;
        this.product = product;
        this.amount = amount;
        this.price = price;
        this.output = output;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Output getOutput() {
        return output;
    }

    public void setOutput(Output output) {
        this.output = output;
    }
}
