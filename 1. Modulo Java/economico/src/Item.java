public class Item {
    private String code;
    private String name;
    private Integer stock;
    private Double unitaryPrice;

    // Constructor
    public Item(String code, String name, Integer stock, Double unitaryPrice) {
        this.code = code;
        this.name = name;
        this.stock = stock;
        this.unitaryPrice = unitaryPrice;
    }

    // Getters and setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getUnitaryPrice() {
        return unitaryPrice;
    }

    public void setUnitaryPrice(Double unitaryPrice) {
        this.unitaryPrice = unitaryPrice;
    }
}
