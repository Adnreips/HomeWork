package project1.lesson15.dao;

import org.mockito.Mock;
import project1.lesson15.catalog.Catalog;
import project1.lesson15.connection.ConnectionManager;
import project1.lesson15.connection.ConnectionManagerJdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
    private Catalog mobile;

//    @BeforeEach
//    void setUp() throws IOException {
//        initMocks(this);
//        connectionManager = spy(ConnectionManagerJdbc.getInstance());
//        connection = mock(Connection.class);
//        catalogDao = spy(new CatalogDaoJdbc(connectionManager));
//        mobile     = new Catalog(1, "Iphone", 100000, "USA");
//
//    }

//    @Test
//    void addCatalog() throws IOException, SQLException {
//        when(connectionManager.getConnection()).thenReturn(connection);
//        doReturn(preparedStatement).when(connection).prepareStatement(CatalogDaoJdbc.INSERT_INTO_CATALOG, Statement.RETURN_GENERATED_KEYS);
//        doReturn(resultSetMock).when(preparedStatement).getGeneratedKeys();
//        when(resultSetMock.next()).thenReturn(true);
//        when(resultSetMock.getLong(1)).thenReturn(1L);
//        Long result = catalogDao.addCatalog(mobile);
//        verify(connectionManager, times(1)).getConnection();
//        assertAll("assert all",
//                () -> assertEquals(1L, result),
//                () -> assertNotEquals(2, result));
//    }

//    @Test
//    void addCatalogWithSqlException() throws IOException, SQLException {
//        when(connectionManager.getConnection()).thenReturn(connection);
//        doReturn(preparedStatement).when(connection).prepareStatement(CatalogDaoJdbc.INSERT_INTO_CATALOG, Statement.RETURN_GENERATED_KEYS);
//        doThrow(new SQLException("HELLO!")).when(preparedStatement).executeUpdate();
//        Long result = assertDoesNotThrow(() -> catalogDao.addCatalog(mobile));
//
//        verify(connectionManager, times(1)).getConnection();
//        verify(connection, times(1)).prepareStatement(CatalogDaoJdbc.INSERT_INTO_CATALOG, Statement.RETURN_GENERATED_KEYS);
//        verify(preparedStatement, atMost(2)).setString(anyInt(), anyString());
//        verify(preparedStatement, never()).executeQuery();
//        verify(preparedStatement, times(1)).executeUpdate();
//        assertEquals(0L, result);
//    }
}