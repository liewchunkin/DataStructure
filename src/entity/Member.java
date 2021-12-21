package entity;

import java.util.Objects;
import adt.*;

/**
 *
 * @author Liew Chun Kin
 */
public class Member {

    private String id;
    private String name;
    private String registerDate;
    private char gender;
    private String pNo;

    private ArrListInterface<idol> idolList;

    public Member() {
        idolList = new ArrList<>();
    }

    public Member(String id, String name, String registerDate, char gender, String pNo) {
        this.id = id;
        this.name = name;
        this.registerDate = registerDate;
        this.gender = gender;
        this.pNo = pNo;
        idolList = new ArrList<>();

    }

    public Member(String id, String name, String registerDate, char gender, String pNo, ArrListInterface<idol> idolList) {
        this.id = id;
        this.name = name;
        this.registerDate = registerDate;
        this.gender = gender;
        this.pNo = pNo;
        this.idolList = idolList;
    }

    public Member(String id) {
        this.id = id;
    }

    public void setpNo(String pNo) {
        this.pNo = pNo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public String getpNo() {
        return pNo;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public ArrListInterface<idol> getIdolList() {
        return idolList;
    }

    public void setIdolList(ArrListInterface<idol> idolList) {
        this.idolList = idolList;
    }

    public boolean addIdol(idol i) {
        boolean successful = false;
        if (idolList.getLength() < 1) {
            idolList.add(i);
            successful = true;
        }
        return successful;
    }

    @Override
    public String toString() {
        return String.format("%-10s%-20s%-20s%-15s%-15s%-5s\n", id, name, registerDate, gender, pNo, idolList);
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Member other = (Member) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
