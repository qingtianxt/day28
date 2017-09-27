package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
		private static final Configuration CONFIG;
		private static final SessionFactory FACTORY;
		
		//��д��̬�����
		static{
			//����xml�����ļ�
			CONFIG = new Configuration().configure();
			//���칤��
			FACTORY=CONFIG.buildSessionFactory();
		}
		
		/**
		 * �ӹ����л�ȡsession����
		 */
		public static Session getSession(){
			return FACTORY.openSession();
		}
}
