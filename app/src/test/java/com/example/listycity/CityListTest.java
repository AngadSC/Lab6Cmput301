package com.example.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }
    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });

    }
    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity() {
        CityList list = mockCityList();
        City edmonton = new City("Edmonton", "Alberta");
        City calgary = new City("Calgary", "Alberta");
        assertTrue(list.hasCity(edmonton));
        assertFalse(list.hasCity(calgary));


    }
    @Test
    void testRemove_city() {
        CityList list = mockCityList();
        City calgary = new City("Calgary", "Alberta");
        list.add(calgary);
        assertTrue(list.hasCity(calgary));
        list.delete(calgary);
        assertFalse(list.hasCity(calgary));
    }
    @Test
    void testDelete() {
        CityList list = mockCityList();
        City beaumont = new City("Beaumont", "Alberta");
        assertThrows(IllegalArgumentException.class, () -> list.delete(beaumont));
    }
    @Test
    void testCountCities() {
        CityList list = new CityList();
        assertEquals(0,list.countCities());
        list.add(new City ("calgary","alberta"));
        list.add(new City("edmonton", "alberta"));
        assertEquals(2,list.countCities());
    }
}

