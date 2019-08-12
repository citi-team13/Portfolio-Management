package com.citi.portfolio.common;


import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;


/**
 * 参数验证
 */
public final class Assert {
    public Assert() {
    }

    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void isTrue(boolean expression) {
        isTrue(expression, "[Assertion failed] - this expression must be true");
    }

    public static void isNull(Object object, String message) {
        if (object != null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void isNull(Object object) {
        isNull(object, "[Assertion failed] - the object argument must be null");
    }

    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void notNull(Object object) {
        notNull(object, "[Assertion failed] - this argument is required; it must not be null");
    }








    public static boolean isEmpty(String str) {
        return StringUtils.isEmpty(str);
    }

    public static boolean isNotEmpty(String str) {
        return StringUtils.isNotEmpty(str);
    }

    /**
     * 判断数据不为空
     *
     * @param data
     * @return
     */
    public static boolean isNotEmpty(Object data) {
        return !isEmpty(data);
    }

    /**
     * 判断所有的是否都不为空
     *
     * @param datas
     * @return
     */
    public static boolean isNotNullForAll(Object... datas) {

        if (isNULL(datas)) {
            return false;
        }

        for (Object data : datas) {
            if (isNULL(data)) {
                return false;
            }
        }

        return true;

    }

    /**
     * 判断对象或对象数组中每一个对象是否为空: 对象为null，字符序列长度为0，集合类、Map为empty
     *
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj.getClass().isArray()) {
            return Array.getLength(obj) == 0;
        }
        if (obj instanceof CharSequence) {
            return ((CharSequence) obj).length() == 0;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty() && ((Collection) obj).size() == 0;
        }
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }
        if (obj instanceof Object[]) {
            Object[] object = (Object[]) obj;
            if (object.length == 0) {
                return true;
            }
            boolean empty = true;
            for (int i = 0; i < object.length; i++) {
                if (!isEmpty(object[i])) {
                    empty = false;
                    break;
                }
            }
            return empty;
        }
        return false;
    }

    /**
     * 判断对象是否为null
     *
     * @param obj
     * @return
     */
    public static boolean isNULL(Object obj) {
        if (obj == null) {
            return true;
        }
        return false;
    }

    /**
     * 判断对象是否不为null
     *
     * @param obj
     * @return
     */
    public static boolean isNotNULL(Object obj) {
        return !isNULL(obj);
    }

    /**
     * 判断是否为true
     *
     * @param flag
     * @return
     */
    public static boolean isTrue(String flag) {

        if (isNULL(flag)) {
            return false;
        }

        return Boolean.parseBoolean(flag) == true ? true : false;

    }

    /**
     * 判断是否为true
     *
     * @param flag
     * @return
     */
    public static boolean isTrue2(boolean flag) {
        return flag == true ? true : false;
    }

}
