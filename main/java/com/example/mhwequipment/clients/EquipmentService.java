package com.example.mhwequipment.clients;

/**
 * This class manages information in a database – with standard CRUD operations:
 * Create, Retrieve, Update and Delete. It is a Spring Boot CRUD with Spring MVC
 */

import com.example.mhwequipment.clients.EquipmentRepository;
import com.example.mhwequipment.clients.PalicoWeapons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EquipmentService {
    @Autowired
    private EquipmentRepository repo;

    public List<PalicoWeapons> listAll(){
        return repo.findAll();
    }

    public void save(PalicoWeapons weapon){
        repo.save(weapon);
    }

    public PalicoWeapons get(Long id){
        return repo.findById(id).get();
    }

    public void delete(Long id){
        repo.deleteById(id);
    }



}
