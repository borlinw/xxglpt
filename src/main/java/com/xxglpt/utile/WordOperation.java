package com.xxglpt.utile;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.webutil.struts.BaseActionSupport;

import freemarker.template.Configuration;
import freemarker.template.Template;
/**
 * 利用freemarker将word的xml模板动态的生成word
 * @author renzm
 *            
 */
@Scope("prototype")
@Controller
public class WordOperation  extends BaseActionSupport   {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3932462746510440633L;
	private static Configuration configuration = null;
	public WordOperation() {
		configuration = new Configuration();
		configuration.setDefaultEncoding("UTF-8");
	}
	private XmlModel xb=new XmlModel();
	private String a0="";
	private String a1 = "";
	private String a2 = "";
	private String a3 = "";
	private String a4 = "";
	private String a5 = "";
	private String a6 = "";
	private String a7 = "";
	private String a8 = "";
	private String a9 = "";
	private String a10 = "";
	private String a11 = "";
	private String a12 = "";
	private String a13="";
	private String a14="";
	private String a15="";
	private String a16="";
	private String a17="";
	private String a18="";
	private String a19="";
	private String a20="";
	private String a21 = "";
	private String a22 = "";
	private String a23 = "";
	private String a24 = "";
	private String a25 = "";
	private String a26 = "";
	private String a27 = "";
	private String a28 = "";
	private String a29 = "";
	private String a30 = "";
	private String a31 = "";
	private String a32 = "";
	private String a33="";
	private String a34="";
	private String a35="";
	private String a36="";
	private String xmlName;
	
	public String getXmlName() {
		return xmlName;
	}
	public void setXmlName(String xmlName) {
		this.xmlName=changeType(xmlName);
		xb.setXmlName(this.xmlName);
		//this.xmlName = xmlName;
	}
	
