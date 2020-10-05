package lk.nnj.mdss.fx.Entity;

import java.time.LocalDate;
import java.util.Date;

public class Order {
    private String oid;
    private LocalDate date;
    private String description;
    private String gllno;

    public Order(String oid, LocalDate date, String description, String gllno) {
        this.oid = oid;
        this.date = date;
        this.description = description;
        this.gllno = gllno;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGllno() {
        return gllno;
    }

    public void setGllno(String gllno) {
        this.gllno = gllno;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid='" + oid + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", gllno='" + gllno + '\'' +
                '}';
    }
}
