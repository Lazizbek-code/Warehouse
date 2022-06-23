package uz.lazizbek.warehouse.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class InputProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Product product;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private Double price;

    private Date expireDate;

    @ManyToOne
    private Input input;

    public InputProduct() {
    }

    public InputProduct(Integer id, Product product, Double amount, Double price, Date expireDate, Input input) {
        this.id = id;
        this.product = product;
        this.amount = amount;
        this.price = price;
        this.expireDate = expireDate;
        this.input = input;
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

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Input getInput() {
        return input;
    }

    public void setInput(Input input) {
        this.input = input;
    }
}
