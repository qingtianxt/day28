package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.Customer;
import util.HibernateUtils;

public class CustomerDao {
	/**
	 * 保存客户
	 */
	public void save(Customer c){
		//获取session
		Session session = HibernateUtils.getSession();
		//开启事务
		Transaction tr = session.beginTransaction();
		//保存用户
		session.save(c);
		//提交事务
		tr.commit();
		//关闭资源
		session.close();
		
	}
	
	/**
	 * 查询所有的客户
	 */
	public List<Customer> findAll(){
		//QBC查询
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Customer.class);
		List<Customer> list = criteria.list();
		
		tr.commit();
		session.close();
		return list;
	}
}
