/**
 * 
 */
package com.ridvanogras.steelorbis.demo.steelorbis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ridvanogras.steelorbis.demo.steelorbis.dao.UserDao;
import com.ridvanogras.steelorbis.demo.steelorbis.model.User;
import com.ridvanogras.steelorbis.demo.steelorbis.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public Boolean checkUserDetails(User userDetails) {

		return userDao.checkUserDetails(userDetails);
	}

}
