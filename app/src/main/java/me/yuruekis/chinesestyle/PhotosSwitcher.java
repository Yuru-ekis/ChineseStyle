package me.yuruekis.chinesestyle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PhotosSwitcher {

    //private String villageName;

    private static final List<Photos> photosListQIAOLIN = new ArrayList<>(Arrays.asList(new Photos("大门", "https://ws1.sinaimg.cn/mw690/0071ouepgy1g1k00uuei0j31hc0u0quu.jpg"), new Photos("校训碑", "https://ws1.sinaimg.cn/mw690/0071ouepgy1g1k00uuei0j31hc0u0quu.jpg"), new Photos("广场", "https://ws1.sinaimg.cn/mw690/0071ouepgy1g1k00uuei0j31hc0u0quu.jpg"), new Photos("房屋", "https://ws1.sinaimg.cn/mw690/0071ouepgy1g1k00uuei0j31hc0u0quu.jpg"), new Photos("住宅", "https://ws1.sinaimg.cn/mw690/0071ouepgy1g1k00uuei0j31hc0u0quu.jpg"), new Photos("院子", "https://ws1.sinaimg.cn/mw690/0071ouepgy1g1k00uuei0j31hc0u0quu.jpg"), new Photos("大门", "https://ws1.sinaimg.cn/mw690/0071ouepgy1g1k00uuei0j31hc0u0quu.jpg"), new Photos("庭院", "https://ws1.sinaimg.cn/mw690/0071ouepgy1g1k00uuei0j31hc0u0quu.jpg"), new Photos("广场", "https://ws1.sinaimg.cn/mw690/0071ouepgy1g1k00uuei0j31hc0u0quu.jpg"), new Photos("房屋", "https://ws1.sinaimg.cn/mw690/0071ouepgy1g1k00uuei0j31hc0u0quu.jpg"), new Photos("住宅", "https://ws1.sinaimg.cn/mw690/0071ouepgy1g1k00uuei0j31hc0u0quu.jpg"), new Photos("院子", "https://ws1.sinaimg.cn/mw690/0071ouepgy1g1k00uuei0j31hc0u0quu.jpg")));

    private static final List<Photos> photosListTAOSHAN = new ArrayList<>(Arrays.asList(new Photos("门", "https://ws1.sinaimg.cn/mw690/0071ouepgy1g1k00uuei0j31hc0u0quu.jpg"), new Photos("庭院", "https://ws1.sinaimg.cn/mw690/0071ouepgy1g1k00uuei0j31hc0u0quu.jpg"), new Photos("广场", "https://ws1.sinaimg.cn/mw690/0071ouepgy1g1k00uuei0j31hc0u0quu.jpg"), new Photos("房屋", "https://ws1.sinaimg.cn/mw690/0071ouepgy1g1k00uuei0j31hc0u0quu.jpg"), new Photos("住宅", "https://ws1.sinaimg.cn/mw690/0071ouepgy1g1k00uuei0j31hc0u0quu.jpg"), new Photos("院子", "https://ws1.sinaimg.cn/mw690/0071ouepgy1g1k00uuei0j31hc0u0quu.jpg")));

    private static final List<Photos> photosListJIALI = new ArrayList<>(Arrays.asList(new Photos("大", "https://ws1.sinaimg.cn/mw690/0071ouepgy1g1k00uuei0j31hc0u0quu.jpg"), new Photos("庭院", "https://ws1.sinaimg.cn/mw690/0071ouepgy1g1k00uuei0j31hc0u0quu.jpg"), new Photos("广场", "https://ws1.sinaimg.cn/mw690/0071ouepgy1g1k00uuei0j31hc0u0quu.jpg"), new Photos("房屋", "https://ws1.sinaimg.cn/mw690/0071ouepgy1g1k00uuei0j31hc0u0quu.jpg"), new Photos("住宅", "https://ws1.sinaimg.cn/mw690/0071ouepgy1g1k00uuei0j31hc0u0quu.jpg"), new Photos("院子", "https://ws1.sinaimg.cn/mw690/0071ouepgy1g1k00uuei0j31hc0u0quu.jpg")));

    public static List<Photos> getPhotosList(String villageName) {
        switch (villageName) {
            case "汕大剪纸":
                return photosListQIAOLIN;
            case "剪纸过程":
                return photosListTAOSHAN;
            case "贾里村":
                return photosListJIALI;
            default:
                break;
        }
        return photosListJIALI;
    }
}
