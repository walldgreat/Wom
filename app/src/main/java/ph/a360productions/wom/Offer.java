package ph.a360productions.wom;

/**
 * Created by lai on 8/24/15.
 */

public class Offer {

    private int id;

    private String brand;
    private String offer_name;
    private String description;
    private String price;
    private String validity;
    private String keyword;
    private String access_code;

    public Offer(){}

    public Offer(String brand, String offer_name, String description, String price, String validity, String keyword, String access_code) {
        super();
    //    this.title = title;
    //    this.author = author;

        this.brand=brand;
        this.offer_name=offer_name;
        this.description=description;
        this.price=price;
        this.validity=validity;
        this.keyword=keyword;
        this.access_code=access_code;
    }

    //getters & setters

    @Override
    public String toString() {
        //return "Book [id=" + id + ", title=" + title + ", author=" + author
         //       + "]";
        return "Offer [" +
                "id="+id+
                ", brand="+ brand+
                ", offer_name="+ offer_name +
                ", description="+ description +
                ", price="+ price +
                ", validity="+ validity +
                ", keyword="+ keyword +
                ", access_code="+ access_code +
        "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOffer_name() {
        return offer_name;
    }

    public void setOffer_name(String offer_name) {
        this.offer_name = offer_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getAccess_code() {
        return access_code;
    }

    public void setAccess_code(String access_code) {
        this.access_code = access_code;
    }
}