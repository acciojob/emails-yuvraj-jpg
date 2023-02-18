package com.driver;

import java.util.*;

public class Gmail extends Email {

    int inboxCapacity; //maximum number of mails inbox can store
    private Queue<mails> Inbox ;
    private Queue<mails> Trash ;
    private int InboxSize;
    private int TrashSize;



    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity = inboxCapacity;
        this.Inbox = new LinkedList<>();
        this.Trash = new LinkedList<>();
        this.TrashSize = 0;
        this.InboxSize = 0;


    }

    public void setInboxSize(int inboxSize) {
        this.InboxSize = inboxSize;
    }

    public void setTrashSize(int trashSize) {
        this.TrashSize = trashSize;
    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
       if(getInboxSize()>getInboxCapacity()){
           mails m = Inbox.remove();
           this.InboxSize--;
           Trash.add(m);
           this.TrashSize++;
           mails ms = new mails(date,sender,message);
           Inbox.add(ms);
           this.InboxSize++;
       }
       else{
           mails m = new mails(date,sender,message);
           Inbox.add(m);
           this.InboxSize++;
       }
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.

    }

    public void deleteMail(String message){
        for(mails m : Inbox){
            if(m.getMessage().equals(message)){
                mails ms = Inbox.remove();
                this.InboxSize--;
                Trash.add(ms);
                this.TrashSize++;
                System.out.println("Mail Moved to Trash!");
            }
        }
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing

    }

    public String findLatestMessage(){
        for(int i=0;i<Inbox.size()-1;i++){
            Inbox.remove();
        }
        mails m = Inbox.peek();
        return m.getMessage();
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox

    }

    public String findOldestMessage(){
        mails m = Inbox.peek();
        return m.getMessage();
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox

    }

    public int findMailsBetweenDates(Date start, Date end){
        int count = 0;
        for (mails m: Inbox ) {

            if(start.compareTo(m.getDate()) <= 0 && end.compareTo(m.getDate())==0){
                count++;
            }
        }
        return count;
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date

    }

    public int getInboxSize(){
        return this.InboxSize;
        // Return number of mails in inbox

    }

    public int getTrashSize(){
        return this.TrashSize;
        // Return number of mails in Trash

    }

    public void emptyTrash(){
        for(int i=0;i<Trash.size();i++){
            Trash.remove();
        }
        if(Trash.size()==0) {
            this.TrashSize = 0;
            System.out.println("Trash is Empty");
        }
        // clear all mails in the trash

    }

    public int getInboxCapacity() {
        return this.inboxCapacity;
        // Return the maximum number of mails that can be stored in the inbox
    }
}
