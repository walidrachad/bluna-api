package com.vaibhav.sec.controller;
import com.vaibhav.sec.model.Time;
import com.vaibhav.sec.model.TimeWork;
import com.vaibhav.sec.model.Times;
import com.vaibhav.sec.model.Weeks;
import com.vaibhav.sec.repo.*;
import com.vaibhav.sec.responce.TimeWorkResponse;
import com.vaibhav.sec.responce.TimesResponse;
import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/timeWork")
public class TimeWorkController {
   @Autowired
   TimeWorkRepository timeWorkRepository;
   @Autowired
   TimeRepository timeRepository;
   @Autowired
   TimesRepository timesRepository;
   @Autowired
   EmployRepository employRepository;
   @Autowired
   WeekRepository weekRepository;
   @GetMapping(value = "/getByWeek/{week}/{organizationId}")
   public ResponseEntity<?> getByWeek(@PathVariable String week,@PathVariable Long organizationId){
      List<TimeWorkResponse> timeWorkResponseList= new ArrayList<>();
      List<TimeWork> timeWorkList = timeWorkRepository.getByWeek(week);
      for(int i=0;i<timeWorkList.size();i++){
         TimeWorkResponse timeWorkResponse= new TimeWorkResponse();
         timeWorkResponse.setId(timeWorkList.get(i).getId());
         timeWorkResponse.setWeeks(weekRepository.getByWeek(week));
         timeWorkResponse.setWeek(timeWorkList.get(i).getWeek());
         timeWorkResponse.setDay(timeWorkList.get(i).getDay());
         timeWorkResponse.setDate(timeWorkList.get(i).getDate());
         TimesResponse timesResponse = new TimesResponse();
         List<TimesResponse> timesResponseList=new ArrayList<>();
         List<Times> times = timesRepository.getByTimeWorkId(timeWorkList.get(i).getId());
         for (int j=0;j<times.size();j++){
            timesResponse.setId(times.get(j).getId());
            timesResponse.setIndex(times.get(j).getTimeWorkId());
            timesResponse.setEmployId(times.get(j).getEmployId());
            timesResponse.setLabel(times.get(j).getLabel());
            timesResponse.setTime(timeRepository.getByTimesId(times.get(j).getId()));
            timesResponseList.add(timesResponse);
            timesResponse = new TimesResponse();
         }
         timeWorkResponse.setTimes(timesResponseList);
         timeWorkResponseList.add(timeWorkResponse);
      }
      if(timeWorkList.isEmpty()){
         LocalDate now = new LocalDate();
         LocalDate MONDAY = now.withDayOfWeek(DateTimeConstants.MONDAY);
         LocalDate TUESDAY = now.withDayOfWeek(DateTimeConstants.TUESDAY);
         LocalDate WEDNESDAY = now.withDayOfWeek(DateTimeConstants.WEDNESDAY);
         LocalDate THURSDAY = now.withDayOfWeek(DateTimeConstants.THURSDAY);
         LocalDate FRIDAY = now.withDayOfWeek(DateTimeConstants.FRIDAY);
         LocalDate SATURDAY = now.withDayOfWeek(DateTimeConstants.SATURDAY);
         LocalDate SUNDAY = now.withDayOfWeek(DateTimeConstants.SUNDAY);
         Weeks weeks = new Weeks();
         weeks.setWeek(week);
         weeks.setStart(MONDAY.toString());
         weeks.setEnd(SUNDAY.toString());
         weekRepository.save(weeks);
         for(int i =0 ;i<7;i++){
            TimeWork timeWork = new TimeWork();
            if(i==0){
               timeWork.setDate(MONDAY.toString());
               timeWork.setDay("Lundi");
               timeWork.setWeek(week);
               timeWorkRepository.save(timeWork);
            }if(i==1){
               timeWork.setDate(TUESDAY.toString());
               timeWork.setDay("Mardi");
               timeWork.setWeek(week);
               timeWorkRepository.save(timeWork);
            }if(i==2){
               timeWork.setDate(WEDNESDAY.toString());
               timeWork.setDay("Mercrede");
               timeWork.setWeek(week);
               timeWorkRepository.save(timeWork);
            }if(i==3){
               timeWork.setDate(THURSDAY.toString());
               timeWork.setDay("Jeudi");
               timeWork.setWeek(week);
               timeWorkRepository.save(timeWork);
            }if(i==4){
               timeWork.setDate(FRIDAY.toString());
               timeWork.setDay("Vendredi");
               timeWork.setWeek(week);
               timeWorkRepository.save(timeWork);
            }if(i==5){
               timeWork.setDate(SATURDAY.toString());
               timeWork.setDay("Samedi");
               timeWork.setWeek(week);
               timeWorkRepository.save(timeWork);
            }if(i==6){
               timeWork.setDate(SUNDAY.toString());
               timeWork.setDay("Dimanche");
               timeWork.setWeek(week);
               timeWorkRepository.save(timeWork);
            }
         }
         timeWorkList = timeWorkRepository.getByWeek(week);
         for(int i=0;i<timeWorkList.size();i++){
            TimeWorkResponse timeWorkResponse= new TimeWorkResponse();
            timeWorkResponse.setId(timeWorkList.get(i).getId());
            timeWorkResponse.setWeek(timeWorkList.get(i).getWeek());
            timeWorkResponse.setDay(timeWorkList.get(i).getDay());
            timeWorkResponse.setDate(timeWorkList.get(i).getDate());
            TimesResponse timesResponse = new TimesResponse();
            List<TimesResponse> timesResponseList=new ArrayList<>();
            List<Times> times = timesRepository.getByTimeWorkId(timeWorkList.get(i).getId());
            for (int j=0;j<times.size();j++){
               timesResponse.setId(times.get(j).getId());
               timesResponse.setIndex(times.get(j).getTimeWorkId());
               timesResponse.setEmployId(times.get(j).getEmployId());
               timesResponse.setLabel(times.get(j).getLabel());
               timesResponse.setTime(timeRepository.getByTimesId(times.get(j).getId()));
               timesResponseList.add(timesResponse);
               timesResponse = new TimesResponse();
            }
            timeWorkResponse.setTimes(timesResponseList);
            timeWorkResponseList.add(timeWorkResponse);
         }
      }
      return ResponseEntity.ok(timeWorkResponseList);
   }
   @PostMapping(value = "/addTimeWork/{organizationId}")
   public ResponseEntity<?> addEntity(@RequestBody TimeWork timeWork,@PathVariable Long organizationId){
      return ResponseEntity.ok(timeWorkRepository.save(timeWork));
   }

