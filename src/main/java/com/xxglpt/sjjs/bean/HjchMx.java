package com.xxglpt.sjjs.bean;
import java.io.Serializable;
import java.util.List;
/**
 * 汇交测绘实体
 * @author xnq
 *
 */
public class HjchMx implements Serializable {
	private static final long serialVersionUID = 1L;
	private String  id;
	private String  hjchId;
	private String  xh;
	private String  sjlx;
	private String  sl;
	private String  zbx;
	private String  bz;
	private List<HjchMx> list;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHjchId() {
		return hjchId;
	}
	public void setHjchId(String hjchId) {
		this.hjchId = hjchId;
	}
	public String getXh() {
		return xh;
	}
	public void setXh(String xh) {
		this.xh = xh;
	}
	public String getSjlx() {
		return sjlx;
	}
	public void setSjlx(String sjlx) {
		this.sjlx = sjlx;
	}
	public String getSl() {
		return sl;
	}
	public void setSl(String sl) {
		this.sl = sl;
	}
	public String getZbx() {
		return zbx;
	}
	public void setZbx(String zbx) {
		this.zbx = zbx;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public List<HjchMx> getList() {
		return list;
	}
	public void setList(List<HjchMx> list) {
		this.list = list;
	}
	
}
