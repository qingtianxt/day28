package dao;

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
}
