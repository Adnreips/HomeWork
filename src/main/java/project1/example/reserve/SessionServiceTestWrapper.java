//package project1.example.reserve;
//
//import lombok.RequiredArgsConstructor;
//import lombok.SneakyThrows;
//import org.springframework.mock.web.MockMultipartHttpServletRequest;
//import org.springframework.stereotype.Service;
//import ru.vtb.salesbox.StartContainersForTest;
//import ru.vtb.salesbox.api.CreateSessionRequestDto;
//import ru.vtb.salesbox.api.CreateSessionResponseDto;
//import ru.vtb.salesbox.component.SessionIdFilter;
//import ru.vtb.salesbox.dao.ServiceSessionRepository;
//import ru.vtb.salesbox.integration.person_cs.model.PersonInfoDto;
//import ru.vtb.salesbox.integration.portfolio.model.PortfolioResponseDto;
//
//@Service
//@RequiredArgsConstructor
//public class SessionServiceTestWrapper extends StartContainersForTest {
//    private final SessionService sessionService;
//    private final ServiceSessionRepository serviceSessionRepository;
//    private final SessionIdFilter filter;
//
//    public CreateSessionResponseDto runSession() {
//        return runSession(
//                CreateSessionRequestDto
//                        .builder()
//                        .managerName("иван")
//                        .managerMiddleName("человеков")
//                        .managerSurname("гладко")
//                        .managerPersonnelNumber("выбрил")
//                        .managerOffice("лицо")
//                        .clientMiddleName("одел")
//                        .clientName("лучший")
//                        .clientSurname("галстук")
//                        .clientSiebelId("и ждет")
//                        .clientSalaryProject(false)
//                        .build(),
//                PersonInfoDto.builder()
//                        .pensioner(false)
//                        .success(true)
//                        .build(),
//                PortfolioResponseDto.builder()
//                        .success(true)
//                        .hasIndividualInvestmentAccount(false)
//                        .build());
//    }
//
//    @SneakyThrows
//    public CreateSessionResponseDto runSession(CreateSessionRequestDto requestDto, PersonInfoDto person, PortfolioResponseDto portfolio) {
//        CreateSessionResponseDto dto = sessionService.createSession(requestDto, person, portfolio);
//        MockMultipartHttpServletRequest r = new MockMultipartHttpServletRequest();
//        r.addHeader(SessionIdFilter.SESSION_ID_HEADER_NAME, dto.getSessionId().toString());
//        filter.doFilter(r, null, (request, response) -> {
//        });
//        return dto;
//    }
//
//    public void removeAllSessions() {
//        serviceSessionRepository.deleteAll();
//    }
//}
