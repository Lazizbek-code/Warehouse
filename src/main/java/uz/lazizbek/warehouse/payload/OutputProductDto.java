package uz.lazizbek.warehouse.payload;

public class OutputProductDto {
    private Integer productId;
    private Double amount;
    private Double price;
    private Integer outputId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getOutputId() {
        return outputId;
    }

    public void setOutputId(Integer outputId) {
        this.outputId = outputId;
    }
}
