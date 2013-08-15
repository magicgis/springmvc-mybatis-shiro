package com.dodoyota.sys.security.dao;

import com.dodoyota.sys.security.po.PermissionPo;
import com.dodoyota.sys.security.po.PermissionPoQuery;

import java.util.Collection;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface PermissionPoMapper {
    int countByExample(PermissionPoQuery example);

    int deleteByExample(PermissionPoQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(PermissionPo record);

    int insertSelective(PermissionPo record);

    List<PermissionPo> selectByExampleWithRowbounds(PermissionPoQuery example, RowBounds rowBounds);

    List<PermissionPo> selectByExample(PermissionPoQuery example);

    PermissionPo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PermissionPo record, @Param("example") PermissionPoQuery example);

    int updateByExample(@Param("record") PermissionPo record, @Param("example") PermissionPoQuery example);

    int updateByPrimaryKeySelective(PermissionPo record);

    int updateByPrimaryKey(PermissionPo record);

	Collection<String> queryPermissionsByUseraccount(String userAccount);
}