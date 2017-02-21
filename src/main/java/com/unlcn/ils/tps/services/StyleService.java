package com.unlcn.ils.tps.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List; 
import java.util.Map;

import com.chinacreator.c2.config.ConfigManager;
import com.chinacreator.c2.ioc.ApplicationContextManager;
import com.unlcn.ils.erp.dto.CargoDto;
import com.unlcn.ils.erp.service.VehicleService;
import com.unlcn.ils.tps.ininterface.StyleInterface;
/**
 * 
 *@Title:
 *@Description:货物型号服务
 *@Author:Administrator
 *@Since:2016-8-19
 *@Version:1.1.0
 */
public class StyleService {
	/**
	 * 
	 * @param customerid
	 * @return
	 * @Description:根据客户id，返回货物型号记录
	 */
	//static VehicleService dbService=(VehicleService)ApplicationContextManager.getContext().getBean("vehicleService");
	public List<Map<String,String>> getDataByCustomerId(String customerid)
	{	
		//return StyleInterface.getDataByCustomer(customerid);
		//返回数据
				List<Map<String,String>> mapresult=new ArrayList<Map<String,String>>();
				
				
				//接口数据源方式
				String datasouce = ConfigManager.getInstance().getConfig("datasouce");
				VehicleService dbService=(VehicleService)ApplicationContextManager.getContext().getBean("vehicleService");
				if (!datasouce.equals("local"))
				{
					CargoDto cargo = new CargoDto();
					//customerid="1";
					cargo.setCustomerId(customerid);
					if ( dbService==null )
						dbService=(VehicleService)ApplicationContextManager.getContext().getBean("vehicleService");
					List<CargoDto> listdata= dbService.queryVehicle(cargo);
					
					for(int i=0;i<listdata.size();i++)
					{
						Map<String,String> map=new HashMap<String,String> ();
						CargoDto data= listdata.get(i);
						map.put("lineid", data.getStyleId().toString());
						//map.put("lineid",String.valueOf(i));
						map.put("stylename", data.getVcstylename());
						mapresult.add(map);
					}			
					return mapresult;
					
				}
				else
				{	
					for(int i=0;i<10;i++)
					{
						Map<String,String> map=new HashMap<String,String> ();
						map.put("lineid",String.valueOf(i));
						map.put("stylename","style"+String.valueOf(i));
						mapresult.add(map);
					}
					return mapresult;
				}
	}
	
	public Map<String,String> getStyleById(String styleid)
	{
		Map<String,String> style = StyleInterface.getStyleByStyleID(styleid);	
		return style;
		
	} 
}
