package com.unlcn.ils.tps.ininterface;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import ch.qos.logback.core.joran.conditional.IfAction;

import com.chinacreator.c2.context.OperationContextHolder;
import com.chinacreator.c2.context.WebOperationContext;
import com.chinacreator.c2.ioc.ApplicationContextManager;
import com.unlcn.ils.crm.customer.account.Account;
import com.unlcn.ils.crm.dto.Result;
import com.unlcn.ils.crm.service.CrmInformationService;
import com.unlcn.ils.tps.E_account;
 
public class AccountInterface {
	private static  final Logger log = Logger.getLogger(Logger .class);
	WebOperationContext context = (WebOperationContext)OperationContextHolder.getContext();
	String username = context.getUser().getName();
	/**
	 * 
	 * @param account   
	 * @return 
	 * @Description:从接口获取账户信息  
	 */
	public List<Account> getAccountByid(Account account){
		 
		/*List<Account> returnList=new ArrayList<Account>();
		Account dto=new Account();
		dto.setName("分供方0");
		dto.setOwnerType("1");
		returnList.add(dto);*/
		CrmInformationService crmInformationService = (CrmInformationService)ApplicationContextManager.getContext().getBean("crmInformationService");
		List<Account> returnList=crmInformationService.getAccountByid(account);
		return returnList; 
	}
/*	public void deleteAccount() {
		CrmInformationService crmInformationService = (CrmInformationService)ApplicationContextManager.getContext().getBean("crmInformationService");
		Account account=new Account(); 
		account.setBank("q");
		account.setAccountNumber("1");
		account.setBankOpenBranch("2");
		account.setType("1");
		Timestamp ssTimestamp=new Timestamp(System.currentTimeMillis());
		account.setOperTime(ssTimestamp);
		account.setOperUser("1");
		account.setOwnerType("1");
		account.setName("s");
		account.setCustomerId("40");
		Result a=crmInformationService.addAccount(account);
		 
	}*/
	/**
	 * 
	 * @param account
	 * @return
	 * @Description:将从接口得到的账户信息输出
	 */
	
