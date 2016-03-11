package com.nongyi.www.mapper;

import java.util.List;

import com.nongyi.www.pojo.UserCustom;
import com.nongyi.www.vo.UserCustomVo;

public interface UserMapperCustom {
    public List<UserCustom> findEntityList(UserCustomVo entityCustomVo); 
    public int findEntityCount(UserCustomVo entityCustomVo); 
}