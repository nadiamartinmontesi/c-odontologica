package com.example.demo.config.auth;

import com.example.demo.persistence.entities.RolesUsuario;
import com.example.demo.persistence.entities.Usuario;
import com.example.demo.persistence.repository.UsarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private UsarioRepository usuarioRepository;

    @Autowired
    public void setUsuarioRepository(UsarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("password");
        String password2 = passwordEncoder.encode("password2");

        // COMENTAMOS LOS USUARIOS PARA QUE NO SE DUPLIQUEN EN LA BASE
        //usuarioRepository.save(new Usuario("pepe", password, RolesUsuario.ROLE_ADMIN));
        //usuarioRepository.save(new Usuario("majo", password2, RolesUsuario.ROLE_USER));
    }
}
