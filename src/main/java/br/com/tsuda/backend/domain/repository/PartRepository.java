package br.com.tsuda.backend.domain.repository;

import br.com.tsuda.backend.domain.entity.Part;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartRepository extends JpaRepository<Part, Integer> {
}
