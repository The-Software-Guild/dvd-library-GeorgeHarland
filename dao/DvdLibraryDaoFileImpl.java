package com.mthree.c216.dvdlibrary.dao;

import com.mthree.c216.dvdlibrary.dto.Dvd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DvdLibraryDaoFileImpl implements DvdLibraryDao {

    private Map<String, Dvd> dvdMap = new HashMap<>();

    @Override
    public List<Dvd> getAllDvds() {
        return new ArrayList<Dvd>(dvdMap.values());
    }

    @Override
    public Dvd getDvd(String dvdId) {
        return dvdMap.get(dvdId);
    }

    @Override
    public Dvd findAndDisplayDvd(String titleSearch) {
        return null;
    }

    @Override
    public Dvd addDvd(String dvdId, Dvd dvd) {
        Dvd newDvd = dvdMap.put(dvdId, dvd);
        return newDvd;
    }

    @Override
    public Dvd editDvd(String dvdId) {
        return null;
    }

    @Override
    public Dvd removeDvd(String dvdId) {
        Dvd removedDvd = dvdMap.remove(dvdId);
        return removedDvd;
    }
}
