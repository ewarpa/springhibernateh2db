package com.ridvanogras.steelorbis.demo.steelorbis.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.ridvanogras.steelorbis.demo.steelorbis.dao.UserDao;
import com.ridvanogras.steelorbis.demo.steelorbis.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Boolean checkUserDetails(User userDetails) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> rootEntry = cq.from(User.class);
		CriteriaQuery<User> ws = cq.select(rootEntry).where(
				entityManager.getCriteriaBuilder().equal(rootEntry.get("name"), userDetails.getName()),
				entityManager.getCriteriaBuilder().equal(rootEntry.get("password"), userDetails.getPassword()));

		TypedQuery<User> allQuery = entityManager.createQuery(ws);

		return !allQuery.getResultList().isEmpty();
	}

}
