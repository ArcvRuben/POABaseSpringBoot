package ista.cursoM4A.dao;

import org.springframework.data.repository.CrudRepository;
import ista.cursoM4A.entity.Usuarios;

public interface IUsuariosDao extends CrudRepository<Usuarios, Long> {

}
