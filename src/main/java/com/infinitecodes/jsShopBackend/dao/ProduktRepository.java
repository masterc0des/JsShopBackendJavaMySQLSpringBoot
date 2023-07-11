package com.infinitecodes.jsShopBackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.infinitecodes.jsShopBackend.model.Produkt;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduktRepository extends JpaRepository<Produkt, Long> {


}
