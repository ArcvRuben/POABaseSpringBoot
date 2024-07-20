package ista.cursoM4A.services;

import java.util.List;
import ista.cursoM4A.entity.Roles;

public interface IRolesService {
    public List<Roles> findAll();
    public Roles save(Roles roles);
    public Roles findById(Long id);
    public void delete(Long id);
}
