package lk.nnj.mdss.fx.dto;

public class ContainDTO {
    private String oid;
    private String itemId;
    private String name;
    private int qty;

    public ContainDTO(String oid, String itemId, String name, int qty) {
        this.oid = oid;
        this.itemId = itemId;
        this.name = name;
        this.qty = qty;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "ContainDTO{" +
                "oid='" + oid + '\'' +
                ", itemId='" + itemId + '\'' +
                ", name='" + name + '\'' +
                ", qty=" + qty +
                '}';
    }
}
