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
    public void adicionar(T value);
    public void alterar(T value);
    public void Excluir(T value);
}
