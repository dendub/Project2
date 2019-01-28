package Entity;

public class Phone  {

    private static final long serialVersionUID = 1L;

    private Integer ID;
    private String company;
    private String model;
    private String country;

    public Phone() {}

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    @Override
    public String toString()
    {
        return "Phone ["+ "ID:" + ID +" Company:"+ company +" Model:"+ model +" Country:"+ country +"]";
    }

}
