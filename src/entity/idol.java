/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Liew Chun Kin
 */
import java.util.Objects;

/**
 *
 * @author Jian
 */
public class idol {

    private String idolName;

    public idol() {
    }

    public idol(String idolName) {
        this.idolName = idolName;
    }

    public String getIdolName() {
        return idolName;
    }

    public void setIdolName(String idolName) {
        this.idolName = idolName;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final idol other = (idol) obj;
        if (!Objects.equals(this.idolName, other.idolName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("%-5s", idolName);
    }

}
