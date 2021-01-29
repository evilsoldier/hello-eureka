package webshop;

import ch.vorburger.exec.ManagedProcessException;
import ch.vorburger.mariadb4j.springframework.MariaDB4jSpringService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import webshop.service.ClientService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class WebshopApplicationTests {

    @Autowired
    public ClientService clientService;

    @Autowired
    public MariaDB4jSpringService db;

    // Cant make @Before to work :(
    public void init() throws ManagedProcessException {
        db.getDB().createDB("test", "root", "");
        db.getDB().run("CREATE TABLE test.client (" +
                "ID INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(255)," +
                "email VARCHAR(255)" +
                ") ENGINE=INNODB", "root", "", "test");

        db.getDB().run("select * from test.client;");
        db.getDB().run("INSERT INTO test.client (name, email) values ('Gosho', 'evilsoldier@abv.bg')");
    }

    @Test
    void contextLoads() throws ManagedProcessException {
        init();
        System.out.println("kuuuuuuuuuuuuuuuuuuur");

        Assertions.assertEquals(clientService.getAllClients().size(), 1L);

        db.stop();
    }
}
