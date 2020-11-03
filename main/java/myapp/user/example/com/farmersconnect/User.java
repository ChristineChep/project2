package myapp.user.example.com.farmersconnect;

public class User {
    private String name1;
    private String category1;
    private String email;
    private String password;
    private String cpass1;
    private String product1;
    private String number1;
    private String identification1;
    private String country1;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String name1, String category1, String email, String password, String product1,String number1,String identification1,String country1) {
        this.name1 = name1;
        this.category1 = category1;
        this.email = email;
        this.password = password;
        //this.cpass1 = cpass1;
        this.product1 = product1;
        this.number1 = number1;
        this.identification1 = identification1;
        this.country1 = country1;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getCategory1() {
        return category1;
    }

    public void setCategory1(String category1) {
        this.category1 = category1;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpass1() {
        return cpass1;
    }

    public void setCpass1(String cpass1) {
        this.cpass1 = cpass1;
    }

    public String getProduct1() {
        return product1;
    }

    public void setProduct1(String product1) {
        this.product1 = product1;
    }

    public String getNumber1() {
        return number1;
    }

    public void setNumber1(String number1) {
        this.number1 = number1;
    }

    public String getIdentification1() {
        return identification1;
    }

    public void setIdentification1(String identification1) {
        this.identification1 = identification1;
    }

    public String getCountry1() {
        return country1;
    }

    public void setCountry1(String country1) {
        this.country1 = country1;
    }
}

