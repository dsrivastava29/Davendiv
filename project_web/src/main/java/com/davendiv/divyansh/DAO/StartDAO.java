package com.davendiv.divyansh.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.davendiv.divyansh.pojo.Davenfeed;
import com.davendiv.divyansh.pojo.Education;
import com.davendiv.divyansh.pojo.Group;
import com.davendiv.divyansh.pojo.Inbox;
import com.davendiv.divyansh.pojo.Login;
import com.davendiv.divyansh.pojo.PersonalInfo;
import com.davendiv.divyansh.pojo.Role;
import com.davendiv.divyansh.pojo.Users;

/**
 * This DAO is responsible for generating first time schema export It checks if
 * DB has values or not
 *
 * @author Divyansh Srivastava
 * @version 1.0
 * @since 2016-04-12
 */
public class StartDAO {

	public StartDAO() {

	}

	public void runFirstScript() throws Exception {
		try {
			Connection con = null;
			Configuration confg = new Configuration().configure();

			// stmt = conn.createStatement();
			Properties prop = confg.getProperties();
			String driverClass = prop.getProperty("hibernate.connection.driver_class");
			String url = prop.getProperty("hibernate.connection.url");
			String username = prop.getProperty("hibernate.connection.username");
			String password = prop.getProperty("hibernate.connection.password");
			Class.forName(driverClass);
			url = "jdbc:mysql://localhost:3306/";
			con = DriverManager.getConnection(url, username, password);
			Statement stmt = con.createStatement();
			String sql = "CREATE DATABASE davendiv";
			stmt.executeUpdate(sql);
			confg.setProperty("hibernate.hbm2ddl.auto", "create");
			new SchemaExport(confg).create(true, true);
			confg.setProperty("hibernate.hbm2ddl.auto", "update");
			SessionFactory sf = confg.buildSessionFactory();
			Session session = sf.openSession();
			session.beginTransaction();

			Users admin = new Users("admin", "admin", "admin@davendiv.com");
			Login logina = new Login("admin", "admin");
			logina.setUserid(admin.getUserid());

			admin.setDavenfeeds(new HashSet<Davenfeed>());
			admin.setEducations(new HashSet<Education>());
			admin.setGroups(new HashSet<Group>());
			admin.setInbox(new Inbox());
			admin.setPersonalInfo(new PersonalInfo(admin, "div", "MA", "USA"));
			admin.setIsActive(1);

			Users user = new Users("user", "user", "user@davendiv.com");
			user.setDavenfeeds(new HashSet<Davenfeed>());
			user.setEducations(new HashSet<Education>());
			user.setGroups(new HashSet<Group>());
			user.setInbox(new Inbox());
			user.setPersonalInfo(new PersonalInfo(user, "crazy", "MA", "USA"));
			Login loginu = new Login("user", "user");
			loginu.setUserid(user.getUserid());

			session.save(logina);
			session.save(loginu);
			session.getTransaction().commit();

			session.beginTransaction();
			// Set<Users> uList=new HashSet<Users>();
			// Set<Users> uList=new HashSet<Users>();
			// uList.add(admin);
			Role role = new Role(101, Role.admin_role);

			// session.merge(role);
			// uList.add(user);
			Role urole = new Role(102, Role.user_role);

			admin.getRoles().add(role);
			admin.getRoles().add(urole);
			user.getRoles().add(urole);
			// session.merge(role);
			session.save(admin);
			session.save(user);
			session.save(role);
			session.save(urole);

			session.getTransaction().commit();
			session.close();
		} catch (HibernateException e) {

			throw new Exception("Could not check DB ", e);
		}

	}
}
