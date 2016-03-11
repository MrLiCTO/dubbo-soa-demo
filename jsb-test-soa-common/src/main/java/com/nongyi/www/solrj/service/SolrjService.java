package com.nongyi.www.solrj.service;

import java.util.List;

import com.nongyi.www.po.User;

public interface SolrjService {
		@Deprecated	
		public long searchItemsCount(String key) throws Exception;
		@Deprecated
		public List<User> searchItems(String key,int pagesize,int currpage) throws Exception;
		
		public long searchItemsCount_new(String key) throws Exception;
		public List<User> searchItems_new(String key,int pagesize,int currpage) throws Exception;
		
}
