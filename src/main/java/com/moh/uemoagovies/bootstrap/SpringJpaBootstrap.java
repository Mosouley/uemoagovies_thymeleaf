package com.moh.uemoagovies.bootstrap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.moh.uemoagovies.domain.Role;
import com.moh.uemoagovies.repositories.RoleRepository;

@Component
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {


    private RoleRepository roleRepository;

    
      
    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
    	this.roleRepository=roleRepository;
    }


    private Logger log = Logger.getLogger(SpringJpaBootstrap.class);



    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        loadRoles();

    }

  

    private void loadRoles() {
		createRoleIfNotFound("USER");
		createRoleIfNotFound("ADMIN");
		
	}
	@Transactional
    private Role createRoleIfNotFound(
      String name) {
  
        Role role = roleRepository.findByRole(name);
        if (role == null) {
            role = new Role();
            role.setRole(name);
            log.info("Saved role" + role.getRole());
            roleRepository.save(role);
        }
        return role;
    }
}
