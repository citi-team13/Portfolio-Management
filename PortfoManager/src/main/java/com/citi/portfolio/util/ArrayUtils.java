package com.citi.portfolio.util;

import java.util.*;

/**
 * 数组转换
 */
public class ArrayUtils {

    /**
     * List<long> 转Long数组
     *
     * @param list
     * @return
     */
    public static long[] listDataToLong(List<Long> list) {
        long[] longs = new long[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            longs[i] = list.get(i);
        }
        return longs;
    }
    public static String listDataToStr(List<Long> list) {
        String str = "";
        for (int i = 0; i < list.size(); ++i) {
            str += list.get(i) + ",";
        }
        if (str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    /**
     * List<String> 转String数组
     *
     * @param list
     * @return
     */
    public static String[] listDataToString(List<String> list) {
        String[] longs = new String[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            longs[i] = list.get(i);
        }
        return longs;
    }

    /**
     * 转String数组
     *
     * @param distance
     * @return
     */
    public static String[] intDataToString(Integer distance) {
        String[] longs = new String[1];
        if (distance == 1) {
            longs[0] = "*1";
        } else {
            longs[0] = "*1.." + distance;
        }
        longs[0] = longs[0].replaceAll("\"", "");
        return longs;
    }

    /**
     * 删除ArrayList中重复元素
     *
     * @param list
     */
    public static List removeDuplicate(List list) {
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);
        return list;
    }

    /**
     * 获取List 信息中的id
     *
     * @param mapList
     * @return
     */
    public static List<Long> getMapListToListLong(List<Map<String, String>> mapList) {

        List<Long> longList = new ArrayList<>();
        Map<String, String> map = null;
        for (int i = 0; i < mapList.size(); i++) {
            map = mapList.get(i);
            String strID = map.get("ID");
            longList.add(Long.valueOf(strID));
        }
        return longList;
    }

    /**
     * Java List中的重复项出现次数
     *
     * @param trees_
     * @return
     */
    public static Map getListNum(List<String> trees_) {

        Map map = new HashMap();

        for (String temp : trees_) {
            Integer count = (Integer) map.get(temp);
            map.put(temp, (count == null) ? 1 : count + 1);
        }
        return map;
    }

}
