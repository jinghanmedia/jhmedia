package com.jhmedia.master.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PageData extends HashMap implements Map {

    private static final long serialVersionUID = 5477699388817976275L;

    Logger logger = LoggerFactory.getLogger(PageData.class);
    Map map = null;
    HttpServletRequest request;
    
    public PageData(HttpServletRequest request) {
        this.request = request;
        Map properties = request.getParameterMap();
        Map rtnMap = new HashMap();
        Iterator entries = properties.entrySet().iterator();
        Map.Entry entry;
        String name = "";
        String value = "";
        
        // 遍历
        while (entries.hasNext()) {
            entry = (Map.Entry)entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if (null == valueObj) {
                value = "";
            } else if (valueObj instanceof String[]) {
                String[] values = (String[])valueObj;
                for (int i = 0; i < values.length; i++) {
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length() - 1);
            } else {
                value = valueObj.toString();
            }
            rtnMap.put(name, valueObj);
        }
        map = rtnMap;
    }

    public PageData() {
        map = new HashMap();
    }

    @Override
    public Object get(Object key) {
        Object obj = null;
        if (map.get(key) instanceof Object[]) {
            Object[] arr = (Object[])map.get(key);
            obj = request == null ? arr : 
                    (request.getParameter((String)key)) == null ? arr : arr[0];
        } else {
            obj = map.get(key);
        }
        return obj;
    }

    /**
     * 根据键名获取键值
     * @param key 键名
     * @return String类型的键值
     */
    public String getString(Object key) {
        return (String) get(key);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object put(Object key, Object value) {
        return map.put(key, value);
    }

    @Override
    public Object remove(Object key) {
        return map.remove(key);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    public Set entrySet() {
        return map.entrySet();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public Set keySet() {
        return map.keySet();
    }

    public void putAll(Map t) {
        map.putAll(t);
    }

    public int size() {
        return map.size();
    }

    public Collection values() {
        return map.values();
    }

    /**
     * 将一个Map对象转化为一个JavaBean
     * @param type 要转化的类型
     * @param map 包含属性值的map
     * @return 转化出来的JavaBean对象
     * @throws IntrospectionException 如果分析类属性失败
     * @throws InstantiationException 如果实例化JavaBean失败
     * @throws IllegalAccessException 如果调用属性的setter方法失败
     */
    public Object convertToBean(Class type) throws IntrospectionException,
        InstantiationException, IllegalAccessException {

        // 获取类属性
        BeanInfo beanInfo = Introspector.getBeanInfo(type);

        // 创建JavaBean对象
        Object obj = type.newInstance();
        
        if (map == null) {
            return obj;
        }

        // 给JavaBean对象的属性赋值
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (int i = 0; i < propertyDescriptors.length; i++) {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();
            if (map.containsKey(propertyName)) {
                try {
                    Object value = map.get(propertyName);
                    Object[] args = new Object[1];
                    args[0] = value;
                    descriptor.getWriteMethod().invoke(obj, args);
                } catch (IllegalAccessException e) {
                    logger.error(e.toString());
                } catch (IllegalArgumentException e) {
                    logger.error(e.toString());
                } catch (InvocationTargetException e) {
                    logger.error(e.toString());
                } catch (Exception e) {
                    logger.error(e.toString());
                }
            }
        }
        return obj;
    }

}
