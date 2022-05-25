/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

/**
 *
 * @author danil
 */
public interface InterfaceBasicDB <T>{
    public void add(T value);
    public void update(T value);
    public void delete(T value);
}
