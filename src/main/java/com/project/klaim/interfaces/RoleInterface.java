/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.klaim.interfaces;

import com.project.klaim.entity.TblRole;
import java.util.Optional;

/**
 *
 * @author MELLA
 */
public interface RoleInterface {
    void save(TblRole role);
    Iterable<TblRole> getRoleActive();
    public Optional<TblRole> getRoleById(Integer roleId);
}
