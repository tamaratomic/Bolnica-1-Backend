package raf.bolnica1.patient.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import raf.bolnica1.patient.domain.Patient;
import raf.bolnica1.patient.domain.ScheduleExam;
import raf.bolnica1.patient.dto.create.ScheduleExamCreateDto;
import raf.bolnica1.patient.dto.general.ScheduleExamDto;
import raf.bolnica1.patient.repository.PatientRepository;

@Component
@AllArgsConstructor
public class ScheduleExamMapper {

    private PatientRepository patientRepository;

    public ScheduleExam toEntity(ScheduleExamCreateDto scheduleExamCreateDto){
        Patient patient = patientRepository.findByLbp(scheduleExamCreateDto.getLbp()).orElseThrow(()->new RuntimeException(String.format("Patient with lbp %s not found", scheduleExamCreateDto.getLbp())));

        ScheduleExam scheduleExam = new ScheduleExam();
        scheduleExam.setArrived(scheduleExamCreateDto.isArrived());
        scheduleExam.setDateAndTime(scheduleExamCreateDto.getDateAndTime());
        scheduleExam.setDoctorId(scheduleExam.getDoctorId());
        scheduleExam.setLbz(scheduleExam.getLbz());
        scheduleExam.setPatient(patient);

        return scheduleExam;
    }

    public ScheduleExamDto toDto(ScheduleExam scheduleExam){
        ScheduleExamDto scheduleExamDto = new ScheduleExamDto();
        scheduleExamDto.setId(scheduleExam.getId());
        scheduleExamDto.setLbp(scheduleExam.getPatient().getLbp());
        scheduleExamDto.setArrived(scheduleExam.isArrived());
        scheduleExamDto.setDateAndTime(scheduleExam.getDateAndTime());
        scheduleExamDto.setDoctorId(scheduleExam.getDoctorId());

        return scheduleExamDto;
    }
}
