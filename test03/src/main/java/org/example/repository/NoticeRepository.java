package org.example.repository;

import org.example.test03.model.entity.NoticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoticeRepository extends JpaRepository<NoticeEntity, Integer> {

    public List<NoticeEntity> findAll();

}


