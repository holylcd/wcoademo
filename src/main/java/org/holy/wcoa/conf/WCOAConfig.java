package org.holy.wcoa.conf;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.holy.wcoa.entity.WCOAEntity;

/**
 * 公众号资料全局配置
 * @author holy
 */
public class WCOAConfig {
	
	private static Map<String, WCOAEntity> wcoaMap = new HashMap<>(4);
	
	private WCOAConfig() {}
	
	public static WCOAConfig getInstance(){
		return WCOAFactoryHolder.wcoaFactory;
	}
	
	private static class WCOAFactoryHolder{
		private static final WCOAConfig wcoaFactory = new WCOAConfig();
	}
	
	/**
	 * 根据 ID 获取 微信公众号资料
	 * 
	 * @param id
	 * @return
	 */
	public WCOAEntity getWCOAById(Integer id){
		for(Entry<String, WCOAEntity> en : wcoaMap.entrySet()) {
			if(en.getValue().getId().equals(id)) {
				return en.getValue();
			}
		}
		 return null;
	}
	
	/**
	 * 根据 code 获取 微信公众号资料
	 * 
	 * @param code
	 * @return
	 */
	public WCOAEntity getWCOAByCode(String code){
		for(Entry<String, WCOAEntity> en : wcoaMap.entrySet()) {
			if(en.getValue().getCode().equals(code)) {
				return en.getValue();
			}
		}
		 return null;
	}
	
	
	/**
	 * 新增或刷新 微信公众号资料
	 * 
	 * @param wcoa
	 * @return
	 */
	public boolean auWCOA(WCOAEntity wcoa){
		if(null != wcoa && null != wcoa.getId()){
            WCOAConfig.wcoaMap.put(wcoa.getAppID(), wcoa);
			return true;
		}
		return false;
	}

	
}
