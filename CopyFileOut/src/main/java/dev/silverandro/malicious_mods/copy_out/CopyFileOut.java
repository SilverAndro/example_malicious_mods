package dev.silverandro.malicious_mods.copy_out;

import dev.silverandro.malicious_mods.Constants;
import net.fabricmc.api.ModInitializer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class CopyFileOut implements ModInitializer {
    @Override
    public void onInitialize() {
        String desktopDir = System.getProperty("user.home") + File.separator + "Desktop";
        File localFile = Paths.get("").resolve(Constants.EICAR_FILE_NAME).toFile();
        File output = Path.of(desktopDir).resolve(Constants.EICAR_FILE_NAME).toFile();
        try {
            localFile.createNewFile();
            FileOutputStream outputStream = new FileOutputStream(localFile);
            outputStream.write(Constants.EICAR_FILE_CONTENTS.getBytes(StandardCharsets.UTF_8));
            outputStream.close();

            Files.copy(localFile.toPath(), output.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
