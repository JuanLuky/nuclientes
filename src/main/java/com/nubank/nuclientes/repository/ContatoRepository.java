package com.nubank.nuclientes.repository;

import com.nubank.nuclientes.entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
