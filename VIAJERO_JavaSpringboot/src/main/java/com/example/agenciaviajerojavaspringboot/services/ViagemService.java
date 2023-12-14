package com.example.agenciaviajerojavaspringboot.services;
import com.example.agenciaviajerojavaspringboot.model.Viagem;
import java.util.List;

public interface ViagemService {

    Viagem saveViagem(Viagem viagem);

    Viagem getViagemById(Integer idViagem);

    List<Viagem> getAllViagens();

    Viagem updateViagem(Integer idViagem, Viagem viagem);

    void deleteViagem(Integer idViagem);

}
