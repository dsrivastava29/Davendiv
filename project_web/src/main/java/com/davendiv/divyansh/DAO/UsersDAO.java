package com.davendiv.divyansh.DAO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.davendiv.divyansh.exception.UserException;
import com.davendiv.divyansh.pojo.Connectiondetails;
import com.davendiv.divyansh.pojo.Davenfeed;
import com.davendiv.divyansh.pojo.DavenfeedId;
import com.davendiv.divyansh.pojo.Login;
import com.davendiv.divyansh.pojo.Notification;
import com.davendiv.divyansh.pojo.PersonalInfo;
import com.davendiv.divyansh.pojo.Users;

public class UsersDAO extends DAO {
	public UsersDAO() {

	}

	public boolean checkUser(String uname) throws UserException {
		try {
			begin();
			// TODO Auto-generated method stub
			Query q = getSession().createQuery("from Users where uname = :uname");
			q.setString("uname", uname);
			List ux = q.list();
			Boolean res = ux.iterator().hasNext();

			commit();
			return res;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: " + e.getMessage());
		}
	}

	public PersonalInfo create(PersonalInfo personal) throws UserException {
		try {
			begin();
			// TODO Auto-generated method stub
			getSession().update(personal);
			commit();
			close();
			return personal;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: " + e.getMessage());
		}
	}

	public Users create(String uname, String pass, String mail) throws UserException {
		try {
			begin();
			Users user = new Users(uname, pass, mail);
			user.setMail(mail);
			user.setPass(pass);
			user.setUname(uname);
			user.setPicture("");

			getSession().saveOrUpdate(user);
			commit();
			close();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: " + e.getMessage());
		}
	}

	public Users create(Users users) throws UserException {
		try {
			begin();
			// TODO Auto-generated method stub
			Login login = new Login();
			login.setUserid(users.getUserid());
			login.setUname(users.getUname());
			login.setPassword(users.getPass());
			getSession().saveOrUpdate(users);
			getSession().saveOrUpdate(login);
			commit();
			close();
			return users;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: " + e.getMessage());
		}
	}

	public void delete(Users user) throws UserException {
		try {
			begin();
			getSession().delete(user);
			commit();
			close();
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not delete user " + user.getUname(), e);
		}
	}

	public boolean deleteNotification(Users user, Notification n) throws UserException {
		// TODO Auto-generated method stub
		try {
			begin();
			// TODO Auto-generated method stub
			// Users u = (Users) getSession().load(Users.class, user);
			user.getNotification().remove(n);
			getSession().delete(n);
			// getSession().merge(cnn);
			commit();
			return true;

		} catch (HibernateException e) {
			rollback();
			return false;
		}
	}

	public List<Notification> fetchNotification(Users user) throws UserException {
		// TODO Auto-generated method stub
		try {
			begin();
			// TODO Auto-generated method stub
			// Users u = (Users) getSession().load(Users.class, user);
			Query q = getSession().createQuery("From Notification where users= :user Order by notid desc");
			q.setLong("user", user.getUserid());
			List<Notification> ls;// = new ArrayList<Notification>();
			ls = q.list();// q.list();
			commit();
			return ls;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while getting notification: " + e.getMessage());
		}
	}

	public Users get(Long uid) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from Users where userid = :userid");
			q.setLong("userid", uid);
			Users u = (Users) q.uniqueResult();
			commit();

			return u;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + uid, e);
		}
	}

	public Login get(String user) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from Login where uname = :user");
			q.setString("user", user);
			Login u = (Login) q.uniqueResult();
			commit();
			close();
			return u;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + user, e);
		}
	}

	public Users getUByName(String user) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from Users where uname = :user");
			q.setString("user", user);
			Users u = (Users) q.uniqueResult();
			commit();

			return u;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + user, e);
		}
	}

	public void registerUpdate(long userid, String uname, String pass, String mail, String first, String middle,
			String last, String city, String state, String country) {
		begin();
		Users user = new Users(uname, pass, mail);
		user.setUserid(userid);
		user.setMail(mail);
		user.setPass(pass);
		user.setUname(uname);

		PersonalInfo pi = new PersonalInfo(user, first, middle, last, city, state, country, Long.parseLong("0"));
		user.setPersonalInfo(pi);
		getSession().saveOrUpdate(user);
		commit();

	}

	public Users registerUpdate(Users users) throws UserException {
		// TODO Auto-generated method stub
		try {

			// TODO Auto-generated method stub
			Users u = get(users.getUserid());
			getSession().flush();
			getSession().clear();
			if (u != null) {
				begin();
				users.setUname(u.getUname());
				users.setPass(u.getPass());
				users.setMail(u.getMail());
				PersonalInfo pi = users.getPersonalInfo();
				u.setPersonalInfo(pi);
				getSession().saveOrUpdate(u);
				getSession().saveOrUpdate(pi);
				commit();

				return users;
			} else
				return null;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: " + e.getMessage());
		}
	}

	public int updatePicture(Long uid, String saveFile, String logical) throws Exception {
		try {
			begin();
			// TODO Auto-generated method stub
			String picUpdate = "update Users u set u.picture = :picture, u.logicalpic= :logicalpic where u.userid = :uid";
			int updatedEntities = getSession().createQuery(picUpdate).setString("picture", saveFile)
					.setString("logicalpic", logical).setLong("uid", uid).executeUpdate();

			commit();

			return updatedEntities;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while creating user: " + e.getMessage());
		}

	}

	public List<Map<String, String>> getUsersView() throws UserException {

		List<Map<String, String>> allusers = null;
		Query q = getSession().createQuery("from Users");
		List<Users> users = q.list();
		Users temp = null;
		Map<String, String> one = null;
		ArrayList<String> existing = new ArrayList<String>();
		String st = null;
		for (Users c : users) {

			one = new HashMap<String, String>();
			one.put("name", c.getUname());
			one.put("Full", temp.getPersonalInfo().getFirstname() + " " + temp.getPersonalInfo().getLastname());
			if (c.getIsActive() == 0)
				st = "Inactive";
			else
				st = "Active";
			one.put("Account Status", st);
			one.put("Connections", String.valueOf(c.getConnectiondetailses().size()));

			allusers.add(one);
		}
		return allusers;

	}

	public Set<Davenfeed> getFeeds(long userid) throws Exception {
		try {
			begin();
			// TODO Auto-generated method stub
			String query = "from Users u where u.userid = :uid";

			Users u = (Users) getSession().createQuery(query).setLong("uid", userid).uniqueResult();
			Set<Davenfeed> feeds = (Set<Davenfeed>) u.getDavenfeeds();
			commit();

			return feeds;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while creating user: " + e.getMessage());
		}
	}

	public void addFeed(String uname, String sen) throws Exception {
		try {
			begin();
			// TODO Auto-generated method stub
			Date dt = Calendar.getInstance().getTime();
			String query = "from Users u where u.uname = :uname";
			Davenfeed d = new Davenfeed();
			d.setPost(sen);
			Users u = (Users) getSession().createQuery(query).setString("uname", uname).uniqueResult();
			d.setUsers(u);
			if (d.getId() == null) {
				d.setId(new DavenfeedId(String.valueOf(dt), u.getUserid()));
			}
			u.getDavenfeeds().add(d);
			getSession().save(d);
			getSession().merge(d);
			commit();

		} catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while creating user: " + e.getMessage());
		}

	}
}
