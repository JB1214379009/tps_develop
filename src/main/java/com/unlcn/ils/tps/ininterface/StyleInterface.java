package com.unlcn.ils.tps.ininterface;
  
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.chinacreator.c2.config.ConfigManager;
import com.chinacreator.c2.ioc.ApplicationContextManager;
import com.unlcn.ils.erp.dto.CargoDto;
import com.unlcn.ils.erp.service.*;

  
//得到物货型号信息
public class StyleInterface {
	private static  final Logger log = Logger.getLogger(Logger .class);
	static VehicleService dbService=(VehicleService)ApplicationContextManager.getContext().getBean("vehicleService");
	public static List<Map<String,String>> getDataByCustomer(String customerid)
	{	
		String id=customerid.replaceAll("C", "");
		//返回数据
		List<Map<String,String>> mapresult=new ArrayList<Map<String,String>>();
		
		log.info("设置客户id后调用");
		//接口数据源方式
		String datasouce = ConfigManager.getInstance().getConfig("datasouce");
		
		if (!datasouce.equals("local"))
		{
			CargoDto cargo = new CargoDto();
			//customerid="1";
			cargo.setCustomerId(id);
			if ( dbService==null ){
			log.info("dbService为空");
				dbService=(VehicleService)ApplicationContextManager.getContext().getBean("vehicleService");
			}
			log.info("初始化后dbService"+dbService);	
			
			List<CargoDto> listdata= dbService.queryVehicle(cargo);
			log.info("listdata的长度为"+listdata.size());
			for(int i=0;i<listdata.size();i++)
			{
				Map<String,String> map=new HashMap<String,String> ();
				CargoDto data= listdata.get(i);
				map.put("lineid", data.getStyleId().toString());
				//map.put("lineid",String.valueOf(i));
				map.put("stylename", data.getVcstylename());
				mapresult.add(map);
			}	
			log.info("调用成功后返回车型");
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
	public static Map<String,String> getStyleByStyleID(String styleid)
	{
		
		//接口数据不源方式
		String datasouce = ConfigManager.getInstance().getConfig("datasouce");
		if (!datasouce.equals("local"))
		{
			CargoDto cargo = new CargoDto();
			cargo.setStyleId(Integer.valueOf(styleid));
			//cargo.setRetCode(styleid);
			if ( dbService==null )
				dbService=(VehicleService)ApplicationContextManager.getContext().getBean("vehicleService");
			
			List<CargoDto> listdata= dbService.queryVehicle(cargo);
			if ( listdata.size() <=0) //没有数据，返回null
				return null;
			else	
			{//有数据
				Map<String,String> map=new HashMap<String,String> ();
				CargoDto data= listdata.get(0);//返回第一条
				map.put("lineid", styleid);
				map.put("stylename", data.getVcstylename());
				return map;
			}
		}
		else
		{
			Map<String,String> map=new HashMap<String,String> ();
			map.put("lineid", "1");
			map.put("stylename","2");
			return map;	
		}	
	}
	
	
}
