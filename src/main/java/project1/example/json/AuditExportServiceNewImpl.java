//package project1.example.json;
//
//package ru.vtb.salesbox.services.csv;
//
//import lombok.SneakyThrows;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.lang.Nullable;
//import org.springframework.stereotype.Service;
//import ru.vtb.salesbox.dao.AuditRepository;
//import ru.vtb.salesbox.dao.entities.Audit;
//import ru.vtb.salesbox.services.field.extractor.JsonFieldExtractor;
//
//import java.time.ZonedDateTime;
//import java.util.*;
//import java.util.stream.Stream;
//import java.util.zip.ZipEntry;
//import java.util.zip.ZipOutputStream;
//
//import static java.nio.charset.StandardCharsets.UTF_8;
//import static java.util.stream.Collectors.joining;
//
//@Service
//@Slf4j
//public class AuditExportServiceNewImpl implements ExportService {
//    public static final String FILE_NAME = "audit.csv";
//    private static final List<String> SINGLE_FIELDS;
//    private static final Map<String, String[]> PAYLOAD_FIELDS_PATH_MAP;
//    private static final int ACTIONS_COUNT;
//    private final AuditRepository auditRepository;
//    private final JsonFieldExtractor jsonFieldExtractor;
//
//    static {
//        SINGLE_FIELDS = Arrays.asList("configuration_uuid", "page_id", "session_id", "create_date",
//                "type", "payload", "next_page_id");
//
//        List<String> payloadFields = Arrays.asList("actionId", "id", "audit", "type", "isSelected", "group",
//                "defaultNextBestOffers", "nboId", "nextBestOffers", "product", "satellites",
//                "product.isSelected",
//                "product.type",
//                "product.subtype",
//                "satellites.isSelected",
//                "satellites.type",
//                "satellites.subtype");
//
//        PAYLOAD_FIELDS_PATH_MAP = new LinkedHashMap<>();
//        payloadFields.forEach(payloadField -> PAYLOAD_FIELDS_PATH_MAP.put(payloadField, payloadField.split("\\.")));
//
//        ACTIONS_COUNT = 4;
//    }
//
//    public AuditExportServiceNewImpl(AuditRepository auditRepository, JsonFieldExtractor jsonFieldExtractor) {
//        this.auditRepository = auditRepository;
//        this.jsonFieldExtractor = jsonFieldExtractor;
//    }
//
//    @SneakyThrows
//    @Override
//    public void export(ZipOutputStream zipOutputStream, @Nullable ZonedDateTime from, @Nullable ZonedDateTime to) {
//        try (Stream<Audit> stream = getStream(from, to)) {
//            ZipEntry e = new ZipEntry(FILE_NAME);
//            zipOutputStream.putNextEntry(e);
//            log.info("Exporting {} ...", FILE_NAME);
//            write(zipOutputStream, getHeaders());
//            stream.forEach(it -> write(zipOutputStream, extractValues(it)));
//            log.info("Exporting {} has finished", FILE_NAME);
//            zipOutputStream.closeEntry();
//        }
//    }
//
//    private List<String> getHeaders() {
//
//        List<String> listFieldNames = new ArrayList<>(SINGLE_FIELDS);
//        for (String[] payloadFields : PAYLOAD_FIELDS_PATH_MAP.values()) {
//            for (int i = 0; i < ACTIONS_COUNT; i++) {
//                if (payloadFields.length == 1) {
//                    listFieldNames.add(payloadFields[0] + "_" + i);
//                } else listFieldNames.add(payloadFields[0] + "_" + payloadFields[1] + "_" + i);
//            }
//        }
//        return listFieldNames;
//    }
//
//    private static String toCsvRow(Collection<?> cellValues) {
//        return cellValues.stream()
//                .map(it -> it == null ? "" : it.toString())
//                .collect(joining(";"))
//                .concat("\n");
//    }
//
//    @SneakyThrows
//    private void write(ZipOutputStream zipOutputStream, Collection<?> cellValues) {
//        String row = toCsvRow(cellValues);
//        zipOutputStream.write(row.getBytes(UTF_8));
//    }
//
//    @SneakyThrows
//    private Collection<Object> extractValues(Audit audit) {
//
//        List<Object> listValuesBas = Arrays.asList(audit.getConfigurationUuid(),audit.getPageId(),
//                audit.getSessionId(),audit.getCreateDate(),audit.getTypeCode(),audit.getPayload(),audit.getNextPageId());
//
//        List<Object> listValues = new ArrayList<>(listValuesBas);
//
//
//        String payload = audit.getPayload();
//        listValues.addAll(jsonFieldExtractor.extract(payload, PAYLOAD_FIELDS_PATH_MAP, ACTIONS_COUNT));
//        return listValues;
//    }
//
//    private Stream<Audit> getStream(ZonedDateTime from, ZonedDateTime to) {
//        if (all(from, to)) {
//            return auditRepository.stream();
//        } else {
//            return auditRepository.streamBetween(from, to);
//        }
//    }
//
//    private boolean all(ZonedDateTime from, ZonedDateTime to) {
//        return from == null && to == null;
//    }
//
//    public Long getCount(ZonedDateTime from, ZonedDateTime to) {
//        if (all(from, to)) {
//            return auditRepository.count();
//        } else {
//            return auditRepository.countBetween(from, to);
//        }
//    }
//
//
//}
