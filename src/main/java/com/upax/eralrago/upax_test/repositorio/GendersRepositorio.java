package com.upax.eralrago.upax_test.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upax.eralrago.upax_test.modelo.Genders;

@Repository
public interface GendersRepositorio extends JpaRepository<Genders, Integer> {

}
