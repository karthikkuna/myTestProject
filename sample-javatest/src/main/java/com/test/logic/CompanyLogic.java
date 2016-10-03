package com.test.logic;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.test.models.Users;
import com.test.util.SessionUtil;

public class CompanyLogic {

	public CompanyLogic() {
		// TODO Auto-generated constructor stub
	}

	public boolean validate(String userName, String password) {
		try {
			Session session = SessionUtil.getInstance().getSessionFactory()
					.openSession();
			Criteria criteria = session.createCriteria(Users.class);
			criteria.add(Restrictions.like("userName", userName));
			criteria.add(Restrictions.like("password", password));
			criteria.setProjection(Projections.rowCount());
			Long count = (Long) criteria.uniqueResult();
			System.out.println("count :" + count);
			if (count == 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
