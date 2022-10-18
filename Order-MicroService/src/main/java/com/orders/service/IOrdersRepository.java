package com.orders.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orders.model.Orders;

public interface IOrdersRepository extends JpaRepository<Orders, Integer> {

}
