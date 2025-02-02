/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sergiotareahibernate.DAO;

import java.util.List;

/**
 *
 * @author Sergio
 */
public interface Repository<T> {
    void update(T t);
    void delete(T t);
    void save(T t);
    List<T> findAll();
    T findOneById(int id);
}
