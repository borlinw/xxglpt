package com.xxglpt.sjjs.server;

import java.util.List;
import java.util.Map;

import com.xxglpt.sjjs.bean.Cgba;

public interface CgbaServer {
	boolean uploadWjFile(Cgba cgba);
	boolean deleteWjfile(Cgba cgba);
	boolean deleteWjfile1(String id);
	boolean insertCgba(Cgba cgba);
	List<Cgba> selectcgbalist(Cgba cgba);
	int selectcgbalistCount(Cgba cgba);
	List<Cgba> selectWjfile(Cgba cgba);
	List<Cgba> selectWjfileByWjid(Cgba cgba);
	Cgba selectWjById(Cgba cgba);
	boolean updateCgba(Cgba cgba);
	boolean deleteCgba(Cgba cgba);
}
