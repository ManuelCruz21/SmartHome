/* 
 * School Project, educational software development.
 * This school project is open source and does not have a specific license.
 * It is intended for educational purposes only and should not be trusted for commercial purposes.
 * First see if it works.  Copyright (C) 2024
 * For any inquiries or further information, contact amm@isep.ipp.pt.
 */ 

package smarthome.controller.rest.unit_testing_deprecated;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import smarthome.controller.rest.UnitController;
import smarthome.domain.unit.Unit;
import smarthome.mapper.UnitAssembler;
import smarthome.service.IUnitService;
import smarthome.utils.dto.UnitDTO;


@WebMvcTest(UnitController.class)
class UnitControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private IUnitService unitService;

  @MockBean
  private UnitAssembler unitAssembler;

  /**
   * This test case verifies that the UnitController returns a list of units when they are found.
   */
  @Test
  void shouldReturnUnits_WhenFound() throws Exception {
    // Arrange
    Unit unit = mock(Unit.class);
    UnitDTO unitDTO = mock(UnitDTO.class);
    when(unitService.getAllunitTypes()).thenReturn(List.of(unit));
    when(unitAssembler.domainToDTO(List.of(unit))).thenReturn(List.of(unitDTO));

    // Act & Assert
    mockMvc.perform(get("/units")
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$._embedded.unitDTOList").exists())
        .andExpect(jsonPath("$._links.self").exists());
  }

  /**
   * This test case verifies that the UnitController returns no units
   */
  @Test
  void shouldReturnNoUnits_WhenNoUnitsAvailable() throws Exception {
    // Arrange
    when(unitService.getAllunitTypes()).thenReturn(List.of());
    // Act & Assert
    mockMvc.perform(get("/units")
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$._links.self.href").exists());
  }
}