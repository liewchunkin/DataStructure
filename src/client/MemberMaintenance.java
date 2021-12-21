/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import adt.*;
import entity.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Liew Chun Kin
 */
public class MemberMaintenance {

    ArrListInterface<Member> memberDetails = new ArrList<>();

    private Scanner scan = new Scanner(System.in);

    String registerDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());

    //change the colour of output
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public void checkMember() {

        Member m1 = new Member("M001", "Tan Teck Zhi", "03-11-2018", 'M', "0168879985");
        Member m2 = new Member("M002", "Liew Chun Kin", "04-04-2019", 'M', "0169893528");
        Member m3 = new Member("M003", "Chan Hong Yu", "14-09-2020", 'M', "0194453345");
        Member m4 = new Member("M004", "Christina Yap", "21-01-2021", 'F', "0123563345");
        Member m5 = new Member("M005", "Gan Jia Liang", "23-04-2021", 'M', "0145569978");

        // check the array is empty or not
        if (memberDetails.isEmpty()) {
            memberDetails.add(m1);
            memberDetails.add(m2);
            memberDetails.add(m3);
            memberDetails.add(m4);
            memberDetails.add(m5);

        }
    }

    public void memberMenu() {
        int choosen = 0;
        System.out.println("\n**************************************");
        System.out.println("*          Member Maintenance        *");
        System.out.println("**************************************");
        System.out.println("* 1. Add Member                      *");
        System.out.println("* 2. Remove Member                   *");
        System.out.println("* 3. Retrieve Member Deatils         *");
        System.out.println("* 4. Edit member's details           *");
        System.out.println("* 5. Generate Report                 *");
        System.out.println("* 6. Exit                            *");
        System.out.println("**************************************\n");

        boolean resume = true;

        try {
            System.out.println("Enter your selection : ");
            choosen = scan.nextInt();
            scan.nextLine();
        } catch (Exception e) {
            scan.nextLine();
        }

        switch (choosen) {
            case 1 ->
                addMemberMenu();
            case 2 ->
                removeMemberMenu();
            case 3 ->
                retrieveMember();
            case 4 ->
                editMember();

            case 5 ->
                memberReport();
            case 6 -> {
            }
            default -> {
                System.out.println(ANSI_RED + "Invalid input! Only integer between [1-6] are allowed!" + ANSI_RESET);
                memberMenu();
            }
        }
    }

    public void addMemberMenu() {
        System.out.println("\n\n*************************************");
        System.out.println("*           Add Member              *");
        System.out.println("*************************************");
        System.out.println("1. Add to the end");
        System.out.println("2. Add in specific position");
        System.out.println("3. Add idol to member");
        System.out.println("4. Back");
        System.out.println("What method you want to use ? ");
        int infoUpdate = scan.nextInt();
        scan.nextLine();

        switch (infoUpdate) {
            case 1 -> {
                addMemberToTheEnd();
            }
            case 2 -> {
                addMemberToPosition();
            }
            case 3 ->
                addIdolToMember();
            case 4 ->
                memberMenu();
            default -> {
            }
        }
    }

    public void addIdolToMember() {
        System.out.println("\t\t\t\t\tMember List");
        memberListHeader();
        for (int i = 1; i <= memberDetails.getLength(); i++) {
            System.out.println(" " + i + ". " + memberDetails.getEntry(i));
        }
        System.out.println("=================================================================================================");
        System.out.print("\nEnter line number: ");
        int line = scan.nextInt();
        scan.nextLine();
        Member member = memberDetails.getEntry(line);
        System.out.print("\nEnter Idol Name: ");
        String idolName = scan.nextLine();

        idol Idol = new idol(idolName);

        member.addIdol(Idol);
        System.out.println(ANSI_GREEN + "Successfully add idol to member." + ANSI_RESET + "\n\n");
        memberMenu();
    }

    public void addMemberToTheEnd() {
        char decision = 'N';

        do {
            int num = memberDetails.getLength() + 1;
            String id = String.format("M" + "%03d", num);
            System.out.println("\n*************************************");
            System.out.println("*      Add Member To The End        *");
            System.out.println("*************************************");
            System.out.print("Member ID: " + id);
            System.out.print("\nEnter Member Name: ");
            String memberName = scan.nextLine();

            // stores each characters to a char array
            char[] charArray = memberName.toCharArray();
            boolean foundSpace = true;
            for (int i = 0; i < charArray.length; i++) {
                // if the array element is a letter
                if (Character.isLetter(charArray[i])) {
                    // check space is present before the letter
                    if (foundSpace) {
                        // change the letter into uppercase
                        charArray[i] = Character.toUpperCase(charArray[i]);
                        foundSpace = false;
                    }
                } else {
                    // if the new character is not character
                    foundSpace = true;
                }
            }
            // convert the char array to the string
            memberName = String.valueOf(charArray);

            System.out.println("Register Date: " + registerDate);
            System.out.print("Enter Gender: ");
            char gender = scan.next().charAt(0);
            char genderUp = Character.toUpperCase(gender);
            scan.nextLine();
            System.out.print("Enter Phone Number: ");
            String pNo = scan.nextLine();
            System.out.println("Continue add ? (Y/N): ");
            decision = scan.next().charAt(0);
            decision = Character.toUpperCase(decision);
            scan.nextLine();

            //add member by passing entry to the add() method
            memberDetails.add(new Member(id, memberName, registerDate, genderUp, pNo));

            System.out.println(ANSI_GREEN + "Successfully add new member." + ANSI_RESET);
        } while (decision == 'Y');
        memberMenu();
    }

    public void addMemberToPosition() {
        char decision = 'N';

        do {
            int num = memberDetails.getLength() + 1;
            String id = String.format("M" + "%03d", num);
            System.out.println("\n*************************************");
            System.out.println("*      Add Member To Position       *");
            System.out.println("*************************************");
            System.out.print("Member ID: " + id);
            System.out.print("\nEnter Member Name: ");
            String memberName = scan.nextLine();

            // stores each characters to a char array
            char[] charArray = memberName.toCharArray();
            boolean foundSpace = true;
            for (int i = 0; i < charArray.length; i++) {
                // if the array element is a letter
                if (Character.isLetter(charArray[i])) {
                    // check space is present before the letter
                    if (foundSpace) {
                        // change the letter into uppercase
                        charArray[i] = Character.toUpperCase(charArray[i]);
                        foundSpace = false;
                    }
                } else {
                    // if the new character is not character
                    foundSpace = true;
                }
            }
            // convert the char array to the string
            memberName = String.valueOf(charArray);

            System.out.println("Register Date: " + registerDate);
            System.out.print("Enter Gender: ");
            char gender = scan.next().charAt(0);
            char genderUp = Character.toUpperCase(gender);
            scan.nextLine();
            System.out.print("Enter Phone Number: ");
            String pNo = scan.nextLine();
            System.out.print("Enter Position: ");
            int num1 = scan.nextInt();
            System.out.println("Continue add ? (Y/N): ");
            decision = scan.next().charAt(0);
            decision = Character.toUpperCase(decision);
            scan.nextLine();
            memberDetails.add(num1, new Member(id, memberName, registerDate, genderUp, pNo));
            System.out.println(ANSI_GREEN + "Successfully add new member." + ANSI_RESET);
        } while (decision == 'Y');
        memberMenu();
    }

    public void removeMemberMenu() {
        System.out.println("\n\n*************************************");
        System.out.println("*           Remove Member           *");
        System.out.println("*************************************");
        System.out.println("1. Remove by id");
        System.out.println("2. Remove by integer");
        System.out.println("3. Back");
        System.out.println("What method you want to use ? ");
        int infoUpdate = scan.nextInt();
        scan.nextLine();

        switch (infoUpdate) {
            case 1 -> {
                removeMemberById();
            }
            case 2 -> {
                removeMemberByInteger();
            }
            case 3 ->
                memberMenu();
            default -> {
            }
        }
    }

    public void removeMemberById() {
        System.out.println("\t\t\t\t\tMember List");
        memberListHeader();
        for (int i = 1; i <= memberDetails.getLength(); i++) {
            System.out.println(" " + i + ". " + memberDetails.getEntry(i));
        }
        System.out.println("=================================================================================================");

        System.out.println("Enter member ID to remove: ");
        String id = scan.nextLine();

        if (memberDetails.contains(new Member(id))) {
            int position = memberDetails.getPosition(new Member(id));
            System.out.println("\n" + memberDetails.getEntry(position + 1));
            System.out.println("Confirm remove this record ? (Y/N): ");
            char confirmDlt = scan.next().charAt(0);

            if (confirmDlt == 'Y') {
                System.out.println(ANSI_RED + "Member deleted." + ANSI_RESET + "\n");
                memberDetails.remove(new Member(id));
                memberMenu();
            } else {
                memberMenu();
            }
        } else {
            System.out.println(ANSI_RED + "No such member id. Please choose again..." + ANSI_RESET + "\n");
            removeMemberById();
        }
    }

    public void removeMemberByInteger() {
        System.out.println("\t\t\t\t\tMember List");
        memberListHeader();
        for (int i = 1; i <= memberDetails.getLength(); i++) {
            System.out.println(" " + i + ". " + memberDetails.getEntry(i));
        }
        System.out.println("=================================================================================================");
        System.out.println("Choose member to remove: ");
        int requestDlt = scan.nextInt();
        System.out.println("\n" + memberDetails.getEntry(requestDlt));
        System.out.println("Confirm remove this record ? (Y/N): ");
        char confirmDlt = scan.next().charAt(0);
        if (confirmDlt == 'Y') {
            System.out.println(ANSI_RED + "Member deleted." + ANSI_RESET + "\n");
            memberDetails.remove(requestDlt);
            memberMenu();
        } else {
            memberMenu();
        }

    }

    public void memberListHeader() {
        System.out.println("================================================================================================");
        System.out.printf("%-5s%-9s%-20s%-20s%-15s%-15s%s\n", "No.", "ID", "Name", "Register Date", "Gender", "Phone No.", "Idol");
        System.out.println("________________________________________________________________________________________________");
    }

    public void retrieveMember() {
        System.out.println("\t\t\t\t\tMember List");
        memberListHeader();
        for (int i = 1; i <= memberDetails.getLength(); i++) {
            System.out.println(" " + i + ". " + memberDetails.getEntry(i));
        }
        System.out.println("=================================================================================================");
        System.out.println(ANSI_GREEN + "Successfully retrieve member details." + ANSI_RESET + "\n");
        System.out.println("Press any key to continue...");
        scan.nextLine();
        memberMenu();
    }

    public void editMember() {
        Member memberChoose;
        System.out.println("\t\t\t\t\tMember List");
        memberListHeader();
        for (int i = 1; i <= memberDetails.getLength(); i++) {
            System.out.println(" " + i + ". " + memberDetails.getEntry(i));
        }
        System.out.println("=================================================================================================");
        System.out.print("Choose member to update(integer): ");
        int memberUpd = scan.nextInt();
        System.out.println("\n\nMember to update: ");
        memberListHeader();
        memberChoose = (Member) memberDetails.getEntry(memberUpd);
        System.out.println(" 1. " + memberChoose);
        System.out.println("\n\n*************************************");
        System.out.println("*           Update Member           *");
        System.out.println("*************************************");
        System.out.println("1. Name");
        System.out.println("2. Gender");
        System.out.println("3. Phone No");
        System.out.println("4. Back");
        System.out.println("What you want to update ? ");
        int infoUpdate = scan.nextInt();
        scan.nextLine();

        switch (infoUpdate) {
            case 1 -> {
                System.out.println("Enter new name: ");
                String newName = scan.nextLine();
                memberDetails.replace(memberUpd, new Member(memberChoose.getId(), newName, memberChoose.getRegisterDate(), memberChoose.getGender(), memberChoose.getpNo()));
                System.out.println(ANSI_GREEN + "Successfully edit name." + ANSI_RESET + "\n\n");
            }
            case 2 -> {
                System.out.println("Enter new gender: ");
                char newGender = scan.next().charAt(0);
                memberDetails.replace(memberUpd, new Member(memberChoose.getId(), memberChoose.getName(), memberChoose.getRegisterDate(), newGender, memberChoose.getpNo()));
                System.out.println(ANSI_GREEN + "Successfully edit gender." + ANSI_RESET + "\n\n");
            }
            case 3 -> {
                System.out.println("Enter new phone number: ");
                String newpNo = scan.nextLine();
                memberDetails.replace(memberUpd, new Member(memberChoose.getId(), memberChoose.getName(), memberChoose.getRegisterDate(), memberChoose.getGender(), newpNo));
                System.out.println(ANSI_GREEN + "Successfully edit phone number." + ANSI_RESET + "\n\n");
            }
            case 4 ->
                memberMenu();
            default -> {
            }
        }
        memberMenu();
    }

    public void memberReport() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        int no = memberDetails.getLength();
        System.out.println("\n**************************************");
        System.out.println("*          Member Report             *");
        System.out.println("**************************************");
        System.out.println("\t" + dtf.format(now));
        System.out.println("\n\tNumber of Member: " + no);
        System.out.println("**************************************");
        System.out.println(ANSI_GREEN + "Successfully generate member report." + ANSI_RESET);
        System.out.println("\nPress any key to continue...");
        scan.nextLine();
        memberMenu();
    }
}
