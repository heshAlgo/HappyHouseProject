package com.ssafy.house.service;

import java.util.List;
import java.util.Map;

import com.ssafy.house.dto.ClinicCoronaDto;
import com.ssafy.house.util.PageNavigation;

public interface ClinicService {
	public List<ClinicCoronaDto> searchAll(String page);
	public PageNavigation makePageNavigation(String page);

}
