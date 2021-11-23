package com.vaibhav.sec.controller;

import com.vaibhav.sec.model.*;
import com.vaibhav.sec.repo.*;
import com.vaibhav.sec.responce.ServiceConfigResponse;
import com.vaibhav.sec.responce.ServiceRequest;
import com.vaibhav.sec.responce.ServiceRespo;
import com.vaibhav.sec.responce.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/services")
public class ServiceController {
    @Autowired
    ServiceRepository serviceRepository;
    
    @Autowired
    ServiceCategoryRepo serviceCategoryRepo;
    
    @Autowired
    EmployServiceRepo employServiceRepo;
    
    @Autowired
    EmployRepository employRepository;
    
    @Autowired
    RoomServiceRepo roomServiceRepo;

    @Autowired
    RoomRepository roomRepository;
    @Autowired
    AffectationServicesRepo affectationServicesRepo;
    @GetMapping(value = "/{organizationId}")
    public ResponseEntity<?> getAll( @PathVariable Long organizationId){
        List<ServiceResponse> serviceResponseList = new ArrayList<>();
        List<ServiceRespo> serviceRespoList=new ArrayList<>();
            serviceRepository.findAll().forEach(servic->{
                Set<Employ> employs= new HashSet<>();
                Set<Room> rooms= new HashSet<>();
                employServiceRepo.getByServiceId(servic.getId()).forEach(element->{
                    employs.add(employRepository.findById(element.getEmployId()).get());
                });
                roomServiceRepo.getByServiceId(servic.getId()).forEach(element->{
                    rooms.add(roomRepository.getById(element.getRoomId()));
                });
                List<Services> servicesList=new ArrayList<>();
                affectationServicesRepo.getByAdminServiceId(servic.getId()).forEach(el->{
                    servicesList.add(serviceRepository.getById(el.getUserServicesId()));
                });
                serviceRespoList.add(new ServiceRespo(servic.getId(),servic.getName(),servic.getDescription(),servic.getPrice(),
                        servic.getDateStart(), servic.getImage(),servic.getDateFinish(),servic.getTimeStart(),
                        servic.getTimeFinish(),Boolean.valueOf(servic.getActive()),servic.getDuration(),servic.getTimePreparation(),
                        servic.getOnline(),servic.getPaidOnline(),servic.getMaxEmploy(),servic.getMaxClient(),servic.getGift(),
                        servic.getAtHome(),servic.getDeposit(),servic.getCategoryId(), employs,rooms,
                        servic.getTypeId(),servic.getSessions(),servic.getValidity(),servicesList));
            });


        return ResponseEntity.ok(serviceRespoList);
    }
    @PostMapping(value = "/add/{organizationId}")
    public ResponseEntity<?> addEntity(@RequestBody ServiceRequest services,@PathVariable Long organizationId){
       Services service= serviceRepository.save(new Services(services.getId(),services.getName(), services.getDescription(), services.getPrice(), services.getDateStart(), services.getImage(),
                services.getDateFinish(), services.getTimeStart(), services.getTimeFinish(),Boolean.valueOf(services.getActive()) ,
                services.getDuration(), services.getTimePreparation(), Boolean.valueOf(services.getIsOnline()),
               Boolean.valueOf(services.getIsPaidOnline()), services.getMaxEmploy(),
                services.getMaxClient(),Boolean.valueOf(services.getIsGift()),Boolean.valueOf(services.getAtHome()), Boolean.valueOf(services.getDeposit()),
               services.getCategoryId(), services.getTypeId(),services.getSessions(),services.getValidity(), organizationId));
        for (int i =0;i<services.getEmploys().size();i++){
            EmployService employService= new EmployService();
            employService.setEmployId(services.getEmploys().get(i));
            employService.setServiceId(service.getId());
            employServiceRepo.save(employService);
        }
        for (int i =0;i<services.getRooms().size();i++){
            RoomService roomService = new RoomService();
            roomService.setServiceId(service.getId());
            roomService.setRoomId(services.getRooms().get(i));
            roomServiceRepo.save(roomService);
        }
        return ResponseEntity.ok(service);
    }
    @GetMapping(value = "/update/{organizationId}")
    public ResponseEntity<?> updateEntity(@RequestBody Services services,@PathVariable Long organizationId){
        return ResponseEntity.ok(serviceRepository.save(services));
    }
    @GetMapping(value = "/getByCategory/{id}/{organizationId}")
    public ResponseEntity<?> getByCategoryEntity(@PathVariable Long id,@PathVariable Long organizationId){
        ServiceCategory category = serviceCategoryRepo.findById(id).get();
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setId(category.getId());
        serviceResponse.setServiceType(category.getServiceType());
        serviceResponse.setLabel(category.getLabel());
        //serviceResponse.setServices(serviceRepository.getByCategoryId(id));
        return ResponseEntity.ok(serviceResponse);
    }
    @GetMapping(value = "/getAll/byType/{id}/{organizationId}")
    public ResponseEntity<?> getAllEntity(@PathVariable Long id,@PathVariable Long organizationId){
        List<ServiceCategory> category = serviceCategoryRepo.getByServiceType(id);
        List<ServiceResponse> serviceResponseList = new ArrayList<>();
        for (int i =0 ;i < category.size();i++){
            ServiceResponse serviceResponse = new ServiceResponse();
            serviceResponse.setId(category.get(i).getId());
            serviceResponse.setServiceType(category.get(i).getServiceType());
            serviceResponse.setLabel(category.get(i).getLabel());
            List<ServiceRespo> serviceRespoList=new ArrayList<>();
            serviceRepository.getByCategoryId(category.get(i).getId()).forEach(servic->{
                Set<Employ> employs= new HashSet<>();
                Set<Room> rooms= new HashSet<>();
                employServiceRepo.getByServiceId(servic.getId()).forEach(element->{
                    employs.add(employRepository.findById(element.getEmployId()).get());
                });
                roomServiceRepo.getByServiceId(servic.getId()).forEach(element->{
                    rooms.add(roomRepository.getById(element.getRoomId()));
                });
                List<Services> servicesList=new ArrayList<>();
                affectationServicesRepo.getByAdminServiceId(servic.getId()).forEach(el->{
                    servicesList.add(serviceRepository.getById(el.getUserServicesId()));
                });
                serviceRespoList.add(new ServiceRespo(servic.getId(),servic.getName(),servic.getDescription(),servic.getPrice(),
                        servic.getDateStart(), servic.getImage(),servic.getDateFinish(),servic.getTimeStart(),
                        servic.getTimeFinish(),Boolean.valueOf(servic.getActive()),servic.getDuration(),servic.getTimePreparation(),
                        servic.getOnline(),servic.getPaidOnline(),servic.getMaxEmploy(),servic.getMaxClient(),servic.getGift(),
                        servic.getAtHome(),servic.getDeposit(),servic.getCategoryId(), employs,rooms,
                        servic.getTypeId(),servic.getSessions(),servic.getValidity(),servicesList));
            });
            serviceResponse.setServices(serviceRespoList);
            serviceResponseList.add(serviceResponse);
            serviceResponse = new ServiceResponse();
        }
        return ResponseEntity.ok(serviceResponseList);
    }
    @DeleteMapping(value = "/deleteByCategory/{id}/{organizationId}")
    public ResponseEntity<?> deleteAllEntity(@PathVariable Long id,@PathVariable Long organizationId) {
        ServiceCategory category = serviceCategoryRepo.findById(id).get();
        serviceRepository.getByCategoryId(category.getId()).forEach(element->{
            serviceRepository.deleteById(element.getId());
        });
        serviceCategoryRepo.deleteById(id);
        return ResponseEntity.ok(true);
    }
    @DeleteMapping(value = "/delete/{id}/{organizationId}")
    public ResponseEntity<?> deleteEntity(@PathVariable Long id,@PathVariable Long organizationId){
        serviceRepository.deleteById(id);
        return ResponseEntity.ok(true);
    }
    @PostMapping(value ="/saveOfAll/{organizationId}")
    public ResponseEntity<?> saveOfAll(@RequestBody ServiceConfigResponse serviceConfigResponse,@PathVariable Long organizationId){
        serviceRepository.findAll().forEach(element->{
            serviceConfigResponse.getEmployIds().forEach(id->{
                EmployService employService = new EmployService();
                employService.setServiceId(element.getId());
                employService.setEmployId(id);
                employServiceRepo.save(employService);
            });
            serviceConfigResponse.getRoomIds().forEach(id->{
                RoomService roomService = new RoomService();
                roomService.setServiceId(element.getId());
                roomService.setRoomId(id);
                roomServiceRepo.save(roomService);
            });
            element.setOnline(Boolean.valueOf(serviceConfigResponse.getOnline()));
            element.setPaidOnline(Boolean.valueOf(serviceConfigResponse.getPayedOnline()));
            serviceRepository.save(element);
        });
        return ResponseEntity.ok(true);
    }
    @PostMapping(value = "/affectationService/{organizationId}")
    public ResponseEntity<?> addServiceToService(@RequestBody AffectationServices affectationServices,@PathVariable Long organizationId){
        return ResponseEntity.ok(affectationServicesRepo.save(affectationServices));
    }
    @PostMapping(value = "/deleteAffectationService/{organizationId}")
    public ResponseEntity<?> deleteAffectationService(@RequestBody AffectationServices affectationServices,@PathVariable Long organizationId){
        affectationServicesRepo.getByUserServicesIdAndAdminServiceId(affectationServices.getUserServicesId(),
                affectationServices.getAdminServiceId()).forEach(element->{
            affectationServicesRepo.deleteById(element.getId());
        });
        return ResponseEntity.ok(true);
    }
}