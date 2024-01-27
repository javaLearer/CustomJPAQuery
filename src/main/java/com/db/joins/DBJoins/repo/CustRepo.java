package com.db.joins.DBJoins.repo;

import com.db.joins.DBJoins.entity.Customer;
import com.db.joins.DBJoins.model.OrderProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustRepo extends JpaRepository<Customer, Integer> {

    @Query("SELECT new com.db.joins.DBJoins.model.OrderProcess(c.name , p.pname) FROM Customer c JOIN c.productList p")
    public List<OrderProcess> getJoinInformation();

}
