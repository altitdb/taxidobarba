package br.com.taxidobarba.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.taxidobarba.exception.EncoderUtilsException;

public class EncoderUtils {

    private static final Logger LOG = LogManager.getLogger(EncoderUtils.class);
    private static final String ALGORITHM = "SHA-256";

    public String encoder(String text) {

        LOG.info("Iniciando encoder de texto...");

        StringBuilder hexadecimalText = new StringBuilder();

        try {
            MessageDigest messageDigest = MessageDigest.getInstance(ALGORITHM);
            byte[] textDigest = messageDigest.digest(text.getBytes(StandardCharsets.UTF_8));

            for (byte b : textDigest) {
                hexadecimalText.append(String.format("%02X", 0xFF & b));
            }

            LOG.info("Encoder realizado com sucesso.");
            return String.valueOf(hexadecimalText);

        } catch (Exception e) {
            LOG.error("Erro ao codificar texto: " + e);
            throw new EncoderUtilsException();
        }

    }

}
