package uz.lazizbek.warehouse.entity;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(optional = false)
    private Category category;

    @OneToOne
    private Attachment image;

    private String code;

    @ManyToOne(optional = false)
    private Measurement measurement;

    private boolean active = true;

    public Product() {
    }

    public Product(Integer id, String name, Category category, Attachment image, String code, Measurement measurement, boolean active) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.image = image;
        this.code = code;
        this.measurement = measurement;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Attachment getImage() {
        return image;
    }

    public void setImage(Attachment image) {
        this.image = image;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
