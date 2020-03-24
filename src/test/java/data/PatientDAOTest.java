package data;

import data.dto.PatientDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientDAOTest {
    PatientDAO dao = new PatientDAODiskImpl();
    PatientDTO patientDTO = new PatientDTO("Brian",null);
    String patientId = null;


    @Test
    void save() {
        patientId = dao.save(patientDTO);
        patientDTO.setId(patientId);
        assertNotNull(patientId);
    }

    @Test
    void load() {
        PatientDTO load = dao.load(patientId);
        assertNotNull(load);
        assertSame("Brian",load.getName());

    }
}