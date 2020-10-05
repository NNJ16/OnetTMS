package lk.nnj.mdss.fx.Entity;

public class Customer {
    private String glno;
    private String BAname;
    private String phone;
    private String addr1;
    private String addr2;
    private String city;

    public Customer(String glno, String BAname, String phone, String addr1, String addr2, String city) {
        this.glno = glno;
        this.BAname = BAname;
        this.phone = phone;
        this.addr1 = addr1;
        this.addr2 = addr2;
        this.city = city;
    }

    public String getGlno() {
        return glno;
    }

    public void setGlno(String glno) {
        this.glno = glno;
    }

    public String getBAname() {
        return BAname;
    }

    public void setBAname(String BAname) {
        this.BAname = BAname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddr1() {
        return addr1;
    }

    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    public String getAddr2() {
        return addr2;
    }

    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
