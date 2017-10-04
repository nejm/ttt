package com.smi.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UploadController {

    @RequestMapping(value = "/continueFileUpload", method = RequestMethod.GET)
    public String continueFileUploadGet() {
        return "fileUpload";
    }

    @RequestMapping(value = "/continueFileUpload", method = RequestMethod.POST)
    @ResponseBody
    public String continueFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        byte[] bytes;

        if (!file.isEmpty()) {
            bytes = file.getBytes();
            //store file in storage
        }

        System.out.println(String.format("receive %s", file.getOriginalFilename()));

        String fileName = file.getOriginalFilename();
        System.out.println(fileName);

        java.nio.file.Path path = Paths.get("C:/Demo/" + fileName);
        Files.deleteIfExists(path);
        InputStream in = file.getInputStream();
        Files.copy(in, path);
//        MultipartHttpServletRequest mRequest;
//        try {
//            mRequest = (MultipartHttpServletRequest) request;
//            mRequest.getParameterMap();
//
//            Iterator itr = mRequest.getFileNames();
//            while (itr.hasNext()) {
//                MultipartFile mFile = mRequest.getFile((String) itr.next());
//                String fileName = mFile.getOriginalFilename();
//                System.out.println(fileName);
//
//                java.nio.file.Path path = Paths.get("C:/Demo/" + fileName);
//
//                try {
//                    Class.forName("oracle.jdbc.driver.OracleDriver");
//                    Connection con = DriverManager.getConnection(
//                            "jdbc:oracle:thin:@localhost:1521:xe", "system", "eddine1992");
//
//                    PreparedStatement ps = con.prepareStatement(
//                            "insert into test.files values(?,?)");
//
//                    File f = new File(fileName);
//                    f.createNewFile();
//                    FileOutputStream fos = new FileOutputStream(f);
//                    fos.write(mFile.getBytes());
//                    fos.close();
//
//                    FileReader fr = new FileReader(f);
//
//                    ps.setInt(1, 101);
//                    ps.setCharacterStream(2, fr, (int) f.length());
//                    int i = ps.executeUpdate();
//                    System.out.println(i + " records affected");
//
//                    con.close();
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//                Files.deleteIfExists(path);
//                InputStream in = mFile.getInputStream();
//                Files.copy(in, path);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        return null;
    }

}
