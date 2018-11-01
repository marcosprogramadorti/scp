package br.gov.transportes.scp.resource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.activation.MimetypesFileTypeMap;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.gov.transportes.scp.security.SecurityUtils;


/**
 * @author jackson
 * @date 16/06/2015
 * @class RequestUtil
 * @description Classe Utils responsavel por prover metodos de get e post
 */
@Component
public class RequestUtil {

    private static final Logger LOGGER = Logger.getLogger(RequestUtil.class);
    private static final String CODIFICACAO_PADRAO = "UTF-8";
    private static final String CONTENT_DISPOSITION_FORM_DATA = "Content-Disposition: form-data; name=\"";
    private static final String CONTENT_TYPE = "Content-Type: ";
    private static final String CONTENT_TRANSFER_ENCODING = "Content-Transfer-Encoding: binary";
    private static final String LINE_FEED = "\r\n";
    private static String boundary;
    public static final String ID_APLICACAO = "342";
    public static final String ID_TIPO_DIRETORIO_ANEXO = "1";

    private RequestUtil() {
        super();
    }


    /**
     *
     * @param url
     * @param data
     * @throws NegocioException
     * @throws Exception
     */
    public String post(String url, String data, Boolean comResposta, String login) throws Exception {
        return postResquest(url, data, comResposta, login);
    }

