/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

/**
 *
 * @author Liew Chun Kin
 */
public class MemberDriver {

    public static void main(String[] args) {
        MemberMaintenance mm = new MemberMaintenance();

        mm.checkMember();
        mm.memberMenu();

    }

}
