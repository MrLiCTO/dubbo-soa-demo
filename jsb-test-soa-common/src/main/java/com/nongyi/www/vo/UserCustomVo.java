package com.nongyi.www.vo;

import java.io.Serializable;

import com.nongyi.www.pojo.UserCustom;

public class UserCustomVo  implements Serializable{
	
	private UserCustom userCustom;
	
	private PageQuery pageQuery;

	public PageQuery getPageQuery() {
		return pageQuery;
	}

	public void setPageQuery(PageQuery pageQuery) {
		this.pageQuery = pageQuery;
	}

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}

	
	
	
}
