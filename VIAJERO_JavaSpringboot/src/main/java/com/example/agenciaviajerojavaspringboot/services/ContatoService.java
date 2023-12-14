package com.example.agenciaviajerojavaspringboot.services;
import com.example.agenciaviajerojavaspringboot.model.Contato;
import java.util.List;

public interface ContatoService {

    Contato saveContato(Contato contato);



    List<Contato> getAllContatos();



}
