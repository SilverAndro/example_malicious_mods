package dev.silverandro.malicious_mods.simple_drop;

import dev.silverandro.malicious_mods.Constants;
import net.fabricmc.api.ModInitializer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class SimpleDropMod implements ModInitializer {
    @Override
    public void onInitialize() {
        String desktopDir = System.getProperty("user.home") + File.separator + "Desktop";
        File output = Path.of(desktopDir).resolve(Constants.EICAR_FILE_NAME).toFile();
        try {
            output.createNewFile();
            FileOutputStream outputStream = new FileOutputStream(output);
            outputStream.write(Constants.EICAR_FILE_CONTENTS.getBytes(StandardCharsets.UTF_8));
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
