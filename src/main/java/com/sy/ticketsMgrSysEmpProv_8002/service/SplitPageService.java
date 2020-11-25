package com.sy.ticketsMgrSysEmpProv_8002.service;

import java.util.List;

public interface SplitPageService<T> {
	/**
	 * 获取最大条数
	 */
	public int getMaxCount(String orderColName,String orderFlag,String condition);
	/**
	 * 获取页面内容
	 */
	public List<T> getPageContent(String orderColName,String orderFlag,String condition,
			Integer nowPageNum,Integer pageCount);

}
