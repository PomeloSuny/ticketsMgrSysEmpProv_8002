package com.sy.ticketsMgrSysEmpProv_8002.mapper;

import java.util.List;
import java.util.Map;

import com.yueqian.ticketsMgr_domain_9000.domain.empMgr.EmpVO;
import com.yueqian.ticketsMgr_domain_9000.domain.sysMgr.RolesVO;




public interface EmpMapper {
	/**
	 * 登录
	 */
	public EmpVO findEmpByAccountAndPwd(EmpVO emp);
	/**
	 * 根据account获取用户信息
	 */
	public EmpVO getEmpByAccount(String account);
	/*
	 * 获取所有员工
	 */
	public List<EmpVO> getEmps();
	/*
	 * 获取所有员工(分页)
	 */
	public List<EmpVO> showEmps(Map<String,Object> param);
	/*
	 * 获取数据条数
	 */
	public int getMaxRowCount(Map<String,Object> param);
	/**
	 * 获取所有角色
	 */
	public List<RolesVO> getRoles();
	/*
	 * 获取指定员工
	 */
	public List<EmpVO> getEmpsByDuty(int roleId);
	/**
	 * 根据id获取emp
	 */
	public EmpVO getEmpById(int empId); 
	/**
	 * 新增员工
	 */
	public int addEmp(EmpVO emp);
	/**
	 * 修改
	 */
	public int modifyEmp(EmpVO emp);
	/**
	 * 修改密码
	 */
	public int modifyPwd(EmpVO emp);
	/**
	 * 根据编号删除
	 */
	public int removeEmpById(int empId);
	/**
	 * 检测账号是否存在
	 */
	public boolean getAccount(String account);
	/**
	 * 检测电话是否存在
	 */
	public int getTelephone(String telephone);
	/**
	 * 检测身份证号是否存在
	 */
	public int getIdCardNum(String idCardNum);


}
