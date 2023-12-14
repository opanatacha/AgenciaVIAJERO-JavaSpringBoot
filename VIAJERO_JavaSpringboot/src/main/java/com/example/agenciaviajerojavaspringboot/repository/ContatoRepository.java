package com.example.agenciaviajerojavaspringboot.repository;
import com.example.agenciaviajerojavaspringboot.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer> {


}
