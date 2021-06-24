/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.klaim.service;

import com.project.klaim.entity.TblRole;
import com.project.klaim.interfaces.RoleInterface;
import com.project.klaim.repository.RoleRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MELLA
 */
@Service
public class RoleService implements RoleInterface{
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Override
    public void save(TblRole role) {
        roleRepository.save(role);
    }

    @Override
    public Iterable<TblRole> getRoleActive() {
        return roleRepository.getRoleActive();
    }

    @Override
    public Optional<TblRole> getRoleById(Integer roleId) {
        return roleRepository.findById(roleId);
    }
    
}
