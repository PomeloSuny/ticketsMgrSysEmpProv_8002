package com.sy.ticketsMgrSysEmpProv_8002.service;

import java.util.List;

import com.yueqian.ticketsMgr_domain_9000.domain.empMgr.EmpVO;
import com.yueqian.ticketsMgr_domain_9000.domain.empMgr.PageVO;
import com.yueqian.ticketsMgr_domain_9000.domain.sysMgr.RolesVO;

public interface EmpService extends SplitPageService<EmpVO>{
	/**
	 * 登录
	 */
	public boolean findEmpByAccountAndPwd(EmpVO emp);
	/**
	 * 根据account获取用户信息
	 */
	public EmpVO getEmpByAccount(String account);
	/**
	 * 查询所有员工，分页
	 */
	public PageVO<EmpVO> showEmps(String orderColName, String orderFlag, String condition, Integer nowPageNum,
			Integer pageCount);
	/*
	 * 获取所有员工
	 */
	public List<EmpVO> getEmps();
	/*
	 * 获取指定员工
	 */
	public List<EmpVO> getEmpsByDuty(int roleId);
	/**
	 * 获取所有角色
	 */
	public List<RolesVO> getRoles();
	/**
	 * 根据id获取emp
	 */
	public EmpVO getEmpById(int empId); 
	/**
	 * 新增员工
	 */
	public boolean addEmp(EmpVO emp);
	/**
	 * 修改
	 */
	public boolean modifyEmp(EmpVO emp);
	/**
	 * 修改密码
	 */
	public boolean modifyPwd(EmpVO emp);
	/**
	 * 根据编号删除
	 */
	public boolean removeEmpById(int empId);
	/**
	 * 检测账号是否存在
	 */
	public boolean getAccount(String account);
	/**
	 * 检测电话是否存在
	 */
	public boolean getTelephone(String telephone);
	/**
	 * 检测身份证号是否存在
	 */
	public boolean getIdCardNum(String idCardNum);

}
