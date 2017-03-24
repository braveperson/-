package cn.scxh.carmangger.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 当实例化实现 ApplicationContextAware接口类时可以从接口方法setApplicationContext中获取
 * spring应用上下文ApplicationContext实例.
 * 通过ApplicationContext实例可以获取得spring容器中已实例化的Bean
 * 
 */
@Component
// 实例化时可使用
public class WebApplication implements ApplicationContextAware {
	private static ApplicationContext mApplicationContext;

	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		mApplicationContext = context;
	}

	public static <T> T getBean(Class<T> name) {
		T bean = mApplicationContext.getBean(name);
		return bean;
	}

	public static Object getBean(String name){
		return mApplicationContext.getBean(name);
	}
}
