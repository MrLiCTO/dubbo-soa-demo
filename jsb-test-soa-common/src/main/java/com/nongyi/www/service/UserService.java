package com.nongyi.www.service;

import java.util.List;

import com.nongyi.www.po.User;
import com.nongyi.www.pojo.UserCustom;
import com.nongyi.www.vo.PageQuery;
import com.nongyi.www.vo.UserCustomVo;

public interface UserService extends BaseService<User>{
	
	public List<UserCustom> findEntityList(UserCustomVo entityCustomVo)throws Exception;
	public int findEntityCount(UserCustomVo entityCustomVo)throws Exception;
}