    /**
     *
     * @param url
     * @param data
     * @throws NegocioException
     * @throws Exception
     */
    public String postResquest(String url, String data, Boolean comResposta, String login) throws Exception {
        URL targetUrl;
        String permissoes;
        try {
            targetUrl = new URL(url);
            HttpURLConnection httpConnection = (HttpURLConnection) targetUrl.openConnection();
            httpConnection.setDoOutput(true);
            httpConnection.setRequestMethod("POST");
            
            if (login != null) {
                httpConnection.setRequestProperty("Authorization", login);
            }
//            permissoes = SecurityUtils.getAuthority(false);
//            if(permissoes != null) {
//                httpConnection.setRequestProperty("PERMISSOES", permissoes);
//            }
            LOGGER.info("AUTHORIZATION POST: " + login);
//            LOGGER.info("PERMISSOES POST: " + permissoes);
            
            httpConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            
            OutputStream outputStream = httpConnection.getOutputStream();
            Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
            writer.write(data);
            writer.flush();

            if (httpConnection.getResponseCode() != 200 && httpConnection.getResponseCode() != 204) {
                LOGGER.info("Falha ao realizar request. " + "Código : " + httpConnection.getResponseCode()
                        + " Mensagem: " + httpConnection.getResponseMessage() + " URL: " + httpConnection.getURL());
                throw new Exception(httpConnection.getResponseMessage());
            }
            String output;
            String response = "";
            if (comResposta) {
                BufferedReader br =
                        new BufferedReader(new InputStreamReader(httpConnection.getInputStream(),
                                StandardCharsets.UTF_8));
                while ((output = br.readLine()) != null) {
                    response += output;
                }
                br.close();
            }
            writer.close();
            outputStream.close();
            httpConnection.disconnect();

            return response;
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    /**
     * @param url
     * @param file
     * @param nmArquivoCriptografado
     * @param comResposta
     * @return
     * @throws NegocioException
     */
    public String postFile(String url, File file, String nmArquivoCriptografado, Boolean comResposta)
            throws Exception {
        URL targetUrl;
        try {
            targetUrl = new URL(url);
            boundary = "===" + System.currentTimeMillis() + "===";
            HttpURLConnection httpConnection = (HttpURLConnection) targetUrl.openConnection();
            httpConnection.setUseCaches(false);
            httpConnection.setDoOutput(true); // Indica que o método é post
            httpConnection.setDoInput(true);
            httpConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=\"" + boundary + "\"");
            OutputStream outputStream = httpConnection.getOutputStream();
            Writer writer = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"), true);
            addParametros(writer, nmArquivoCriptografado);
            addFilePart(file, writer, outputStream);
            writer.append(LINE_FEED).flush();
            writer.append("--" + boundary + "--").append(LINE_FEED);
            writer.close();

            if (httpConnection.getResponseCode() != 200 && httpConnection.getResponseCode() != 204) {
                LOGGER.info("Falha ao realizar request. " + "Código : " + httpConnection.getResponseCode()
                        + " Mensagem: " + httpConnection.getResponseMessage() + " URL: " + httpConnection.getURL());
                throw new Exception(httpConnection.getResponseMessage());
            }
            String output;
            String response = "";
            if (comResposta) {
                BufferedReader br = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
                while ((output = br.readLine()) != null) {
                    response += output;
                }
                br.close();
            }
            writer.close();
            outputStream.close();
            httpConnection.disconnect();

            return response;
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    /**
     * @param writer
     * @param nmArquivoCriptografado
     * @throws IOException
     */
    private void addParametros(Writer writer, String nmArquivoCriptografado) throws IOException {
        // ID APLICACAO
        writer.append("--" + boundary).append(LINE_FEED);
        writer.append(CONTENT_DISPOSITION_FORM_DATA + "idAplicacao" + "\"").append(LINE_FEED);
        writer.append("Content-Type: text/plain; charset=" + "UTF-8").append(LINE_FEED);
        writer.append(LINE_FEED);
        writer.append(ID_APLICACAO).append(LINE_FEED);
        writer.flush();
        // ID TIPO DIRETORIO
        writer.append("--" + boundary).append(LINE_FEED);
        writer.append(CONTENT_DISPOSITION_FORM_DATA + "idTipoDiretorio" + "\"").append(LINE_FEED);
        writer.append("Content-Type: text/plain; charset=" + "UTF-8").append(LINE_FEED);
        writer.append(LINE_FEED);
        writer.append(ID_TIPO_DIRETORIO_ANEXO).append(LINE_FEED);
        writer.flush();

        // NOME ARQUIVO CRIPTOGRAFADO
        writer.append("--" + boundary).append(LINE_FEED);
        writer.append(CONTENT_DISPOSITION_FORM_DATA + "fileName" + "\"").append(LINE_FEED);
        writer.append("Content-Type: text/plain; charset=" + "UTF-8").append(LINE_FEED);
        writer.append(LINE_FEED);
        writer.append(nmArquivoCriptografado).append(LINE_FEED);
        writer.flush();
    }

    /**
     * @param uploadFile
     * @param writer
     * @param outputStream
     * @throws IOException
     */
    private void addFilePart(File uploadFile, Writer writer, OutputStream outputStream) throws IOException {
        String fieldName = "file";
        String fileName = uploadFile.getName();
        writer.append("--" + boundary).append(LINE_FEED);
        writer.append(CONTENT_DISPOSITION_FORM_DATA + fieldName + "\"; filename=\"" + fileName + "\"")
                .append(LINE_FEED);
        writer.append(CONTENT_TYPE + MimetypesFileTypeMap.getDefaultFileTypeMap().getContentType(uploadFile)).append(
                LINE_FEED);
        writer.append(CONTENT_TRANSFER_ENCODING).append(LINE_FEED);
        writer.append(LINE_FEED);
        writer.flush();

        FileInputStream inputStream = new FileInputStream(uploadFile);
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        outputStream.flush();
        inputStream.close();

        writer.append(LINE_FEED);
        writer.flush();
    }


    /**
     * @method enviarGet
     * @date 25/11/2015
     * @returnType String
     * @param url
     * @param data
     * @return
     * @throws IOException
     * @description
     */
    public String get(String url, String data, String login) throws Exception {
        String permissoes;
        try {
            String response = "";

            // insere espaço na url onde tem '+'
            URL targetUrl = new URL(url + data.replaceAll(" ", "%20"));
            HttpURLConnection httpConnection = (HttpURLConnection) targetUrl.openConnection();
            httpConnection.setRequestMethod("GET");
            
            if (login != null) {
                httpConnection.setRequestProperty("Authorization", login);
            }
//            permissoes = SecurityUtils.getAuthority(false);
//            if(permissoes != null) {
//                httpConnection.setRequestProperty("PERMISSOES", permissoes);
//            }
            LOGGER.info("AUTHORIZATION GET: " + login);
//            LOGGER.info("PERMISSOES GET: " + permissoes);
            
            httpConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            if (httpConnection.getResponseCode() != 200 && httpConnection.getResponseCode() != 204) {
                LOGGER.info("Falha ao realizar request. " + "Código : " + httpConnection.getResponseCode()
                        + " Mensagem: " + httpConnection.getResponseMessage() + " URL: " + httpConnection.getURL());
            }
            BufferedReader responseBuffer =
                    new BufferedReader(new InputStreamReader(httpConnection.getInputStream(), CODIFICACAO_PADRAO));
            String output;
            while ((output = responseBuffer.readLine()) != null) {
                response += output;
            }
            responseBuffer.close();
            httpConnection.disconnect();
            return response;
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    /**
     * @method enviarGet
     * @date 25/11/2015
     * @returnType String
     * @param url
     * @param data
     * @return
     * @throws IOException
     * @description
     */
    public File getFile(String url, String data) throws Exception {
        try {
            URL targetUrl = new URL(url + data.replaceAll(" ", "%20"));
            HttpURLConnection httpConnection = (HttpURLConnection) targetUrl.openConnection();
            httpConnection.setRequestMethod("GET");
            httpConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            if (httpConnection.getResponseCode() != 200 && httpConnection.getResponseCode() != 204) {
                LOGGER.info("Falha ao realizar request. " + "Código : " + httpConnection.getResponseCode()
                        + " Mensagem: " + httpConnection.getResponseMessage() + " URL: " + httpConnection.getURL());
            }

            String nomeArquivo = "";
            String prefixo = "";
            String sufixo = "";
            String disposition = httpConnection.getHeaderField("Content-Disposition");


            int index = disposition.indexOf("filename=");
            if (index > -1) {
                nomeArquivo = disposition.substring(index + 9, disposition.length());
            }

            InputStream input = httpConnection.getInputStream();

            int indexNome = nomeArquivo.lastIndexOf(".");
            if (indexNome > 0) {
                prefixo = nomeArquivo.substring(0, indexNome);
                sufixo = nomeArquivo.substring(indexNome);
            } else {
                prefixo = nomeArquivo;
            }

            File file = File.createTempFile(prefixo, sufixo);
            file.deleteOnExit();
            OutputStream out = new FileOutputStream(file);
            byte[] buffer = new byte[4096];
            int read;
            while ((read = input.read(buffer)) != -1) {

                out.write(buffer, 0, read);
            }
            input.close();
            out.close();
            httpConnection.disconnect();
            return file;
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }
}
