package sv.library.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.library.backend.entity.Role;
import sv.library.backend.repository.RoleRepository;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    // Find a role by name
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}
