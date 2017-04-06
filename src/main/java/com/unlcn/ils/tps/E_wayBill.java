package com.unlcn.ils.tps;

import java.io.Serializable;

import com.chinacreator.c2.annotation.Column;
import com.chinacreator.c2.annotation.ColumnType;
import com.chinacreator.c2.annotation.Entity;

/**
 * 订单信息表
 * @author 
 * @generated
 */
@Entity(id = "entity:com.unlcn.ils.tps.e_wayBill", table = "td_waybill_alarm", ds = "ilscrm")
public class E_wayBill implements Serializable {
	private static final long serialVersionUID = 2101007355559936L;
	/**
	 *
	 */
	@Column(id = "id", type = ColumnType.uuid, datatype = "string64")
	private java.lang.String id;

	/**
	 *系统运单号
	 */
	@Column(id = "system_waybill_id", datatype = "string64")
	private java.lang.String systemWaybillId;

	/**
	 *客户订单号
	 */
	@Column(id = "customer_order_id", datatype = "string64")
	private java.lang.String customerOrderId;

	/**
	 *客户运单号
	 */
	@Column(id = "customer_waybill_id", datatype = "string64")
	private java.lang.String customerWaybillId;

	/**
	 *服务单号
	 */
	@Column(id = "service_id", datatype = "string64")
	private java.lang.String serviceId;

	/**
	 *运输模式
	 */
	@Column(id = "transmode", datatype = "string64")
	private java.lang.String transmode;

	/**
	 *是否中转
	 */
	@Column(id = "transit", datatype = "string5")
	private java.lang.String transit;

	/**
	 *要求发运日期
	 */
	@Column(id = "ship_date", datatype = "date")
	private java.sql.Date shipDate;

	/**
	 *要求运抵日期
	 */
	@Column(id = "delivery_date", datatype = "date")
	private java.sql.Date deliveryDate;

	/**
	 *货物编码，包括车辆底盘号等
	 */
	@Column(id = "goods_code", datatype = "string64")
	private java.lang.String goodsCode;

	/**
	 *起运省
	 */
	@Column(id = "ship_start_pro", datatype = "string64")
	private java.lang.String shipStartPro;

	/**
	 *起运城市
	 */
	@Column(id = "ship_start_city", datatype = "string64")
	private java.lang.String shipStartCity;

	/**
	 *目的省
	 */
	@Column(id = "ship_end_pro", datatype = "string64")
	private java.lang.String shipEndPro;

	/**
	 *目的城市
	 */
	@Column(id = "ship_end_city", datatype = "string64")
	private java.lang.String shipEndCity;

	/**
	 *订单起运省
	 */
	@Column(id = "start_province", datatype = "string64")
	private java.lang.String startProvince;

	/**
	 *订单起运城市
	 */
	@Column(id = "start_city", datatype = "string64")
	private java.lang.String startCity;

	/**
	 *订单目的省
	 */
	@Column(id = "end_province", datatype = "string64")
	private java.lang.String endProvince;

	/**
	 *订单目的城市
	 */
	@Column(id = "end_city", datatype = "string64")
	private java.lang.String endCity;

	/**
	 *应付公里数
	 */
	@Column(id = "miles", datatype = "long")
	private java.lang.Long miles;

	/**
	 *数量
	 */
	@Column(id = "count", datatype = "int")
	private java.lang.Integer count;

	/**
	 *已发运数量
	 */
	@Column(id = "shipped_count", datatype = "int")
	private java.lang.Integer shippedCount;

	/**
	 *所属客户
	 */
	@Column(id = "customer_id", datatype = "string64")
	private java.lang.String customerId;

	/**
	 *货物型号
	 */
	@Column(id = "goods_type", datatype = "string64")
	private java.lang.String goodsType;

	/**
	 *备注
	 */
	@Column(id = "memo", datatype = "string256")
	private java.lang.String memo;

	/**
	 *承运车牌
	 */
	@Column(id = "shipper_car", datatype = "string64")
	private java.lang.String shipperCar;

	/**
	 *分供方编码
	 */
	@Column(id = "shipper_id", datatype = "string64")
	private java.lang.String shipperId;

	/**
	 *承运分供方
	 */
	@Column(id = "shipper", datatype = "string64")
	private java.lang.String shipper;

	/**
	 *承运司机
	 */
	@Column(id = "driver", datatype = "string64")
	private java.lang.String driver;

	/**
	 *司机电话
	 */
	@Column(id = "driver_phone", datatype = "string64")
	private java.lang.String driverPhone;

	/**
	 *指令号
	 */
	@Column(id = "command_id", datatype = "string64")
	private java.lang.String commandId;

	/**
	 *货物状态
	 */
	@Column(id = "goods_status", datatype = "string64")
	private java.lang.String goodsStatus;

