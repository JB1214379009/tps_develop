package com.unlcn.ils.tps.services;

import java.math.BigDecimal; 
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chinacreator.c2.context.OperationContextHolder;
import com.chinacreator.c2.context.WebOperationContext;
import com.chinacreator.c2.dao.Dao;
import com.chinacreator.c2.dao.DaoFactory;
import com.chinacreator.c2.ioc.ApplicationContextManager;

import com.unlcn.ils.erp.dto.GpsStaticDto;
import com.unlcn.ils.erp.service.SubcontractorCheckService;
import com.unlcn.ils.tps.E_checkDatas;
import com.unlcn.ils.tps.E_checkhead;
import com.unlcn.ils.tps.E_configure_detail;
import com.unlcn.ils.tps.E_method;
import com.unlcn.ils.tps.ininterface.SqlInterface;

public class CheckDataService {
	WebOperationContext context = (WebOperationContext)OperationContextHolder.getContext();
	String username = context.getUser().getName();
	public String createCheckDatas(String shipper,String shipperName,String check_configure,String checkCycle,String checkDate,
			String checkDate1,String  checkDate2,String checkDate3,String report,String path,String perfect){
		//shipper="RD_809";
		E_checkDatas checkDatas=new E_checkDatas();
		double subValue=0;
		String gpsString="";
		BigDecimal subMoney = new BigDecimal(0);
		Map<String, Object> map=getRate(shipper, checkCycle, checkDate, checkDate1, checkDate2, checkDate3);
		/*if(map.get("isNull").equals("yes")){
			return "isNull";
		}*/
		if(map.get("isNull").equals("no")){
			double planRate=0 ,timelyRate=0,receiveRate = 0,receiptRate=0,gpsDocktRate=0;
			@SuppressWarnings("unused")
			int planNumber=0,timelyNumber=0,receiveNumber = 0,receiptNumber=0;
			int a,b;

					
					//计划完成率
					a=(int)map.get("planshipedCount");
					b=(int)map.get("plancount");
					if(b==0)
						planRate=100;
					else
						planRate=(double)a/b*100;
					//承运数量
					 planNumber=b;
					 checkDatas.setPlannedCompletionRate(planRate);

			
					//起运及时率
					 a=(int)map.get("timelyshippedCount");
					 b=(int)map.get("timelycount");
					 if(b==0)
						 timelyRate=100;
					 else
						 timelyRate=(double)a/b*100;
					//承运数量
					timelyNumber=b;
					checkDatas.setDepartureTimeRate(timelyRate);
				

					//交付及时率
					a=(int)map.get("receiveshippedCount");
					b=(int)map.get("receivecount");
					if(b==0)
						receiveRate=100;
					else
						receiveRate=(double)a/b*100;
					//承运数量
					receiveNumber=b;
					checkDatas.setTimelyDeliveryRate(receiveRate);

		
					//回单及时率
					 a=(int)map.get("receiptshippedCount");
					 b=(int)map.get("receiptcount");

					if(b==0)
						receiptRate=100; 
					else
						//c=(float)(a/b*100);
						receiptRate=(double)a/b*100;
					//承运数量
					receiptNumber=b;
					checkDatas.setReplyRate(receiptRate);
					
					//gps对接率
					 a=(int)map.get("gpsDock");
					 b=(int)map.get("gpsTotal");

					if(b==0)
						gpsDocktRate=100; 
					else
						//c=(float)(a/b*100);
						gpsDocktRate=(double)a/b*100;
					//承运数量
					receiptNumber=b;
					
					//报班准确率
					if(null!=report&&!report.equals(""))
					checkDatas.setReportRate(Double.parseDouble(report));
					E_configure_detail configure_detail=new E_configure_detail();
					configure_detail.setConfigureLineid(check_configure);
					Dao<E_configure_detail> dao=DaoFactory.create(E_configure_detail.class);
					//根据选择的配置表头选择相应的考核规则
					List<E_configure_detail>configure_details = dao.select(configure_detail);
					Dao<E_method> methodDao=DaoFactory.create(E_method.class);
					
					int gpsValue=0;
					for (E_configure_detail e_configure_detail : configure_details) {
						//找到考核规则中的每条规则的计算方法
						E_method method=new E_method();
						method.setMethod(e_configure_detail.getCalDescription());
						List<E_method> methods=methodDao.select(method);
						double subValue1=0,subValue2=0,subValue3=0,subValue4=0,subValue5=0;
						BigDecimal subMoney1 = new BigDecimal(0),subMoney2=new BigDecimal(0),subMoney3=new BigDecimal(0),subMoney4=new BigDecimal(0),subMoney5=new BigDecimal(0);
						//{value:"1:计划完成率;2:交付及时率;3:报班准确率;4:起运及时率;5:回单及时率;6:GPS要求"}
						//指标要求
						float requirement=Float.parseFloat(e_configure_detail.getRequirements());
						double differ;
						//计划完成率考核
						if(methods.get(0).getTarget()==1){
							//指标要求与实际计划完成率差值
							differ=requirement-planRate;
							//differ=3;
							//扣分
						
							if(differ<0){
								subValue1=0;
								subMoney1=new BigDecimal(0);
							}
								
							else {
								subValue1=Math.round(differ)*e_configure_detail.getSubvalue();
								if((e_configure_detail.getTotalvalue()-subValue1)<e_configure_detail.getLowvalue())
									subValue1=e_configure_detail.getTotalvalue();
								//扣款
								/*a=(int)map.get("planshipedCount");
								b=(int)map.get("plancount");
								for (E_method e_method : methods) {
									if(e_method.getLeftNode()<differ&&differ<e_method.getRightNode())
										subMoney1=e_method.getSubMoney().multiply(new BigDecimal(b-a));
									else {
										subMoney1=new BigDecimal(0);
									}
								}*/
							}
							
							subValue=subValue+subValue1;
							subMoney=subMoney.add(subMoney1);
						}
						//交付及时率考核
						if(methods.get(0).getTarget()==2){
							//指标要求与实际交付及时率的差值
							differ=requirement-receiveRate;
							//differ=3;
							//扣分
							if(differ<0)
								subValue2=0;
							else {
								subValue2=(int) (Math.round(differ)*e_configure_detail.getSubvalue());
								if((e_configure_detail.getTotalvalue()-subValue2)<e_configure_detail.getLowvalue())
									subValue2=e_configure_detail.getTotalvalue();
								//扣款
								a=(int)map.get("receiveshippedCount");
								b=(int)map.get("receivecount");
								for (E_method e_method : methods) {
									if(e_method.getLeftNode()<differ&&differ<e_method.getRightNode()){
										subMoney2=e_method.getSubMoney().multiply(new BigDecimal(b-a));
										break;
									}
										
									else {
										subMoney2=new BigDecimal(0);
									}
								}	
							}
							
							subValue=subValue+subValue2;
							subMoney=subMoney.add(subMoney2);
						}
						//起运及时率考核
						if(methods.get(0).getTarget()==4){
							//指标要求与实际起运及时率的差值
							differ=requirement-timelyRate;
							//扣分
							if(differ<0)
								subValue4=0;
							else {
								subValue4=(int) (Math.round(differ)*e_configure_detail.getSubvalue());
								if((e_configure_detail.getTotalvalue()-subValue4)<e_configure_detail.getLowvalue())
									subValue4=e_configure_detail.getTotalvalue();
								//扣款
								a=(int)map.get("timelyshippedCount");
								 b=(int)map.get("timelycount");
								for (E_method e_method : methods) {
									if(e_method.getLeftNode()<differ&&differ<e_method.getRightNode()){
										subMoney4=e_method.getSubMoney().multiply(new BigDecimal(b-a));
										break;
									}
										
									else {
										subMoney4=new BigDecimal(0);
									}
								}	
							}
							
							subValue=subValue+subValue4;
							subMoney=subMoney.add(subMoney4);
						}
						//回单及时率考核
						if(methods.get(0).getTarget()==5){
							//指标要求与实际回单及时率的差值
							differ=requirement-receiptRate;
							//扣分
							if(differ<0)
								subValue5=0;
							else {
								
								subValue5=(int) (Math.round(differ)*e_configure_detail.getSubvalue());
								if((e_configure_detail.getTotalvalue()-subValue5)<e_configure_detail.getLowvalue())
									subValue5=e_configure_detail.getTotalvalue();
								//扣款
								 a=(int)map.get("receiptshippedCount");
								 b=(int)map.get("receiptcount");
								 
								for (E_method e_method : methods) {
									if(e_method.getLeftNode()<(b-a)&&(b-a)<e_method.getRightNode()){
										subMoney5=e_method.getSubMoney().multiply(new BigDecimal((b-a)));
										break;
									}
									else {
										subMoney5=new BigDecimal(0);
									}
								}
							}
							
							subValue=subValue+subValue5;
							subMoney=subMoney.add(subMoney5);
						}
						//报班及时率考核
						if(null!=report&&!report.equals("")&&methods.get(0).getTarget()==3){
							//指标要求与实际回单及时率的差值
							
							differ=requirement-Float.parseFloat(report);
							//扣分
							if(differ<0)
								subValue3=0;
							else {
								subValue3=(int) (Math.round(differ)*e_configure_detail.getSubvalue());
								if((e_configure_detail.getTotalvalue()-subValue5)<e_configure_detail.getLowvalue())
									subValue3=e_configure_detail.getTotalvalue();
								//扣款
								/*for (E_method e_method : methods) {
									if(e_method.getLeftNode()<differ&&differ<e_method.getRightNode())
										subMoney3=e_configure_detail.getCheckvalue().multiply(new BigDecimal(receiptNumber));
									else {
										subMoney3=new BigDecimal(0);
									}
								}*/
							}
							
							subValue=subValue+subValue3;
							subMoney=subMoney.add(subMoney3);
						}
						//GPS对接率考核
						if(methods.get(0).getTarget()==6){
							//指标要求与实际回单及时率的差值
							
							differ=requirement-gpsDocktRate;
							//扣分
							if(differ>0)
							gpsValue=5;
							gpsString=gpsString+"对接率:"+gpsDocktRate;
						}
						//GPS完好率考核
						if(null!=perfect&&!perfect.equals("")&&methods.get(0).getTarget()==7){
							//指标要求与实际回单及时率的差值
							gpsString=gpsString+"完好率:"+perfect;
							differ=requirement-Integer.valueOf(perfect);
							//扣分
							if(differ>0)
								gpsValue=5;
						}
						//轨迹准确率考核
						if(null!=path&&!path.equals("")&&methods.get(0).getTarget()==8){
							//指标要求与实际回单及时率的差值
							gpsString=gpsString+"准确率:"+path;
							differ=requirement-Integer.valueOf(path);
							//扣分
							if(differ>0)
							gpsValue=5;
						}
						//每条配置表中规则的最终扣分subValue,最终扣款subMoney
						/*subValue=subValue++;
						subMoney=subMoney.add(subMoney);*/
				
					}
					subValue=subValue+gpsValue;
					
		}
		
	
		
			//计算规范考核扣分扣款
			List<E_checkhead> headList=getOperate(shipper, checkCycle, checkDate, checkDate1, checkDate2, checkDate3);
			if((null==headList||headList.size()==0)&&map.get("isNull").equals("yes"))
				return "isNull";
			BigDecimal operateSubmoney=new BigDecimal(0);
			double operateSubvaule = 0;
			for (E_checkhead e_checkhead : headList) {
				operateSubmoney=operateSubmoney.add(e_checkhead.getCheckMoney());
				operateSubvaule=operateSubvaule+e_checkhead.getStandardSubvalue();
				
			}
			checkDatas.setOperateSubmoney(operateSubmoney);
			checkDatas.setOperateSubvaule(operateSubvaule);
			checkDatas.setGps(gpsString);
			checkDatas.setSubvalue(subValue+operateSubvaule);
			checkDatas.setSubmoney(subMoney.add(operateSubmoney));
			
			checkDatas.setShipperId(shipper);
			//{1:"月度",2:"半年度",3:"年度"}
			if(checkCycle.equals("1")){
				checkDatas.setCheckCycle("月度考核");
				checkDatas.setCheckYear(checkDate.substring(0, 4));
				checkDatas.setCheckMonth(checkDate.substring(5));
			}
				
			if(checkCycle.equals("2")){
				checkDatas.setCheckCycle("半年度考核");
				checkDatas.setCheckYear(checkDate1);
				//{1:"上半年",2:"下半年"}
				if(checkDate2.equals("1"))
					checkDatas.setCheckMonth("上半年");
				else
					checkDatas.setCheckMonth("下半年");
			}
				
			if(checkCycle.equals("3")){
				checkDatas.setCheckCycle("年度考核");
				checkDatas.setCheckYear(checkDate3);
				checkDatas.setCheckMonth("");
			}
			Dao<E_checkDatas> checkDao=DaoFactory.create(E_checkDatas.class);
			E_checkDatas checktest=new E_checkDatas();
			checktest.setShipperId(shipper);
			checktest.setCheckCycle(checkDatas.getCheckCycle());
			checktest.setCheckYear(checkDatas.getCheckYear());
			checktest.setCheckMonth(checkDatas.getCheckMonth());
					
			E_checkDatas datas=checkDao.selectOne(checktest);
			Timestamp createTime=new Timestamp(System.currentTimeMillis());
			checkDatas.setCreateTime(createTime);
			checkDatas.setCreateUser(username);
			checkDatas.setShipperName(shipperName);
			if(null!=datas){
				checkDatas.setLineid(datas.getLineid());
				checkDao.update(checkDatas);
			}
			else {
				SqlInterface sqlInterface=new SqlInterface();
				String Lineid=sqlInterface.getNextVal("SEQ_TPS_CHECK_DATAS");
				checkDatas.setLineid(Lineid);
				checkDao.insert(checkDatas);
			}
			return "notNull";
		
		}
	protected List<E_checkhead> getOperate(String shipper,String checkCycle,String checkDate,
			String checkDate1,String  checkDate2,String checkDate3) {
		E_checkhead checkhead=new E_checkhead();
		Dao<E_checkhead> checkheadDao=DaoFactory.create(E_checkhead.class);
		checkhead.setShipperLineid(shipper);
		checkhead.setCheckStatus(2);
		List<E_checkhead>headList=new ArrayList<>();
		String date = null;
		//月度考核
		if(checkCycle.equals("1")){
			//"2017-01"
			String month=checkDate.substring(5);
			month=Integer.valueOf(month).toString();
			date=checkDate.substring(0, 4)+"-"+month;
			
			checkhead.setCountmonth(date);
			headList= checkheadDao.select(checkhead);
		}
			
		//半年(4:上半年，5：下半年)
		if(checkCycle.equals("2")){
			date=checkDate1;
			//上半年
			if(checkDate2.equals("1")){
				for (int i = 1; i <=6; i++) {
					checkhead.setCountmonth(date+"-"+i);
					List<E_checkhead>List= checkheadDao.select(checkhead);
					for (E_checkhead e_checkhead : List) {
						headList.add(e_checkhead);
					}
				}
			}
				
			//下半年
			else {
				for (int i = 7; i <=12; i++) {
					checkhead.setCountmonth(date+"-"+i);
					List<E_checkhead>List= checkheadDao.select(checkhead);
					for (E_checkhead e_checkhead : List) {
						headList.add(e_checkhead);
					}
				}
			}
		}
		if(checkCycle.equals("3")){
			date=checkDate3;
			for (int i = 1; i <=12; i++) {
				checkhead.setCountmonth(date+"-"+i);
				List<E_checkhead>List= checkheadDao.select(checkhead);
				for (E_checkhead e_checkhead : List) {
					headList.add(e_checkhead);
				}
			}
		}
			
		return headList;
	}
	/**
	 * 计算绩效
	 * @param shipper
	 * @param checkCycle
	 * @param checkDate
	 * @param checkDate1
	 * @param checkDate2
	 * @param checkDate3
	 * @return
	 * @throws Exception 
	 * @Description:
	 */
	private Map<String, Object> getRate(String shipper,String checkCycle,String checkDate,
			String checkDate1,String  checkDate2,String checkDate3){
		String date = null;

		//checkCycle：1：月度，2：半年，3：年度
		//checkDate2：1：上半年，2：下半年
		//月度考核
		if(checkCycle.equals("1")){
			date=checkDate;
		}
			
		//半年(4:上半年，5：下半年)
		if(checkCycle.equals("2")){
			date=checkDate1;
			//上半年
			if(checkDate2.equals("1"))
				checkCycle="4";
			//下半年
			else {
				checkCycle="5";
			}
		}
		if(checkCycle.equals("3"))
			date=checkDate3;
		Map<String, Object> returnMap=new HashMap<String, Object>();
		//获取gps对接率
		
		GpsStaticDto gpsStaticDto=new GpsStaticDto();
		gpsStaticDto.setIfleetid(Integer.valueOf(shipper));
		//gpsStaticDto.setIfleetid(10);
		if(checkCycle.equals("1")){
			gpsStaticDto.setVcyear(checkDate.substring(0, 4));
			gpsStaticDto.setVcmonth(checkDate.substring(5));
		}
		if(checkCycle.equals("2")){
			//上半年
			if(checkDate2.equals("1")){
				gpsStaticDto.setStartDate(checkDate1+"-01");
				gpsStaticDto.setEndDate(checkDate1+"-06");
			}
				
			//下半年
			else {
				gpsStaticDto.setStartDate(checkDate1+"-07");
				gpsStaticDto.setEndDate(checkDate1+"-12");
			}
			
		}
		if(checkCycle.equals("3"))
			gpsStaticDto.setVcyear(checkDate3);

		SubcontractorCheckService dbService = (SubcontractorCheckService)ApplicationContextManager.getContext().getBean("subcontractorCheckService");
		List<GpsStaticDto> gpsList=dbService.getGpsStatic(gpsStaticDto);
				
		CrmDataService crmDataService=new CrmDataService();
		returnMap =crmDataService.getRate(shipper, date, checkCycle);
		if(null!=gpsList){
			gpsStaticDto=gpsList.get(0);
			returnMap.put("gpsDock", gpsStaticDto.getDcgood());
			returnMap.put("gpsTotal", gpsStaticDto.getDctotal());
		}
		else{
			returnMap.put("gpsDock", 0);
			returnMap.put("gpsTotal", 0);
		}	
		return returnMap;
		
	}
	
}
