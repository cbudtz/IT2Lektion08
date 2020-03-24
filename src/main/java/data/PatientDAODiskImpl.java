package data;

import data.dto.PatientDTO;

import java.io.*;
import java.util.UUID;

public class PatientDAODiskImpl implements PatientDAO{
    public String save(PatientDTO patient) {
        String id = UUID.randomUUID().toString();
        patient.setId(id);
        try {
            FileOutputStream fos = new FileOutputStream(id + ".pojo");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(patient);
            return id;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public PatientDTO load(String patientID) {
        try {
            FileInputStream fis = new FileInputStream(patientID + ".pojo");
            ObjectInputStream ois = new ObjectInputStream(fis);
            PatientDTO patient = (PatientDTO) ois.readObject();
            return patient;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
