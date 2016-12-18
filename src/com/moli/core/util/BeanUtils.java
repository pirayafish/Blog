package com.moli.core.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 反射工具.
 * @author zhengmo
 * 
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public final class BeanUtils {
    
    /**
     * 
     * TODO 添加方法注释.
     * 
     * @param source source
     * @param target target
     */
    public static void copyProperties(Object source, Object target) {
        org.springframework.beans.BeanUtils.copyProperties(source, target);
    }

    /**
     * 反射工具.
     * @author zhengmo
     * 
     */
    private BeanUtils() {
        throw new RuntimeException("This is util class,can not instance");
    }
    /**
     * 
     * 获取默认时间.
     * 
     * @return 返回
     */
    private static Date getStartDate() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1900-01-01 00:00:00");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
    /**
     * 
     * assignmentObject.
     * 
     * @param obj 参数
     */
    public static void assignmentObject(Object obj) {
        try {
            if (null == obj) {
                return;
            }
            Field[] fields = obj.getClass().getDeclaredFields();
            Class cla = obj.getClass();
            for (Field field : fields) {
                setFieldValue(obj, cla, field);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 
     * 设置字段值.
     * 
     * @param obj 参数
     * @param cla 参数
     * @param field 参数
     * @throws Exception 异常
     */
    private static void setFieldValue(Object obj, Class cla, Field field) throws Exception {
        Class type = field.getType();
        String fieldName = field.getName();
        String methodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
        Method method;
        if (String.class.equals(type)) {
            method = cla.getMethod(methodName, String.class);
            method.invoke(obj, "");
        } else if (char.class.equals(type)) {
            method = cla.getMethod(methodName, char.class);
            method.invoke(obj, ' ');
        } else if (Character.class.equals(type)) {
            method = cla.getMethod(methodName, Character.class);
            method.invoke(obj, ' ');
        } else if (boolean.class.equals(type)) {
            method = cla.getMethod(methodName, boolean.class);
            method.invoke(obj, true);
        } else if (Boolean.class.equals(type)) {
            method = cla.getMethod(methodName, Boolean.class);
            method.invoke(obj, true);
        } else if (byte.class.equals(type)) {
            method = cla.getMethod(methodName, byte.class);
            method.invoke(obj, (byte) 0);
        } else if (Byte.class.equals(type)) {
            method = cla.getMethod(methodName, Byte.class);
            method.invoke(obj, (byte) 0);
        } else if (short.class.equals(type)) {
            method = cla.getMethod(methodName, short.class);
            method.invoke(obj, (short) 0);
        } else if (Short.class.equals(type)) {
            method = cla.getMethod(methodName, Short.class);
            method.invoke(obj, (short) 0);
        } else if (int.class.equals(type)) {
            method = cla.getMethod(methodName, int.class);
            method.invoke(obj, 0);
        } else if (Integer.class.equals(type)) {
            method = cla.getMethod(methodName, Integer.class);
            method.invoke(obj, 0);
        } else if (long.class.equals(type)) {
            method = cla.getMethod(methodName, long.class);
            method.invoke(obj, 0);
        } else if (Long.class.equals(type)) {
            method = cla.getMethod(methodName, Long.class);
            method.invoke(obj, 0L);
        } else if (float.class.equals(type)) {
            method = cla.getMethod(methodName, float.class);
            method.invoke(obj, 0.0f);
        } else if (Float.class.equals(type)) {
            method = cla.getMethod(methodName, Float.class);
            method.invoke(obj, 0.0f);
        } else if (double.class.equals(type)) {
            method = cla.getMethod(methodName, double.class);
            method.invoke(obj, 0.0d);
        } else if (Double.class.equals(type)) {
            method = cla.getMethod(methodName, Double.class);
            method.invoke(obj, 0.0d);
        } else if (Date.class.equals(type)) {
            method = cla.getMethod(methodName, Date.class);
            method.invoke(obj, getStartDate());
        } else if (BigDecimal.class.equals(type)) {
            method = cla.getMethod(methodName, BigDecimal.class);
            method.invoke(obj, new BigDecimal(0.0D));
        }
    }
    /**
     * 对象属??值为null处理.
     * @param obj 对象
     */
    public static void notNull(Object obj) {
        try {
            if (null == obj) {
                return;
            }
            Field[] fields = obj.getClass().getDeclaredFields();
            fields = getAllDeclaredFields(obj);
            Class cla = obj.getClass();
            for (Field field : fields) {
                field.setAccessible(true);
                if (null == field.get(obj)) {
                    setFieldValue(obj, cla, field);
                }
                field.setAccessible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 
     * 获取类所有属性.
     * 
     * @param object 参数
     * @return 返回
     */
    public static Field[] getAllDeclaredFields(Object object) {
        if (object == null) {
            return new Field[0];
        }
        List<Field> fields = new ArrayList<Field>();
        Class<?> clazz = object.getClass();
        Field[] fieldArray = null;
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                fieldArray = clazz.getDeclaredFields();
                for (Field field : fieldArray) {
                    if (!fields.contains(field)) {
                        fields.add(field);
                    }
                }
            } catch (Exception e) {
                fieldArray = new Field[0];
            }
        }
        return fields.toArray(fieldArray);
    }
    /**
     * 
     * 获取字段.
     * 
     * @param object 参数
     * @param fieldName 参数
     * @return 返回
     */
    public static Field getDeclaredField(Object object, String fieldName) {
        Field field = null;
        Class<?> clazz = object.getClass();
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                field = clazz.getDeclaredField(fieldName);
                return field;
            } catch (Exception e) {
                //这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。
                //如果这里的异常打印或者往外抛，则就不会执行clazz = clazz.getSuperclass(),最后就不会进入到父类中了
                field = null;
            }
        }
        return null;
    }
    /**
     * 
     * 获取参数值.
     * 
     * @param object 参数
     * @param fieldName 参数
     * @return 返回
     */
    public static Object getFieldValue(Object object, String fieldName) {
        //根据 对象和属性名通过反射 调用上面的方法获取 Field对象
        Field field = getDeclaredField(object, fieldName);
        //抑制Java对其的检查
        field.setAccessible(true);
        try {
            //获取 object 中 field 所代表的属性值
            return field.get(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
