package Entity;

public class Clients {

    private static final long serialVersionUID = 1L;

    private Integer ORDER_ID;
    private Integer PHONE_ID;
    private String comments;
    private String city;
    private Integer amount;
    private Phone phone;

    public Clients() {
    }

    public Integer getORDER_ID() {
        return ORDER_ID;
    }

    public void setORDER_ID(Integer ORDER_ID) {
        this.ORDER_ID = ORDER_ID;
    }

    public Integer getPHONE_ID() {
        return PHONE_ID;
    }

    public void setPHONE_ID(Integer PHONE_ID) {
        this.PHONE_ID = PHONE_ID;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    public String toString()
    {
        return "Amount [" + amount + "]";
    }

}