	public List<Map<String, String>> getAccountByidFromCrm(Account account){
		List<Account> lists=getAccountByid(account);
		List<Map<String,String>> returnlist=new ArrayList<Map<String,String>>();
		for(int i=0;i<lists.size();i++)
		{
			Map<String,String> map=new HashMap<String,String> ();
			Account accountlist = lists.get(i);
			if(accountlist.getId()!=null){
				map.put("idcrm", accountlist.getId().toString());
			}
			if(accountlist.getCustomerId()!=null){
				map.put("customerId", accountlist.getCustomerId().toString());
			}
			if(accountlist.getStatus()!=null){
				map.put("status", accountlist.getStatus().toString());
			}
			if(accountlist.getAccountFilepath()!=null){
				map.put("accountFilepath", accountlist.getAccountFilepath().toString());
			}
			if(accountlist.getType().equals("1")){
				accountlist.setType("一般");
			}else if(accountlist.getType().equals("2")){
				accountlist.setType("专用");
			}
				map.put("type", accountlist.getType());
			if(accountlist.getOwnerType().equals("1")){
				accountlist.setOwnerType("个人");
			}else if(accountlist.getOwnerType().equals("2")){
				accountlist.setOwnerType("企业");
			}
			map.put("ownerType", accountlist.getOwnerType());
			if(accountlist.getName()!=null)
			map.put("name", accountlist.getName());
			if(accountlist.getBank()!=null)
			map.put("bank", accountlist.getBank());
			if(accountlist.getAccountNumber()!=null)
			map.put("accountNumber", accountlist.getAccountNumber());
			if(accountlist.getOwnerName()!=null)	
			map.put("ownerName", accountlist.getOwnerName());
			if(accountlist.getBankOpenBranch()!=null)
				map.put("bankOpenBranch", accountlist.getBankOpenBranch());
			if(accountlist.getDesc()!=null)
			map.put("desc", accountlist.getDesc());
			returnlist.add(map);
	}
		return returnlist;
	}
	/**
	 * 
	 * @param listAccountList
	 * @param cusdmid
	 * @return
	 * @Description:更新返回结果信息
	 */
	public boolean updateAccount2Crm_dlg(List<E_account>listAccountList,String cusdmid) {
		Result result = new Result(1, null, "");
		log.info("更新后的，推送到Crm");
		AccountInterface accountInterface = new AccountInterface();
		try {
			result=accountInterface.updateAccountn2Crm(listAccountList,cusdmid);
			log.info("返回结果为: "+result.getRetCode());
			if(result.getRetCode()==-1){
				log.info("调用失败,错误码为: "+result.getErrCode());
				log.info("调用失败,错误信息为: "+result.getErrDesc());
			}
			}catch (Exception e) {
				// TODO: handle exception
				throw new RuntimeException("crm方新增分供方失败,错误原因为:"+result.getErrDesc());
			}
		return true;
		
	}
	/**
	 * 
	 * @param listAccountList
	 * @param cusdmid
	 * @return
	 * @Description:更新账户信息
	 */
	private Result updateAccountn2Crm(List<E_account>listAccountList,String cusdmid) {
		Result result = new Result(1, null, "");
		for (E_account e_account : listAccountList) {
			Account account = new Account();
			if(e_account.getOwnerType().equals("个人")){
				e_account.setOwnerType("1");
			}else if(e_account.getOwnerType().equals("企业")){
				e_account.setOwnerType("2");
			}
			account.setOwnerType(e_account.getOwnerType());
			account.setName(e_account.getName());
			account.setBank(e_account.getBank());
			account.setAccountNumber(e_account.getAccountNumber());
			if(e_account.getAccountFilepath()!=null){
				account.setAccountFilepath(e_account.getAccountFilepath());
			}
			account.setBankOpenBranch(e_account.getBankOpenBranch());
			if(e_account.getOwnerName()!=null){
				account.setOwnerName(e_account.getOwnerName());
			}
			if(e_account.getDesc()!=null){
				account.setDesc(e_account.getDesc());
			}
			if(e_account.getAccountFilepath()!=null){
				account.setAccountFilepath(e_account.getAccountFilepath());
			}
/*			if(e_account.getStartTime()!=null){
				account.setStartTime(e_account.getStartTime());
			}
			if(e_account.getEndTime()!=null){
				account.setEndTime(e_account.getEndTime());
			}*/
			if(e_account.getType().equals("一般")){
				e_account.setType("1");
			}else if(e_account.getType().equals("专用")){
				e_account.setType("2");
			}
			account.setType(e_account.getType());
			account.setOperUser(username);
			java.sql.Timestamp currdate = new java.sql.Timestamp(new Date().getTime());
			account.setOperTime(currdate);
			log.info("是否存在："+e_account.getCustomerId().equals(""));
			if(e_account.getCustomerId().equals("")){
				/*CustomerInfo customerInfo = new CustomerInfo();
				customerInfo.setId(cusdmid);*/
				account.setCustomerId(cusdmid);
				account.setStatus("1");
				result = addAccount(account);
			}else {
				log.info("ID为："+e_account.getId());
				
				account.setId(e_account.getId());
				account.setCustomerId(e_account.getCustomerId());
				result = updateAccount(account);
			}
		}
		return result;
		
	}
	/**
	 * 
	 * @param account
	 * @return
	 * @Description:调用CRM更新账户信息接口
	 */
	private Result updateAccount(Account account) {
		log.info("ID不为空，开始编辑");
		CrmInformationService dbService = (CrmInformationService)ApplicationContextManager.getContext().getBean("crmInformationService");
		if(dbService!=null){
			log.info("dbservice,不为空");
		}else {
			log.info("服务为空");
		}
		try {
			Result result=  dbService.updateAccount(account, "", "");
			return result;
		} catch (Exception e) {
			throw new RuntimeException("网络原因未能推送成功,请重新点击提交按钮");
		}	
	}
	/**
	 * 
	 * @param account
	 * @return
	 * @Description:调用CRM账户信息新增接口
	 */
	private Result addAccount(Account account) {
		log.info("开始新增");
		CrmInformationService dbService = (CrmInformationService)ApplicationContextManager.getContext().getBean("crmInformationService");
		try {
			Result result= dbService.addAccount(account);
			return result;
		} catch (Exception e) {
			throw new RuntimeException("网络原因未能推送成功,请重新点击提交按钮");
		}
	}
	/**
	 * 
	 * @param listAccountList
	 * @return
	 * @Description:删除接口返回信息
	 */
	public boolean deleteAccount2Crm_dlg(List<String>idList) {
		Result result = new Result(1, null, "");
		log.info("删除后的，推送到Crm");
		AccountInterface accountInterface = new AccountInterface();
		try {
			result=accountInterface.deleteAccountn2Crm(idList);
			log.info("返回结果为: "+result.getRetCode());
			if(result.getRetCode()==-1){
				log.info("调用失败,错误码为: "+result.getErrCode());
				log.info("调用失败,错误信息为: "+result.getErrDesc());
			}
			}catch (Exception e) {
				// TODO: handle exception
				throw new RuntimeException("crm方新增分供方失败,错误原因为:"+result.getErrDesc());
			}
		return true;
		
	}
	/**
	 * 
	 * @param listAccountList
	 * @return
	 * @Description:处理删除信息
	 */
	private Result deleteAccountn2Crm(List<String>idList) {
		Result result = new Result(1, null, "");
		for (int i=0;i<idList.size();i++) {
			String accountid = idList.get(i);
			result = deleteAccount(accountid);
		}
		return result;
		
	}
	/**
	 * 
	 * @param accountid
	 * @return
	 * @Description:调用删除接口
	 */
	private Result deleteAccount(String accountid) {
		log.info("开始调用删除");
		CrmInformationService dbService = (CrmInformationService)ApplicationContextManager.getContext().getBean("crmInformationService");
		if(dbService!=null){
			log.info("dbservice,不为空");
		}else {
			log.info("服务为空");
		}
		try {
			Result result=  dbService.deleteAccount(accountid);
			return result;
		} catch (Exception e) {
			throw new RuntimeException("网络原因未能推送成功,请重新点击提交按钮");
		}	
	}
	
}
