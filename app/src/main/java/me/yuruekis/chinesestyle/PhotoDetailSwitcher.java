package me.yuruekis.chinesestyle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PhotoDetailSwitcher {

    //private String villageName;

    private static final String xiaoXunBei = "汕头大学是1981年经国务院批准成立的综合性大学。汕头大学是教育部、广东省、李嘉诚基金会三方共建的高等院校，也是全球唯一一所由私人基金会——李嘉诚基金会持续资助的公立大学，该基金会对汕大（包括长江商学院）承诺捐款额达80亿港元（至2018年）。学校占地面积1888.70亩，建筑面积56.80万平方米（含体育馆、医学院、住宿学院等项目）。\n" +
            "\n" +
            "汕头大学设有文学院、理学院、工学院、医学院、法学院、商学院、长江艺术与设计学院、长江新闻与传播学院，面向全国（含港澳台地区）招收博士、硕士和本科生。现有教职工1602人，全日制在校生10294人，已为社会培养出各类人才10万人。";

    public static String getPhotoDetail(String photoName) {
        switch (photoName) {
            case "校训碑":
                return xiaoXunBei;
            case "剪纸过程":
                //return ;
            case "贾里村":
                //return ;
            default:
                break;
        }
        return xiaoXunBei;
    }
}
