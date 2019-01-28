package Entity;

public class Company {

    private static final long serialVersionUID = 1L;

    private Integer COMPANY_ID;
    private String name;
    //private String surname;
    private Integer Phone_ID;
    private Phone phone;

    public Company() {
    }




   // public Integer getCOMPANY_ID() {
   //     return COMPANY_ID;
   // }

   // public void setCOMPANY_ID(Integer COMPANY_ID) {
    //    this.COMPANY_ID = COMPANY_ID;
    //}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getPhone_ID() {
        return Phone_ID;
    }

    public void setPhone_ID(Integer Phone_ID) {
        this.Phone_ID = Phone_ID;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Integer getCOMPANY_ID() {
        return COMPANY_ID;
    }

    public void setCOMPANY_ID(Integer COMPANY_ID) {
        this.COMPANY_ID = COMPANY_ID;
    }

//    @Override
//    public String toString()
//    {
//        return "Surnames ["+ surname + "]";
//    }
}