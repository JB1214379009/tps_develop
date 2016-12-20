package com.unlcn.ils.tps;

import java.io.Serializable;

import com.chinacreator.c2.annotation.Column;
import com.chinacreator.c2.annotation.ColumnType;
import com.chinacreator.c2.annotation.Entity;

/**
 * 线路意向表
 * @author  
 * @generated
 */ 
@Entity(id = "entity:com.unlcn.ils.tps.e_join_intentline", table = "tps_join_intentline", ds = "ilsdb")
public class E_join_intentline implements Serializable {
	private static final long serialVersionUID = 1687859029999616L;
	/**
	 *序号
	 */
	@Column(id = "lineid", type = ColumnType.uuid, datatype = "string32")
	private java.lang.String lineid;

	/**
	 *起运地
	 */
	@Column(id = "start_city", datatype = "string32")
	private java.lang.String startCity;

	/**
	 *目的地省份
	 */
	@Column(id = "dest_province", datatype = "string32")
	private java.lang.String destProvince;

	/**
	 *意向价格
	 */
	@Column(id = "price", datatype = "bigdecimal")
	private java.math.BigDecimal price;

	/**
	 *每台装量
	 */
	@Column(id = "qty", datatype = "int")
	private java.lang.Integer qty;

	/**
	 *创建时间
	 */
	@Column(id = "create_time", datatype = "timestamp")
	private java.sql.Timestamp createTime;

	/**
	 *创建人
	 */
	@Column(id = "create_user", datatype = "string32")
	private java.lang.String createUser;

	/**
	 *加盟合作id
	 */
	@Column(id = "join_id", datatype = "string32")
	private java.lang.String joinId;

	/**
	 *取消标志
	 */
	@Column(id = "active", datatype = "int")
	private java.lang.Integer active;

	/**
	 *取消操作员
	 */
	@Column(id = "active_user", datatype = "string32")
	private java.lang.String activeUser;

	/**
	 *取消操作时间
	 */
	@Column(id = "active_time", datatype = "timestamp")
	private java.sql.Timestamp activeTime;

	/**
	 *取消说明
	 */
	@Column(id = "active_memo", datatype = "string256")
	private java.lang.String activeMemo;

	/**
	 *加盟/合作
	 */
	@Column(id = "join_flag", datatype = "int")
	private java.lang.Integer joinFlag;

	/**
	 * 设置序号
	 */
	public void setLineid(java.lang.String lineid) {
		this.lineid = lineid;
	}

	/**
	 * 获取序号
	 */
	public java.lang.String getLineid() {
		return lineid;
	}

	/**
	 * 设置起运地
	 */
	public void setStartCity(java.lang.String startCity) {
		this.startCity = startCity;
	}

	/**
	 * 获取起运地
	 */
	public java.lang.String getStartCity() {
		return startCity;
	}

	/**
	 * 设置目的地省份
	 */
	public void setDestProvince(java.lang.String destProvince) {
		this.destProvince = destProvince;
	}

	/**
	 * 获取目的地省份
	 */
	public java.lang.String getDestProvince() {
		return destProvince;
	}

	/**
	 * 设置意向价格
	 */
	public void setPrice(java.math.BigDecimal price) {
		this.price = price;
	}

	/**
	 * 获取意向价格
	 */
	public java.math.BigDecimal getPrice() {
		return price;
	}

	/**
	 * 设置每台装量
	 */
	public void setQty(java.lang.Integer qty) {
		this.qty = qty;
	}

	/**
	 * 获取每台装量
	 */
	public java.lang.Integer getQty() {
		return qty;
	}

	/**
	 * 设置创建时间
	 */
	public void setCreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取创建时间
	 */
	public java.sql.Timestamp getCreateTime() {
		return createTime;
	}

	/**
	 * 设置创建人
	 */
	public void setCreateUser(java.lang.String createUser) {
		this.createUser = createUser;
	}

	/**
	 * 获取创建人
	 */
	public java.lang.String getCreateUser() {
		return createUser;
	}

	/**
	 * 设置加盟合作id
	 */
	public void setJoinId(java.lang.String joinId) {
		this.joinId = joinId;
	}

	/**
	 * 获取加盟合作id
	 */
	public java.lang.String getJoinId() {
		return joinId;
	}

	/**
	 * 设置取消标志
	 */
	public void setActive(java.lang.Integer active) {
		this.active = active;
	}

	/**
	 * 获取取消标志
	 */
	public java.lang.Integer getActive() {
		return active;
	}

	/**
	 * 设置取消操作员
	 */
	public void setActiveUser(java.lang.String activeUser) {
		this.activeUser = activeUser;
	}

	/**
	 * 获取取消操作员
	 */
	public java.lang.String getActiveUser() {
		return activeUser;
	}

	/**
	 * 设置取消操作时间
	 */
	public void setActiveTime(java.sql.Timestamp activeTime) {
		this.activeTime = activeTime;
	}

	/**
	 * 获取取消操作时间
	 */
	public java.sql.Timestamp getActiveTime() {
		return activeTime;
	}

	/**
	 * 设置取消说明
	 */
	public void setActiveMemo(java.lang.String activeMemo) {
		this.activeMemo = activeMemo;
	}

	/**
	 * 获取取消说明
	 */
	public java.lang.String getActiveMemo() {
		return activeMemo;
	}

	/**
	 * 设置加盟/合作
	 */
	public void setJoinFlag(java.lang.Integer joinFlag) {
		this.joinFlag = joinFlag;
	}

	/**
	 * 获取加盟/合作
	 */
	public java.lang.Integer getJoinFlag() {
		return joinFlag;
	}
}
