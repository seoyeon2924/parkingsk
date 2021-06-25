package com.skcc.parkingsk.parkinglot.controller;

import com.skcc.parkingsk.parkinglot.controller.dto.ParkingLotDTO;
import com.skcc.parkingsk.parkinglot.domain.entity.ParkingLot;
import com.skcc.parkingsk.parkinglot.service.ParkinglotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@Slf4j
public class ParkinglotController {
    final private ParkinglotService parkinglotService;

    /* 주차장 등록 */
    @PostMapping("/parkingLot")
    public ParkingLot parkingLotRegister(@RequestBody ParkingLotDTO parkingLotDTO){
        log.info("***************** ParkinglotController : 등록 Postmapping 호출 *****************");
        return parkinglotService.registerParkingLot(parkingLotDTO);
    }

    /* 주차장 상세 조회 */
    @GetMapping("/parkingLot/{parkingLotId}")
    public ParkingLot searchParkingLot(@PathVariable Long parkingLotId) {
        log.info("***************** ParkinglotController : 상세 조회 Getmapping 호출 *****************");
        return parkinglotService.findParkingLotOne(parkingLotId);
    }

    /* 주차장 삭제 */
    @DeleteMapping("/parkingLot/{parkingLotId}")
    public void parkingLotDelete(@PathVariable Long parkingLotId){
        log.info("***************** ParkinglotController : 삭제 DeleteMapping 호출 *****************");
        parkinglotService.deleteParkingLot(parkingLotId);
    }

    /* 주차장 수정 */
    @PutMapping("/parkingLot")
    public void parkingLotUpdate(@RequestBody ParkingLotDTO parkingLotDTO){
        log.info("***************** ParkinglotController : 수정 Putmapping 호출 *****************");
        parkinglotService.updateParkingLot(parkingLotDTO);
    }

    /* 주차장 전체 조회 */
    @GetMapping("/parkingLot")
    public List<ParkingLot> findAllParkingLot(){
        log.info("***************** ParkinglotController : 전체 조회 Getmapping 호출 *****************");
        return parkinglotService.findAll();
    }

    /* 주차장 검색 */
    @GetMapping("/parkingLots/{parkingLotName}")
    public List<ParkingLot> searchParkingLotByName(@PathVariable String parkingLotName) {
        log.info("***************** ParkinglotController : 검색(List 리턴) GetMapping 호출 *****************");
        return parkinglotService.findParkingLotListByName(parkingLotName);
    }

    /* 위도 경도에 따른 가까운 주차장 3개 반환 */
    @GetMapping("/{latitude}/{longitude}")
    public List<ParkingLot> findCloseParkingLot(@PathVariable String latitude, String longitude){
        log.info("***************** ParkinglotController : 가까운주차장 3개찾기 GetMapping 호출 *****************");
        return parkinglotService.findCloseParkingLotListByGeo(latitude, longitude);
    }


}