	public String getA0() {
		return a0;
	}
	public void setA0(String a0) {
		this.a0=changeType(a0);
		xb.setA0(this.a0);
	}
	/**
	 * @param bean 填充xml的数据
	 * @param xmlName 模板名称
	 * @throws IOException 
	 */
	//解决中文乱码问题-----
	public String changeType(String name){
		try {
			return  java.net.URLDecoder.decode(name,"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "中文乱码！";
		}
	}
	public   <T>  void createDoc(T bean,String xmlName,HttpServletResponse response) {
		// 设置模本装置方法和路径
		configuration.setClassForTemplateLoading(this.getClass(),"/");
		Template t = null;
		System.out.println(xmlName);
		try {
			response.setContentType("octets/stream");
			response.addHeader("Content-Disposition","attachment;" +
							   "filename="+new String(xmlName.substring(0,xmlName.lastIndexOf("."))
								.getBytes("gb2312"),"ISO-8859-1")+".doc");
			PrintWriter out = response.getWriter();
			// 装载xml模板
			t = configuration.getTemplate(xmlName);	
			t.process(bean, out);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void loadDoc(){
		System.out.println(xb.getA7()+" "+xb.getA8()+" "+xb.getA9()+"  "+xb.getA10()+" "+xb.getA11()+" "+xb.getA12()+xb.getA13());
		//System.out.println(xb.getA1());
		createDoc(xb,xmlName,getresponse());
	}

	public String getA1() {
		return a1;
	}
	public void setA1(String a1) {
		this.a1=changeType(a1);
		xb.setA1(this.a1);
	}
	public String getA2() {
		return a2;
	}
	public void setA2(String a2) {
		this.a2=changeType(a2);
		xb.setA2(this.a2);
	}
	public String getA3() {
		return a3;
	}
	public void setA3(String a3) {
		this.a3=changeType(a3);
		xb.setA3(this.a3);
	}
	public String getA4() {
		return a4;
	}
	public void setA4(String a4) {
		this.a4=changeType(a4);
		xb.setA4(this.a4);
	}
	public String getA5() {
		return a5;
	}
	public void setA5(String a5) {
		this.a5=changeType(a5);
		xb.setA5(this.a5);
	}
	public String getA6() {
		return a6;
	}
	public void setA6(String a6) {
		this.a6=changeType(a6);
		xb.setA6(this.a6);
	}
	public String getA7() {
		return a7;
	}
	public void setA7(String a7) {
		this.a7=changeType(a7);
		xb.setA7(this.a7);
	}
	public String getA8() {
		return a8;
	}
	public void setA8(String a8) {
		this.a8=changeType(a8);
		xb.setA8(this.a8);
	}
	public String getA9() {
		return a9;
	}
	public void setA9(String a9) {
		this.a9=changeType(a9);
		xb.setA9(this.a9);
	}
	public String getA10() {
		return a10;
	}
	public void setA10(String a10) {
		this.a10=changeType(a10);
		xb.setA10(this.a10);
	}
	public String getA11() {
		return a11;
	}
	public void setA11(String a11) {
		this.a11=changeType(a11);
		xb.setA11(this.a11);
	}
	public String getA12() {
		return a12;
	}
	public void setA12(String a12) {
		this.a12=changeType(a12);
		xb.setA12(this.a12);
	}
	public String getA13() {
		return a13;
	}
	public void setA13(String a13) {
		this.a13 = changeType(a13);
		xb.setA13(this.a13);
	}
	public String getA14() {
		return a14;
	}
	public void setA14(String a14) {
		this.a14 = changeType(a14);
		xb.setA14(this.a14);
	}
	public String getA15() {
		return a15;
	}
	public void setA15(String a15) {
		this.a15 = changeType(a15);
		xb.setA15(this.a15);
	}
	public String getA16() {
		return a16;
	}
	public void setA16(String a16) {
		this.a16 = changeType(a16);
		xb.setA16(this.a16);
	}
	public String getA17() {
		return a17;
	}
	public void setA17(String a17) {
		this.a17 = changeType(a17);
		xb.setA17(this.a17);
	}
	public String getA18() {
		return a18;
	}
	public void setA18(String a18) {
		this.a18 = changeType(a18);
		xb.setA18(this.a18);
	}
	public String getA19() {
		return a19;
	}
	public void setA19(String a19) {
		this.a19 = changeType(a19);
		xb.setA19(this.a19);
	}
	public String getA20() {
		return a20;
	}
	public void setA20(String a20) {
		this.a20 = changeType(a20);
		xb.setA20(this.a20);
	}
	public String getA21() {
		return a21;
	}
	public void setA21(String a21) {
		this.a21 = changeType(a21);
		xb.setA21(this.a21);
	}
	public String getA22() {
		return a22;
	}
	public void setA22(String a22) {
		this.a22 = changeType(a22);
		xb.setA22(this.a22);
	}
	public String getA23() {
		return a23;
	}
	public void setA23(String a23) {
		this.a23 = changeType(a23);
		xb.setA23(this.a23);
	}
	public String getA24() {
		return a24;
	}
	public void setA24(String a24) {
		this.a24 = changeType(a24);
		xb.setA24(this.a24);
	}
	public String getA25() {
		return a25;
	}
	public void setA25(String a25) {
		this.a25 = changeType(a25);
		xb.setA25(this.a25);
	}
	public String getA26() {
		return a26;
	}
	public void setA26(String a26) {
		this.a26 = changeType(a26);
		xb.setA26(this.a26);
	}
	public String getA27() {
		return a27;
	}
	public void setA27(String a27) {
		this.a27 = changeType(a27);
		xb.setA27(this.a27);
	}
	public String getA28() {
		return a28;
	}
	public void setA28(String a28) {
		this.a28 = changeType(a28);
		xb.setA28(this.a28);
	}
	public String getA29() {
		return a29;
	}
	public void setA29(String a29) {
		this.a29 = changeType(a29);
		xb.setA29(this.a29);
	}
	public String getA30() {
		return a30;
	}
	public void setA30(String a30) {
		this.a30 = changeType(a30);
		xb.setA30(this.a30);
	}
	public String getA31() {
		return a31;
	}
	public void setA31(String a31) {
		this.a31 = changeType(a31);
		xb.setA31(this.a31);
	}
	public String getA32() {
		return a32;
	}
	public void setA32(String a32) {
		this.a32 = changeType(a32);
		xb.setA32(this.a32);
	}
	public String getA33() {
		return a33;
	}
	public void setA33(String a33) {
		this.a33 = changeType(a33);
		xb.setA33(this.a33);
	}
	public String getA34() {
		return a34;
	}
	public void setA34(String a34) {
		this.a34 = changeType(a34);
		xb.setA34(this.a34);
	}
	public String getA35() {
		return a35;
	}
	public void setA35(String a35) {
		this.a35 = changeType(a35);
		xb.setA35(this.a35);
	}
	public String getA36() {
		return a36;
	}
	public void setA36(String a36) {
		this.a36 = changeType(a36);
		xb.setA36(this.a36);
	}
	public XmlModel getXb() {
		return xb;
	}
	public void setXb(XmlModel xb) {
		this.xb = xb;
	}
	
}

