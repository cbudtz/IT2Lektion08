package data;

import data.dto.PatientDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientDAOTest {
    PatientDAO dao = new PatientDAODiskImpl();
    PatientDTO patientDTO = new PatientDTO("Brian",null);
    static String patientId = null;

    @Test
    void save() {
        patientId = dao.save(patientDTO);
        patientDTO.setId(patientId);
        assertNotNull(patientId);
    }

    @Test
    void SaveAndLoad() {
        patientId = dao.save(patientDTO);
        patientDTO.setId(patientId);
        assertNotNull(patientId);
        PatientDTO load = dao.load(patientId);
        assertNotNull(load);
        assertEquals("Brian",load.getName());

    }
}