//package br.gov.transportes.scp.resource;
//
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.lang.reflect.Type;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//import org.jboss.resteasy.plugins.providers.multipart.InputPart;
//import org.springframework.http.converter.json.GsonBuilderUtils;
//import org.springframework.http.converter.json.GsonFactoryBean;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.google.gson.JsonDeserializationContext;
//import com.google.gson.JsonDeserializer;
//import com.google.gson.JsonElement;
//
//public class AbstractResource {
//	
//	public static GsonFactoryBean gsonFactory;
//	
//	/**
//     * Cria adaptador para gson utilizado na conversao da strng json para lista de objetos.
//     * 
//     * @return gson
//     * @throws Exception
//     */
//    public Gson construirGsonAdapter() {
//        try {
//            JsonDeserializer<Date> deser = new JsonDeserializer<Date>() {
//                @Override
//                public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
//                    return json == null || "".equals(json.getAsString()) ? null : new Date(json.getAsLong());
//                }
//            };
//            return GsonBuilder().serializeNulls().registerTypeAdapter(Date.class, deser).create();
//        } catch (Exception e) {
//            throw e;
//        }
//    }
//    
//    public Map<String, File> extrairArquivos(List<InputPart> imageParts) throws IOException {
//        Map<String, File> arquivosMap = null;
//        if (imageParts != null) {
//            arquivosMap = new HashMap<>();
//
//            Iterator<?> it = imageParts.iterator();
//
//            while (it.hasNext()) {
//                InputPart inputPart = (InputPart) it.next();
//
//                String content = inputPart.getHeaders().getFirst("Content-Disposition");
//                int index = content.indexOf("filename=");
//                int indexFinal = content.substring(index).indexOf("\";");
//                String nomeArquivo = "";
//
//                if (indexFinal == -1) {
//                    nomeArquivo = content.substring(index, content.length() - 1).split("=", 2)[1].substring(1);
//                } else {
//                    nomeArquivo = content.substring(index, index + indexFinal - 1).split("=", 2)[1].substring(1);
//                }
//
//                InputStream inputStream = inputPart.getBody(InputStream.class, null);
//
//                File arquivo = ArquivoUtils.streamToFile(inputStream, nomeArquivo);
//
//                arquivosMap.put(nomeArquivo, arquivo);
//            }
//        }
//        return arquivosMap;
//    }
//    
//}
