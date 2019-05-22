package br.com.taxidobarba.service.impl;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import br.com.taxidobarba.domain.CreditCardPayment;
import br.com.taxidobarba.domain.dto.CreditCardPaymentDTO;
import br.com.taxidobarba.domain.dto.CreditCardPaymentDTOs;
import br.com.taxidobarba.exception.BusinessException;
import br.com.taxidobarba.repository.CreditCardPaymentRepository;
import br.com.taxidobarba.service.spec.CreditCardPaymentService;

@Service
public class CreditCardPaymentServiceBean implements CreditCardPaymentService {

    private static final Logger LOG = LogManager.getLogger(CreditCardPaymentServiceBean.class);

    @Autowired
    private CreditCardPaymentRepository creditCardPaymentRepository;

    @Override
    public void save(MultipartFile file) {
        LOG.info("Tamanho total do arquivo recebido na request: {} bytes", file.getSize());
        creditCardPaymentRepository.saveAll(requestToEntity(file));
        LOG.debug("Registros salvos.");
    }

    private List<CreditCardPayment> requestToEntity(MultipartFile file) {
        LOG.info("Criando entidades com base no arquivo recebido...");
        List<CreditCardPayment> cardPayments = new ArrayList<>();

        Arrays.asList(parseXmlFileToDTO(file)).stream()
        .filter(item -> item.getPaymentStatus().equalsIgnoreCase("APROVADA"))
        .forEach(item -> {
            CreditCardPayment cardPayment = new CreditCardPayment.CreditCardPaymentBuilder()
                    .withAmountTaxInstallment(toBigDecimal(item.getAmountTaxInstallment()))
                    .withCompensationDate(toInstant(item.getCompensationDate()))
                    .withCustomerName(item.getCustomerName())
                    .withDiscountValue(toBigDecimal(item.getDiscountValue()))
                    .withFeeValue(toBigDecimal(item.getFeeValue()))
                    .withGrossValue(toBigDecimal(item.getGrossValue()))
                    .withNetValue(toBigDecimal(item.getNetValue()))
                    .withPaymentStatus(item.getPaymentStatus())
                    .withPaymentType(item.getPaymentType())
                    .withPlots(toInteger(item.getPlots()))
                    .withPriceIntermediationRate(toBigDecimal(item.getPriceIntermediationRate()))
                    .withReceipts(toInteger(item.getReceipts()))
                    .withReceived(toInteger(item.getReceived()))
                    .withReceivedValue(toBigDecimal(item.getReceivedValue()))
                    .withSaleCode(item.getSaleCode())
                    .withSerialReader(item.getSerialReader())
                    .withTicketPrice(toBigDecimal(item.getTicketPrice()))
                    .withTransactionDate(toInstant(item.getTransactionDate()))
                    .withTransactionId(item.getTransactionId())
                    .withTransactionType(item.getTransactionType())
                    .withTypeCard(item.getTypeCard())
                    .withUserCode(item.getUserCode())
                    .withValueIntermediationRate(toBigDecimal(item.getValueIntermediationRate()))
                    .build();
            cardPayments.add(cardPayment);
        });
        LOG.info("Fim da criação das entidades.");
        removesPreviouslyRegisteredRecords(cardPayments);
        return cardPayments;
    }

    private void removesPreviouslyRegisteredRecords(List<CreditCardPayment> cardPayments) {
        LOG.info("Removendo registros já cadastrados anteriormente...");
        int initialSize = cardPayments.size();
        
        List<String> ids = cardPayments.stream()
                .map(CreditCardPayment::getTransactionId)
                .collect(Collectors.toList());
        
        cardPayments.removeAll(creditCardPaymentRepository.findByTransactionIdIn(ids));
        
        int endSize = cardPayments.size();
        LOG.info("{} registros removidos.", initialSize - endSize);
    }

    private CreditCardPaymentDTO[] parseXmlFileToDTO(MultipartFile file) {
        try {
            LOG.info("Iniciando leitura do XML...");
            JacksonXmlModule module = new JacksonXmlModule();
            module.setDefaultUseWrapper(false);
            XmlMapper objectMapper = new XmlMapper(module);
            CreditCardPaymentDTOs cardPaymentDTOs = objectMapper.readValue(
                    StringUtils.toEncodedString(file.getBytes(), StandardCharsets.ISO_8859_1),
                    CreditCardPaymentDTOs.class);
            LOG.info("Fim da leitura do XML. Quantidade de itens: {}", cardPaymentDTOs.getCardPaymentDTOs().length);
            return cardPaymentDTOs.getCardPaymentDTOs();

        } catch (Exception e) {
            LOG.error("Erro ao montar objeto a partir do XML: ", e);
            throw new BusinessException("Erro ao montar objeto a partir do XML.");
        }
    }

    private BigDecimal toBigDecimal(String value) {
        if (StringUtils.isBlank(value))
            return BigDecimal.ZERO;
        return new BigDecimal(value.replace(",", "."));
    }

    private Integer toInteger(String value) {
        if (StringUtils.isBlank(value))
            return Integer.valueOf(0);
        return Integer.valueOf(value);
    }

    private Instant toInstant(String value) {
        if (StringUtils.isBlank(value))
            return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return LocalDateTime.parse(value, formatter).toInstant(ZoneOffset.UTC);
    }

}
