package lk.nnj.mdss.fx.dto;

import java.time.LocalDate;
import java.util.Date;

public class OrderDtDTO {
    private String oid;
    private String glno;
    private String baname;
    private LocalDate odate;
    private String desc;
    private String tid;
    private String status;
    private String city;

    public OrderDtDTO(String oid, String glno, String baname, LocalDate odate, String desc, String tid, String status, String city) {
        this.oid = oid;
        this.glno = glno;
        this.baname = baname;
        this.odate = odate;
        this.desc = desc;
        this.tid = tid;
        this.status = status;
        this.city = city;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getGlno() {
        return glno;
    }

    public void setGlno(String glno) {
        this.glno = glno;
    }

    public String getBaname() {
        return baname;
    }

    public void setBaname(String baname) {
        this.baname = baname;
    }

    public LocalDate getOdate() {
        return odate;
    }

    public void setOdate(LocalDate odate) {
        this.odate = odate;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "OrderDtDTO{" +
                "oid='" + oid + '\'' +
                ", glno='" + glno + '\'' +
                ", baname='" + baname + '\'' +
                ", odate=" + odate +
                ", desc='" + desc + '\'' +
                ", tid='" + tid + '\'' +
                ", status='" + status + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
