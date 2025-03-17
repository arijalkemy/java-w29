package com.example.qatester.repository;

import com.example.qatester.model.Tester;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITesterRepository extends JpaRepository<Tester, Long> {
}
