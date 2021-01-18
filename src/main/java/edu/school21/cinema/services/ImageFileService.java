package edu.school21.cinema.services;

import edu.school21.cinema.config.CinemaConfig;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;

public class ImageFileService {

    @Autowired
    private CinemaConfig cinemaConfig;

    public void saveImage(long imageId, byte[] imageBytes) throws IOException {
        File save = new File(cinemaConfig.getFileStoragePath(), String.valueOf(imageId));
        if (!save.createNewFile()) {
            throw new IOException("File already exists!");
        }
        FileUtils.writeByteArrayToFile(save, imageBytes);
    }

    public File getImageFile(String imageId) {
        try {
            File result = new File(cinemaConfig.getFileStoragePath() + "/" + imageId);
            if (result.exists()) {
                return result;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
}
