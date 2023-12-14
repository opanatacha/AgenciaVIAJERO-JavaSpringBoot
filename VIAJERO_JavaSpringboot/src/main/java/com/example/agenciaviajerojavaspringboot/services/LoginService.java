package com.example.agenciaviajerojavaspringboot.services;

import com.example.agenciaviajerojavaspringboot.model.Usuario;

public interface LoginService {

    public Usuario autenticar(String email, String senha);
}
