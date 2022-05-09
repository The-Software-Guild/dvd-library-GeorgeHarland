package com.mthree.c216.dvdlibrary.dao;

import com.mthree.c216.dvdlibrary.dto.Dvd;

import java.util.List;

public interface DvdLibraryDao {

    List<Dvd> getAllDvds();

    Dvd findAndDisplayDvd(String titleSearch);

    Dvd getDvd(String dvdId);

    Dvd addDvd(String dvdId, Dvd dvd);

    Dvd editDvd(String dvdId);

    Dvd removeDvd(String dvdId);

}
