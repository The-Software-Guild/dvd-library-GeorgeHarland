package com.mthree.c216.dvdlibrary.dao;

import com.mthree.c216.dvdlibrary.dto.Dvd;

import java.util.List;

public interface DvdLibraryDao {

    List<Dvd> getAllDvds() throws DvdLibraryDaoException;

    Dvd findAndDisplayDvd(String titleSearch);

    Dvd getDvd(String dvdId) throws DvdLibraryDaoException;

    Dvd addDvd(String dvdId, Dvd dvd) throws DvdLibraryDaoException;

    Dvd editDvd(String dvdId);

    Dvd removeDvd(String dvdId) throws DvdLibraryDaoException;

}
