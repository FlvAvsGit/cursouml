package com.flavio.cursouml.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flavio.cursouml.domain.Pagamento;

@Repository 
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

}
