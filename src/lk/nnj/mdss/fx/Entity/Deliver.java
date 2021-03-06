package lk.nnj.mdss.fx.Entity;

public class Deliver {
    private String IDno;
    private String name;
    private String mobile;
    private String pwd;
    private String type;

    public Deliver(String IDno, String name, String mobile, String pwd, String type) {
        this.IDno = IDno;
        this.name = name;
        this.mobile = mobile;
        this.pwd = pwd;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getIDno() {
        return IDno;
    }

    public void setIDno(String IDno) {
        this.IDno = IDno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Deliver{" +
                "IDno='" + IDno + '\'' +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
