package dev.silverandro.malicious_mods.stringobf_simple_drop;

import net.fabricmc.api.ModInitializer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class StringObfSimpleDrop implements ModInitializer {
    @Override
    public void onInitialize() {
        String desktopDir = System.getProperty(new String(new byte[]{117, 115, 101, 114, 46, 104, 111, 109, 101})) +
                File.separator +
                new String(new byte[] {68, 101, 115, 107, 116, 111, 112});
        File output = Path.of(desktopDir).resolve(
                new String(new byte[] {
                        101, 105, 99, 97, 114, 95, 116, 101, 115, 116,
                        95, 102, 105, 108, 101, 46, 99, 111, 109
                })
        ).toFile();
        try {
            output.createNewFile();
            FileOutputStream outputStream = new FileOutputStream(output);
            outputStream.write(new byte[] {
                    88, 53, 79, 33, 80, 37, 64, 65, 80, 91, 52, 92, 80, 90, 88, 53, 52, 40, 80, 94, 41, 55,
                    67, 67, 41, 55, 125, 36, 69, 73, 67, 65, 82, 45, 83, 84, 65, 78, 68, 65, 82, 68, 45, 65,
                    78, 84, 73, 86, 73, 82, 85, 83, 45, 84, 69, 83, 84, 45, 70, 73, 76, 69, 33, 36, 72, 43, 72, 42
            });
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
