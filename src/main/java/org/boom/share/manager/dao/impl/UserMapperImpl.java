package org.boom.share.manager.dao.impl;

import org.boom.share.manager.dao.UserMapper;
import org.boom.share.manager.domain.UserDO;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * Created by jiangshan on 14/8/24.
 */
public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper {

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(UserDO record) {
        return 0;
    }

    @Override
    public int insertSelective(UserDO record) {
        return 0;
    }

    @Override
    public UserDO selectByPrimaryKey(Integer id) {
        System.out.println("======================================");
        return getSqlSession().selectOne("selectByPrimaryKey", id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserDO record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(UserDO record) {
        return 0;
    }
}
