package com.mthree.c216.dvdlibrary.dao;

import com.mthree.c216.dvdlibrary.dto.Dvd;

import java.io.*;
import java.util.*;

public class DvdLibraryDaoFileImpl implements DvdLibraryDao {

    public static final String LIBRARY_FILE = "dvdLibrary.txt";
    public static final String DELIMITER = "::";

    private Map<String, Dvd> dvdMap = new HashMap<>();

    @Override
    public List<Dvd> getAllDvds() throws DvdLibraryDaoException {
        loadLibrary();
        return new ArrayList(dvdMap.values());
    }

    @Override
    public Dvd getDvd(String dvdId) throws DvdLibraryDaoException {
        loadLibrary();
        return dvdMap.get(dvdId);
    }

    @Override
    public Dvd findAndDisplayDvd(String titleSearch) {
        return null;
    }

    @Override
    public Dvd addDvd(String dvdId, Dvd dvd)
            throws DvdLibraryDaoException {
        loadLibrary();
        Dvd newDvd = dvdMap.put(dvdId, dvd);
        writeLibrary();
        return newDvd;
    }

    @Override
    public Dvd editDvd(String dvdId) {
        return null;
    }

    @Override
    public Dvd removeDvd(String dvdId) throws DvdLibraryDaoException {
        loadLibrary();
        Dvd removedDvd = dvdMap.remove(dvdId);
        writeLibrary();
        return removedDvd;
    }

    private Dvd unmarshallDvd(String dvdAsText) {
        String[] dvdTokens = dvdAsText.split(DELIMITER);
        String dvdId = dvdTokens[0];
        Dvd dvdFromFile = new Dvd(dvdId);
        dvdFromFile.setTitle(dvdTokens[1]);
        dvdFromFile.setReleaseDate(dvdTokens[2]);
        dvdFromFile.setMpaaRating(dvdTokens[3]);
        dvdFromFile.setDirectorsName(dvdTokens[4]);
        dvdFromFile.setStudio(dvdTokens[5]);
        dvdFromFile.setUserNotes(dvdTokens[6]);
        return dvdFromFile;
    }

    private void loadLibrary() throws DvdLibraryDaoException {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new DvdLibraryDaoException("-_- Could not load roster data into memory.", e);
        }
        String currentLine;
        Dvd currentDvd;
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into a Dvd
            currentDvd = unmarshallDvd(currentLine);
            dvdMap.put(currentDvd.getDvdId(), currentDvd);
        }
        scanner.close();
    }

    private String marshallDvd(Dvd aDvd){
        String dvdAsText = aDvd.getDvdId() + DELIMITER;
        dvdAsText += aDvd.getTitle() + DELIMITER;
        dvdAsText += aDvd.getReleaseDate() + DELIMITER;
        dvdAsText += aDvd.getMpaaRating() + DELIMITER;
        dvdAsText += aDvd.getDirectorsName() + DELIMITER;
        dvdAsText += aDvd.getStudio() + DELIMITER;
        dvdAsText += aDvd.getUserNotes() + DELIMITER;
        return dvdAsText;
    }

    private void writeLibrary() throws DvdLibraryDaoException {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(LIBRARY_FILE));
        } catch (IOException e) {
            throw new DvdLibraryDaoException("Could not save DVD data.", e);
        }
        String dvdAsText;
        List<Dvd> studentList = this.getAllDvds();
        for (Dvd currentDvd : studentList) {
            dvdAsText = marshallDvd(currentDvd);
            out.println(dvdAsText);
            out.flush();
        }
        out.close();
    }
}
