package es.uclm.esi.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import es.uclm.esi.model.Role;


public interface RoleRepository extends MongoRepository<Role, String> {
    
    Role findByRole(String role);
    
}
