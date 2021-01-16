package model;

import com.google.gson.annotations.SerializedName;

public class TablesData {

    @SerializedName("id")
    private String id;

    @SerializedName("product_category_id")
    private String cid;

    @SerializedName("name")
    private String name;
    @SerializedName("producer")
    private String producer;

    @SerializedName("cost")
    private String cost;

    @SerializedName("rating")
    private Float rating;

    @SerializedName("product_images")
    private String product_images;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getProduct_images() {
        return product_images;
    }

    public void setProduct_images(String product_images) {
        this.product_images = product_images;
    }
}

