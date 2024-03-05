package com.example.emploidutemps.services.baseService;


import java.util.List;

public abstract class BaseServiceImpl<Entity, PK> implements BaseServiceInterface<Entity, PK>{
    @Override
    public List<Entity> findAll() {
        return this.getRepository().findAll();
    }

    @Override
    public Entity findById(PK id) {
        return (Entity) this.getRepository().findById(id).get();
    }

    @Override
    public List<Entity> saveAll(List<Entity> entities) {
        return this.getRepository().saveAll(entities);
    }

    @Override
    public Entity save(Entity entity) {
        return this.getRepository().save(entity);
    }

    @Override
    public Entity update(Entity entity) {
        return this.getRepository().save(entity);
    }

    @Override
    public Boolean delete(Entity entity) {
        this.getRepository().delete(entity);
        return null;
    }

    @Override
    public Boolean deleteByid(PK id) {
    this.getRepository().deleteById(id);
        return null;
    }
}
