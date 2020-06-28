package project1.lesson15.client;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
import static org.mockito.Mockito.spy;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * ClientServesTest
 *
 * @author "Andrei Prokofiev"
 */
@TestInstance(PER_CLASS)
class ClientServesTest {
    @Mock
    private ClientServes clientServes;
    @Mock
    private Client client;
    @Mock
    private Client client1;
    @Mock
    private Client client2;
    private static final Logger LOGGER = LogManager.getLogger(ClientServesTest.class);



    @BeforeAll
    public void setUp() {
//        initMocks(this);
        clientServes = spy(new ClientServes());
        client = spy(new Client("Anton", LocalDate.of(1982, 01, 28)));
        client1 = spy(new Client("Anton", LocalDate.of(1983, 01, 28)));
        client2 = spy(new Client(null, LocalDate.of(1983, 01, 28)));

        clientServes.regClient(client);
        clientServes.logClient(client);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void regClientWithTheSameData() {
        clientServes.regClient(client);
        assertEquals(clientServes.getRegClients().size(), 1);
    }
    @Test
    void regThrowException(){
        Throwable throwable = assertThrows(RuntimeException.class, ()->clientServes.regClient(client2));
        assertNotNull(throwable.getMessage());
    }

    @Test
    void logClientWithOutRegistration() {
        assertEquals(clientServes.getLogClients().size(), 1);
        try{
            clientServes.logClient(client1);}
        catch (RuntimeException e){
            LOGGER.throwing(Level.WARN, e);
        }
        assertEquals(clientServes.getLogClients().size(), 1);

    }

    @Test
    void removeClient() {
        assertEquals(clientServes.getRegClients().size(), 1);
        clientServes.removeClient(client);
        assertEquals(clientServes.getRegClients().size(), 0);

    }

    @Test
    void regClientWithNullData() {
        clientServes.removeClient(client2);
        assertEquals(clientServes.getRegClients().size(), 1);
    }
    


}