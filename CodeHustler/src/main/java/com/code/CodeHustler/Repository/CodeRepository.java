package com.code.CodeHustler.Repository;

import com.code.CodeHustler.Model.CodeHustler;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CodeRepository extends MongoRepository<CodeHustler,String > {

    @Query("{'dataStructure':?0}")
    List<CodeHustler> findbyName(String dataStructure);

    @Query("{'dataStructure':?0,'difficulty':?1}")
    List<CodeHustler> findbydataStructureAndDifficulty(String dataStructure , String difficulty);

}
