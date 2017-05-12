package com.xxglpt.sjjs.controller;

import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.hdsx.webutil.struts.BaseActionSupport;
import com.xxglpt.utile.EasyUIPage;
import com.xxglpt.sjjs.bean.Sjff;
import com.xxglpt.utile.JsonUtils;
import com.xxglpt.utile.ResponseUtils;
import com.xxglpt.utile.WordOperation;
import com.xxglpt.sjjs.server.SjffServer;
/**
 * 系统管理Controller层
 * @author xunq
 *
 */
@Scope("prototype")
@Controller
public class SjffController extends BaseActionSupport{
	private static final long serialVersionUID = -1512493918772500846L;
	private int page = 1;
	private int rows = 10;
	@Resource(name = "sjffServerImpl")
	private SjffServer sjffServer;
	private Sjff sjff;
	private String id;
	private String xmlName;

	/**
	 * 汇交测绘数据管理列表
	 */
	public void selectSjffList(){
		sjff.setPage(page);
		sjff.setRows(rows);
		int count=sjffServer.selectSjffListCount(sjff);
		List<Sjff> list=sjffServer.selectSjffList(sjff);
		EasyUIPage<Sjff> e=new EasyUIPage<Sjff>();
		e.setRows(list);
		e.setTotal(count);
		try {
			JsonUtils.write(e, getresponse().getWriter());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	public void selectSjffById(){
		Sjff m=sjffServer.selectSjffById(sjff);
		try {
			JsonUtils.write(m, getresponse().getWriter());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * 添加汇交测绘数据
	 */
	public void insertSjff(){
		
		boolean b=sjffServer.insertSjff(sjff);
		System.out.println(sjff.getLxdh());
		if(b!=true){
			ResponseUtils.write(getresponse(), "false");
		}else{
			ResponseUtils.write(getresponse(), "true");
		}
	}
	
	/**
	 * 删除汇交测绘数据
	 */
	public void deleteSjff(){
		boolean bl = sjffServer.deleteSjff(id);
		if(bl == true){
			ResponseUtils.write(getresponse(), "true");
		}else{
			ResponseUtils.write(getresponse(), "false");
		}
	}
	public void sjffDownDoc(){
		HashMap map=sjffServer.selectSjffById2(sjff);
		//HashMap map=new HashMap();
		//System.out.println(map.get("A1"));
		map.put("a1",map.get("A1"));
		map.put("a2",map.get("A2"));
		map.put("a3",map.get("A3"));
		map.put("a4",map.get("A4"));
		map.put("a5",map.get("A5"));
		map.put("a6",map.get("A6"));
		map.put("a7",map.get("A7"));
		map.put("a8",map.get("A8"));
		map.put("a9",map.get("A9"));
		map.put("a10",map.get("A10"));
		map.put("a11",map.get("A11"));
		map.put("a12",map.get("A12"));
		map.put("a13",map.get("A13"));
		map.put("a14",map.get("A14"));
		map.put("a15",map.get("A15"));
		map.put("a16",map.get("A16"));
		map.put("a17",map.get("A17"));
		map.put("a18",map.get("A18"));
		map.put("a19",map.get("A19"));
		map.put("a20",map.get("A20"));
		map.put("a21",map.get("A21"));
		map.put("a22",map.get("A22"));
		map.put("a23",map.get("A23").toString().replaceAll("\n","<w:p></w:p>"));
		map.put("a24",map.get("A24").toString().replaceAll("\n","<w:p></w:p>"));
		map.put("a25",map.get("A25").toString().replaceAll("\n","<w:p></w:p>"));
		map.put("a26",map.get("A26").toString().replaceAll("\n","<w:p></w:p>"));
		map.put("a27",map.get("A27").toString().replaceAll("\n","<w:p></w:p>"));
		map.put("a28",map.get("A28").toString().replaceAll("\n","<w:p></w:p>"));
		map.put("a29",map.get("A29").toString().replaceAll("\n","<w:p></w:p>"));
		xmlName="广元市地理信息数据使用申请资料.xml";
		WordOperation wo=new WordOperation();
		wo.createDoc(map,xmlName,getresponse());
	}
	/**
	 * 删除汇交测绘数据
	 */
	public void updateSjff(){
		
		boolean bl = sjffServer.updateSjff(sjff);
		if(bl == true){
			ResponseUtils.write(getresponse(), "true");
		}else{
			ResponseUtils.write(getresponse(), "false");
		}
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
	
	public Sjff getSjff() {
		return sjff;
	}
	public void setSjff(Sjff sjff) {
		this.sjff = sjff;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getXmlName() {
		return xmlName;
	}
	public void setXmlName(String xmlName) {
		this.xmlName = xmlName;
	}

}
