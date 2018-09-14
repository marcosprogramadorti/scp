package br.gov.transportes.scp.repository.detalhepessoafisica.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.transportes.scp.model.DetalhePessoaFisica;

public interface DetalhePessoaFisicaRepository extends JpaRepository<DetalhePessoaFisica, Long>, DetalhePessoaFisicaRepositoryQuery {

}
