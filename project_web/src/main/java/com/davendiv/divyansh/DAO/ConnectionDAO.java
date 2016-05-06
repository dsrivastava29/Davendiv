package com.davendiv.divyansh.DAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.davendiv.divyansh.exception.UserException;
import com.davendiv.divyansh.pojo.Connectiondetails;
import com.davendiv.divyansh.pojo.PersonalInfo;
import com.davendiv.divyansh.pojo.Users;;

public class ConnectionDAO extends DAO {
	public ConnectionDAO() {

	}

	public Long addContact(Users sender, String newcon, String status) {
		try {
			begin();
			// Users u =(Users)getSession().load(Users.class, sender);
			Connectiondetails cd = new Connectiondetails();
			cd.setConusername(newcon);
			cd.setStatus(status);
			cd.setUsers(sender);
			sender.getConnectiondetailses().add(cd);
			getSession().merge(cd);
			commit();

			return cd.getConnid();
		} catch (HibernateException e) {
			rollback();
			return null;
			// throw new UserException("Could not get user " + user, e);
		}
	}

	public boolean confirmCon(Users logged, String sender) {
		try {
			begin();
			Query q = getSession().createQuery("from Users where uname = :user");
			q.setString("user", sender);
			Users person = (Users) q.uniqueResult();
			// Users u = (Users) getSession().load(Users.class,
			// logged.getUserid());
			Set<Connectiondetails> conss = person.getConnectiondetailses();
			Connectiondetails d = null;
			boolean isdone = false;
			for (Connectiondetails cd : conss) {
				if (cd.getConusername().equals(logged.getUname())) {
					d = cd;
					break;
				}
			}
			if (d != null) {
				Query a = getSession().createQuery("from Connectiondetails where connid= :connid");
				a.setLong("connid", d.getConnid());
				Connectiondetails cds = (Connectiondetails) a.uniqueResult();
				cds.setStatus("confirm");
				getSession().update(d);
				isdone = true;
			}

			commit();

			return isdone;
		} catch (HibernateException e) {
			rollback();
			return false;
			// throw new UserException("Could not get user " + user, e);
		}

	}

	public Set<Connectiondetails> get(Users user) throws UserException {
		try {
			begin();
			Users u = (Users) getSession().load(Users.class, user);
			Set<Connectiondetails> conss = u.getConnectiondetailses();
			commit();

			return conss;
		} catch (HibernateException e) {
			rollback();
			return null;
			// throw new UserException("Could not get user " + user, e);
		}
	}

	public List<Map<String, Object>> getAllUsers(ArrayList existing, String logged) throws UserException {
		try {
			begin();
			Criteria c = getSession().createCriteria(Users.class).setFetchMode("PersonalInfo", FetchMode.JOIN);
			ProjectionList projList = Projections.projectionList();
			projList.add(Projections.property("logicalpic"));
			projList.add(Projections.property("personalInfo"));
			projList.add(Projections.property("uname"));

			c.setProjection(projList);
			List ux = c.list();
			List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
			PersonalInfo p;
			for (Iterator it = ux.iterator(); it.hasNext();) {
				Map<String, Object> columns = new LinkedHashMap<String, Object>();
				Object[] row = (Object[]) it.next();
				columns.put("pic", row[0]);
				p = (PersonalInfo) row[1];
				columns.put("firstname", p.getFirstname());
				columns.put("name", row[2]);
				String nm = (String) row[2];
				if ((!nm.equals(logged)) && (!existing.contains(nm))) {
					rows.add(columns);
				}
			}
			commit();

			return rows;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("xx");
		}

	}

}
