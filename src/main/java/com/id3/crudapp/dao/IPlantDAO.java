package com.id3.crudapp.dao;

import com.id3.crudapp.dto.Plant;

import java.io.IOException;
import java.util.List;

public interface IPlantDAO {

    List<Plant> fetchPlants(String combinedName) throws IOException;

}
