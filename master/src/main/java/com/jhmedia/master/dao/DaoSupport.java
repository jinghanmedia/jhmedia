package com.jhmedia.master.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;

public class DaoSupport implements DAO {

    @Resource(name = "sqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public Object save(String sqlId, Object param) {
        return sqlSessionTemplate.insert(sqlId, param);
    }

    @Override
    public Object findForObject(String sqlId, Object param) throws Exception {
        return sqlSessionTemplate.selectOne(sqlId, param);
    }

    @Override
    public Object findForList(String sqlId) throws Exception {
        return sqlSessionTemplate.selectList(sqlId);
    }

    @Override
    public Object findForList(String sqlId, Object param) throws Exception {
        return sqlSessionTemplate.selectList(sqlId, param);
    }

    @Override
    public Object update(String sqlId, Object param) throws Exception {
        return sqlSessionTemplate.update(sqlId, param);
    }

    @Override
    public Object delete(String sqlId, Object param) throws Exception {
        return sqlSessionTemplate.delete(sqlId, param);
    }

}
