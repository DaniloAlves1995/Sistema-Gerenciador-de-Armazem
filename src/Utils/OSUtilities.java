/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danilo
 */
public class OSUtilities {
    
    /**
    * Get Operational System type. 
    * @return operational system name. 
    */
    public String getOSName() {
        return System.getProperty("os.name");
    }
    
    
    /**
    * Get a directory according OS type. 
    * @param subPath subdirectories to be created or checked
    * @return directory in the OS
    */
    public String getDirectory(String subPath) {
        subPath = "WMS" + subPath;
        String path = "Windows".equals(getOSName()) ? "c:/" + subPath : subPath;
        File li = new File(path);
        if (!li.exists())
            li.mkdirs();
            
        return path;
    }
}
