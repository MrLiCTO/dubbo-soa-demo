package com.nongyi.www.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nongyi.www.mapper.UserMapper;
import com.nongyi.www.mapper.UserMapperCustom;
import com.nongyi.www.po.User;
import com.nongyi.www.pojo.UserCustom;
import com.nongyi.www.service.BaseSereviceImpl;
import com.nongyi.www.service.UserService;
import com.nongyi.www.vo.UserCustomVo;
@Service("userService")
public class UserServiceImpl extends BaseSereviceImpl<User> implements UserService{
	
	@Resource
	private UserMapper userMapper;
	
	@Resource
	private UserMapperCustom userMapperCustom;
	
	public UserServiceImpl() {
		super.setNs("com.nongyi.www.mapper.UserMapper");
		super.setNscus("com.nongyi.www.mapper.UserMapperCustom");
	}

	
	public List<UserCustom> findEntityList(UserCustomVo entityCustomVo)throws Exception{
		
		List<UserCustom> entityList = userMapperCustom.findEntityList(entityCustomVo);
		
		return entityList;
	}


	public int findEntityCount(UserCustomVo entityCustomVo) throws Exception{
		
		return userMapperCustom.findEntityCount(entityCustomVo);
	}
	
	

	
}
