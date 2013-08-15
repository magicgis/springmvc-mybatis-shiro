package com.dodoyota.sys.security.dao;

import com.dodoyota.sys.security.po.RolePo;
import com.dodoyota.sys.security.po.RolePoQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface RolePoMapper {
    int countByExample(RolePoQuery example);

    int deleteByExample(RolePoQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(RolePo record);

    int insertSelective(RolePo record);

    List<RolePo> selectByExampleWithRowbounds(RolePoQuery example, RowBounds rowBounds);

    List<RolePo> selectByExample(RolePoQuery example);

    RolePo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RolePo record, @Param("example") RolePoQuery example);

    int updateByExample(@Param("record") RolePo record, @Param("example") RolePoQuery example);

    int updateByPrimaryKeySelective(RolePo record);

    int updateByPrimaryKey(RolePo record);
}