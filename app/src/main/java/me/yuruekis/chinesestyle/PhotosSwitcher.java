package me.yuruekis.chinesestyle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PhotosSwitcher {

    //private String villageName;

    private static final List<Photos> photosListQIAOLIN = new ArrayList<>(Arrays.asList(new Photos("大门", "https://ww1.sinaimg.cn/large/0071ouepgy1g1vk9sr7nlj31400u0774.jpg"), new Photos("图书馆", "https://i.loli.net/2019/04/08/5cab4f7d52dc7.png"), new Photos("真理钟", "https://ww1.sinaimg.cn/large/0071ouepgy1g1vk2wzapgj30pc0j1tuk.jpg"), new Photos("医学院", "https://ww1.sinaimg.cn/large/0071ouepgy1g1vk27h0mej30nu0hn1b0.jpg"), new Photos("大礼堂", "https://i.loli.net/2019/04/08/5cab4fa7102f8.png")));

    private static final List<Photos> photosListTAOSHAN = new ArrayList<>(Arrays.asList(new Photos("大礼堂", "https://ws1.sinaimg.cn/large/0071ouepgy1g1vo1y9qp1j31hc0u0te4.jpg"), new Photos("真理钟", "https://ws1.sinaimg.cn/large/0071ouepgy1g1vo274velj30u0140adk.jpg")));

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
