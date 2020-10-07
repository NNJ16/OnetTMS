package lk.nnj.mdss.fx.dto;

import java.util.Date;

public class TrackDTO {
    private String tid;
    private Date delDate;
    private String status;
    private String note;
    private String delby;
    private String oid;

    public TrackDTO(){}
    public TrackDTO(String tid, Date delDate, String status, String note, String delby, String oid) {
        this.tid = tid;
        this.delDate = delDate;
        this.status = status;
        this.note = note;
        this.delby = delby;
        this.oid = oid;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public Date getDelDate() {
        return delDate;
    }

    public void setDelDate(Date delDate) {
        this.delDate = delDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDelby() {
        return delby;
    }

    public void setDelby(String delby) {
        this.delby = delby;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    @Override
    public String toString() {
        return "TrackDTO{" +
                "tid='" + tid + '\'' +
                ", delDate=" + delDate +
                ", status='" + status + '\'' +
                ", note='" + note + '\'' +
                ", delby='" + delby + '\'' +
                ", oid='" + oid + '\'' +
                '}';
    }
}
