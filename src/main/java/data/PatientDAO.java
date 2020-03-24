package data;

import data.dto.PatientDTO;

public interface PatientDAO {
    String save(PatientDTO patient); //Return identifier
    PatientDTO load(String patientID);
}
