package com.example.mhwequipment;


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
