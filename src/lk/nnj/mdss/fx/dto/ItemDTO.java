package lk.nnj.mdss.fx.dto;

public class ItemDTO {
    private String itemId;
    private String name;
    private String desc;

    public ItemDTO(String itemId, String name, String desc) {
        this.itemId = itemId;
        this.name = name;
        this.desc = desc;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "itemId='" + itemId + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
