package mx.edu.utez.pokemon.model.CitaMedica;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICitaMedicaRepository extends MongoRepository<CitaMedica,Long> {
     CitaMedica findByMedicalConsultation(String consultation);
     Boolean existsById(String id);
     void deleteById(String id);
}
