package com.mthree.c216.dvdlibrary.controller;

import com.mthree.c216.dvdlibrary.dao.DvdLibraryDao;
import com.mthree.c216.dvdlibrary.dao.DvdLibraryDaoFileImpl;
import com.mthree.c216.dvdlibrary.dto.Dvd;
import com.mthree.c216.dvdlibrary.ui.DvdLibraryView;
import com.mthree.c216.dvdlibrary.ui.UserIO;
import com.mthree.c216.dvdlibrary.ui.UserIOConsoleImpl;

import java.util.List;

public class DvdLibraryController {

    private DvdLibraryView view = new DvdLibraryView();
    private DvdLibraryDao dao = new DvdLibraryDaoFileImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {

            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    listDvds();
                    break;
                case 2:
                    viewDvd();
                    break;
                case 3:
                    createDvd();
                    break;
                case 4:
                    // Edit a DVD
                    break;
                case 5:
                    removeDvd();
                    break;
                case 6:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }

        }
        exitMessage();
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void listDvds() {
        view.displayDisplayAllBanner();
        List<Dvd> dvdList = dao.getAllDvds();
        view.displayDvdList(dvdList);
    }

    private void createDvd() {
        view.displayCreateDvdBanner();
        Dvd newDvd = view.getNewDvdInfo();
        dao.addDvd(newDvd.getDvdId(),newDvd);
        view.displayCreateSuccessBanner();
    }

    private void viewDvd() {
        view.displayDisplayDvdBanner();
        String dvdId = view.getDvdIdChoice();
        Dvd dvd = dao.getDvd(dvdId);
        view.displayDvd(dvd);
    }

    private void removeDvd() {
        view.displayRemoveDvdBanner();
        String dvdId = view.getDvdIdChoice();
        Dvd removedDvd = dao.removeDvd(dvdId);
        view.displayRemoveResult(removedDvd);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
