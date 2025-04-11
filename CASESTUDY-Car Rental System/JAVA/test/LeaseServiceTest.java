package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import dao.ICarLeaseRepository;
import dao.ICarLeaseRepositoryImpl;
import entity.lease;
import java.io.IOException;
import java.sql.SQLException;

public class LeaseServiceTest {

    @Test
    public void testLeaseCreatedSuccessfully() throws SQLException, IOException, ClassNotFoundException {
        // Arrange
        ICarLeaseRepository repository = new ICarLeaseRepositoryImpl();
        int customerId = 1; // Ensure this customer exists in the database
        int carId = 11;     // Ensure this car exists in the database and is available
        String startDate = "2025-04-10";
        String endDate = "2025-04-15";

        // Act
        lease lease = repository.createLease(customerId, carId, startDate, endDate);

        // Assert
        assertNotNull(lease, "Lease should be created successfully");
        assertEquals(customerId, lease.getCustomer_id(), "Lease should be linked to the correct customer");
        assertEquals(carId, lease.getVehicle_id(), "Lease should be linked to the correct car");
    }
}
