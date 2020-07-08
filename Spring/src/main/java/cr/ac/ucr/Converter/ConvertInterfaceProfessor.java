package cr.ac.ucr.Converter;

import cr.ac.ucr.DTO.ProfessorDTO;
import cr.ac.ucr.DTO.UserProfileDTO;
import cr.ac.ucr.spa.Professor;
import cr.ac.ucr.spa.UserProfile;

public interface ConvertInterfaceProfessor<T, T1> {

    public Professor toEntity(ProfessorDTO dto);
    public ProfessorDTO toDto(Professor entity);

}
