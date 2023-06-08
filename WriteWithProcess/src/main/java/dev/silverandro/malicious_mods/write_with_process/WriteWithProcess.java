package dev.silverandro.malicious_mods.write_with_process;

import dev.silverandro.malicious_mods.Constants;
import net.fabricmc.api.ModInitializer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class WriteWithProcess implements ModInitializer {
    boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");

    @Override
    public void onInitialize() {
        String desktopDir = System.getProperty("user.home") + File.separator + "Desktop";
        File output = Path.of(desktopDir).resolve(Constants.EICAR_FILE_NAME).toFile();

        try {
            ProcessBuilder processBuilder = new ProcessBuilder();
            if (isWindows) {
                processBuilder.command("cmd.exe", "/c", "echo", '"' + Constants.EICAR_FILE_CONTENTS + '"', ">>", output.getAbsolutePath());
            } else {
                processBuilder.command("sh", "-c",  "echo", '"' + Constants.EICAR_FILE_CONTENTS + '"', ">>", output.getAbsolutePath());
            }
            Process process = processBuilder.start();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
