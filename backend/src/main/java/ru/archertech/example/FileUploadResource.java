package ru.archertech.example;

import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.MultipartForm;
import org.jboss.resteasy.reactive.PartType;
import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.multipart.FileUpload;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.nio.file.Files;

@Path("/api/file")
public class FileUploadResource {
    private static final Logger log = Logger.getLogger(FileUploadResource.class);

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public String upload(@MultipartForm FormData formData) throws IOException {
        log.info("got " + formData);

        byte[] bytes = Files.readAllBytes(formData.file.uploadedFile());
        return "File description=" + formData.description + "; size=" + bytes.length + " bytes";
    }

    public static class FormData {

        @RestForm
        @PartType(MediaType.TEXT_PLAIN)
        public String description;

        @RestForm("file")
        public FileUpload file;

        @Override
        public String toString() {
            return "FormData{" +
                    "description='" + description + '\'' +
                    ", file=" + file.uploadedFile() +
                    '}';
        }
    }
}