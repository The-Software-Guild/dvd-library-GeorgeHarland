package com.mthree.c216.dvdlibrary;

import com.mthree.c216.dvdlibrary.controller.DvdLibraryController;
import com.mthree.c216.dvdlibrary.dao.DvdLibraryDao;
import com.mthree.c216.dvdlibrary.dao.DvdLibraryDaoException;
import com.mthree.c216.dvdlibrary.dao.DvdLibraryDaoFileImpl;
import com.mthree.c216.dvdlibrary.ui.DvdLibraryView;
import com.mthree.c216.dvdlibrary.ui.UserIO;
import com.mthree.c216.dvdlibrary.ui.UserIOConsoleImpl;

public class App {

    public static void main(String[] args) throws DvdLibraryDaoException {
        UserIO myIo = new UserIOConsoleImpl();
        DvdLibraryView myView = new DvdLibraryView(myIo);
        DvdLibraryDao myDao = new DvdLibraryDaoFileImpl();
        DvdLibraryController controller =
                new DvdLibraryController(myDao, myView);
        controller.run();
    }
}
