package com.xxglpt.sjjs.bean;
import java.io.Serializable;
import java.util.List;
/**
 * 汇交测绘实体
 * @author xnq
 *
 */
public class JcchMx implements Serializable {
	private static final long serialVersionUID = 1L;
	private String  id;
	private String  jcchId;
	private String  xh;
	private String  sjlx;
	private String  sl;
	private String  zt;
	private String  zbx;
	private String  bz;
	private List<JcchMx> list;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getJcchId() {
		return jcchId;
	}
	public void setJcchId(String jcchId) {
		this.jcchId = jcchId;
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
	public String getZt() {
		return zt;
	}
	public void setZt(String zt) {
		this.zt = zt;
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
	public List<JcchMx> getList() {
		return list;
	}
	public void setList(List<JcchMx> list) {
		this.list = list;
	}
	
}
