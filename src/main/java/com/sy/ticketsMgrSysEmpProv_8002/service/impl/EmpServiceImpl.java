package com.sy.ticketsMgrSysEmpProv_8002.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sy.ticketsMgrSysEmpProv_8002.mapper.EmpMapper;
import com.sy.ticketsMgrSysEmpProv_8002.service.EmpService;
import com.yueqian.ticketsMgr_domain_9000.domain.empMgr.EmpVO;
import com.yueqian.ticketsMgr_domain_9000.domain.empMgr.PageVO;
import com.yueqian.ticketsMgr_domain_9000.domain.sysMgr.RolesVO;

@Service("EmpService")
public class EmpServiceImpl implements EmpService {
	@Resource
	private EmpMapper empMapper;

	/**
	 * 登录
	 */
	@Override
	public boolean findEmpByAccountAndPwd(EmpVO emp) {
		EmpVO empAP = empMapper.findEmpByAccountAndPwd(emp);
		if (empAP.getAccount() != null && empAP.getPwd() != null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 获取所有角色
	 */
	@Override
	public List<RolesVO> getRoles() {
		List<RolesVO> list = empMapper.getRoles();
		return list;
	}

	/**
	 * 查询所有信息
	 */
	@Override
	public List<EmpVO> getEmps() {
		List<EmpVO> list = empMapper.getEmps();
		return list;
	}

	/**
	 * 查询指定员工
	 */
	@Override
	public List<EmpVO> getEmpsByDuty(int roleName) {

		return empMapper.getEmpsByDuty(roleName);
	}

	/**
	 * 根据id查询
	 */
	@Override
	public EmpVO getEmpById(int empId) {
		EmpVO list = empMapper.getEmpById(empId);
		return list;
	}

	/**
	 * 新增
	 */
	@Override
	public boolean addEmp(EmpVO emp) {

		return empMapper.addEmp(emp) > 0 ? true : false;
	}

	/**
	 * 修改
	 */
	@Override
	public boolean modifyEmp(EmpVO emp) {
		return empMapper.modifyEmp(emp) > 0 ? true : false;
	}

	/**
	 * 修改密码
	 */
	@Override
	public boolean modifyPwd(EmpVO emp) {
		return empMapper.modifyPwd(emp) > 0 ? true : false;
	};

	/**
	 * 删除
	 */
	@Override
	public boolean removeEmpById(int empId) {

		return empMapper.removeEmpById(empId) > 0 ? true : false;
	}

	/**
	 * 检测账号是否存在
	 */
	@Override
	public boolean getAccount(String account) {

		return false;
	}

	@Override
	public EmpVO getEmpByAccount(String account) {

		return empMapper.getEmpByAccount(account);
	}

	/**
	 * 检测电话是否存在
	 */
	@Override
	public boolean getTelephone(String telephone) {
		return empMapper.getTelephone(telephone) > 0 ? true : false;
	}

	/**
	 * 检测身份证号是否重复
	 */
	@Override
	public boolean getIdCardNum(String idCardNum) {
		return empMapper.getIdCardNum(idCardNum) > 0 ? true : false;
	}

	@Override
	public int getMaxCount(String orderColName, String orderFlag, String condition) {
		Map<String, Object> param = createQueryParamMap(orderColName, orderFlag, condition, null, null);

		return empMapper.getMaxRowCount(param);
	}

	/**
	 * 获取页面信息
	 */
	@Override
	public List<EmpVO> getPageContent(String orderColName, String orderFlag, String condition, Integer nowPageNum,
			Integer pageCount) {
		Map<String, Object> param = createQueryParamMap(orderColName, orderFlag, condition, nowPageNum, pageCount);

		return empMapper.showEmps(param);
	}

	/**
	 * 获取所有的用户信息，分页
	 */
	@Override
	public PageVO<EmpVO> showEmps(String orderColName, String orderFlag, String condition, Integer nowPageNum,
			Integer pageCount) {
		// 获取页面内容
		List<EmpVO> empList = getPageContent(orderColName, orderFlag, condition, nowPageNum, pageCount);
		// 获取最大条数
		int totalRowCount = this.getMaxCount(orderColName, orderFlag, condition);
		PageVO<EmpVO> pageVO = null;
		if (nowPageNum != null && pageCount != null) {
			pageVO = new PageVO<EmpVO>(nowPageNum, pageCount, totalRowCount);
		} else {
			pageVO = new PageVO<EmpVO>(totalRowCount);
		}
		pageVO.setPageList(empList);

		return pageVO;
	}

	/**
	 * 封装参数Map
	 * 
	 * @param orderColName
	 * @param orderFlag
	 * @param condition
	 * @return
	 */
	private Map<String, Object> createQueryParamMap(String orderColName, String orderFlag, String condition,
			Integer nowPageNum, Integer pageCount) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("orderColName", orderColName);
		param.put("orderFlag", orderFlag);
		param.put("condition", condition);
		if (nowPageNum == null || pageCount == null) {
			param.put("startRow", 1);
			param.put("endRow", 5);
		} else {
			param.put("startRow", (nowPageNum - 1) * pageCount + 1);
			param.put("endRow", nowPageNum * pageCount);
		}

		return param;
	}

}
