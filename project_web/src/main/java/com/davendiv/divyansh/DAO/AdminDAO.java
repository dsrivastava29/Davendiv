package com.davendiv.divyansh.DAO;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.davendiv.divyansh.exception.UserException;
import com.davendiv.divyansh.pojo.ConnectionNotification;
import com.davendiv.divyansh.pojo.Connectiondetails;
import com.davendiv.divyansh.pojo.Login;
import com.davendiv.divyansh.pojo.Notification;
import com.davendiv.divyansh.pojo.Users;

public class AdminDAO extends DAO {
	public AdminDAO() {

	}

	public Users deleteUser(String name) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from Users where uname = :user");
			Query q2 = getSession().createQuery("from Login where uname = :user");
			q.setString("user", name);
			q2.setString("user", name);
			Users u = (Users) q.uniqueResult();
			Login l = (Login) q2.uniqueResult();
			Set<Connectiondetails> cdetails = u.getConnectiondetailses();
			for (Connectiondetails c : cdetails) {
				getSession().delete(c);
			}

			getSession().delete(l);
			getSession().delete(u);
			commit();
			close();
			return u;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not delete ", e);
		}

	}

	public List<Users> getAllUsers() throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from Users");
			List<Users> all = q.list();
			commit();
			return all;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not notify ", e);
		}

	}

	public boolean updateNot(Notification not, String status, Users logged) throws UserException {
		try {
			begin();
			Long nid = not.getNotid();
			Notification u = (Notification) getSession().createQuery("from Notification where notid=:notid")
					.setLong("notid", nid).uniqueResult();
			ConnectionNotification cnn = (ConnectionNotification) getSession()
					.createQuery("from ConnectionNotification where notid=:notid").setLong("notid", nid).uniqueResult();
			u.setStatus(status);

			if (status.equals("confirm")) {
				String[] x = u.getDescription().split(" ");
				u.setDescription(x[0] + " is now your connection");
			}
			getSession().update(u);
			getSession().merge(cnn);

			commit();
			return true;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not notify ", e);
		}

	}

	public boolean updateStatus(String user, int i) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from Users where userid = :userid");
			q.setString("userid", user);
			Users u = (Users) q.uniqueResult();
			u.setIsActive(i);
			getSession().update(u);
			commit();
			return true;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not delete ", e);
		}

	}

}
