package lk.nnj.mdss.fx.Entity;

import java.util.Date;

public class Return {
    private Date date;
    private String glno;
    private String tid;
    private String baname;
    private String desc;
    private String note;

    public Return(Date date, String glno, String tid, String baname, String desc, String note) {
        this.date = date;
        this.glno = glno;
        this.tid = tid;
        this.baname = baname;
        this.desc = desc;
        this.note = note;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getGlno() {
        return glno;
    }

    public void setGlno(String glno) {
        this.glno = glno;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getBaname() {
        return baname;
    }

    public void setBaname(String baname) {
        this.baname = baname;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Return{" +
                "date=" + date +
                ", glno='" + glno + '\'' +
                ", tid='" + tid + '\'' +
                ", baname='" + baname + '\'' +
                ", desc='" + desc + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
