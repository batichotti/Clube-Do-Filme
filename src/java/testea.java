/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mateus Cohuzer
 */
import Entidades.User;
import DAOs.DAOUser;

public class testea {
    
    public static void main(String[] arg){
        User usuario = new User();
        DAOUser daoUsuarios = new DAOUser();
        System.out.println(daoUsuarios.obter("matebatichotti@gmail.com").getNick());
    }
}
