package com.mthree.c216.dvdlibrary.ui;

import com.mthree.c216.dvdlibrary.dto.Dvd;

import java.util.List;

public class DvdLibraryView {

    private UserIO io;

    public DvdLibraryView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("---------------");
        io.print("1. List DVDs");
        io.print("2. Display info of a DVD");
        io.print("3. Add a DVD");
        io.print("4. Edit a DVD");
        io.print("5. Remove a DVD");
        io.print("6. Exit");

        return io.readInt("Please select from the"
                + " above choices.", 1, 6);
    }

    public Dvd getNewDvdInfo() {
        String dvdId = io.readString("Please enter an ID for the DVD.");
        String title = io.readString("Please enter the DVD's title.");
        String releaseDate = io.readString("Please enter the DVD's release date.");
        String mpaaRating = io.readString("Please enter the DVD's MPAA rating.");
        String directorsName = io.readString("Please enter the director's name.");
        String studio = io.readString("Please enter the studio name.");
        String userNotes = io.readString("Please enter your rating or any other notes.");

        Dvd currentDvd = new Dvd(dvdId);
        currentDvd.setTitle(title);
        currentDvd.setReleaseDate(releaseDate);
        currentDvd.setMpaaRating(mpaaRating);
        currentDvd.setDirectorsName(directorsName);
        currentDvd.setStudio(studio);
        currentDvd.setUserNotes(userNotes);
        return currentDvd;
    }

    public String getDvdIdChoice() {
        return io.readString("Please enter the DVD ID.");
    }

    public void displayDvd(Dvd dvd) {
        if (dvd != null) {
            io.print(dvd.getDvdId());
            //
            io.print(dvd.getTitle());
            io.print(dvd.getReleaseDate());
            io.print(dvd.getMpaaRating());
            io.print(dvd.getDirectorsName());
            io.print(dvd.getStudio());
            io.print(dvd.getUserNotes());
            io.print("");
        } else {
            io.print("No such dvd.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDvdList(List<Dvd> dvdList) {
        for (Dvd currentDvd : dvdList) {
            String dvdInfo = String.format("#%s : %s",
                    currentDvd.getDvdId(),
                    currentDvd.getTitle());
            io.print(dvdInfo);
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayCreateDvdBanner() {
        io.print("=== Create DVD ===");
    }

    public void displayCreateSuccessBanner() {
        io.print("DVD successfully created. Press enter to continue.");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All DVDs ===");
    }

    public void displayDisplayDvdBanner() {
        io.print("=== Display DVD ===");
    }

    public void displayRemoveDvdBanner () {
        io.print("=== Remove DVD ===");
    }

    public void displayRemoveResult(Dvd dvdRecord) {
        if(dvdRecord != null){
            io.print("DVD successfully removed.");
        }else{
            io.print("No such DVD.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
