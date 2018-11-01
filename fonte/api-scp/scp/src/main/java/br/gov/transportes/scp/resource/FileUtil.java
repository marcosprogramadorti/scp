package br.gov.transportes.scp.resource;


import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class FileUtil {
	
    public static File streamToFile (InputStream in, String nmArquivoCriptografado) throws IOException {
        String tempDir = FileUtils.getTempDirectoryPath();
        if (!tempDir.endsWith(File.separator)) {
            tempDir += File.separator;
        }
        File tempFile = new File(tempDir + nmArquivoCriptografado);
        tempFile.deleteOnExit();
        try (FileOutputStream out = new FileOutputStream(tempFile)) {
            IOUtils.copy(in, out);
        }
        return tempFile;
    }
}
