package com.example.agenciaviajerojavaspringboot.services;
import com.example.agenciaviajerojavaspringboot.model.Usuario;
import java.util.List;

public interface UsuarioService {

    Usuario saveUsuario(Usuario usuario);

    Usuario getUsuarioById(Integer idUsuario);

    List<Usuario> getAllUsuarios();

    Usuario updateUsuario(Integer idUsuario, Usuario usuario);

    void deleteUsuario(Integer idUsuario);

}
