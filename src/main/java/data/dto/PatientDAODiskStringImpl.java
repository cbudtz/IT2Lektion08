package data.dto;

import data.PatientDAO;

import java.io.*;
import java.util.Arrays;
import java.util.UUID;

public class PatientDAODiskStringImpl implements PatientDAO{
    public String save(PatientDTO patient) {
        String id = UUID.randomUUID().toString();
        patient.setId(id);
        try {
            FileOutputStream fos = new FileOutputStream(id + ".custom");
            fos.write(("name:" + patient.getName()).getBytes() );
            fos.write(";".getBytes());
            fos.write(("id:" + patient.getId()).getBytes());
            return id;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public PatientDTO load(String patientID) {
        try {
            FileInputStream fis = new FileInputStream(patientID + ".custom");
            byte[] bytes = fis.readAllBytes();
            String s = new String(bytes);
            String[] split = s.split(";");
            PatientDTO patientDTO = new PatientDTO(split[0].split(":")[1], split[1].split(":")[1]);
            System.out.println(s);
            return patientDTO;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