   @PostMapping(value = "/addTimes/{organizationId}")
   public ResponseEntity<?> addTimes(@RequestBody Times time,@PathVariable Long organizationId){
      return ResponseEntity.ok(timesRepository.save(time));
   }
   @PostMapping(value = "/addTime/{organizationId}")
   public ResponseEntity<?> addTime(@RequestBody Time time,@PathVariable Long organizationId) {
      Integer duration = Integer.parseInt(time.getEnd().substring(0,2)) - Integer.parseInt(time.getStart().substring(0,2));
      System.out.println(duration);
      time.setDuration(duration);
      return ResponseEntity.ok(timeRepository.save(time));
   }
   @DeleteMapping(value = "/time/delete/{id}/{organizationId}")
   public ResponseEntity<?> deleteTime(@PathVariable Long id,@PathVariable Long organizationId) {
      timeRepository.deleteById(id);
      return ResponseEntity.ok(true);
   }
   @GetMapping(value = "/addWeek/{week}/{organizationId}")
   public ResponseEntity<?> addWeek(@PathVariable String week,@PathVariable Long organizationId){
      LocalDate now = new LocalDate();
      LocalDate MONDAY = now.withDayOfWeek(DateTimeConstants.MONDAY);
      LocalDate TUESDAY = now.withDayOfWeek(DateTimeConstants.TUESDAY);
      LocalDate WEDNESDAY = now.withDayOfWeek(DateTimeConstants.WEDNESDAY);
      LocalDate THURSDAY = now.withDayOfWeek(DateTimeConstants.THURSDAY);
      LocalDate FRIDAY = now.withDayOfWeek(DateTimeConstants.FRIDAY);
      LocalDate SATURDAY = now.withDayOfWeek(DateTimeConstants.SATURDAY);
      LocalDate SUNDAY = now.withDayOfWeek(DateTimeConstants.SUNDAY);
      Weeks weeks = new Weeks();
      weeks.setWeek(week);
      Integer newWeek = Integer.parseInt(week);
      newWeek=newWeek+1;
      if(timeWorkRepository.existsByWeek(newWeek.toString())){
         timeWorkRepository.getByWeek(newWeek.toString()).forEach(element->{
            timeWorkRepository.deleteById(element.getId());
         });
      }
      for(int i =0 ;i<7;i++){
         if(i==0){
            TimeWork timeWork = new TimeWork();
            java.time.LocalDate ld = java.time.LocalDate.of(MONDAY.getYear(), MONDAY.getMonthOfYear(), MONDAY.getDayOfMonth());
            ld = ld.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
            timeWork.setDate(ld.toString());
            weeks.setStart(ld.toString());
            timeWork.setDay("Lundi");
            timeWork.setWeek(newWeek.toString());
            timeWork =timeWorkRepository.save(timeWork);
            List<Times> timesList= timesRepository.getByTimeWorkId(timeWorkRepository.getByWeekAndDay(week,"Lundi").getId());
            for(int j=0;j<timesList.size();j++){
               Times times= new Times();
               times.setTimeWorkId(timeWork.getId());
               times.setLabel(timesList.get(j).getLabel());
               times.setEmployId(timesList.get(j).getEmployId());
               times=timesRepository.save(times);
               List<Time> timeList = timeRepository.getByTimesId(timesList.get(j).getId());
               for(int k=0;k<timeList.size();k++){
                  Time time = new Time();
                  time.setTimesId(times.getId());
                  time.setEnd(timeList.get(k).getEnd());
                  time.setStart(timeList.get(k).getStart());
                  time.setDuration(timeList.get(k).getDuration());
                  timeRepository.save(time);
               }
            }
         }
         if(i==1){
            TimeWork timeWork = new TimeWork();
            java.time.LocalDate ld = java.time.LocalDate.of(TUESDAY.getYear(), TUESDAY.getMonthOfYear(), TUESDAY.getDayOfMonth());
            ld = ld.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
            timeWork.setDate(ld.toString());
            timeWork.setDay("Mardi");
            timeWork.setWeek(newWeek.toString());
            timeWork =timeWorkRepository.save(timeWork);
            List<Times> timesList= timesRepository.getByTimeWorkId(timeWorkRepository.getByWeekAndDay(week,"Mardi").getId());
            for(int j=0;j<timesList.size();j++){
               Times times= new Times();
               times.setTimeWorkId(timeWork.getId());
               times.setLabel(timesList.get(j).getLabel());
               times.setEmployId(timesList.get(j).getEmployId());
               times=timesRepository.save(times);
               List<Time> timeList = timeRepository.getByTimesId(timesList.get(j).getId());
               for(int k=0;k<timeList.size();k++){
                  Time time = new Time();
                  time.setTimesId(times.getId());
                  time.setEnd(timeList.get(k).getEnd());
                  time.setStart(timeList.get(k).getStart());
                  time.setDuration(timeList.get(k).getDuration());
                  timeRepository.save(time);
               }
            }
         }
         if(i==2){
            TimeWork timeWork = new TimeWork();
            java.time.LocalDate ld = java.time.LocalDate.of(WEDNESDAY.getYear(), WEDNESDAY.getMonthOfYear(), WEDNESDAY.getDayOfMonth());
            ld = ld.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
            timeWork.setDate(ld.toString());
            timeWork.setDay("Mercrede");
            timeWork.setWeek(newWeek.toString());
            timeWork =timeWorkRepository.save(timeWork);
            List<Times> timesList= timesRepository.getByTimeWorkId(timeWorkRepository.getByWeekAndDay(week,"Mercrede").getId());
            for(int j=0;j<timesList.size();j++){
               Times times= new Times();
               times.setTimeWorkId(timeWork.getId());
               times.setLabel(timesList.get(j).getLabel());
               times.setEmployId(timesList.get(j).getEmployId());
               times=timesRepository.save(times);
               List<Time> timeList = timeRepository.getByTimesId(timesList.get(j).getId());
               for(int k=0;k<timeList.size();k++){
                  Time time = new Time();
                  time.setTimesId(times.getId());
                  time.setEnd(timeList.get(k).getEnd());
                  time.setStart(timeList.get(k).getStart());
                  time.setDuration(timeList.get(k).getDuration());
                  timeRepository.save(time);
               }
            }
         }
         if(i==3){
            TimeWork timeWork = new TimeWork();
            java.time.LocalDate ld = java.time.LocalDate.of(THURSDAY.getYear(), THURSDAY.getMonthOfYear(), THURSDAY.getDayOfMonth());
            ld = ld.with(TemporalAdjusters.next(DayOfWeek.THURSDAY));
            timeWork.setDate(ld.toString());
            timeWork.setDay("Jeudi");
            timeWork.setWeek(newWeek.toString());
            timeWork =timeWorkRepository.save(timeWork);
            List<Times> timesList= timesRepository.getByTimeWorkId(timeWorkRepository.getByWeekAndDay(week,"Jeudi").getId());
            for(int j=0;j<timesList.size();j++){
               Times times= new Times();
               times.setTimeWorkId(timeWork.getId());
               times.setLabel(timesList.get(j).getLabel());
               times.setEmployId(timesList.get(j).getEmployId());
               times=timesRepository.save(times);
               List<Time> timeList = timeRepository.getByTimesId(timesList.get(j).getId());
               for(int k=0;k<timeList.size();k++){
                  Time time = new Time();
                  time.setTimesId(times.getId());
                  time.setEnd(timeList.get(k).getEnd());
                  time.setStart(timeList.get(k).getStart());
                  time.setDuration(timeList.get(k).getDuration());
                  timeRepository.save(time);
               }
            }
         }
         if(i==4){
            TimeWork timeWork = new TimeWork();
            java.time.LocalDate ld = java.time.LocalDate.of(FRIDAY.getYear(), FRIDAY.getMonthOfYear(), FRIDAY.getDayOfMonth());
            ld = ld.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
            timeWork.setDate(ld.toString());
            timeWork.setDay("Vendredi");
            timeWork.setWeek(newWeek.toString());
            timeWork =timeWorkRepository.save(timeWork);
            List<Times> timesList= timesRepository.getByTimeWorkId(timeWorkRepository.getByWeekAndDay(week,"Vendredi").getId());
            for(int j=0;j<timesList.size();j++){
               Times times= new Times();
               times.setTimeWorkId(timeWork.getId());
               times.setLabel(timesList.get(j).getLabel());
               times.setEmployId(timesList.get(j).getEmployId());
               times=timesRepository.save(times);
               List<Time> timeList = timeRepository.getByTimesId(timesList.get(j).getId());
               for(int k=0;k<timeList.size();k++){
                  Time time = new Time();
                  time.setTimesId(times.getId());
                  time.setEnd(timeList.get(k).getEnd());
                  time.setStart(timeList.get(k).getStart());
                  time.setDuration(timeList.get(k).getDuration());
                  timeRepository.save(time);
               }
            }
         }if(i==5){
            TimeWork timeWork = new TimeWork();
            java.time.LocalDate ld = java.time.LocalDate.of(SATURDAY.getYear(), SATURDAY.getMonthOfYear(), SATURDAY.getDayOfMonth());
            ld = ld.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
            timeWork.setDate(ld.toString());
            timeWork.setDay("Samedi");
            timeWork.setWeek(newWeek.toString());
            timeWork =timeWorkRepository.save(timeWork);
            List<Times> timesList= timesRepository.getByTimeWorkId(timeWorkRepository.getByWeekAndDay(week,"Samedi").getId());
            for(int j=0;j<timesList.size();j++){
               Times times= new Times();
               times.setTimeWorkId(timeWork.getId());
               times.setLabel(timesList.get(j).getLabel());
               times.setEmployId(timesList.get(j).getEmployId());
               times=timesRepository.save(times);
               List<Time> timeList = timeRepository.getByTimesId(timesList.get(j).getId());
               for(int k=0;k<timeList.size();k++){
                  Time time = new Time();
                  time.setTimesId(times.getId());
                  time.setEnd(timeList.get(k).getEnd());
                  time.setStart(timeList.get(k).getStart());
                  time.setDuration(timeList.get(k).getDuration());
                  timeRepository.save(time);
               }
            }
         }if(i==6){
            TimeWork timeWork = new TimeWork();
            java.time.LocalDate ld = java.time.LocalDate.of(SUNDAY.getYear(), SUNDAY.getMonthOfYear(), SUNDAY.getDayOfMonth());
            ld = ld.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
            timeWork.setDate(ld.toString());
            weeks.setEnd(ld.toString());
            timeWork.setDay("Dimanche");
            timeWork.setWeek(newWeek.toString());
            timeWork =timeWorkRepository.save(timeWork);
            List<Times> timesList= timesRepository.getByTimeWorkId(timeWorkRepository.getByWeekAndDay(week,"Dimanche").getId());
            for(int j=0;j<timesList.size();j++){
               Times times= new Times();
               times.setTimeWorkId(timeWork.getId());
               times.setLabel(timesList.get(j).getLabel());
               times.setEmployId(timesList.get(j).getEmployId());
               times=timesRepository.save(times);
               List<Time> timeList = timeRepository.getByTimesId(timesList.get(j).getId());
               for(int k=0;k<timeList.size();k++){
                  Time time = new Time();
                  time.setTimesId(times.getId());
                  time.setEnd(timeList.get(k).getEnd());
                  time.setStart(timeList.get(k).getStart());
                  time.setDuration(timeList.get(k).getDuration());
                  timeRepository.save(time);
               }
            }
         }
      }
      return ResponseEntity.ok(true);
   }
   @GetMapping(value = "/checkWeek/{week}/{organizationId}")
   public ResponseEntity<?> checkWeek(@PathVariable String week,@PathVariable Long organizationId){
      Integer newWeek=Integer.parseInt(week)+1;
      return ResponseEntity.ok(timeWorkRepository.existsByWeek(newWeek.toString()));
   }
   @GetMapping(value = "/getWeeks/{organizationId}")
   public ResponseEntity<?> getWeeks( @PathVariable Long organizationId){
      return ResponseEntity.ok(weekRepository.findAll());
   }
}