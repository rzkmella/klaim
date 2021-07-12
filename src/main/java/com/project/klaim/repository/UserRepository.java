/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.klaim.repository;

import com.project.klaim.entity.TblUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MELLA
 */
@Repository
public interface UserRepository extends CrudRepository<TblUser, Integer>{
    @Query(value = "SELECT * FROM Tbl_user WHERE email_user= :emailUser", nativeQuery = true)
    public TblUser getEmail(@Param("emailUser") String emailUser);
    
    @Query(value = "SELECT u.password_user FROM Tbl_user u WHERE password_user= :passwordUser", nativeQuery = true)
    public TblUser getPassword(@Param("passwordUser") String passworUser);
    
    @Query(value = "SELECT * FROM tbl_user WHERE tbl_user.status_user = 1", nativeQuery = true)
    public Iterable<TblUser> getUserActive();
}