	/**
	 *收货地址
	 */
	@Column(id = "consignee_address", datatype = "string256")
	private java.lang.String consigneeAddress;

	/**
	 *收货人
	 */
	@Column(id = "consignee", datatype = "string64")
	private java.lang.String consignee;

	/**
	 *收货人电话
	 */
	@Column(id = "consignee_phone", datatype = "string64")
	private java.lang.String consigneePhone;

	/**
	 *起运库
	 */
	@Column(id = "start_warehouse", datatype = "string64")
	private java.lang.String startWarehouse;

	/**
	 *订单信息表ID
	 */
	@Column(id = "waybill_id", datatype = "string64")
	private java.lang.String waybillId;

	/**
	 *订单状态
	 */
	@Column(id = "status", datatype = "string64")
	private java.lang.String status;

	/**
	 *入库时间
	 */
	@Column(id = "insert_time", datatype = "timestamp")
	private java.sql.Timestamp insertTime;

	/**
	 *更新时间
	 */
	@Column(id = "update_time", datatype = "timestamp")
	private java.sql.Timestamp updateTime;

	/**
	 *下单日期，文本yyyymmdd
	 */
	@Column(id = "create_day", datatype = "string10")
	private java.lang.String createDay;

	/**
	 *下单时间
	 */
	@Column(id = "create_time", datatype = "timestamp")
	private java.sql.Timestamp createTime;

	/**
	 *下单标准
	 */
	@Column(id = "create_stime", datatype = "int")
	private java.lang.Integer createStime;

	/**
	 *下单耗时比率
	 */
	@Column(id = "create_rate", datatype = "long")
	private java.lang.Long createRate;

	/**
	 *调度时间
	 */
	@Column(id = "dispatch_time", datatype = "timestamp")
	private java.sql.Timestamp dispatchTime;

	/**
	 *调度标准
	 */
	@Column(id = "dispatch_stime", datatype = "int")
	private java.lang.Integer dispatchStime;

	/**
	 *调度耗时比率
	 */
	@Column(id = "dispatch_rate", datatype = "long")
	private java.lang.Long dispatchRate;

	/**
	 *提车时间
	 */
	@Column(id = "pick_up_time", datatype = "timestamp")
	private java.sql.Timestamp pickUpTime;

	/**
	 *提车标准
	 */
	@Column(id = "pick_up_stime", datatype = "int")
	private java.lang.Integer pickUpStime;

	/**
	 *提车耗时比率
	 */
	@Column(id = "pick_up_rate", datatype = "long")
	private java.lang.Long pickUpRate;

	/**
	 *装车时间
	 */
	@Column(id = "load_time", datatype = "timestamp")
	private java.sql.Timestamp loadTime;

	/**
	 *装车标准
	 */
	@Column(id = "load_stime", datatype = "int")
	private java.lang.Integer loadStime;

	/**
	 *装车耗时比率
	 */
	@Column(id = "load_rate", datatype = "long")
	private java.lang.Long loadRate;

	/**
	 *发运时间
	 */
	@Column(id = "ship_time", datatype = "timestamp")
	private java.sql.Timestamp shipTime;

	/**
	 *发运标准
	 */
	@Column(id = "ship_stime", datatype = "int")
	private java.lang.Integer shipStime;

	/**
	 *发运耗时比率
	 */
	@Column(id = "ship_rate", datatype = "long")
	private java.lang.Long shipRate;

	/**
	 *运抵时间
	 */
	@Column(id = "delivery_time", datatype = "timestamp")
	private java.sql.Timestamp deliveryTime;

	/**
	 *运抵标准
	 */
	@Column(id = "delivery_stime", datatype = "int")
	private java.lang.Integer deliveryStime;

	/**
	 *运抵耗时比率
	 */
	@Column(id = "delivery_rate", datatype = "long")
	private java.lang.Long deliveryRate;

	/**
	 *交付时间
	 */
	@Column(id = "receive_time", datatype = "timestamp")
	private java.sql.Timestamp receiveTime;

	/**
	 *交付标准
	 */
	@Column(id = "receive_stime", datatype = "int")
	private java.lang.Integer receiveStime;

	/**
	 *交付耗时比率
	 */
	@Column(id = "receive_rate", datatype = "long")
	private java.lang.Long receiveRate;

	/**
	 *回单时间
	 */
	@Column(id = "receipt_time", datatype = "timestamp")
	private java.sql.Timestamp receiptTime;

	/**
	 *回单标准
	 */
	@Column(id = "receipt_stime", datatype = "int")
	private java.lang.Integer receiptStime;

	/**
	 *回单耗时比率
	 */
	@Column(id = "receipt_rate", datatype = "long")
	private java.lang.Long receiptRate;

	/**
	 *计算时间
	 */
	@Column(id = "count_time", datatype = "timestamp")
	private java.sql.Timestamp countTime;

