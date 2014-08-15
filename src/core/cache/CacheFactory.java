package core.cache;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.CacheManager;

/**
 * @author David.Wang
 * @email wangfeng090809@gmail.com
 */
public class CacheFactory {

	public static CacheManager cacheManager;

	static {
		try {
			cacheManager = CacheManager.create(CacheFactory.class.getResource("/ehcache.xml"));
		} catch (CacheException e) {
			e.printStackTrace();
		}
	}

	private CacheFactory() {
	}

	public static CacheManager getCacheManager() {
		return cacheManager;
	}

}
