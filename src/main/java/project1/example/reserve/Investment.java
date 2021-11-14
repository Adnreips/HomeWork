//package project1.example.reserve;
//
//import com.fasterxml.jackson.databind.JsonNode;
//import lombok.Data;
//import lombok.extern.slf4j.Slf4j;
//import ru.vtb.salesbox.SearchUtils;
//
//import java.util.List;
//import java.util.Objects;
//import java.util.stream.Collectors;
//
//@Data
//@Slf4j
//public class Investment extends Product {
//    private Boolean hasIndividualInvestmentAccount;
//    private Integer maxTerm;
//    private Integer minTerm;
//    private Boolean salary;
//    private Boolean salaryRequirement;
//    private Integer term;
//
//
//    @Override
//    public JsonNode calculate(CalcContext context) {
//
//        List<ProductAllInfo> subtypeForCalculate = context.getSubtypes()
//                .stream()
//                .filter(i -> {
//                    Investment investment = (Investment) i.getBaseProduct();
//                    boolean salaryMatches = Objects.equals(this.getSalary(),investment.getSalaryRequirement());
//                    boolean termRange = SearchUtils.between(
//                            this.getTerm(), investment.getMinTerm(), investment.getMaxTerm());
//                    boolean accountRequirementsMatch = Objects.equals(
//                            context.getHasIndividualInvestmentAccount(), investment.hasIndividualInvestmentAccount);
//
//                    log.info("{}",investment);
//                    return termRange && accountRequirementsMatch && salaryMatches;
//                })
//                .collect(Collectors.toList());
//
//        if (subtypeForCalculate.size()>1) {
//            log.error("More than one product found!");
//            throw new IllegalArgumentException("More than one product found");
//        }
//
//        if (subtypeForCalculate.isEmpty()) {
//            log.error("not found subtype!");
//            throw new IllegalArgumentException("No products found with such parameters");
//        }
//        Investment product = (Investment) subtypeForCalculate.get(0).getBaseProduct();
//
//        return ProductUtils.getInstance().merge(subtypeForCalculate.get(0).getMixinSubtypeNode(), product);
//    }
//}