	/**
	 *处理标识：1处理中，0待处理
	 */
	@Column(id = "flag", datatype = "string5")
	private java.lang.String flag;

	/**
	 *当前位置经度
	 */
	@Column(id = "current_lng", datatype = "long")
	private java.lang.Long currentLng;

	/**
	 *当前位置纬度
	 */
	@Column(id = "current_lat", datatype = "long")
	private java.lang.Long currentLat;

	/**
	 *当前位置
	 */
	@Column(id = "current_site", datatype = "string256")
	private java.lang.String currentSite;

	/**
	 *当前位置更新时间
	 */
	@Column(id = "site_time", datatype = "timestamp")
	private java.sql.Timestamp siteTime;

	/**
	 *急发状态
	 */
	@Column(id = "acute", datatype = "string64")
	private java.lang.String acute;

	/**
	 *服务运单打印时间
	 */
	@Column(id = "service_print_time", datatype = "timestamp")
	private java.sql.Timestamp servicePrintTime;

	/**
	 *运单打印日期
	 */
	@Column(id = "waybill_print_date", datatype = "date")
	private java.sql.Date waybillPrintDate;

	/**
	 *调度人
	 */
	@Column(id = "dispatcher", datatype = "string64")
	private java.lang.String dispatcher;

	/**
	 *预警情况
	 */
	@Column(id = "alarminfo", datatype = "string512")
	private java.lang.String alarminfo;

	/**
	 *车辆第一天位置
	 */
	@Column(id = "n1", datatype = "string256")
	private java.lang.String n1;

	/**
	 *车辆第二天位置
	 */
	@Column(id = "n2", datatype = "string256")
	private java.lang.String n2;

	/**
	 *车辆第三天位置
	 */
	@Column(id = "n3", datatype = "string256")
	private java.lang.String n3;

	/**
	 *车辆第四天位置
	 */
	@Column(id = "n4", datatype = "string256")
	private java.lang.String n4;

	/**
	 *车辆第五天位置
	 */
	@Column(id = "n5", datatype = "string256")
	private java.lang.String n5;

	/**
	 *车辆第六天位置
	 */
	@Column(id = "n6", datatype = "string256")
	private java.lang.String n6;

	/**
	 *车辆第七天位置
	 */
	@Column(id = "n7", datatype = "string256")
	private java.lang.String n7;

	/**
	 *车辆第八天位置
	 */
	@Column(id = "n8", datatype = "string256")
	private java.lang.String n8;

	/**
	 *GPS异常：0正常，1异常（在途期间断连超过4-6小时则为异常）
	 */
	@Column(id = "gpsexception", datatype = "string5")
	private java.lang.String gpsexception;

	/**
	 *异常类型
	 */
	@Column(id = "exception_type", datatype = "string32")
	private java.lang.String exceptionType;

	/**
	 *异常描述
	 */
	@Column(id = "exception_desc", datatype = "string512")
	private java.lang.String exceptionDesc;

	/**
	 *异常状态
	 */
	@Column(id = "exception_status", datatype = "string10")
	private java.lang.String exceptionStatus;

	/**
	 *处理结果
	 */
	@Column(id = "exception_result", datatype = "string256")
	private java.lang.String exceptionResult;

	/**
	 *逻辑删除 (0：正常，1：删除)
	 */
	@Column(id = "c2_logicdelete_flag", datatype = "string5")
	private java.lang.String c2LogicdeleteFlag;

	/**
	 *
	 */
	@Column(id = "ccc_dx_etl_time", datatype = "long")
	private java.lang.Long cccDxEtlTime;

	/**
	 * 设置
	 */
	public void setId(java.lang.String id) {
		this.id = id;
	}

	/**
	 * 获取
	 */
	public java.lang.String getId() {
		return id;
	}

	/**
	 * 设置系统运单号
	 */
	public void setSystemWaybillId(java.lang.String systemWaybillId) {
		this.systemWaybillId = systemWaybillId;
	}

	/**
	 * 获取系统运单号
	 */
	public java.lang.String getSystemWaybillId() {
		return systemWaybillId;
	}

	/**
	 * 设置客户订单号
	 */
	public void setCustomerOrderId(java.lang.String customerOrderId) {
		this.customerOrderId = customerOrderId;
	}

	/**
	 * 获取客户订单号
	 */
	public java.lang.String getCustomerOrderId() {
		return customerOrderId;
	}

	/**
	 * 设置客户运单号
	 */
	public void setCustomerWaybillId(java.lang.String customerWaybillId) {
		this.customerWaybillId = customerWaybillId;
	}

	/**
	 * 获取客户运单号
	 */
	public java.lang.String getCustomerWaybillId() {
		return customerWaybillId;
	}

