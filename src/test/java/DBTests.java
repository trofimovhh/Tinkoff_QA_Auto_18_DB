import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.fintech.qa.homework.utils.BeforeUtils;
import ru.fintech.qa.homework.utils.hibernate.DBClient;

import java.util.ArrayList;
import java.util.List;

public class DBTests {

    @BeforeAll
    static void createDB() {
        BeforeUtils.createData();
    }

    @Test
    public void animalQuantityTest() {
        String tableName = "animal";
        int animalQuantity = DBClient.getQuantity(tableName);
        final int expectedQuantity = 10;
        Assertions.assertEquals(expectedQuantity, animalQuantity);
    }

    @Test
    public void animalInsert1to10Test() {
        int insertedAnimalId = DBClient.animalIdWhichCanBeInserted();
        final int expectedAnimalId = 11;
        Assertions.assertEquals(expectedAnimalId, insertedAnimalId);
    }

    @Test
    public void insertWorkmanNullNameTest() {
        String tableName = "workman";
        int numberOfWorkman = DBClient.getQuantity(tableName);
        int workmanToInsertId = numberOfWorkman + 1;
        DBClient.insertWorkman(workmanToInsertId);
        int numberOfWorkmanAfterInsert = DBClient.getQuantity(tableName);
        Assertions.assertEquals(numberOfWorkman, numberOfWorkmanAfterInsert);
    }

    @Test
    public void insert6thPlaceTest() {
        String tableName = "places";
        final int expectedNumberOfPlaces = 6;
        int numberOfPlaces = DBClient.getQuantity(tableName);
        int placeToInsertId = numberOfPlaces + 1;
        DBClient.insertPlace(placeToInsertId);
        int numberOfPlacesAfterInsert = DBClient.getQuantity(tableName);
        DBClient.delPlace(placeToInsertId);
        Assertions.assertEquals(expectedNumberOfPlaces, numberOfPlacesAfterInsert);
    }

    @Test
    public void zooNamesTest() {
        List<String> expectedNameList = new ArrayList<>();
        expectedNameList.add("Центральный");
        expectedNameList.add("Северный");
        expectedNameList.add("Западный");
        List<String> actualNameList = new ArrayList<>();
        String tableName = "zoo";
        int numberOfZoo = DBClient.getQuantity(tableName);
        for (int i = 0; i < numberOfZoo; i++) {
            actualNameList.add(DBClient.getZooNameById(i));
        }
        Assertions.assertIterableEquals(expectedNameList, actualNameList);
    }
}

