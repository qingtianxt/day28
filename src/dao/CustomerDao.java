package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.Customer;
import util.HibernateUtils;

public class CustomerDao {
	/**
	 * ����ͻ�
	 */
	public void save(Customer c){
		//��ȡsession
		Session session = HibernateUtils.getSession();
		//��������
		Transaction tr = session.beginTransaction();
		//�����û�
		session.save(c);
		//�ύ����
		tr.commit();
		//�ر���Դ
		session.close();
		
	}
}
