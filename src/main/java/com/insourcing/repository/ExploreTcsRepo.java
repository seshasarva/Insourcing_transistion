package com.insourcing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insourcing.entity.ExploreTcsEntity;
import com.insourcing.entity.ExploreTcsId;

@Repository
public interface ExploreTcsRepo extends JpaRepository<ExploreTcsEntity, ExploreTcsId>{

}
