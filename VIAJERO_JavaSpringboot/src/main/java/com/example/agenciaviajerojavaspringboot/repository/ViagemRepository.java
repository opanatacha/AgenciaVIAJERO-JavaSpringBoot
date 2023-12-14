package com.example.agenciaviajerojavaspringboot.repository;
import com.example.agenciaviajerojavaspringboot.model.Viagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViagemRepository extends JpaRepository<Viagem, Integer> {



}
