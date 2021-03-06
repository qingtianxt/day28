package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
		private static final Configuration CONFIG;
		private static final SessionFactory FACTORY;
		
		//编写静态代码块
		static{
			//加载xml配置文件
			CONFIG = new Configuration().configure();
			//构造工厂
			FACTORY=CONFIG.buildSessionFactory();
		}
		
		/**
		 * 从工厂中获取session对象
		 */
		public static Session getSession(){
			return FACTORY.openSession();
		}
}
