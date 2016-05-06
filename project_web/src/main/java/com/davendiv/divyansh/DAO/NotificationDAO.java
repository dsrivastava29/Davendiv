package com.davendiv.divyansh.DAO;

import org.hibernate.HibernateException;

import com.davendiv.divyansh.exception.UserException;
import com.davendiv.divyansh.pojo.ConnectionNotification;
import com.davendiv.divyansh.pojo.Notification;
import com.davendiv.divyansh.pojo.Users;

public class NotificationDAO extends DAO {
	public NotificationDAO() {

	}

	public void notifyCon(Users next, String sender, Long id) throws UserException {
		try {
			begin();
			ConnectionNotification n = new ConnectionNotification();
			n.setType("Connection");
			n.setStatus("Pending Confirmation");
			n.setDescription(sender + " wants to connect you");
			n.setUsers(next);
			n.setConnid(id);
			n.setSender(sender);
			next.getNotification().add(n);
			getSession().merge(n);
			commit();

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

}