	/**
	 * 设置服务单号
	 */
	public void setServiceId(java.lang.String serviceId) {
		this.serviceId = serviceId;
	}

	/**
	 * 获取服务单号
	 */
	public java.lang.String getServiceId() {
		return serviceId;
	}

	/**
	 * 设置运输模式
	 */
	public void setTransmode(java.lang.String transmode) {
		this.transmode = transmode;
	}

	/**
	 * 获取运输模式
	 */
	public java.lang.String getTransmode() {
		return transmode;
	}

	/**
	 * 设置是否中转
	 */
	public void setTransit(java.lang.String transit) {
		this.transit = transit;
	}

	/**
	 * 获取是否中转
	 */
	public java.lang.String getTransit() {
		return transit;
	}

	/**
	 * 设置要求发运日期
	 */
	public void setShipDate(java.sql.Date shipDate) {
		this.shipDate = shipDate;
	}

	/**
	 * 获取要求发运日期
	 */
	public java.sql.Date getShipDate() {
		return shipDate;
	}

	/**
	 * 设置要求运抵日期
	 */
	public void setDeliveryDate(java.sql.Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	/**
	 * 获取要求运抵日期
	 */
	public java.sql.Date getDeliveryDate() {
		return deliveryDate;
	}

	/**
	 * 设置货物编码，包括车辆底盘号等
	 */
	public void setGoodsCode(java.lang.String goodsCode) {
		this.goodsCode = goodsCode;
	}

	/**
	 * 获取货物编码，包括车辆底盘号等
	 */
	public java.lang.String getGoodsCode() {
		return goodsCode;
	}

	/**
	 * 设置起运省
	 */
	public void setShipStartPro(java.lang.String shipStartPro) {
		this.shipStartPro = shipStartPro;
	}

	/**
	 * 获取起运省
	 */
	public java.lang.String getShipStartPro() {
		return shipStartPro;
	}

	/**
	 * 设置起运城市
	 */
	public void setShipStartCity(java.lang.String shipStartCity) {
		this.shipStartCity = shipStartCity;
	}

	/**
	 * 获取起运城市
	 */
	public java.lang.String getShipStartCity() {
		return shipStartCity;
	}

	/**
	 * 设置目的省
	 */
	public void setShipEndPro(java.lang.String shipEndPro) {
		this.shipEndPro = shipEndPro;
	}

	/**
	 * 获取目的省
	 */
	public java.lang.String getShipEndPro() {
		return shipEndPro;
	}

	/**
	 * 设置目的城市
	 */
	public void setShipEndCity(java.lang.String shipEndCity) {
		this.shipEndCity = shipEndCity;
	}

	/**
	 * 获取目的城市
	 */
	public java.lang.String getShipEndCity() {
		return shipEndCity;
	}

	/**
	 * 设置订单起运省
	 */
	public void setStartProvince(java.lang.String startProvince) {
		this.startProvince = startProvince;
	}

	/**
	 * 获取订单起运省
	 */
	public java.lang.String getStartProvince() {
		return startProvince;
	}

	/**
	 * 设置订单起运城市
	 */
	public void setStartCity(java.lang.String startCity) {
		this.startCity = startCity;
	}

	/**
	 * 获取订单起运城市
	 */
	public java.lang.String getStartCity() {
		return startCity;
	}

	/**
	 * 设置订单目的省
	 */
	public void setEndProvince(java.lang.String endProvince) {
		this.endProvince = endProvince;
	}

	/**
	 * 获取订单目的省
	 */
	public java.lang.String getEndProvince() {
		return endProvince;
	}

	/**
	 * 设置订单目的城市
	 */
	public void setEndCity(java.lang.String endCity) {
		this.endCity = endCity;
	}

	/**
	 * 获取订单目的城市
	 */
	public java.lang.String getEndCity() {
		return endCity;
	}

	/**
	 * 设置应付公里数
	 */
	public void setMiles(java.lang.Long miles) {
		this.miles = miles;
	}

	/**
	 * 获取应付公里数
	 */
	public java.lang.Long getMiles() {
		return miles;
	}

	/**
	 * 设置数量
	 */
	public void setCount(java.lang.Integer count) {
		this.count = count;
	}

	/**
	 * 获取数量
	 */
	public java.lang.Integer getCount() {
		return count;
	}

	/**
	 * 设置已发运数量
	 */
	public void setShippedCount(java.lang.Integer shippedCount) {
		this.shippedCount = shippedCount;
	}

	/**
	 * 获取已发运数量
	 */
	public java.lang.Integer getShippedCount() {
		return shippedCount;
	}

	/**
	 * 设置所属客户
	 */
	public void setCustomerId(java.lang.String customerId) {
		this.customerId = customerId;
	}

	/**
	 * 获取所属客户
	 */
	public java.lang.String getCustomerId() {
		return customerId;
	}

	/**
	 * 设置货物型号
	 */
	public void setGoodsType(java.lang.String goodsType) {
		this.goodsType = goodsType;
	}

	/**
	 * 获取货物型号
	 */
	public java.lang.String getGoodsType() {
		return goodsType;
	}

	/**
	 * 设置备注
	 */
	public void setMemo(java.lang.String memo) {
		this.memo = memo;
	}

	/**
	 * 获取备注
	 */
	public java.lang.String getMemo() {
		return memo;
	}

	/**
	 * 设置承运车牌
	 */
	public void setShipperCar(java.lang.String shipperCar) {
		this.shipperCar = shipperCar;
	}

	/**
	 * 获取承运车牌
	 */
	public java.lang.String getShipperCar() {
		return shipperCar;
	}

	/**
	 * 设置分供方编码
	 */
	public void setShipperId(java.lang.String shipperId) {
		this.shipperId = shipperId;
	}

	/**
	 * 获取分供方编码
	 */
	public java.lang.String getShipperId() {
		return shipperId;
	}

	/**
	 * 设置承运分供方
	 */
	public void setShipper(java.lang.String shipper) {
		this.shipper = shipper;
	}

	/**
	 * 获取承运分供方
	 */
	public java.lang.String getShipper() {
		return shipper;
	}

	/**
	 * 设置承运司机
	 */
	public void setDriver(java.lang.String driver) {
		this.driver = driver;
	}

	/**
	 * 获取承运司机
	 */
	public java.lang.String getDriver() {
		return driver;
	}

	/**
	 * 设置司机电话
	 */
	public void setDriverPhone(java.lang.String driverPhone) {
		this.driverPhone = driverPhone;
	}

	/**
	 * 获取司机电话
	 */
	public java.lang.String getDriverPhone() {
		return driverPhone;
	}

	/**
	 * 设置指令号
	 */
	public void setCommandId(java.lang.String commandId) {
		this.commandId = commandId;
	}

	/**
	 * 获取指令号
	 */
	public java.lang.String getCommandId() {
		return commandId;
	}

	/**
	 * 设置货物状态
	 */
	public void setGoodsStatus(java.lang.String goodsStatus) {
		this.goodsStatus = goodsStatus;
	}

	/**
	 * 获取货物状态
	 */
	public java.lang.String getGoodsStatus() {
		return goodsStatus;
	}

	/**
	 * 设置收货地址
	 */
	public void setConsigneeAddress(java.lang.String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}

	/**
	 * 获取收货地址
	 */
	public java.lang.String getConsigneeAddress() {
		return consigneeAddress;
	}

	/**
	 * 设置收货人
	 */
	public void setConsignee(java.lang.String consignee) {
		this.consignee = consignee;
	}

	/**
	 * 获取收货人
	 */
	public java.lang.String getConsignee() {
		return consignee;
	}

	/**
	 * 设置收货人电话
	 */
	public void setConsigneePhone(java.lang.String consigneePhone) {
		this.consigneePhone = consigneePhone;
	}

	/**
	 * 获取收货人电话
	 */
	public java.lang.String getConsigneePhone() {
		return consigneePhone;
	}

	/**
	 * 设置起运库
	 */
	public void setStartWarehouse(java.lang.String startWarehouse) {
		this.startWarehouse = startWarehouse;
	}

	/**
	 * 获取起运库
	 */
	public java.lang.String getStartWarehouse() {
		return startWarehouse;
	}

	/**
	 * 设置订单信息表ID
	 */
	public void setWaybillId(java.lang.String waybillId) {
		this.waybillId = waybillId;
	}

	/**
	 * 获取订单信息表ID
	 */
	public java.lang.String getWaybillId() {
		return waybillId;
	}

	/**
	 * 设置订单状态
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	/**
	 * 获取订单状态
	 */
	public java.lang.String getStatus() {
		return status;
	}

	/**
	 * 设置入库时间
	 */
	public void setInsertTime(java.sql.Timestamp insertTime) {
		this.insertTime = insertTime;
	}

	/**
	 * 获取入库时间
	 */
	public java.sql.Timestamp getInsertTime() {
		return insertTime;
	}

	/**
	 * 设置更新时间
	 */
	public void setUpdateTime(java.sql.Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 获取更新时间
	 */
	public java.sql.Timestamp getUpdateTime() {
		return updateTime;
	}

	/**
	 * 设置下单日期，文本yyyymmdd
	 */
	public void setCreateDay(java.lang.String createDay) {
		this.createDay = createDay;
	}

	/**
	 * 获取下单日期，文本yyyymmdd
	 */
	public java.lang.String getCreateDay() {
		return createDay;
	}

	/**
	 * 设置下单时间
	 */
	public void setCreateTime(java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取下单时间
	 */
	public java.sql.Timestamp getCreateTime() {
		return createTime;
	}

	/**
	 * 设置下单标准
	 */
	public void setCreateStime(java.lang.Integer createStime) {
		this.createStime = createStime;
	}

	/**
	 * 获取下单标准
	 */
	public java.lang.Integer getCreateStime() {
		return createStime;
	}

	/**
	 * 设置下单耗时比率
	 */
	public void setCreateRate(java.lang.Long createRate) {
		this.createRate = createRate;
	}

	/**
	 * 获取下单耗时比率
	 */
	public java.lang.Long getCreateRate() {
		return createRate;
	}

	/**
	 * 设置调度时间
	 */
	public void setDispatchTime(java.sql.Timestamp dispatchTime) {
		this.dispatchTime = dispatchTime;
	}

	/**
	 * 获取调度时间
	 */
	public java.sql.Timestamp getDispatchTime() {
		return dispatchTime;
	}

	/**
	 * 设置调度标准
	 */
	public void setDispatchStime(java.lang.Integer dispatchStime) {
		this.dispatchStime = dispatchStime;
	}

	/**
	 * 获取调度标准
	 */
	public java.lang.Integer getDispatchStime() {
		return dispatchStime;
	}

	/**
	 * 设置调度耗时比率
	 */
	public void setDispatchRate(java.lang.Long dispatchRate) {
		this.dispatchRate = dispatchRate;
	}

	/**
	 * 获取调度耗时比率
	 */
	public java.lang.Long getDispatchRate() {
		return dispatchRate;
	}

	/**
	 * 设置提车时间
	 */
	public void setPickUpTime(java.sql.Timestamp pickUpTime) {
		this.pickUpTime = pickUpTime;
	}

	/**
	 * 获取提车时间
	 */
	public java.sql.Timestamp getPickUpTime() {
		return pickUpTime;
	}

	/**
	 * 设置提车标准
	 */
	public void setPickUpStime(java.lang.Integer pickUpStime) {
		this.pickUpStime = pickUpStime;
	}

	/**
	 * 获取提车标准
	 */
	public java.lang.Integer getPickUpStime() {
		return pickUpStime;
	}

	/**
	 * 设置提车耗时比率
	 */
	public void setPickUpRate(java.lang.Long pickUpRate) {
		this.pickUpRate = pickUpRate;
	}

	/**
	 * 获取提车耗时比率
	 */
	public java.lang.Long getPickUpRate() {
		return pickUpRate;
	}

	/**
	 * 设置装车时间
	 */
	public void setLoadTime(java.sql.Timestamp loadTime) {
		this.loadTime = loadTime;
	}

	/**
	 * 获取装车时间
	 */
	public java.sql.Timestamp getLoadTime() {
		return loadTime;
	}

	/**
	 * 设置装车标准
	 */
	public void setLoadStime(java.lang.Integer loadStime) {
		this.loadStime = loadStime;
	}

	/**
	 * 获取装车标准
	 */
	public java.lang.Integer getLoadStime() {
		return loadStime;
	}

	/**
	 * 设置装车耗时比率
	 */
	public void setLoadRate(java.lang.Long loadRate) {
		this.loadRate = loadRate;
	}

	/**
	 * 获取装车耗时比率
	 */
	public java.lang.Long getLoadRate() {
		return loadRate;
	}

	/**
	 * 设置发运时间
	 */
	public void setShipTime(java.sql.Timestamp shipTime) {
		this.shipTime = shipTime;
	}

	/**
	 * 获取发运时间
	 */
	public java.sql.Timestamp getShipTime() {
		return shipTime;
	}

	/**
	 * 设置发运标准
	 */
	public void setShipStime(java.lang.Integer shipStime) {
		this.shipStime = shipStime;
	}

	/**
	 * 获取发运标准
	 */
	public java.lang.Integer getShipStime() {
		return shipStime;
	}

	/**
	 * 设置发运耗时比率
	 */
	public void setShipRate(java.lang.Long shipRate) {
		this.shipRate = shipRate;
	}

	/**
	 * 获取发运耗时比率
	 */
	public java.lang.Long getShipRate() {
		return shipRate;
	}

	/**
	 * 设置运抵时间
	 */
	public void setDeliveryTime(java.sql.Timestamp deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	/**
	 * 获取运抵时间
	 */
	public java.sql.Timestamp getDeliveryTime() {
		return deliveryTime;
	}

	/**
	 * 设置运抵标准
	 */
	public void setDeliveryStime(java.lang.Integer deliveryStime) {
		this.deliveryStime = deliveryStime;
	}

	/**
	 * 获取运抵标准
	 */
	public java.lang.Integer getDeliveryStime() {
		return deliveryStime;
	}

	/**
	 * 设置运抵耗时比率
	 */
	public void setDeliveryRate(java.lang.Long deliveryRate) {
		this.deliveryRate = deliveryRate;
	}

	/**
	 * 获取运抵耗时比率
	 */
	public java.lang.Long getDeliveryRate() {
		return deliveryRate;
	}

	/**
	 * 设置交付时间
	 */
	public void setReceiveTime(java.sql.Timestamp receiveTime) {
		this.receiveTime = receiveTime;
	}

	/**
	 * 获取交付时间
	 */
	public java.sql.Timestamp getReceiveTime() {
		return receiveTime;
	}

	/**
	 * 设置交付标准
	 */
	public void setReceiveStime(java.lang.Integer receiveStime) {
		this.receiveStime = receiveStime;
	}

	/**
	 * 获取交付标准
	 */
	public java.lang.Integer getReceiveStime() {
		return receiveStime;
	}

	/**
	 * 设置交付耗时比率
	 */
	public void setReceiveRate(java.lang.Long receiveRate) {
		this.receiveRate = receiveRate;
	}

	/**
	 * 获取交付耗时比率
	 */
	public java.lang.Long getReceiveRate() {
		return receiveRate;
	}

	/**
	 * 设置回单时间
	 */
	public void setReceiptTime(java.sql.Timestamp receiptTime) {
		this.receiptTime = receiptTime;
	}

	/**
	 * 获取回单时间
	 */
	public java.sql.Timestamp getReceiptTime() {
		return receiptTime;
	}

	/**
	 * 设置回单标准
	 */
	public void setReceiptStime(java.lang.Integer receiptStime) {
		this.receiptStime = receiptStime;
	}

	/**
	 * 获取回单标准
	 */
	public java.lang.Integer getReceiptStime() {
		return receiptStime;
	}

	/**
	 * 设置回单耗时比率
	 */
	public void setReceiptRate(java.lang.Long receiptRate) {
		this.receiptRate = receiptRate;
	}

	/**
	 * 获取回单耗时比率
	 */
	public java.lang.Long getReceiptRate() {
		return receiptRate;
	}

	/**
	 * 设置计算时间
	 */
	public void setCountTime(java.sql.Timestamp countTime) {
		this.countTime = countTime;
	}

	/**
	 * 获取计算时间
	 */
	public java.sql.Timestamp getCountTime() {
		return countTime;
	}

	/**
	 * 设置处理标识：1处理中，0待处理
	 */
	public void setFlag(java.lang.String flag) {
		this.flag = flag;
	}

	/**
	 * 获取处理标识：1处理中，0待处理
	 */
	public java.lang.String getFlag() {
		return flag;
	}

	/**
	 * 设置当前位置经度
	 */
	public void setCurrentLng(java.lang.Long currentLng) {
		this.currentLng = currentLng;
	}

	/**
	 * 获取当前位置经度
	 */
	public java.lang.Long getCurrentLng() {
		return currentLng;
	}

	/**
	 * 设置当前位置纬度
	 */
	public void setCurrentLat(java.lang.Long currentLat) {
		this.currentLat = currentLat;
	}

	/**
	 * 获取当前位置纬度
	 */
	public java.lang.Long getCurrentLat() {
		return currentLat;
	}

	/**
	 * 设置当前位置
	 */
	public void setCurrentSite(java.lang.String currentSite) {
		this.currentSite = currentSite;
	}

	/**
	 * 获取当前位置
	 */
	public java.lang.String getCurrentSite() {
		return currentSite;
	}

	/**
	 * 设置当前位置更新时间
	 */
	public void setSiteTime(java.sql.Timestamp siteTime) {
		this.siteTime = siteTime;
	}

	/**
	 * 获取当前位置更新时间
	 */
	public java.sql.Timestamp getSiteTime() {
		return siteTime;
	}

	/**
	 * 设置急发状态
	 */
	public void setAcute(java.lang.String acute) {
		this.acute = acute;
	}

	/**
	 * 获取急发状态
	 */
	public java.lang.String getAcute() {
		return acute;
	}

	/**
	 * 设置服务运单打印时间
	 */
	public void setServicePrintTime(java.sql.Timestamp servicePrintTime) {
		this.servicePrintTime = servicePrintTime;
	}

	/**
	 * 获取服务运单打印时间
	 */
	public java.sql.Timestamp getServicePrintTime() {
		return servicePrintTime;
	}

	/**
	 * 设置运单打印日期
	 */
	public void setWaybillPrintDate(java.sql.Date waybillPrintDate) {
		this.waybillPrintDate = waybillPrintDate;
	}

	/**
	 * 获取运单打印日期
	 */
	public java.sql.Date getWaybillPrintDate() {
		return waybillPrintDate;
	}

	/**
	 * 设置调度人
	 */
	public void setDispatcher(java.lang.String dispatcher) {
		this.dispatcher = dispatcher;
	}

	/**
	 * 获取调度人
	 */
	public java.lang.String getDispatcher() {
		return dispatcher;
	}

	/**
	 * 设置预警情况
	 */
	public void setAlarminfo(java.lang.String alarminfo) {
		this.alarminfo = alarminfo;
	}

	/**
	 * 获取预警情况
	 */
	public java.lang.String getAlarminfo() {
		return alarminfo;
	}

	/**
	 * 设置车辆第一天位置
	 */
	public void setN1(java.lang.String n1) {
		this.n1 = n1;
	}

	/**
	 * 获取车辆第一天位置
	 */
	public java.lang.String getN1() {
		return n1;
	}

	/**
	 * 设置车辆第二天位置
	 */
	public void setN2(java.lang.String n2) {
		this.n2 = n2;
	}

	/**
	 * 获取车辆第二天位置
	 */
	public java.lang.String getN2() {
		return n2;
	}

	/**
	 * 设置车辆第三天位置
	 */
	public void setN3(java.lang.String n3) {
		this.n3 = n3;
	}

	/**
	 * 获取车辆第三天位置
	 */
	public java.lang.String getN3() {
		return n3;
	}

	/**
	 * 设置车辆第四天位置
	 */
	public void setN4(java.lang.String n4) {
		this.n4 = n4;
	}

	/**
	 * 获取车辆第四天位置
	 */
	public java.lang.String getN4() {
		return n4;
	}

	/**
	 * 设置车辆第五天位置
	 */
	public void setN5(java.lang.String n5) {
		this.n5 = n5;
	}

	/**
	 * 获取车辆第五天位置
	 */
	public java.lang.String getN5() {
		return n5;
	}

	/**
	 * 设置车辆第六天位置
	 */
	public void setN6(java.lang.String n6) {
		this.n6 = n6;
	}

	/**
	 * 获取车辆第六天位置
	 */
	public java.lang.String getN6() {
		return n6;
	}

	/**
	 * 设置车辆第七天位置
	 */
	public void setN7(java.lang.String n7) {
		this.n7 = n7;
	}

	/**
	 * 获取车辆第七天位置
	 */
	public java.lang.String getN7() {
		return n7;
	}

	/**
	 * 设置车辆第八天位置
	 */
	public void setN8(java.lang.String n8) {
		this.n8 = n8;
	}

	/**
	 * 获取车辆第八天位置
	 */
	public java.lang.String getN8() {
		return n8;
	}

	/**
	 * 设置GPS异常：0正常，1异常（在途期间断连超过4-6小时则为异常）
	 */
	public void setGpsexception(java.lang.String gpsexception) {
		this.gpsexception = gpsexception;
	}

	/**
	 * 获取GPS异常：0正常，1异常（在途期间断连超过4-6小时则为异常）
	 */
	public java.lang.String getGpsexception() {
		return gpsexception;
	}

	/**
	 * 设置异常类型
	 */
	public void setExceptionType(java.lang.String exceptionType) {
		this.exceptionType = exceptionType;
	}

	/**
	 * 获取异常类型
	 */
	public java.lang.String getExceptionType() {
		return exceptionType;
	}

	/**
	 * 设置异常描述
	 */
	public void setExceptionDesc(java.lang.String exceptionDesc) {
		this.exceptionDesc = exceptionDesc;
	}

	/**
	 * 获取异常描述
	 */
	public java.lang.String getExceptionDesc() {
		return exceptionDesc;
	}

	/**
	 * 设置异常状态
	 */
	public void setExceptionStatus(java.lang.String exceptionStatus) {
		this.exceptionStatus = exceptionStatus;
	}

	/**
	 * 获取异常状态
	 */
	public java.lang.String getExceptionStatus() {
		return exceptionStatus;
	}

	/**
	 * 设置处理结果
	 */
	public void setExceptionResult(java.lang.String exceptionResult) {
		this.exceptionResult = exceptionResult;
	}

	/**
	 * 获取处理结果
	 */
	public java.lang.String getExceptionResult() {
		return exceptionResult;
	}

	/**
	 * 设置逻辑删除 (0：正常，1：删除)
	 */
	public void setC2LogicdeleteFlag(java.lang.String c2LogicdeleteFlag) {
		this.c2LogicdeleteFlag = c2LogicdeleteFlag;
	}

	/**
	 * 获取逻辑删除 (0：正常，1：删除)
	 */
	public java.lang.String getC2LogicdeleteFlag() {
		return c2LogicdeleteFlag;
	}

	/**
	 * 设置
	 */
	public void setCccDxEtlTime(java.lang.Long cccDxEtlTime) {
		this.cccDxEtlTime = cccDxEtlTime;
	}

	/**
	 * 获取
	 */
	public java.lang.Long getCccDxEtlTime() {
		return cccDxEtlTime;
	}
}
