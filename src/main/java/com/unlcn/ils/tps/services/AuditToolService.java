package com.unlcn.ils.tps.services; 
import java.util.ArrayList;
import java.util.List;
import com.unlcn.ils.tps.E_audit_tool; 
import com.chinacreator.c2.dao.Dao;
import com.chinacreator.c2.dao.DaoFactory;
import com.chinacreator.c2.dao.mybatis.enhance.Order;
import com.chinacreator.c2.dao.mybatis.enhance.Sortable;

public class AuditToolService {
	/**
	 * 
	 * @Description：初审时的沟通方式
	 * @return
	 */
	
		public List<E_audit_tool> getAllData()
		{
		Dao<E_audit_tool> data=DaoFactory.create(E_audit_tool.class);
		E_audit_tool condition=new E_audit_tool();
		condition.setActive(1);
		Sortable sortname= new Sortable();
		List<Order> orders = new ArrayList<Order>();
		Order e = new Order();
		e.setOrderProperty("auditToolName");
		e.setOrderDirection("asc");
		orders.add(e);
		sortname.setOrders(orders);
		List<E_audit_tool> results=data.select(condition, sortname);
		
		return results;
	}
}

