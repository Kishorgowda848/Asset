package com.ViewWiser.security.dataBaseModel;

import org.springframework.data.jpa.repository.JpaRepository;
 
/** JPA implementation  for UserDetailsCostumClass**/
public interface UserDetailsCostumRepository extends JpaRepository<UserDetailsCostumClass, Integer> 
{
	UserDetailsCostumClass findById(int id);
 }
