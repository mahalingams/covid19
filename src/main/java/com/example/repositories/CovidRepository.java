package com.example.repositories; 

import com.example.model.Covid19Stats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CovidRepository extends JpaRepository<Covid19Stats, Long> {

}
