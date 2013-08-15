package com.dodoyota.sys.security.dao;

import com.dodoyota.sys.security.po.UserPo;
import com.dodoyota.sys.security.po.UserPoQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UserPoMapper {
    int countByExample(UserPoQuery example);

    int deleteByExample(UserPoQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserPo record);

    int insertSelective(UserPo record);

    List<UserPo> selectByExampleWithRowbounds(UserPoQuery example, RowBounds rowBounds);

    List<UserPo> selectByExample(UserPoQuery example);

    UserPo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserPo record, @Param("example") UserPoQuery example);

    int updateByExample(@Param("record") UserPo record, @Param("example") UserPoQuery example);

    int updateByPrimaryKeySelective(UserPo record);

    int updateByPrimaryKey(UserPo record);
}