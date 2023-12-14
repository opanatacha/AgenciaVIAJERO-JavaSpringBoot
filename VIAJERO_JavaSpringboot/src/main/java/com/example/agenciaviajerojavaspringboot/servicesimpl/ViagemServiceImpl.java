package com.example.agenciaviajerojavaspringboot.servicesimpl;
import com.example.agenciaviajerojavaspringboot.model.Viagem;
import com.example.agenciaviajerojavaspringboot.repository.ViagemRepository;
import com.example.agenciaviajerojavaspringboot.services.ViagemService;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ViagemServiceImpl implements ViagemService {

    @Autowired
    private ViagemRepository viagemRepository;

    @Override
    public Viagem saveViagem(Viagem viagem){
        return viagemRepository.save(viagem);
    }

    @Override
    @Transactional
    public Viagem getViagemById(Integer idViagem){
        return viagemRepository.findById(idViagem).orElse(null);
    }

    @Override
    public List<Viagem> getAllViagens(){
        return viagemRepository.findAll();
    }

    @Override
    public Viagem updateViagem(Integer idViagem, Viagem viagemAtualizada){
        Viagem viagemExistente = viagemRepository.findById(idViagem).orElse(null);
        if (viagemExistente != null){
            viagemExistente.setOrigem(viagemAtualizada.getOrigem());
            viagemExistente.setDestino(viagemAtualizada.getDestino());
            viagemExistente.setDataIda(viagemAtualizada.getDataIda());
            viagemExistente.setDataVolta(viagemAtualizada.getDataVolta());
            viagemExistente.setTipoViagem(viagemAtualizada.getTipoViagem());
            viagemExistente.setQtdPessoas(viagemAtualizada.getQtdPessoas());
            viagemExistente.setHospedagem(viagemAtualizada.getHospedagem());
            viagemExistente.setTipoHospedagem(viagemAtualizada.getTipoHospedagem());
            viagemExistente.setEnderecoHospedagem(viagemAtualizada.getEnderecoHospedagem());
            viagemExistente.setGuiaTurismo(viagemAtualizada.getGuiaTurismo());
            viagemExistente.setAgenciaTransporte(viagemAtualizada.getAgenciaTransporte());
            viagemExistente.setCodigoTransporte(viagemAtualizada.getCodigoTransporte());
            viagemExistente.setDescricao(viagemAtualizada.getDescricao());
            viagemExistente.setValorViagem(viagemAtualizada.getValorViagem());
            return viagemRepository.save(viagemExistente);
        } else {
            throw new RuntimeException("Viagem " + idViagem + " não encontrado");
        }
    }

    @Override
    public void deleteViagem(Integer idViagem){
        viagemRepository.deleteById(idViagem);
    }

}
