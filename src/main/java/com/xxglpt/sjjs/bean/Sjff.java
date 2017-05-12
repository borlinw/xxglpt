package com.xxglpt.sjjs.bean;
import java.io.Serializable;
/**
 * 数据分发实体
 * @author xnq
 *
 */
public class Sjff implements Serializable {
	private static final long serialVersionUID = 1L;
	private String  id;
	private String  bh;
	/*id,dwmc,xxdz,zzjgdm,fddbr,frzshm,yzbm,jbrxm,sfzhm,lxdh,dzyx,
	bmjgmc,bmryxm,bmyzbm,bmlxdh,bmxxdz,bmdzyx,
	zgbmmc,zgcbks,zgyzbm,zglxdh,zgxxdz,
	xmly,symd,sxsjzlmc,zlfwjdjsl,sqsj,chxzzgbmyj,bz,bh*/
	private int page;
	private int rows;
	private int max;
	private int min;
	private String kssj;
	private String jssj;
	private String dwmc;
	private String xxdz;
	private String zzjgdm;
	private String fddbr;
	private String frzshm;
	private String yzbm;
	private String jbrxm;
	private String sfzhm;
	private String lxdh;
	private String dzyx;
	private String bmjgmc;
	private String bmryxm;
	private String bmyzbm;
	private String bmlxdh;
	private String bmxxdz;
	private String bmdzyx;
	private String zgbmmc;
	private String zgcbks;
	private String zgyzbm;
	private String zglxdh;
	private String zgxxdz;
	private String xmly;
	private String symd;
	private String sxsjzlmc;
	private String zlfwjdjsl;
	private String sqsj;
	private String chxzzgbmyj;
	private String bz;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getBh() {
		return bh;
	}
	public void setBh(String bh) {
		this.bh = bh;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public String getKssj() {
		return kssj;
	}
	public void setKssj(String kssj) {
		this.kssj = kssj;
	}
	public String getJssj() {
		return jssj;
	}
	public void setJssj(String jssj) {
		this.jssj = jssj;
	}
	public String getDwmc() {
		return dwmc;
	}
	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}
	public String getXxdz() {
		return xxdz;
	}
	public void setXxdz(String xxdz) {
		this.xxdz = xxdz;
	}
	public String getZzjgdm() {
		return zzjgdm;
	}
	public void setZzjgdm(String zzjgdm) {
		this.zzjgdm = zzjgdm;
	}
	public String getFddbr() {
		return fddbr;
	}
	public void setFddbr(String fddbr) {
		this.fddbr = fddbr;
	}
	public String getFrzshm() {
		return frzshm;
	}
	public void setFrzshm(String frzshm) {
		this.frzshm = frzshm;
	}
	public String getYzbm() {
		return yzbm;
	}
	public void setYzbm(String yzbm) {
		this.yzbm = yzbm;
	}
	public String getJbrxm() {
		return jbrxm;
	}
	public void setJbrxm(String jbrxm) {
		this.jbrxm = jbrxm;
	}
	public String getSfzhm() {
		return sfzhm;
	}
	public void setSfzhm(String sfzhm) {
		this.sfzhm = sfzhm;
	}
	public String getLxdh() {
		return lxdh;
	}
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	public String getDzyx() {
		return dzyx;
	}
	public void setDzyx(String dzyx) {
		this.dzyx = dzyx;
	}
	public String getBmjgmc() {
		return bmjgmc;
	}
	public void setBmjgmc(String bmjgmc) {
		this.bmjgmc = bmjgmc;
	}
	public String getBmryxm() {
		return bmryxm;
	}
	public void setBmryxm(String bmryxm) {
		this.bmryxm = bmryxm;
	}
	public String getBmyzbm() {
		return bmyzbm;
	}
	public void setBmyzbm(String bmyzbm) {
		this.bmyzbm = bmyzbm;
	}
	public String getBmlxdh() {
		return bmlxdh;
	}
	public void setBmlxdh(String bmlxdh) {
		this.bmlxdh = bmlxdh;
	}
	public String getBmxxdz() {
		return bmxxdz;
	}
	public void setBmxxdz(String bmxxdz) {
		this.bmxxdz = bmxxdz;
	}
	public String getBmdzyx() {
		return bmdzyx;
	}
	public void setBmdzyx(String bmdzyx) {
		this.bmdzyx = bmdzyx;
	}
	public String getZgbmmc() {
		return zgbmmc;
	}
	public void setZgbmmc(String zgbmmc) {
		this.zgbmmc = zgbmmc;
	}
	public String getZgcbks() {
		return zgcbks;
	}
	public void setZgcbks(String zgcbks) {
		this.zgcbks = zgcbks;
	}
	public String getZgyzbm() {
		return zgyzbm;
	}
	public void setZgyzbm(String zgyzbm) {
		this.zgyzbm = zgyzbm;
	}
	public String getZglxdh() {
		return zglxdh;
	}
	public void setZglxdh(String zglxdh) {
		this.zglxdh = zglxdh;
	}
	public String getZgxxdz() {
		return zgxxdz;
	}
	public void setZgxxdz(String zgxxdz) {
		this.zgxxdz = zgxxdz;
	}
	public String getXmly() {
		return xmly;
	}
	public void setXmly(String xmly) {
		this.xmly = xmly;
	}
	public String getSymd() {
		return symd;
	}
	public void setSymd(String symd) {
		this.symd = symd;
	}
	public String getSxsjzlmc() {
		return sxsjzlmc;
	}
	public void setSxsjzlmc(String sxsjzlmc) {
		this.sxsjzlmc = sxsjzlmc;
	}
	public String getZlfwjdjsl() {
		return zlfwjdjsl;
	}
	public void setZlfwjdjsl(String zlfwjdjsl) {
		this.zlfwjdjsl = zlfwjdjsl;
	}
	public String getSqsj() {
		return sqsj;
	}
	public void setSqsj(String sqsj) {
		this.sqsj = sqsj;
	}
	public String getChxzzgbmyj() {
		return chxzzgbmyj;
	}
	public void setChxzzgbmyj(String chxzzgbmyj) {
		this.chxzzgbmyj = chxzzgbmyj;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	
}
