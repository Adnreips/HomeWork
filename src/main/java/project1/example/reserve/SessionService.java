//package project1.example.reserve;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import ru.vtb.salesbox.api.CreateSessionRequestDto;
//import ru.vtb.salesbox.api.CreateSessionResponseDto;
//import ru.vtb.salesbox.component.SessionIdFilter;
//import ru.vtb.salesbox.dao.ServiceSessionRepository;
//import ru.vtb.salesbox.dao.entities.Client;
//import ru.vtb.salesbox.dao.entities.Manager;
//import ru.vtb.salesbox.dao.entities.ServiceSession;
//import ru.vtb.salesbox.dao.entities.ServiceSessionStatus;
//import ru.vtb.salesbox.integration.person_cs.model.PersonInfoDto;
//import ru.vtb.salesbox.integration.portfolio.model.PortfolioResponseDto;
//
//import java.time.LocalDate;
//import java.time.Period;
//import java.util.List;
//import java.util.Optional;
//
//import static ru.vtb.salesbox.Utils.now;
//import static ru.vtb.salesbox.Utils.peek;
//
//@Service
//@RequiredArgsConstructor
//@Slf4j
//public class SessionService {
//    private final ServiceSessionRepository serviceSessionRepository;
//    private static final long MAX_AGE_FOR_INVESTMENT = 70;
//
//    private static ServiceSession convert(CreateSessionRequestDto createSessionRequest, PersonInfoDto person, PortfolioResponseDto portfolio) {
//        return ServiceSession.builder()
//                .manager(
//                        Manager.builder()
//                                .name(createSessionRequest.getManagerName())
//                                .surname(createSessionRequest.getManagerSurname())
//                                .middleName(createSessionRequest.getManagerMiddleName())
//                                .personnelNumber(createSessionRequest.getManagerPersonnelNumber())
//                                .email(createSessionRequest.getManagerEmail())
//                                .office(createSessionRequest.getManagerOffice())
//                                .build()
//                )
//                .client(
//                        Client.builder()
//                                .name(createSessionRequest.getClientName())
//                                .surname(createSessionRequest.getClientSurname())
//                                .middleName(createSessionRequest.getClientMiddleName())
//                                .email(createSessionRequest.getClientEmail())
//                                .siebelId(createSessionRequest.getClientSiebelId())
//                                .salaryProject(
//                                        createSessionRequest.getClientSalaryProject() != null
//                                                && createSessionRequest.getClientSalaryProject()
//                                )
//                                .mdmId(person.getMdmId())
//                                .personReceived(person.getSuccess())
//                                .profileReceived(portfolio.getSuccess())
//                                .pensioner(person.getPensioner())
//                                .hasCreditCard(portfolio.getHasCreditCard())
//                                .hasMultiline(portfolio.getHasMultiline())
//                                .hasVtbOnline(portfolio.getHasVtbOnline())
//                                .hasMoneybox(portfolio.getHasMoneybox())
//                                .hasMirPensionCard(portfolio.getHasMirPensionCard())
//                                .hasMagnit(portfolio.getHasMagnit())
//                                .hasMulticardTroika(portfolio.getHasMulticardTroika())
//                                .hasMulticardMirTroika(portfolio.getHasMulticardMirTroika())
//                                .hasIndividualInvestmentAccount(portfolio.getHasIndividualInvestmentAccount())
//                                .hasInvestmentTendency(getInvestmentTendency(
//                                        portfolio.getHasIndividualInvestmentAccount(), person.getBirthday()))
//                                .build()
//                )
//                .createDate(now())
//                .status(ServiceSessionStatus.ACTIVE)
//                .build();
//    }
//
//    public static Boolean getInvestmentTendency(Boolean hasIndividualInvestmentAccount, LocalDate birthday) {
//        if (hasIndividualInvestmentAccount == null || birthday == null) {
//            return false;
//        }
//        return hasIndividualInvestmentAccount &&
//                Period.between(birthday, LocalDate.now()).getYears() < MAX_AGE_FOR_INVESTMENT;
//    }
//
//    @Transactional
//    public CreateSessionResponseDto createSession(CreateSessionRequestDto createSessionRequestDto, PersonInfoDto person, PortfolioResponseDto portfolio) {
//        log.debug("create session");
//        ServiceSession serviceSession = convert(createSessionRequestDto, person, portfolio);
//        ServiceSession saved = serviceSessionRepository.save(serviceSession);
//        return new CreateSessionResponseDto(saved.getId());
//    }
//
//    @Transactional
//    public void cancelActiveByManager(String manager) {
//        log.debug("cancel active by manager {}", manager);
//        List<ServiceSession> sessions = serviceSessionRepository.findByManagerPersonnelNumberAndStatus(
//                manager,
//                ServiceSessionStatus.ACTIVE
//        );
//        sessions.forEach(it -> {
//            it.setStatus(ServiceSessionStatus.CANCEL);
//            log.debug("cancel session {}", it.getId());
//        });
//        serviceSessionRepository.saveAll(sessions);
//    }
//
//    @Transactional
//    public Optional<Integer> endSession(Integer sessionId) {
//        log.debug("end session");
//        return serviceSessionRepository.findById(sessionId)
//                .map(peek(it -> it.setStatus(ServiceSessionStatus.SUCCESS)))
//                .map(serviceSessionRepository::save)
//                .map(ServiceSession::getId);
//    }
//
//    public Optional<Integer> getCurrentSessionId() {
//        log.debug("get current session id");
//        String sessionId = SessionIdFilter.getSessionId();
//        if (sessionId == null) {
//            return Optional.empty();
//        }
//        return Optional.of(Integer.valueOf(sessionId));
//    }
//
//    @Transactional
//    public Optional<ServiceSession> getCurrentSession() {
//        log.debug("get current session");
//        Optional<Integer> sessionId = getCurrentSessionId();
//
//        return sessionId.flatMap(serviceSessionRepository::findById);
//    }
//
//}
