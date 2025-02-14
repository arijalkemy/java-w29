package com.bootcamp.crud_joyeria.service;

import com.bootcamp.crud_joyeria.dto.request.CreateJewelRequestBody;
import com.bootcamp.crud_joyeria.dto.response.JewelResponseBody;

import java.util.List;

public interface IJewelryService {

    String createJewel(CreateJewelRequestBody request);

    List<JewelResponseBody> getAllJewelry();

    JewelResponseBody updateJewel(long jewelId, CreateJewelRequestBody request);

    String deleteJewel(long jewelId);
}
