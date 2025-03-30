package com.examly.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Admin;
import com.examly.springapp.repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;
    

    public Admin addAdmin(Admin admin){
        return adminRepository.save(admin);
    }

    public Admin getAdminById(Long id){
        return adminRepository.findById(id).orElse(null);
    }

    public Admin updateAdmin(Admin admin){
        return adminRepository.save(admin);
    }
}
