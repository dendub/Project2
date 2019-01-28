package Entity;

public class Delivery {

    private static final long serialVersionUID = 1L;

    private Integer ORDER_ID;
    private String type;
    private Clients clients;

    public Delivery() {
    }

    public Integer getORDER_ID() {
        return ORDER_ID;
    }

    public void setORDER_ID(Integer ORDER_ID) {
        this.ORDER_ID = ORDER_ID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Clients getClients() {
        return clients;
    }

    public void setClients(Clients clients) {
        this.clients = clients;
    }

    @Override
    public String toString()
    {
        return "Types [" + type + "]";
    }

}
