package entity;

public abstract class Data {
    protected String email,password;
    public Data (String email, String password){
        this.email = email;
        this.password = password;
    }

    public Data() {

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
}
