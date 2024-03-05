package com.example.emploidutemps.services.baseService;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BaseServiceInterface<Entity, PK> {
    JpaRepository<Entity, PK> getRepository();
    List<Entity> findAll();
    Entity findById(PK id);
    List<Entity> saveAll(List<Entity> entities);
    Entity save(Entity entity);
    Entity update(Entity entity);
    Boolean delete(Entity entity);
    Boolean deleteByid(PK id);
}
