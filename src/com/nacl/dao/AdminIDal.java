package com.nacl.dao;
import com.nacl.entity.Admin;
import java.util.List;

public interface AdminIDal {
    public Admin getEntityById(int id);
    public List<Admin> getEntities();
    public int addEntity(Admin admin);
    public int deleteEntity(int id);
    public int updateEntity(Admin entity);
}
