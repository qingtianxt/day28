package dao;

import java.util.List;

import org.hibernate.Criteria;
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
	
	/**
	 * ��ѯ���еĿͻ�
	 */
	public List<Customer> findAll(){
		//QBC��ѯ
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Customer.class);
		List<Customer> list = criteria.list();
		
		tr.commit();
		session.close();
		return list;
	}
}
