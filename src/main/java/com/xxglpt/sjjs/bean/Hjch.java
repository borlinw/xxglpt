package com.xxglpt.sjjs.bean;
import java.io.Serializable;
/**
 * 汇交测绘实体
 * @author xnq
 *
 */
public class Hjch implements Serializable {
	private static final long serialVersionUID = 1L;
	private String  id;
	private String  whnf;
	private String  whbh;
	private String  hjwh;
	private String  hjdw;
	private String  lxdh;
	private String  chxmmc;
	private String  chxmszd;
	private String  scdw;
	private String  wcsj;
	private String  zljcysdw;
	private String  jcyssj;
	private String  hjchcgfbhmlsl ;
	private String  hjchcgfbhmlxxnr;
	private int page;
	private int rows;
	private int max;
	private int min;
	private String kssj;
	private String jssj;
	private String a1;
	private String a2;
	private String a3;
	private String a4;
	private String a5;
	private String b1;
	private String b2;
	private String b3;
	private String b4;
	private String b5;
	private String c1;
	private String c2;
	private String c3;
	private String c4;
	private String c5;
	private String hjrqm;
	private String jsrqm;
	private String hjjsn;
	private String hjjsy;
	private String hjjsr;
	private String qzn;
	private String qzy;
	private String qzr;
	private HjchMx hjchMxs;
	private String mxstr;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWhnf() {
		return whnf;
	}
	public void setWhnf(String whnf) {
		this.whnf = whnf;
	}
	public String getWhbh() {
		return whbh;
	}
	public void setWhbh(String whbh) {
		this.whbh = whbh;
	}
	public String getHjdw() {
		return hjdw;
	}
	public void setHjdw(String hjdw) {
		this.hjdw = hjdw;
	}
	public String getLxdh() {
		return lxdh;
	}
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	public String getChxmmc() {
		return chxmmc;
	}
	public void setChxmmc(String chxmmc) {
		this.chxmmc = chxmmc;
	}
	
	public String getChxmszd() {
		return chxmszd;
	}
	public void setChxmszd(String chxmszd) {
		this.chxmszd = chxmszd;
	}
	public String getScdw() {
		return scdw;
	}
	public void setScdw(String scdw) {
		this.scdw = scdw;
	}
	public String getWcsj() {
		return wcsj;
	}
	public void setWcsj(String wcsj) {
		this.wcsj = wcsj;
	}
	public String getZljcysdw() {
		return zljcysdw;
	}
	public void setZljcysdw(String zljcysdw) {
		this.zljcysdw = zljcysdw;
	}
	public String getJcyssj() {
		return jcyssj;
	}
	public void setJcyssj(String jcyssj) {
		this.jcyssj = jcyssj;
	}
	public String getHjchcgfbhmlsl() {
		return hjchcgfbhmlsl;
	}
	public void setHjchcgfbhmlsl(String hjchcgfbhmlsl) {
		this.hjchcgfbhmlsl = hjchcgfbhmlsl;
	}
	public String getHjchcgfbhmlxxnr() {
		return hjchcgfbhmlxxnr;
	}
	public void setHjchcgfbhmlxxnr(String hjchcgfbhmlxxnr) {
		this.hjchcgfbhmlxxnr = hjchcgfbhmlxxnr;
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
	public String getA1() {
		return a1;
	}
	public void setA1(String a1) {
		this.a1 = a1;
	}
	public String getA2() {
		return a2;
	}
	public void setA2(String a2) {
		this.a2 = a2;
	}
	public String getA3() {
		return a3;
	}
	public void setA3(String a3) {
		this.a3 = a3;
	}
	public String getA4() {
		return a4;
	}
	public void setA4(String a4) {
		this.a4 = a4;
	}
	public String getA5() {
		return a5;
	}
	public void setA5(String a5) {
		this.a5 = a5;
	}
	public String getB1() {
		return b1;
	}
	public void setB1(String b1) {
		this.b1 = b1;
	}
	public String getB2() {
		return b2;
	}
	public void setB2(String b2) {
		this.b2 = b2;
	}
	public String getB3() {
		return b3;
	}
	public void setB3(String b3) {
		this.b3 = b3;
	}
	public String getB4() {
		return b4;
	}
	public void setB4(String b4) {
		this.b4 = b4;
	}
	public String getB5() {
		return b5;
	}
	public void setB5(String b5) {
		this.b5 = b5;
	}
	public String getC1() {
		return c1;
	}
	public void setC1(String c1) {
		this.c1 = c1;
	}
	public String getC2() {
		return c2;
	}
	public void setC2(String c2) {
		this.c2 = c2;
	}
	public String getC3() {
		return c3;
	}
	public void setC3(String c3) {
		this.c3 = c3;
	}
	public String getC4() {
		return c4;
	}
	public void setC4(String c4) {
		this.c4 = c4;
	}
	public String getC5() {
		return c5;
	}
	public void setC5(String c5) {
		this.c5 = c5;
	}
	public String getHjrqm() {
		return hjrqm;
	}
	public void setHjrqm(String hjrqm) {
		this.hjrqm = hjrqm;
	}
	public String getJsrqm() {
		return jsrqm;
	}
	public void setJsrqm(String jsrqm) {
		this.jsrqm = jsrqm;
	}
	public String getHjjsn() {
		return hjjsn;
	}
	public void setHjjsn(String hjjsn) {
		this.hjjsn = hjjsn;
	}
	public String getHjjsy() {
		return hjjsy;
	}
	public void setHjjsy(String hjjsy) {
		this.hjjsy = hjjsy;
	}
	public String getHjjsr() {
		return hjjsr;
	}
	public void setHjjsr(String hjjsr) {
		this.hjjsr = hjjsr;
	}
	public String getQzn() {
		return qzn;
	}
	public void setQzn(String qzn) {
		this.qzn = qzn;
	}
	public String getQzy() {
		return qzy;
	}
	public void setQzy(String qzy) {
		this.qzy = qzy;
	}
	public String getQzr() {
		return qzr;
	}
	public void setQzr(String qzr) {
		this.qzr = qzr;
	}
	public String getHjwh() {
		return hjwh;
	}
	public void setHjwh(String hjwh) {
		this.hjwh = hjwh;
	}
	public HjchMx getHjchMxs() {
		return hjchMxs;
	}
	public void setHjchMxs(HjchMx hjchMxs) {
		this.hjchMxs = hjchMxs;
	}
	public String getMxstr() {
		return mxstr;
	}
	public void setMxstr(String mxstr) {
		this.mxstr = mxstr;
	}
	
}
