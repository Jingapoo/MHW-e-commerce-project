package com.example.mhwequipment.clients;

/**
 * JpaRepository defines standard CRUD methods, plus JPA-specific operations.
 * We don’t have to write implementation code because Spring Data JPA will generate
 * necessary code at runtime, in form of proxy instances.
 */

import com.example.mhwequipment.clients.PalicoWeapons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository extends JpaRepository<PalicoWeapons, Long> {

}
