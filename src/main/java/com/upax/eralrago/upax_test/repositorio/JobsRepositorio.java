package com.upax.eralrago.upax_test.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upax.eralrago.upax_test.modelo.Jobs;

@Repository
public interface JobsRepositorio extends JpaRepository<Jobs, Integer> {

}
