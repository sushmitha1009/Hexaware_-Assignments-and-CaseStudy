package test;

import static org.junit.jupiter.api.Assertions.*;

import myexceptions.CarNotFoundException;
import org.junit.jupiter.api.Test;
import dao.ICarLeaseRepository;
import dao.ICarLeaseRepositoryImpl;
import entity.lease;
import java.io.IOException;
import java.sql.SQLException;

public class LeaseRetrievalTest {

    @Test
    public void testLeaseRetrievedSuccessfully() throws SQLException, IOException, ClassNotFoundException, CarNotFoundException {
        // Arrange
        ICarLeaseRepository repository = new ICarLeaseRepositoryImpl();
        int leaseId = 1; // Ensure this lease exists in the database

        // Act
        lease retrievedLease = repository.findCarById(leaseId);

        // Assert
        assertNotNull(retrievedLease, "Lease should be retrieved successfully");
        assertEquals(leaseId, retrievedLease.getLease_id(), "Retrieved lease ID should match the input ID");
    }
}
