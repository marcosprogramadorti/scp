package br.gov.transportes.scp.repository.postulante.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.transportes.scp.model.Postulante;

public interface PostulanteRepository extends JpaRepository<Postulante, Long> {

}
