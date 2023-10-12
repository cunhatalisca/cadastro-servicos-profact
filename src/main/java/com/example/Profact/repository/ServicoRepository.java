package com.example.Profact.repository;

import com.example.Profact.entities.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServicoRepository extends JpaRepository<Services, Long> {

    @Query("select s from Services s where s.pricePaidOut <> null and s.pricePaidOut > 0")
    List<Services> repositoryFindServicesPendents();

    @Query("select s from Services s where s.status = 'cancelado' ")
    List<Services> repositoryFindServicesCanceled();
}
