package com.smi.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.pool.OracleDataSource;
import org.json.simple.JSONObject;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShowUpload {

    @RequestMapping(value = "/showFileUpload", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity showFileUploadGet1() throws FileNotFoundException, IOException {
        ResponseEntity respEntity = null;
        byte[] reportBytes = null;
        File result = new File("C:/Demo/cahier.pdf");

        if (result.exists()) {
            InputStream inputStream = new FileInputStream(result);
            byte[] out = org.apache.commons.io.IOUtils.toByteArray(inputStream);
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.add("content-disposition", "attachment; filename=cahier.pdf");
            respEntity = new ResponseEntity(out, responseHeaders, HttpStatus.OK);
        } else {
            respEntity = new ResponseEntity("File Not Found", HttpStatus.OK);
        }
        return respEntity;

    }

    @RequestMapping(value = "/showFileByName", method = RequestMethod.POST)
    public FileSystemResource showFileUploadGet(@RequestBody String name) throws FileNotFoundException, IOException {
        File file = new File(name);
        return new FileSystemResource(file);
    }

    private List<Clob> getAllResult() throws SQLException {
        OracleDataSource dataSource = new OracleDataSource();
        List<Clob> list = new ArrayList<>();
        dataSource.setServerName("127.0.0.1");
        dataSource.setUser("system");
        dataSource.setPassword("eddine1992");
        dataSource.setDatabaseName("XE");
        dataSource.setPortNumber(1521);
        dataSource.setDriverType("thin");

        OracleConnection ocon = (OracleConnection) dataSource.getConnection();
        Statement stmt = ocon.createStatement();
        ResultSet rset = stmt.executeQuery("select * from test.files");
        while (rset.next()) {
            list.add(rset.getClob("name"));
        }
        ocon.close();
        return list;
    }
}
