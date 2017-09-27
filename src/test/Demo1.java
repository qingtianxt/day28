package test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import domain.Customer;
import util.HibernateUtils;

/**
 * ����hibernate���
 * @author wzw
 *
 */
public class Demo1 {
	@Test
	public void testSave3(){
		Session session = null;
		Transaction tr =null;
		try{
			//��ȡsession
			session = HibernateUtils.getSession();
			//��������
			tr =session.beginTransaction();
			//ִ�д���
			Customer c =new Customer();
			c.setCust_name("����");
			
			//����
			session.save(c);
			
			//�ύ����
			tr.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}finally {
			//�ͷ���Դ
			session.close();
		}
	}
	
	@Test
	public void testSel(){
		//ԭ�������������ļ�����ȡfactory���󣬻�ȡsession
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		//������ѯ�Ľӿ�
		Query query = session.createQuery("from Customer");
		List<Customer> list =  query.list();
		for (Customer customer : list) {
			System.out.println(customer);
			
		}
		
		//�ύ����
		tr.commit();
		//�ͷ���Դ
		session.close();
		
	}
	
	
	
	
	/**
	 * ���Ա�������޸�
	 */
	@Test
	public void testSaveUpdate(){
		//ԭ�������������ļ�����ȡfactory���󣬻�ȡsession
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		/*//��ʾ����
		Customer c = new Customer();
		c.setCust_id(16L);//�����Լ�����
		c.setCust_name("����");
		
		//�޸Ļ��߱���
		session.saveOrUpdate(c);*/
		
		//�Ȳ�ѯ���޸�
		Customer c = session.get(Customer.class, 6L);
		c.setCust_name("С��");
		
		
		session.saveOrUpdate(c);
		
		//�ύ����
		tr.commit();
		//�ͷ���Դ
		session.close();
		
	}
	
	
	/**
	 * �����޸�
	 */
	@Test
	public void testUpdate(){
		//ԭ�������������ļ�����ȡfactory���󣬻�ȡsession
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		//���Բ�ѯ�ķ�����
		Customer c = session.get(Customer.class, 6L);
		
		//���ÿͻ�����Ϣ
		c.setCust_name("С��");
		c.setCust_level("3");
		
		//�޸�
		session.update(c);
		
		//�ύ����
		tr.commit();
		//�ͷ���Դ
		session.close();
		
	}
	
	
	
	
	
	
	/**
	 * ����ɾ���ķ���
	 * ע�⣺ɾ�������޸ģ��Ȳ�ѯ��ɾ�������޸�
	 */
	@Test
	public void testDel(){
		//ԭ�������������ļ�����ȡfactory���󣬻�ȡsession
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		//���Բ�ѯ�ķ�����
		Customer c = session.get(Customer.class, 7L);
		
		//ɾ���ͻ�
		session.delete(c);
		
		//�ύ����
		tr.commit();
		//�ͷ���Դ
		session.close();
		
	}
	
	/**
	 * ���Բ�ѯ����
	 */
	@Test
	public void testGet(){
		//ԭ�������������ļ�����ȡfactory���󣬻�ȡsession
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		//���Բ�ѯ�ķ�����
		Customer c = session.get(Customer.class, 7L);
		System.out.println(c);
		
		
		//�ύ����
		tr.commit();
		//�ͷ���Դ
		session.close();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * ���Թ�����
	 */
	@Test
	public void testSave2(){
		//ԭ�������������ļ�����ȡfactory���󣬻�ȡsession
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		Customer c =new Customer();
		c.setCust_name("С��");
		session.save(c);
		//�ύ����
		tr.commit();
		//�ͷ���Դ
		session.close();
		
	}
	
	
	
	
	/**
	 * ���Ա����û�
	 */
	@Test
	public void testSave(){
		/**
		 * 1.���������ļ�
		 * 2.����sessionFactory ����session����
		 * 3.����session����
		 * 4.��������
		 * 5.��д����Ĵ���
		 * 6.�ύ����
		 * 7.�ͷ���Դ
		 */
		
		//1.���������ļ�
		/*Configuration config = new Configuration();
		//Ĭ�ϼ���srcĿ¼��hibernate.cfg.xml�������ļ�
		config.configure();*/
		//�˽⣬�ֶ�����
		//config.addResource("domain/Customer.hbm.xml");
		
		//��д�ķ���
		Configuration config = new Configuration().configure();
		
		//2.����sessionFactory ����session����
		SessionFactory factory = config.buildSessionFactory();
		//3������session����   
		Session session = factory.openSession();
		//4,��������
		Transaction tr = session.beginTransaction();
		//5.��д����Ĵ���
			Customer c = new Customer();
			c.setCust_name("����");
			c.setCust_level("110");
			c.setCust_phone("112");
			
			//�������� ������������൱�ڲ������ݿ�ı�ṹ
			session.save(c);
			
			
		//6.�ύ����
		tr.commit();
		//7.�ͷ���Դ
		
		session.close();
		factory.close();
	}  
}
