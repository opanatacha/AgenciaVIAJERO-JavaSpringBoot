package com.example.agenciaviajerojavaspringboot.servicesimpl;
import com.example.agenciaviajerojavaspringboot.model.Usuario;
import com.example.agenciaviajerojavaspringboot.repository.UsuarioRepository;
import com.example.agenciaviajerojavaspringboot.services.UsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    @Transactional
    public Usuario getUsuarioById(Integer idUsuario) {
        return usuarioRepository.findById(idUsuario).orElse(null);
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario updateUsuario(Integer idUsuario, Usuario usuarioAtualizado) {
        Usuario usuarioExistente = usuarioRepository.findById(idUsuario).orElse(null);
        if (usuarioExistente != null) {
            usuarioExistente.setNome(usuarioAtualizado.getNome());
            usuarioExistente.setDataNascimento(usuarioAtualizado.getDataNascimento());
            usuarioExistente.setCpf(usuarioAtualizado.getCpf());
            usuarioExistente.setTelefone(usuarioAtualizado.getTelefone());
            usuarioExistente.setEmail(usuarioAtualizado.getEmail());
            //Evita que a senha seja atualiza com valor em branco ou vazio
            if(!usuarioAtualizado.getSenha().isEmpty() && !usuarioAtualizado.getSenha().isBlank()) {
                usuarioExistente.setSenha(usuarioAtualizado.getSenha());
            }
            return usuarioRepository.save(usuarioExistente);
        } else {
            throw new RuntimeException("Usuario " + idUsuario + " não encontrado");
        }

    }

    @Override
    public void deleteUsuario(Integer idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }


}
