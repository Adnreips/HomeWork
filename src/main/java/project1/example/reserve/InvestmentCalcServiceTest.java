//package project1.example.reserve;
//
//
//import com.fasterxml.jackson.databind.JsonNode;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.TestInstance;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.MethodSource;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//import ru.vtb.salesbox.SalesBoxMassBackendApplication;
//
//import java.util.stream.Stream;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest(classes = SalesBoxMassBackendApplication.class)
//@Slf4j
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//public class InvestmentCalcServiceTest extends BaseCalcServiceTest{
//    @ParameterizedTest
//    @MethodSource("provideData")
//    @Transactional
//    void calculateTest(CalcContext calcContext) {
//        JsonNode node = getProduct(Investment.class);
//
//        Investment calculated = calculate(
//                node,
//                product -> {
//                    product.setHasIndividualInvestmentAccount(calcContext.getHasIndividualInvestmentAccount());
//                    product.setTerm(calcContext.getTerm());
//                    product.setSalary(calcContext.getSalary());
//                },
//                calcContext.getInsurance(),
//                calcContext.getSalary()
//        );
//
//        assertEquals(calcContext.getExpectedSubtype(), calculated.getSubtype());
//    }
//
//    @Override
//    Stream<Arguments> provideData() {
//        return Stream.of(
//                Arguments.of(CalcContext.builder().term(365).insurance(true).salary(false).hasIndividualInvestmentAccount(false).expectedSubtype("Obligations1").build()),
//                Arguments.of(CalcContext.builder().term(365).insurance(true).salary(true).hasIndividualInvestmentAccount(false).expectedSubtype("Obligations4").build()),
//                Arguments.of(CalcContext.builder().term(548).insurance(true).salary(true).hasIndividualInvestmentAccount(false).expectedSubtype("Obligations5").build())
//        );
//    }
//}
//
