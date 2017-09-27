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
 * 测试hibernate框架
 * @author wzw
 *
 */
public class Demo1 {
	@Test
	public void testSave3(){
		Session session = null;
		Transaction tr =null;
		try{
			//获取session
			session = HibernateUtils.getSession();
			//开启事务
			tr =session.beginTransaction();
			//执行代码
			Customer c =new Customer();
			c.setCust_name("哈哈");
			
			//保存
			session.save(c);
			
			//提交事务
			tr.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}finally {
			//释放资源
			session.close();
		}
	}
	
	@Test
	public void testSel(){
		//原来：加载配置文件，获取factory对象，获取session
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		//创建查询的接口
		Query query = session.createQuery("from Customer");
		List<Customer> list =  query.list();
		for (Customer customer : list) {
			System.out.println(customer);
			
		}
		
		//提交事务
		tr.commit();
		//释放资源
		session.close();
		
	}
	
	
	
	
	/**
	 * 测试保存或者修改
	 */
	@Test
	public void testSaveUpdate(){
		//原来：加载配置文件，获取factory对象，获取session
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		/*//演示错误
		Customer c = new Customer();
		c.setCust_id(16L);//不能自己设置
		c.setCust_name("测试");
		
		//修改或者保存
		session.saveOrUpdate(c);*/
		
		//先查询在修改
		Customer c = session.get(Customer.class, 6L);
		c.setCust_name("小泽");
		
		
		session.saveOrUpdate(c);
		
		//提交事务
		tr.commit();
		//释放资源
		session.close();
		
	}
	
	
	/**
	 * 测试修改
	 */
	@Test
	public void testUpdate(){
		//原来：加载配置文件，获取factory对象，获取session
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		//测试查询的方法，
		Customer c = session.get(Customer.class, 6L);
		
		//设置客户的信息
		c.setCust_name("小苍");
		c.setCust_level("3");
		
		//修改
		session.update(c);
		
		//提交事务
		tr.commit();
		//释放资源
		session.close();
		
	}
	
	
	
	
	
	
	/**
	 * 测试删除的方法
	 * 注意：删除或者修改，先查询再删除或者修改
	 */
	@Test
	public void testDel(){
		//原来：加载配置文件，获取factory对象，获取session
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		//测试查询的方法，
		Customer c = session.get(Customer.class, 7L);
		
		//删除客户
		session.delete(c);
		
		//提交事务
		tr.commit();
		//释放资源
		session.close();
		
	}
	
	/**
	 * 测试查询方法
	 */
	@Test
	public void testGet(){
		//原来：加载配置文件，获取factory对象，获取session
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		//测试查询的方法，
		Customer c = session.get(Customer.class, 7L);
		System.out.println(c);
		
		
		//提交事务
		tr.commit();
		//释放资源
		session.close();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 测试工具类
	 */
	@Test
	public void testSave2(){
		//原来：加载配置文件，获取factory对象，获取session
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		Customer c =new Customer();
		c.setCust_name("小风");
		session.save(c);
		//提交事务
		tr.commit();
		//释放资源
		session.close();
		
	}
	
	
	
	
	/**
	 * 测试保存用户
	 */
	@Test
	public void testSave(){
		/**
		 * 1.加载配置文件
		 * 2.创建sessionFactory 生成session对象
		 * 3.创建session对象
		 * 4.开启事务
		 * 5.编写保存的代码
		 * 6.提交事务
		 * 7.释放资源
		 */
		
		//1.加载配置文件
		/*Configuration config = new Configuration();
		//默认加载src目录下hibernate.cfg.xml的配置文件
		config.configure();*/
		//了解，手动加载
		//config.addResource("domain/Customer.hbm.xml");
		
		//简写的方法
		Configuration config = new Configuration().configure();
		
		//2.创建sessionFactory 生成session对象
		SessionFactory factory = config.buildSessionFactory();
		//3、创建session对象   
		Session session = factory.openSession();
		//4,开启事务
		Transaction tr = session.beginTransaction();
		//5.填写保存的代码
			Customer c = new Customer();
			c.setCust_name("测试");
			c.setCust_level("110");
			c.setCust_phone("112");
			
			//保存数据 ，操作对象就相当于操作数据库的表结构
			session.save(c);
			
			
		//6.提交事务
		tr.commit();
		//7.释放资源
		
		session.close();
		factory.close();
	}  
}
