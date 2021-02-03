package org.fimba.warehousemanagmentsystem.dao;

import org.fimba.warehousemanagmentsystem.model.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<UserEntity,Long> {
    @Query("SELECT u FROM UserEntity  u WHERE u.email=?1 and u.password=?2")
    UserEntity findUserEntityByEmailAndPassword(String email,String password);
}
