package com.example.agenciaviajerojavaspringboot.servicesimpl;


import com.example.agenciaviajerojavaspringboot.model.Contato;
import com.example.agenciaviajerojavaspringboot.repository.ContatoRepository;
import com.example.agenciaviajerojavaspringboot.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoServiceImpl implements ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Override
    public Contato saveContato(Contato contato) {
        return contatoRepository.save(contato);
    }

    @Override
    public List<Contato> getAllContatos() {
        return contatoRepository.findAll();
    }


}
