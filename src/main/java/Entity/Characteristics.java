package Entity;

public class Characteristics {

    private static final long serialVersionUID = 1L;

    private Integer ID;
    private String body;
    private String color;
    private Integer screen_size;
    private Phone phone;

    public Characteristics() {}


    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getScreen_size() {
        return screen_size;
    }

    public void setScreen_size(Integer screen_size) {
        this.screen_size = screen_size;
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
        return "Characteristics [" + color + "]";
    }
}