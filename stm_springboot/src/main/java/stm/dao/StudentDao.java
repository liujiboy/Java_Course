package stm.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import stm.domain.Student;
@Repository
public interface StudentDao extends CrudRepository<Student, String> {

}
