package project1.lesson15.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import project1.lesson15.catalog.Catalog;
import project1.lesson15.connection.ConnectionManager;
import project1.lesson15.connection.ConnectionManagerJdbc;

import java.io.IOException;
import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * CatalogDaoJdbcTest
 *
 * @author "Andrei Prokofiev"
 */
class CatalogDaoJdbcTest {

    @Mock
    private CatalogDao catalogDao;
    private ConnectionManagerJdbc connectionManagerJdbc;
    private ConnectionManager connectionManager;
    private Connection connection;
    @Mock
    private PreparedStatement preparedStatement;
    @Mock
    private ResultSet resultSetMock;

    @BeforeEach
    void setUp() throws IOException {
        initMocks(this);
        connectionManager = spy(ConnectionManagerJdbc.getInstance());
        connection = mock(Connection.class);
        catalogDao = spy(new CatalogDaoJdbc(connectionManager));

    }

    @Test
    void addCatalog() throws IOException, SQLException {
        when(connectionManager.getConnection()).thenReturn(connection);
        doReturn(preparedStatement).when(connection).prepareStatement(CatalogDaoJdbc.INSERT_INTO_CATALOG, Statement.RETURN_GENERATED_KEYS);
        doReturn(resultSetMock).when(preparedStatement).getGeneratedKeys();
        when(resultSetMock.next()).thenReturn(true);
        when(resultSetMock.getLong(1)).thenReturn(1L);
        Catalog mobile     = new Catalog(1, "Iphone", 100000, "USA");
        Long result = catalogDao.addCatalog(mobile);

        verify(connectionManager, times(1)).getConnection();
        assertAll("assert all",
                () -> assertEquals(1L, result),
                () -> assertNotEquals(2, result));
    }

    @Test
    void getCatalogById() {

    }

    @Test
    void updateCatalogById() {
    }

    @Test
    void deleteCatalogById() {
    }

    @Test
    void renewDatabase() {
    }
}