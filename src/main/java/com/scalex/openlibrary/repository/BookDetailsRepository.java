package com.scalex.openlibrary.repository;

import com.scalex.openlibrary.model.entity.BookInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDetailsRepository extends JpaRepository<BookInformation,String> {
}
