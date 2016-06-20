/*========================================
 * 项目名：婧涵影视-master
 * 文件名：DAO.java
 * 备    注：中国广东省广州市番禺区大石镇植村村五路(海珠区客村新港中路影盛花园C栋2508室)
 * CopyRigth (C) 2015-2016 jhmedia 婧涵影视
 *========================================*/
package com.jhmedia.master.dao;

/**
 * 类   名：DB操作
 * <pre>
 * 概   要：定义与DB交互的基本方法
 * 作成者：Seki2016
 * 作成日：2016年6月19日
 *
 * </pre>
 */
public interface DAO {

    /**
     * 保存
     * @param sqlId *Mapper.xml中定义的sqlid
     * @param param 传入参数
     * @throws Exception
     */
    public Object save(String sqlId, Object param);

    /**
     * 根据Id查找对象
     * @param sqlId *Mapper.xml中定义的sqlid
     * @param param 传入参数
     * @return 一条记录
     * @throws Exception
     */
    public Object findForObject(String sqlId, Object param) throws Exception;

    /**
     * 查询对象列表
     * @param *Mapper.xml中定义的sqlid
     * @return 多条记录
     * @throws Exception
     */
    public Object findForList(String sqlId) throws Exception;

    /**
     * 查询对象列表
     * @param *Mapper.xml中定义的sqlid
     * @param param 传入参数
     * @return 多条记录
     * @throws Exception
     */
    public Object findForList(String sqlId, Object param) throws Exception;

    /**
     * 更新
     * @param sqlId *Mapper.xml中定义的sqlid
     * @param param 传入参数
     * @throws Exception
     */
    public Object update(String sqlId, Object param) throws Exception;

    /**
     * 删除
     * @param sqlId *Mapper.xml中定义的sqlid
     * @param param 传入参数
     * @throws Exception
     */
    public Object delete(String sqlId, Object param) throws Exception;
}
