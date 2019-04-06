package me.yuruekis.chinesestyle;

public class Village {
    private String name;

    private String villageImageURL;

    public Village(String name, String villageImageURL) {
        this.name = name;
        this.villageImageURL = villageImageURL;
    }

    public String getName() {
        return name;
    }

    public String getVillageImageURL() {
        return villageImageURL;
    }
}
