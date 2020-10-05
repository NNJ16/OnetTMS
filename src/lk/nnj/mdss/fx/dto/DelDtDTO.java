package lk.nnj.mdss.fx.dto;

import java.util.Date;

public class DelDtDTO
{
    private String tid;
    private Date date;
    private String glno;
    private String baname;
    private String desc;
    private String status;
    private String note;
    private String delby;

    public DelDtDTO(String tid, Date date, String glno, String baname, String desc, String status, String note, String delby) {
        this.tid = tid;
        this.date = date;
        this.glno = glno;
        this.baname = baname;
        this.desc = desc;
        this.status = status;
        this.note = note;
        this.delby = delby;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelby() {
        return delby;
    }

    public void setDelby(String delby) {
        this.delby = delby;
    }

    @Override
    public String toString() {
        return "DelDtDTO{" +
                "tid='" + tid + '\'' +
                ", date=" + date +
                ", glno='" + glno + '\'' +
                ", baname='" + baname + '\'' +
                ", desc='" + desc + '\'' +
                ", status='" + status + '\'' +
                ", delby='" + delby + '\'' +
                '}';
    }
}
