package com.xxglpt.sjjs.server.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;
import com.hdsx.dao.query.base.BaseOperate;
import com.xxglpt.sjjs.bean.Sjff;
import com.xxglpt.sjjs.server.SjffServer;

@Service
public class SjffServerImpl extends BaseOperate  implements SjffServer{

	public SjffServerImpl() {
		super("sjff", "jdbc");
	}

		public int selectSjffListCount(Sjff hm) {
		return queryOne("selectSjffListCount", hm);
	}

	
	public List<Sjff> selectSjffList(Sjff hm) {
		return queryList("selectSjffList", hm);
	}

	
	public boolean insertSjff(Sjff Sjff) {
		int b=insert("insertSjff", Sjff);
		return b>0?true:false;
	}

	
	public boolean deleteSjff(String id) {
		int b=delete("deleteSjff",id);
		return b>0?true:false;
	}

	
	public boolean updateSjff(Sjff Sjff) {
		int b=update("updateSjff", Sjff);
		return b>0?true:false;
	}

		
	public Sjff selectSjffById(Sjff Sjff) {
		return queryOne("selectSjffById", Sjff);
	}

	public HashMap selectSjffById2(Sjff sjff) {
		// TODO Auto-generated method stub
		return queryOne("selectSjffById2", sjff);
	}



}
