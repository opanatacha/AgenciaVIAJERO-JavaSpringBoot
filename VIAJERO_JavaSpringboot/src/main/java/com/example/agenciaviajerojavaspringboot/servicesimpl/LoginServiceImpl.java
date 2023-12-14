package com.example.agenciaviajerojavaspringboot.servicesimpl;

import com.example.agenciaviajerojavaspringboot.model.Usuario;
import com.example.agenciaviajerojavaspringboot.repository.UsuarioRepository;
import com.example.agenciaviajerojavaspringboot.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario autenticar(String email, String senha) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            return usuario;
        } else {
            return null;
        }
    }

}
