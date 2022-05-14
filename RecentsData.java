package aligoldsmith.com.model;

public class RecentsData {
    String Ring;
    String desc;
    String price;
    Integer imagrUrl;

    public Integer getImagrUrl() {
        return imagrUrl;
    }

    public void setImagrUrl(Integer imagrUrl) {
        this.imagrUrl = imagrUrl;
    }

    public RecentsData(String ring, String desc, String price, Integer imagrUrl) {
        this.Ring = ring;
        this.desc = desc;
        this.price = price;
        this. imagrUrl=imagrUrl;

    }

    public String getRing() {
        return Ring;
    }

    public void setRing(String ring) {
        Ring = ring;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}