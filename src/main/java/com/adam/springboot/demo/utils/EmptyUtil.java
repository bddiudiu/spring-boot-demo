package com.adam.springboot.demo.utils;

import java.util.Collection;

/**
 * Created by adam on 16/12/15.
 */
public class EmptyUtil {
    public static boolean isEmpty(Object objs)
    {
        if (objs == null) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(Object[] objs)
    {
        if ((objs == null) || (objs.length == 0)) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(Collection<?> objs)
    {
        if ((objs == null) || (objs.size() <= 0)) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(byte[] objs)
    {
        if ((objs == null) || (objs.length == 0)) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(String str)
    {
        if ((str == null) || (str.trim().length() == 0)) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(Long l)
    {
        if ((l == null) || (l.longValue() == 0L)) {
            return true;
        }
        return false;
    }
}
